$(document).ready(function () {

    toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": "md-toast-top-center",
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "5000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };
});

function showToastr(message) {
    console.log("toastr jestem");
    if (message.includes("Wrong"))
        toastr["error"](message);
    else if (message.includes("missing")) {
        toastr["error"](message);
    } else if (message.includes("cannot")) {
        toastr["error"](message);
    } else toastr["success"](message);

}

function showModal() {
    $('#centralModalInfo').modal();
}