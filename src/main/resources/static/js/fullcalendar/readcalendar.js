var curr_id;

function get_calendar_height() {
    return $(window).height() - 30;
}

$(window).resize(function () {
    $('#calendar').fullCalendar('option', 'height', get_calendar_height());
});

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
        auditoriumName: auditoriumName,
        note: event.description
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
        droppable: false,
        editable: false,
        selectable: false,
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


        eventReceive: function (event) { // called when a proper external event is dropped
            event.id = curr_id;
            $('#calendar').fullCalendar('removeEvents', event._id);
            $('#calendar').fullCalendar('renderEvent', event, true);
            updateElement(event);
            console.log('eventReceive', event);
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
            console.log(calEvent.description);
            $('#modalTitle').html(calEvent.title);
            $('#eventUrl').attr('href', calEvent.url);
            $('#save_btn').attr("disabled", true);
            $('#message-text').val(calEvent.description);
            $('#fullCalModal').modal();
        }
    });

});