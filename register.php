<head>
<title>register</title>
<link rel="stylesheet" type="text/css" href="style1.css">
<style type="text/css">
</style>
</head>

<body>
<body>
<div class="loginbox"> <img src="https://lh3.googleusercontent.com/BIpeBa7JA4lhYlluvwBc0RnLbMInczIQ47nBEyM_SJ9KP9xBvoL_FLh-Kusx-_8JfF3HIl5lyZc_-ip4dS4nKOW0d9Wyp8UmbVq-9OdklW0hSYD-LvWM4jn_ZHgryRh164uPnx-f=s200-p-k" class="avatar" alt = "avatar logo"/>
  <h1>Create Account</h1>
  <form method="post" action="register.php">
    <p>Username</p>
    <input type="text" name="username" placeholder="Enter Username" required>
    <p>Password</p>
    <input type="password" name="username_Password" placeholder="Enter Password" required>
    <p>First Name</p>
    <input type="text" name="first_Name" placeholder="Enter First Name" required>
    <p>Last Name</p>
    <input type="text" name="last_Name" placeholder="Enter Last Name" required>
    <p>Email</p>
    <input type="text" name="email" placeholder="Enter Email" required>
    <Gree type="submit" name="create_account" class="btn"> Create Account</button>
    <a href="login.php">Already have an account?</a>
  </form>
  </form>
</div>
</body>

<br />
<?php
$servername = "localhost";
$username = "yolbarsovi677";
$password = "";
$dbname = "HungryLionsSoftwareEngineProject";

$conn = mysqli_connect($servername, $username, $password, $dbname);

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Escape user inputs for security
$username = mysqli_real_escape_string($conn, $_REQUEST['username']);
$password = mysqli_real_escape_string($conn, $_REQUEST['username_Password']);
$first_Name = mysqli_real_escape_string($conn, $_REQUEST['first_Name']);
$last_Name = mysqli_real_escape_string($conn, $_REQUEST['last_Name']);
$email = mysqli_real_escape_string($conn, $_REQUEST['email']);

 
// attempt insert query execution
$sql = "INSERT INTO TreasureHuntUsers (username, username_Password, first_Name, last_name, email) VALUES ('$username', '$password', '$first_Name', '$last_Name', '$email')";
if(mysqli_query($conn, $sql)){
    echo "Record added successfully.";
} else{
  //  echo "ERROR: Could not able to execute $sql. " . mysqli_error($conn);
}
 
mysqli_close($conn);
?>
</body>
</html>