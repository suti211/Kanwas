function getListFromServer() {
    $.get("CurriculumServlet", function (response) {
        var res = [];
        res = response;
        //console.log(res);
        //console.log(res.length);
        var submitAssignment = "<br /><button type='button' class= 'sub-button submit-button' data-toggle='modal' data-target='#submitmodal' >Submit</button>"


        for (var i = 0; i < res.length; i++) {
           res[i].content = res[i].content + "\n" + submitAssignment;
            $(".generatable").append("<li>" + res[i].title + "<div class=\"grab\" name=\"" + res[i].id + "\"><i class=\"fa fa-bars\" aria-hidden=\"true\"></i></div><div class=\"list-content\">" + res[i].content + "</div></li>");
            //(res[i].content).append(submitAssignment).end();
        }


        sortableList();
    });

}

function sortableList() {

    var dragged = false;

    $(function () {
        $("#sortable").sortable({
            handle: ".grab",
            sort: function () {
                dragged = true;
            },
            stop: function () {
                $("#sortable .grab").each(function () {
                    $.post("CurriculumServlet", { id: $(this).attr("name"), pageIndex: $(this).parent().index() });
                });
            }
        });
        $("#sortable").disableSelection();
    });

    $("li").mousedown(function () {
        dragged = false;
    });

    $("li").mouseup(
        function () {

            if (dragged == false) {

                if ($(this).hasClass("active")) {
                    console.log("faszt");
                    $(this).removeClass("active");
                } else {
                    var $this = $(this);

                    $this.addClass("active").siblings()
                        .removeClass("active");
                }
            }

        });

    $("")

};

$(document).ready(function () {
    getListFromServer();
});

