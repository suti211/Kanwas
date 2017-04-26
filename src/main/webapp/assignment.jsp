<html>
<head>
<link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Poppins"
	rel="stylesheet">
<script src="./js/jquery-3.2.1.min.js"></script>
<script src="./js/modules.js"></script>
<title>Assignment page</title>
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
	text-align: center
}

table {
	padding: 10px;
	width: 100%
}
</style>

<body>
	<div class="menu-container">
		<a href="./index"><img src="./images/logo.png" width="125"
			style="margin-bottom: -8px; margin-left: -125px" /></a>

		<div class="inner-menu-container">
			<a href="./user"><div class="menu-item">Members</div></a> <a
				href="./profile"><div class="menu-item">Profile</div></a>
			<a href="./list.jsp" class="menu-item" style="color: black">Curriculum</a>
			<a href="./register"><div class="menu-item"
					style="border: 1px solid #000; padding: 0px 5px 0px 5px">Sign
				Up</div></a>
			<a href="./logout"><div class="menu-item"
									  style="border: 1px solid #000; padding: 0px 5px 0px 5px">Logout</div></a>
		</div>

		<a href="${extraurl}"><span class="extra-menu-item">${extramenu}</span></a>
	</div>

	<div class="login-title" style="font-family: 'Ubuntu', sans-serif;">
		New Assignment</div>


	<div class="main-window page-item">

		
			<span style="font-size: 24px"> <input type="text"
				class="assignment-input" id="title" name="title" placeholder="Type in title...">
			</span>
			<div
				style="padding-top: 10px; border-top: 1px solid rgba(255, 255, 255, 0.5)">
			</div>

			<div style="font-size: 24px;">
				<textarea class="assignment-input" name="submit-text" id="question"
					style="margin-top: 10px" cols="50" rows="10"
					placeholder="Type your question..."></textarea>
				<div style="font-size: 15px; margin-left: 20px; width: 15%">
					Points: <input type="number" class="points" id="points" name="points">
				</div>

				<div>
					<div
						style="float: right; font-size: 15px; width: 125px; display: inline">
						<input type="radio" name="status" value="0" checked>Unpublished
						<input type="radio" name="status" value="1">Published
					</div>
					<button id="submit-assignment" class="button submit-button">Submit
					</button>
				</div>
			</div>

	</div>

	<div style="text-align: center; color: #fff; margin-top: 5px;">
		Help &#9679; About &#9679; Terms and Conditions</div>
</body>
</html>
