<html>
  <head>
    <link rel="stylesheet" type="text/css" href="./stylesheet/style.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Register - Kanwas</title>
  </head>

  <style>
    a:link {color:#fff;text-decoration: none;}
    a:visited{color:#fff;}
    td{width:45%;text-align: center;}
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
        <form action="POST">
          <table style="color: #fff; width:100%;">
            <tr>
              <td><p style="margin-bottom:0px;">First name</p></td>
              <td><p style="margin-bottom:0px;">Last name</p></td>
            </tr>

            <tr>
              <td><input style="width:100%;" type="email" id="email" name="first-name" class="text-input"/></td>
              <td><input style="width:100%;"  type="email" id="email" name="last-name" class="text-input"/></td>
            </tr>
          </table>

          <p style="margin-bottom:0px;">E-mail</p>
          <input style="width:100%;" type="email" id="email" name="email" class="text-input"/><br />

          <p style="margin-bottom:0px;">Password</p>
          <input style="width:100%;" type="password" id="pass" name="pass" class="text-input"/>

          <p style="margin-bottom:0px;">Confirm password</p>
          <input style="width:100%;" type="password" id="pass2" name="pass2" class="text-input"/>

          <table style="color: #fff; width:100%; margin-bottom:30px; margin-top:10px;">
            <tr>
              <td><input type="radio" name="rule" value="student"> Student</td>
              <td><input type="radio" name="rule" value="mentor"> Mentor</td>
            </tr>
          </table>

          <div>
            <input type="submit" id="submit" name="register" value="Register" class="button" />
          </div>
        </form>
        <div style="font-size:14px;">
          <a href="./login.html">Login</a>
        </div>
      </div>
    </div>
  </body>
</html>
