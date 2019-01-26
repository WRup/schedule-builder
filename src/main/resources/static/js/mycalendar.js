var curr_id;

function updateElement(event) {
    var auditoriumName;
    if (event.title.indexOf('Sala') !== -1) {
        auditoriumName = event.title.split(": ")[1];
    }
    else {
        auditoriumName = ""
    }
    var lectureDto = {
        id: event.id.split("_")[1],
        subjectName: event.title.split("<br/>")[0],
        subjectType: event.title.split("<br/>")[1],
        workerName: event.title.split("<br/>")[3],
        workerSurname: event.title.split("<br/>")[4],
        startDate: event.start._d,
        endDate: event.end._d,
        groupId: event.resourceId,
        auditoriumName: auditoriumName
    };
    var json = JSON.stringify(lectureDto);
    $.ajax({
        url: '/postLecture',
        type: 'POST',
        dataType: "json",
        contentType: "application/json",
        data: json
    });
}

$(function () { // document ready


    $('#external-events .fc-event').each(function () {

        // store data so the calendar knows to render an event upon drop
        $(this).data('event', {
            //title: $.trim($(this).text()), // use the element's text as the event title
            title: $(this).html(),
            stick: true,// maintain when user navigates (see docs on the renderEvent method)
            description: 'Some description',
            color: $(this).data('color')
        });

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
        });


    });

    $('#calendar').fullCalendar({
        defaultView: 'agendaDay',
        themeSystem: 'jquery-ui',
        minTime: "07:00:00",
        maxTime: "21:00:00",
        defaultTimedEventDuration: moment.duration("01:30:00"),
        forceEventDuration: true,
        dragRevertDuration: 0,
        aspectRatio: 1.85,
        slotLabelFormat: "HH:mm",
        handleWindowResize: true,
        droppable: true,
        editable: true,
        selectable: true,
        eventLimit: true, // allow "more" link when too many events
        header: {
            left: 'prev,next today',
            center: 'title'
            //right: 'agendaDay,agendaTwoDay,agendaWeek,month'
        },
        themeButtonIcons: {
            prev: 'circle-triangle-w',
            next: 'circle-triangle-e',
            prevYear: 'seek-prev',
            nextYear: 'seek-next'
        },
        views: {
            agendaTwoDay: {
                type: 'agenda',
                duration: {days: 2},

                // views that are more than a day will NOT do this behavior by default
                // so, we need to explicitly enable it
                groupByResource: true

                //// uncomment this line to group by day FIRST with resources underneath
                //groupByDateAndResource: true
            },
            day: {
                titleFormat: 'dddd, MMMM Do YYYY'
            }
        },

        //// uncomment this line to hide the all-day slot
        allDaySlot: false,

        resources: [
            {id: '1', title: 'GR 1', eventColor: 'orange'},
            {id: '2', title: 'GR 2', eventColor: 'orange'},
            {id: '3', title: 'GR 3', eventColor: 'orange'},
            {id: '4', title: 'GR 4', eventColor: 'orange'},
            {id: '5', title: 'GR 5', eventColor: 'orange'},
            {id: '6', title: 'GR 6', eventColor: 'orange'}
        ],
        timeFormat: 'HH:mm',
        /*events: [
            {id: '1', resourceId: 'a', start: '2018-04-06', end: '2018-04-08', title: 'event 1'},
            {
                id: '2',
                resourceId: 'a',
                start: '2018-04-07T09:00:00',
                end: '2018-04-07T14:00:00',
                title: 'Line 1 <br/>This is Line 2...'
            },
        ]*/
        drop: function (date, jsEvent, ui, resourceId) {
            console.log('drop', date.format(), resourceId);
            curr_id = this.id;
            $(this).remove();
            // is the "remove after drop" checkbox checked?
            /*if ($('#drop-remove').is(':checked')) {
                // if so, remove the element from the "Draggable Events" list
                $(this).remove();
            }*/
        },
        eventReceive: function (event) { // called when a proper external event is dropped
            event.id = curr_id;
            updateElement(event);
            console.log('eventReceive', event);
            console.log(event.start._d)
        },

        eventDrop: function (event, element) { // called when an event (already on the calendar) is moved
            updateElement(event);
            console.log('eventDrop', event);
        },

        eventDragStop: function (event, jsEvent, ui, view) {

            if (isEventOverDiv(jsEvent.clientX, jsEvent.clientY)) {
                $('#calendar').fullCalendar('removeEvents', event._id);
                event.start._d = null;
                event.end._d = null;
                event.resourceId = null;
                if (event.title.indexOf('Sala') !== -1) {
                    event.title = event.title.split(": ")[1];
                }
                var el = $("<td class='fc-event' style='background-color: orange'>").appendTo('#external-events-listing').html(event.title);
                el.draggable({
                    zIndex: 999,
                    revert: true,
                    revertDuration: 0
                });
                el.data('event', {title: event.title, id: event.id, stick: true});
                console.log('html-even', el);
                updateElement(event);
            }
        },

        select: function (start, end, jsEvent, view, resource) {
            console.log(
                'select',
                start.format(),
                end.format(),
                resource ? resource.id : '(no resource)'
            );
        },
        dayClick: function (date, jsEvent, view, resource) {
            console.log(
                'dayClick',
                date.format(),
                resource ? resource.id : '(no resource)'
            );
        },

        eventRender: function (event, element) {
            element.find('div.fc-title').html(element.find('div.fc-title').text());

        },
        eventClick: function (calEvent, jsEvent, view) {

            $('#modalTitle').html(calEvent.title);
            $('#eventUrl').attr('href', calEvent.url);
            $('#save_btn').attr("disabled", true);
            $('#fullCalModal').modal();
            $('#saveBtn').on('click', function () {
                saveAuditorium(calEvent, curr_id);
            })
        }
    });

});

var isEventOverDiv = function (x, y) {

    var external_events = $('#external-events');
    var offset = external_events.offset();
    offset.right = external_events.width() + offset.left;
    offset.bottom = external_events.height() + offset.top;

    // Compare
    return x >= offset.left
        && y >= offset.top
        && x <= offset.right
        && y <= offset.bottom;


};