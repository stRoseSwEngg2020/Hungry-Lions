<?php 
    if (isset($_GET['username'])){
        $databaseName = "HungryLionsSoftwareEngineProject";
        $hostname = "localhost";
        $user = "yolbarsovi677";
        $password = "";

        $conn = mysqli_connect($hostname, $user, $password, $databaseName);

        $username = $_POST["Username"];
        $score = $_POST["Score"];
        if (!$conn){
            die("Connection failed: " . mysqli_connect_error());
        }
        $query = "INSERT INTO EasyScores(username, score) VALUES(" + $username + ", " + $score + ")";
        mysqli_stmt_bind_param($query, $score, $username);
        mysqli_stmt_execute($query);

        mysqli_stmt_close($query);
        mysqli_close($conn);
        echo 'alert("Your score was uploaded to the leaderboard!")';
    }
    else{
        echo 'alert("Error in submitting your score, we are sorry!")';
    }
?>