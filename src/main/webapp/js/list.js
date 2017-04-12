function getListFromServer() {
    $.get("CurriculumServlet", function (response) {
        var string = response;
        console.log("response was: " + string);
    });
}

$(document).ready(function () {
    getListFromServer();
});