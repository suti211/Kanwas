
$(document).ready(function () {
	$("#submit-assignment").click(function () {
		var assignMent = { title: $("#title").val(), content: $("#question").val(), maxScore: $("#points").val(), published: $("input[name=status]:checked").val()};
		console.log(assignMent);

		$.post("AddAssignmentPageServlet", { json: JSON.stringify(assignMent) }, function (response) {
			console.log(response);
		});
		//asdgfsdhgdj
	});
});