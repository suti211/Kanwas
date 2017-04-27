<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
		<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
		<link rel="stylesheet" href="./font-awesome/css/font-awesome.min.css">
		<title>${fullname} - Kanwas</title>
	</head>

	<style>
		a:link {color:#fff;text-decoration: none;}
		a:visited{color:#fff;}
		td {text-align: center;}
		table {padding:10px;width:100%;}
		li {text-align: center}
		li::before {display: none}
	</style>

	<body>
	
		<script>
			var timer = setInterval(function() {
		        document.getElementById("hideable").style.display = "none";
		    }, 2000);
		</script>
		
		<div class="menu-container">
			<a href="./index"><img src="./images/logo.png" width="125" style="margin-bottom:-8px;margin-left:-125px"/></a>

			<div class="inner-menu-container">
				<a href="./user"><div class="menu-item">Members</div></a>
				<a href="./profile"><div class="menu-item">Profile</div></a>
				<a href="./list.jsp"><div class="menu-item" style="color: black">Curriculum</div></a>
				<a href="./register"><div class="menu-item" style="border:1px solid #000; padding: 0px 5px 0px 5px">Sign Up</div></a>
				<a href="./logout"><div class="menu-item"
									  style="border: 1px solid #000; padding: 0px 5px 0px 5px">Logout</div></a>
			</div>
			
			<a href="${extraurl}"><span class="extra-menu-item">${extramenu}</span></a>
		</div>

		<div class="login-title">
			Profile
		</div>
		
		${message}
		
		<div class="main-window" style="width: 50%; overflow: hidden; ">
			<div style="width: 100%; background-color: #fff; border-radius: 0 0 4px; padding: 30px; display: block; overflow: hidden; color: #222">
				<img src="https://lh3.googleusercontent.com/sDYbUKkKzA07gtjsdRk5nGhIROgFk8Ydj5h2YqAm3pYDWnMZcSxvAaokHAeSFAMzQvxNeYAZkVMMWI58kQ" width="200" style="border-radius: 100px; float: left"></img>
				<div style="float:left; font-size: 36px; font-weight: 600; margin-top: 30px; margin-left: 30px;">${fullname}
				<p style="font-size: 26px; margin-top: 5px">${role}</p></div>
			</div>
				
			<ul style="font-size: 20px; margin: auto">
				<li><i class="fa fa-envelope" aria-hidden="true"></i>  E-mail: ${email}</li>
				<li><i class="fa fa-clock-o" aria-hidden="true"></i>  Last login: 2017.04.28 11:02</li>
				<li><i class="fa fa-user" aria-hidden="true"></i>   Role: ${role}</li>
				<li><i class="fa fa-globe" aria-hidden="true"></i>   Address: ${address}</li>
			</ul>
			
		</div>

		<div style="text-align: center; color:#fff; margin-top:5px;">
			Help &#9679; About &#9679; Terms and Conditions
		</div>
	</body>
</html>