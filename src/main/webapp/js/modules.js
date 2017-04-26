
$(document).ready(function () {
	$("#submit-assignment").click(function () {
		var assignMent = { title: $("#title").val(), content: $("#question").val(), maxScore: $("#points").val(), published: $("input[name=status]:checked").val()};
		console.log(assignMent);

		$.post("AddAssignmentPageServlet", { json: JSON.stringify(assignMent) }, function (response) {
			console.log(response);
		});
	});
	
	$("#submit-textpage").click(function () {
		var textpage = { title: $("#title").val(), content: $("#text").val(), published: $("input[name=status]:checked").val()};
		console.log(textpage);

		$.post("AddTextPageServlet", { json: JSON.stringify(textpage) }, function (response) {
			console.log(response);
		});
	});
});