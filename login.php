<html>
<head>
<title>Login</title>
<script>
function makeCookie() {
  var userName = document.getElementById('Uname').value;
  document.cookie = "CKusername=" + userName + "; path=/;";
  var userPass = document.getElementById('UPass').value;
  document.cookie = "CKpassword=" + userPass + "; path=/;";
  //document.cookie = "UserId=" + [user's ID number] + "; path=/;";
}  
</script>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="loginbox"> <img src="https://lh3.googleusercontent.com/BIpeBa7JA4lhYlluvwBc0RnLbMInczIQ47nBEyM_SJ9KP9xBvoL_FLh-Kusx-_8JfF3HIl5lyZc_-ip4dS4nKOW0d9Wyp8UmbVq-9OdklW0hSYD-LvWM4jn_ZHgryRh164uPnx-f=s200-p-k" class="avatar" alt = "avatar logo"/>
  <h1>Login</h1>
  <form action = "login.php" method="post" name="login">
    <p>Username</p>
    <input id="Uname" type="text" name="username" placeholder="Enter Username" required>
    <p>Password</p>
    <input id="Upass" type="password" name="username_Password" placeholder="Enter Password" required>
    <input type="submit" name="login" onclick="makeCookie()">
    <a href="register.php">Create account</a>
  </form>
</div>
</body>
</html>
