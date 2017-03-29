<html>
  <head>
    <link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Login - Kanwas</title>
  </head>

  <style>
    a:link {color:#fff;text-decoration: none;}
    a:visited{color:#fff;}
  </style>

  <body>
    <div class="menu-container">
        <div class="menu-item">Homepage</div>
        <div class="menu-item">Grades</div>
        <div class="menu-item">Assignments</div>
        <div class="menu-item">About</div>
    </div>

    ${message}

    <div class="main-window">
      <div style="padding:10px;width:100%">
        <center><img src="./images/logo.png" width="250px"/></center>
      </div>

        <div class="login-container">
          <form method="POST" action="login">
          <p style="margin-bottom:0px;">E-mail</p>
          <input type="email" id="email" name="email" class="text-input"/><br />
          <p style="margin-bottom:0px;">Password</p>
          <input type="password" id="pass" name="pass" class="text-input"/>
          <div>
            <input type="submit" id="submit" name="login" value="Login" class="button" />
          </div>
        </form>

        <div style="font-size:14px;">
          <a href="./register.html">Register</a>
        </div>
      </div>
    </div>
  </body>
</html>
