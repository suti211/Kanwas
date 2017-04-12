
$(document).ready(function () {
	$("#submit-assignment").click(function () {
		var assignMent = { title: $("#title").val(), question: $("#question").val(), maxScore: $("#points").val(), published: $("#published").val() };
		console.log(assignMent);

		$.post("AddAssignmentPageServlet", { json: JSON.stringify(assignMent) }, function (response) {
			console.log(response);
		});
	});
});