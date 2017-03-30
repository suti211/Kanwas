<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
		<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
		<script src='https://www.google.com/recaptcha/api.js'></script>
		<title>Register - Kanwas</title>
	</head>

	<style>
		a:link {color:#fff;text-decoration: none;}
		a:visited{color:#fff;}
		td{width:45%;text-align: center;border:none;}
	</style>

	<body>
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
			Register to Kanwa$
		</div>
	
		${message}

		<div class="main-window">
			<div style="padding:10px;width:100%;margin-top:20px;">
				<center><img src="./images/logo.png" width="250px"/></center>
			</div>

			<div class="login-container">
				<form method="POST" action="register">
					<table style="color: #fff; width:100%;">
						<tr>
						  <td><p style="margin-bottom:0px;">*First name</p></td>
						  <td><p style="margin-bottom:0px;">*Last name</p></td>
						</tr>

						<tr>
						  <td><input style="width:100%;" type="text" id="first-name" name="first-name" class="text-input"/></td>
						  <td><input style="width:100%;"  type="text" id="last-name" name="last-name" class="text-input"/></td>
						</tr>
					</table>

					<p style="margin-bottom:0px;">*E-mail</p>
					<input style="width:100%;" type="email" id="email" name="email" class="text-input"/><br />

					<p style="margin-bottom:0px;">*Password</p>
					<input style="width:100%;" type="password" id="pass" name="pass" class="text-input"/>

					<p style="margin-bottom:0px;">*Confirm password</p>
					<input style="width:100%;" type="password" id="pass2" name="pass2" class="text-input"/>
					
					<p style="margin-bottom:0px;">*User role</p>
					<table style="width:100%; margin-bottom:20px; margin-top:10px;border:1px solid #fff;padding:5px 0px 5px 0px">
						<tr>
							<td><input type="radio" name="role" checked value="student"> Student</td>
							<td><input type="radio" name="role" value="mentor"> Mentor</td>
						</tr>
					</table>
					
					<center><div class="g-recaptcha" data-sitekey="6Lec2BoUAAAAAMYv9GAQ25ftNKUGUW7H4-xqj-jf"></div></center>

					<div>
						<input type="submit" id="submit" name="register" value="Register" class="button" style="margin-top:20px; "/>
					</div>
				</form>
			
				<div style="font-size:14px;">
					<a href="./login">Login</a>
				</div>	
			</div>
		</div>
		
		<div style="text-align: center; color:#fff; margin-top:5px;">
			Help &#9679; About &#9679; Terms and Conditions
		</div>
  </body>
</html>
