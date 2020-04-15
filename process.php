




<?php
/*
function login(){
	$con = mysqli_connect("localhost", "yolbarsovi677", "", "HungryLionsSoftwareEngineProject");

if (!$con) {
    die("Connection failed: " . mysqli_connect_error());
}
	
	if($con){
		$username = $_POST['username'];
		$password = $_POST['username_Password'];
		
		$sql = "SELECT * FROM `TreasureHuntUsers` WHERE `username` = '$username' AND `username_Password` = '$password'";
			$query = mysqli_query($con, $sql);
			if(mysqli_num_rows($query)){
				$user = mysqli_fetch_assoc($query);
				echo '<pre>';
				session_start();
				$_SESSION['user'] = $user;
				header('location:index.php');
			}else{
				echo 'User not found <a href="login.php"><button>GoTo Login page</button></a>';
			}
	}else{
		echo "Unable to Conncet";
	}
}



*/





$username = $_POST['username'];
$password = $_POST['username_Password'];

$username = stripcslashes($username);
$password = stripcslashes($password);
//$username = mysqli_real_escape_string('username');
//$password = mysqli_real_escape_string('username_Password');


$conn = mysqli_connect("localhost", "yolbarsovi677", "", "HungryLionsSoftwareEngineProject");

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$result = "SELECT * FROM `TreasureHuntUsers` WHERE `username` = '$username' AND `username_Password` = '$password'" or die ("Failed to query database" .mysqli_error());
	
$row = mysqli_fetch_array($result);
 
if ($row['username'] == $username && $row['username_Password' == $password]){
	echo "Login Successfull ";
}else{
	echo "Failed to login";
}

?>
