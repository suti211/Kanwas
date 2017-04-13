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
			
			//Random text shows on homepage
			function randomText() {
				var texts = ["Made for you.", 
							"Solution for you", 
							"Better than the original.", 
							"Any question?",
							"Almost vendible.",
							"Send nudes.",
							"Now its a girl."];
				window.onload = document.getElementById("about").innerHTML = "Kanwas. " + texts[Math.floor(Math.random()*texts.length)];
			}
			window.onload = randomText;
			
			
			//Animated number counting up
			function animateValue(start, end, duration) {
			    var current = start;
			    var timer = setInterval(function() {
			        current += 1;
			        
			        if (Math.random() >= 0.5){
			        	document.getElementById("number1").innerHTML = current;
			        }else{
			        	document.getElementById("number2").innerHTML = current - 396;
			        }
			        
			        if (Math.random() >= 0.5){
			        	document.getElementById("number3").innerHTML = current - 246;
			        }
			        
			        if (current == end) {
			            clearInterval(timer);
			        }
			    }, 2000);
			}

			animateValue(532, 2500, 200000);
			
		</script>
	
		<div class="menu-container">
			<a href="./index"><img src="./images/logo.png" width="125" style="margin-bottom:-8px;margin-left:-125px"/></a>
			
			<div class="inner-menu-container">
				<a href="./user"><div class="menu-item">Members</div></a>
				<a href="./profile"><div class="menu-item">Profile</div></a>
				<a href="./list.jsp"><div class="menu-item">Curriculum</div></a>
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
			There are <span id="number1" style="font-size:36px">534</span> users in kanwas who made <span id="number2" style="font-size:36px">137</span> assignments and <span id="number3" style="font-size:36px">287</span> modules.
		</div>
	
		<div class="fullscreen-bg">
			<video loop muted autoplay poster="./images/background.jpg" class="fullscreen-bg__video">
				<source src="video.mp4" type="video/mp4">
			</video>
		</div>
	</body>
</html>