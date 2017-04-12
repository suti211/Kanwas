<html>
	<head>
		<link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
		<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
			<script src="./js/list.js"></script>
			<link rel="stylesheet" href="./font-awesome/css/font-awesome.min.css">
		<title>Curricolum - Kanwas</title>
	</head>

	<style>
		a:link {color:#fff;text-decoration: none;}
		a:visited{color:#fff;}
		td {text-align: center;}
		table {padding:10px;width:100%;}
	</style>

	<body>

		<script>

		$(document).ready(function() {

			$("li").mouseup(function() {
				console.log("asdasdasdasd");
				var $this = $(this);
				$this.addClass("active")

						 .siblings().removeClass("active");
			});

		});


		</script>

		<div class="menu-container">
			<a href="./index"><img src="./images/logo.png" width="125" style="margin-bottom:-8px;margin-left:-125px"/></a>

			<div class="inner-menu-container">
				<a href="./user"><div class="menu-item">Members</div></a>
				<a href="./profile"><div class="menu-item">Profile</div></a>
				<div class="menu-item">About</div>
				<a href="./register"><div class="menu-item" style="border:1px solid #000; padding: 0px 5px 0px 5px">Sign Up</div></a>
			</div>

			<a href="${extraurl}"><span class="extra-menu-item">${extramenu}</span></a>
		</div>

		<div class="login-title">
			Curriculum
		</div>

		${message}

		<div class="main-window list-container">
		<ul>
			<div class="grab"><i class="fa fa-bars" aria-hidden="true"></i></div>
				<li>teszt
					<div class="list-content">
						Kábítószerterjesztés
					</div>
				</li>
			</ul>
		</div>

		<div style="text-align: center; color:#fff; margin-top:5px;">
			Help &#9679; About &#9679; Terms and Conditions
		</div>
	</body>
</html>
