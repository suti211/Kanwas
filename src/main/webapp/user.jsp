<html>
	<head>
		<link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
		<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
		<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
		<title>${fullname} - Kanwas</title>
	</head>

	<style>
		a:link {color:#fff;text-decoration: none;}
		a:visited{color:#fff;}
		td {text-align: center;}
		table {padding:10px;width:100%;}
		.head {border-bottom: 1px solid #fff;}
	</style>

	<body>
		
		<div class="menu-container">
			<a href="./index"><img src="./images/logo.png" width="125" style="margin-bottom:-8px;margin-left:-125px"/></a>

			<div class="inner-menu-container">
				<a href="./user"><div class="menu-item">Members</div></a>
				<a href="./profile"><div class="menu-item">Profile</div></a>
				<div class="menu-item">About</div>
				<a href="./register.jsp"><div class="menu-item" style="border:1px solid #000; padding: 0px 5px 0px 5px">Sign Up</div></a>
			</div>
			
			<a href="${extra-url}"><span class="extra-menu-item">${extra-menu}</span></a>
		</div>

		<div class="login-title">
			Users
		</div>
		
		<div class="main-window">
			<div id="hideable" style="margin:auto;padding-top:20px;text-align: center;">
				<form method="GET" action="user">
					<input class="button" type="submit" value="Refresh" id="submit" onClick="hide();"/>
				</form>
	     	</div>
	     ${tableContent}
		</div>

		<div style="text-align: center; color:#fff; margin-top:5px;">
			Help &#9679; About &#9679; Terms and Conditions
		</div>
	</body>
</html>