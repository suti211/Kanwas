<html>
<head>
<link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="./js/list.js"></script>
<link rel="stylesheet" href="./font-awesome/css/font-awesome.min.css">
<title>Curriculum - Kanwas</title>
</head>

<style>
a:link {
	color: #fff;
	text-decoration: none;
}


a:visited {
	color: #fff;
}

td {
	text-align: center;
}

table {
	padding: 10px;
	width: 100%;
}
</style>

<body>



	<div class="menu-container">
		<a href="./index"><img src="./images/logo.png" width="125"
			style="margin-bottom: -8px; margin-left: -125px" /></a>

		<div class="inner-menu-container">
			<a href="./user"><div class="menu-item">Members</div></a> <a
				href="./profile"><div class="menu-item">Profile</div></a>
			<div class="menu-item">Curriculum</div>
			<a href="./assignment.jsp" class="menu-item" style="color: black">New Assignment</a>
			<a href="./textpage.jsp" class="menu-item" style="color: black">New TextPage</a>
			<a href="./register"><div class="menu-item"
									  style="border: 1px solid #000; padding: 0px 5px 0px 5px">Sign
				Up</div></a>
			<a href="./logout"><div class="menu-item"
									  style="border: 1px solid #000; padding: 0px 5px 0px 5px">Logout</div></a>
		</div>

		<a href="${extraurl}"><span class="extra-menu-item">${extramenu}</span></a>
	</div>

	<div class="login-title">Curriculum</div>

	${message}

	<div class="main-window list-container">
		<ul id="sortable" class="generatable">
			<!-- IDE J�N A LISTA -->
			
		</ul>
	</div>
	<div class="modal fade" id="submitmodal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<p>Some text in the modal.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>

	<div style="text-align: center; color: #fff; margin-top: 5px;">
		Help &#9679; About &#9679; Terms and Conditions</div>
</body>
</html>
