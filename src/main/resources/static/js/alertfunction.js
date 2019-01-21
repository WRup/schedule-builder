var prevId = null;


$(document).ready(function () {
    $("#success-alert").hide();

});


function showAlert(auditorium, currId) {
    document.getElementById(currId).className = "btn disabled";
    document.getElementById(currId).style.color = "#ff0000";
    if (!prevId) {
        prevId = currId;
    }
    else {
        document.getElementById(prevId).className = "dropdown-item";
        document.getElementById(prevId).style.color = "#000000";
        prevId = currId;
    }
    $("#save_btn").attr("disabled", false)
    $("#success-alert").html('Auditorium ' + auditorium + ' has been set');
    $("#success-alert").fadeTo(1500, 500).slideUp(500, function () {
        $(this).slideUp(500);
    });

    return currId;
}

function saveAuditorium(event, curr_id) {
    if (event.title.indexOf('Sala') !== -1) {
        event.title = event.title.split("Sala")[0] + 'Sala: ' + document.getElementById(prevId).textContent;
    }
    else {
        event.title = event.title + 'Sala: ' + document.getElementById(prevId).textContent;
    }
    $('#calendar').fullCalendar('updateEvent', event);
    event.id = curr_id;
    console.log('updateEvent', event);
    updateElement(event);
}


function renderLectureEvent(lecture_title, lecture_start_date, lecture_end_date, group_id, lecture_id) {
    var event = {
        title: lecture_title,
        start: moment(lecture_start_date),
        end: moment(lecture_end_date),
        resourceId: group_id,
        id: lecture_id
    };
    $('#calendar').fullCalendar('renderEvent', event, true);
    console.log("renderedEvent", event);
}