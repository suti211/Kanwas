function getListFromServer() {
    $.get("CurriculumServlet", function (response) {
        var res = response;
        //console.log(res);
        //console.log(res.length);
        var submitAssignment = "<br /><button type='button' class= 'sub-button submit-button' data-toggle='modal' data-target='#submitmodal' id='smodal' >Submit</button>"

        res.forEach(function(element) {
            $(".generatable").append("<li>" + element.title + "<div class=\"grab\" name=\"" + element.id + "\"><i class=\"fa fa-bars\" aria-hidden=\"true\"></i></div><div class=\"list-content\">" + element.content + submitAssignment + "</div></li>");
            $(".sub-button").click(function () {
                console.log("IrjkiValamit");
                //$(".modal-title").html(element.title);
                //$(".modal-body").html(element.content);
        })

        })
        //($(".active")[0].innerText.split("\n")[0]);

        sortableList();
        //addEventListenerToAnswerButton();
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

                console.log($(this)[0].innerText.split("\n")[0]);
                $(".modal-title").html($(this)[0].innerText.split("\n")[0]);
                $(".modal-body").html($(this)[0].innerText.split("\n")[1]);

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