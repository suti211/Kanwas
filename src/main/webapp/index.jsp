<html>
	<head>
		<link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
		<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">	
		<title>Kanwas</title>
	</head>
	
	<body>	
		<style>
			.fullscreen-bg {
				position: fixed;
				top: 0;
				right: 0;
				bottom: 0;
				left: 0;
				overflow: hidden;
				z-index: -100;
			}

			.fullscreen-bg__video {
				position: absolute;
				top: 0;
				left: 0;
				width: 100%;
				height: 100%;
			}
			
			@media (min-aspect-ratio: 16/9) {
				.fullscreen-bg__video {
					width: 100%;
					height: auto;
				}
			}

			@media (max-aspect-ratio: 16/9) {
				.fullscreen-bg__video {
					width: auto;
					height: 100%;
				}
			}
			

			a:link {color:#fff;text-decoration: none;}
			a:visited{color:#fff;}
		</style>
	
		<script>	
			function randomText() {
				var texts = ["Made for you.", 
							"Solution for you", 
							"Better than the original.", 
							"Any question?",
							"Almost vendible.",
							"Send nudes.",
							"Now its a girl."];
				document.getElementById("about").innerHTML = "Kanwas. " + texts[Math.floor(Math.random()*texts.length)];
			}
			window.onload = randomText;
		</script>
	
		<div class="menu-container">
			<a href="./index"><img src="./images/logo.png" width="125" style="margin-bottom:-8px;margin-left:-125px"/></a>
			
			<div class="inner-menu-container">
				<a href="./user"><div class="menu-item">Members</div></a>
				<a href="./profile"><div class="menu-item">Profile</div></a>
				<div class="menu-item">About</div>
				<a href="./register"><div class="menu-item" style="border:1px solid #000; padding: 0px 5px 0px 5px">Sign Up</div></a>
			</div>
			
			<!--Click here to log in.-->
			<a href="${extraurl}"><span class="extra-menu-item">${extramenu}</span></a>
		</div>

		<div class="homepage-container">
			<div class="homepage-center">
				<span id="about">Kanwas. Made for you.</span>
			</div>
		</div>
		
		<div style="font-size:24px; text-shadow: 0px 0px 5px rgba(0,0,0,0.3); width:100%; text-align: center; margin-top:0px;">
			There are <span style="font-size:36px">517.230</span> users in kanwas who made <span style="font-size:36px">12.502</span> assignments and <span style="font-size:36px">211.345</span> modules.
		</div>
	
		<div class="fullscreen-bg">
			<video loop muted autoplay poster="./images/background.jpg" class="fullscreen-bg__video">
				<source src="video.mp4" type="video/mp4">
			</video>
		</div>
	</body>
</html>