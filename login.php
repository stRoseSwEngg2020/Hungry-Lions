<html>
<head>
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="loginbox"> <img src="https://lh3.googleusercontent.com/BIpeBa7JA4lhYlluvwBc0RnLbMInczIQ47nBEyM_SJ9KP9xBvoL_FLh-Kusx-_8JfF3HIl5lyZc_-ip4dS4nKOW0d9Wyp8UmbVq-9OdklW0hSYD-LvWM4jn_ZHgryRh164uPnx-f=s200-p-k" class="avatar" alt = "avatar logo"/>
  <h1>Login</h1>
  <form action = "login.php" method="post" name="login">
    <p>Username</p>
    <input type="text" name="username" placeholder="Enter Username" required>
    <p>Password</p>
    <input type="password" name="username_Password" placeholder="Enter Password" required>
    <input type="submit" name="login">
    <a href="register.php">Create account</a>
  </form>
</div>
</body>
<?php
$servername = "localhost";
$username = "yolbarsovi677";
$password = "";
$dbname = "HungryLionsSoftwareEngineProject";

$conn = mysqli_connect( $servername, $username, $password, $dbname );

if ( !$conn ) {
  die( "Connection failed: " . mysqli_connect_error() );
}

if ( isset( $_POST[ 'login' ] ) ) {
  $login_user = mysqli_real_escape_string( $conn, $_REQUEST[ 'username' ] );
  $login_password = mysqli_real_escape_string( $conn, $_REQUEST[ 'username_Password' ] );
  $sql = "SELECT * FROM TreasureHuntUsers WHERE username = '$login_user' AND username_Password='$login_password'";
  $results = mysqli_query( $conn, $sql );
  if ( mysqli_num_rows( $results ) > 0 ) {
    header( "Location: homepage.php" );
  } else {
    echo "Username or password not found";
  }
  mysqli_close( $conn );
}
?>
</html>