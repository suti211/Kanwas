<html>
	<head>
		<link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
		<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
		<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">		
		<title>Login - Kanwas</title>
	</head>

	<style>
		a:link {color:#fff;text-decoration: none;}
		a:visited{color:#fff;}
	</style>

	<body>
		<div class="menu-container">
			<a href="./index.html"><img src="./images/logo.png" width="125" style="margin-bottom:-8px;margin-left:-125px"/></a>
			
			<div class="inner-menu-container">
				<div class="menu-item">Courses</div>
				<div class="menu-item">Modules</div>
				<div class="menu-item">About</div>
				<a href="./register.jsp"><div class="menu-item" style="border:1px solid #000; padding: 0px 5px 0px 5px">Sign Up</div></a>
			</div>
		</div>

		<div class="login-title">
			Login to Kanwa$
		</div>
		
		${message}

		<div class="main-window">
			<div style="padding:10px;width:100%;margin-top:20px;">
				<center><img src="./images/logo.png" width="250px"/></center>
			</div>

			<div class="login-container">
				<form method="POST" action="login">
					<p style="margin-bottom:0px;">E-mail</p>
					<input type="email" id="email" name="email" class="text-input"/><br />
					
					<p style="margin-bottom:0px;">Password</p>
					<input type="password" id="pass" name="pass" class="text-input"/>
					
					<div>
						<input type="submit" id="submit" name="login" value="Login" class="button" style="margin-top:20px;"/>
					</div>
				</form>

				<div style="font-size:14px;">
				  <a href="./register.jsp">Register</a>
				</div>
			</div>
		</div>
		
		<div style="text-align: center; color:#fff; margin-top:5px;">
			Help &#9679; About &#9679; Terms and Conditions
		</div>
	</body>
</html>
