$(document).ready(function () {
    $("#success-alert").hide();
});

function showAlert(auditorium) {
    $("#success-alert").html('Auditorium ' + auditorium + ' has been set');
    $("#success-alert").fadeTo(1500, 500).slideUp(500, function () {
        $(this).slideUp(500);
    });
}