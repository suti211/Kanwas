function sendAssignment() {
	var assignMent = { title: $("#title").text, question: $("#question").text, maxScore: $("#points") }
	var JSONString = JSON.stringify(assignMent);

	$.ajax(
		method: "POST",
		url: "AddAssignmentPageServlet",
		data: { json: JSONString },
		dataType: "application/json;charset=UTF-8",
		success: reportSuccess(response),
	);
}

function reportSuccess(response) {
	//FILL
}

$(document).ready(function () {
	$("#submit-assignment").on("click", sendAssignment());
});