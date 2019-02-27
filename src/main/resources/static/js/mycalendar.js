var curr_id;

function get_calendar_height() {
    return $(window).height() - 30;
}

$(window).resize(function () {
    $('#calendar').fullCalendar('option', 'height', get_calendar_height());
});

function getAuditoriums(startDate, endDate) {
    var s_date = JSON.stringify(startDate);
    var e_date = JSON.stringify(endDate);
    var audDate = s_date + "," + e_date;
    var outputData;
    console.log('pass-date', audDate);

    $.ajax({
        type: 'GET',
        url: '/getOccupiedAuditoriums/' + s_date + "," + e_date,
        success: function (result) {
            console.log('aud_reuslt', result);
            disableAuditoriums(result)
        }
    });
}

function updateElement(event) {
    var auditoriumName;
    if (event.title.indexOf('Sala') !== -1) {
        auditoriumName = event.title.split(": ")[1];
    } else {
        auditoriumName = ""
    }
    var lectureDto = {
        id: event.id.split("_")[1],
        subjectName: event.title.split("<br>")[0],
        subjectType: event.title.split("<br>")[1],
        workerName: event.title.split("<br>")[3],
        workerSurname: event.title.split("<br>")[4],
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
        schedulerLicenseKey: 'CC-Attribution-NonCommercial-NoDerivatives',
        defaultView: 'agendaDay',
        themeSystem: 'jquery-ui',
        minTime: "07:00:00",
        maxTime: "21:00:00",
        timezone: 'local',
        height: get_calendar_height,
        defaultTimedEventDuration: moment.duration("01:30:00"),
        forceEventDuration: true,
        dragRevertDuration: 0,
        aspectRatio: 1.85,
        //slotDuration: '00:15:00',
        //slotLabelInterval: 15,
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
            {id: '1', title: 'GR 1'},
            {id: '2', title: 'GR 2'},
            {id: '3', title: 'GR 3'},
            {id: '4', title: 'GR 4'},
            {id: '5', title: 'GR 5'},
            {id: '6', title: 'GR 6'}
        ],
        timeFormat: 'HH:mm',


        drop: function (date, jsEvent, ui, resourceId) {
            console.log('drop', date.format(), resourceId);
            curr_id = this.id;
            //$(this).remove();
        },
        eventReceive: function (event) { // called when a proper external event is dropped
            event.id = curr_id;
            $('#calendar').fullCalendar('removeEvents', event._id);
            $('#calendar').fullCalendar('renderEvent', event, true);
            updateElement(event);
            console.log('eventReceive', event);
        },

        eventDrop: function (event, element) { // called when an event (already on the calendar) is moved
            console.log('event-drop', event);
            updateElement(event);
        },

        eventDragStop: function (event, jsEvent, ui, view) {

            if (isEventOverDiv(jsEvent.clientX, jsEvent.clientY)) {
                $('#calendar').fullCalendar('removeEvents', event._id);
                event.start._d = null;
                event.end._d = null;
                event.resourceId = null;
                if (event.title.indexOf('Sala') !== -1) {
                    event.title = event.title.split("Sala")[0];
                }
                updateElement(event);
                var $el = $("<tr id='external-events-listing'>").appendTo('#tableBody');
                var el2 = $("<td class='fc-event' style='background-color: orange'>").attr({
                    'id': event.id,
                    'data-color': event.color
                });
                el2.css('background-color', event.color);
                el2.appendTo($el).html(event.title);
                el2.draggable({
                    zIndex: 999,
                    revert: true,
                    revertDuration: 0
                });
                el2.data('event', {title: event.title, id: event.id, stick: true});
                console.log('html-even', el2);
                console.log('event-title', event.title);

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
            getAuditoriums(calEvent.start._d, calEvent.end._d);
            $('#modalTitle').html(calEvent.title);
            $('#eventUrl').attr('href', calEvent.url);
            $('#save_btn').attr("disabled", true);
            $('#fullCalModal').modal();
            $('#saveBtn').on('click', function () {
                console.log('event-start-date', calEvent.start._d);
                console.log('event-end-date', calEvent.end._d);
                saveAuditorium(calEvent);
                $(this).off("click");
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