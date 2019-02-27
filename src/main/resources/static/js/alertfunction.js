var id = null;


$(document).ready(function () {
    $("#success-alert").hide();
    $("#save_btn").attr("disabled", true);

});

function disableAuditoriums(aud_list) {
    $('.dropdown-menu > li > a').removeClass();
    $('.dropdown-menu > li > a').addClass('dropdown-item');
    $('.dropdown-menu > li > a').css("color", "#000000");

    if (aud_list.length !== 0) {
        for (var id = 0, l = aud_list.length; id < l; id++) {
            var aud_id = aud_list[id].toString();
            aud_id = "aud_" + aud_id;
            document.getElementById(aud_id).className = "btn disabled";
            document.getElementById(aud_id).style.color = "#ff0000";
        }
    }
}

function showAlert(auditorium, currId) {
    id = currId;
    $("#save_btn").attr("disabled", false)
    $("#success-alert").html('Auditorium ' + auditorium + ' has been set');
    $("#success-alert").fadeTo(1500, 500).slideUp(500, function () {
        $(this).slideUp(500);
    });
}

function saveAuditorium(event) {
    if (event.title.indexOf('Sala') !== -1) {
        event.title = event.title.split("Sala")[0] + 'Sala: ' + document.getElementById(id).textContent;
    } else {
        event.title = event.title + 'Sala: ' + document.getElementById(id).textContent;
    }
    event.description = $('#message-text').val();
    $('#calendar').fullCalendar('updateEvent', event);
    console.log('updateEvent', event);
    updateElement(event);
}


function renderLectureEvent(lecture_title, lecture_start_date, lecture_end_date, group_id, lecture_id, note, color) {
    var event = {
        title: lecture_title,
        start: moment(lecture_start_date),
        end: moment(lecture_end_date),
        resourceId: group_id,
        id: lecture_id,
        color: color,
        description: note
    };
    $('#calendar').fullCalendar('renderEvent', event, true);
    console.log("renderedEvent", event);
}