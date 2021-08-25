<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="login.css">
  </head>
  <body>
    <div class="center">
      <h1>SiteName</h1>
      <form action="LoginCheck" method="post">
        <div class="txt_field">
          <input type="text" required placeholder="Email Address" name="email">
        </div>
        <div class="txt_field">
          <input type="password" required placeholder="Password" name="password">
        </div>
        <div class="pass">Forgotten Password?</div>
        <input type="submit" value="Login">
        <div class="createacc_link">
         Not Registered ? <a href="#registration.jsp">Create New Account</a>
        </div>
      </form>
    </div>
  </body>
</html>