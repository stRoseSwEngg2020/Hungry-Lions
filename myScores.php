<!DOCTYPE html>
<html>
  <head>
    <meta name="author" content="Robinson Acosta">
    <meta name="keywords" content="Treasure, Studios, Lions, Hungry, Hunt, Game">
    <link rel="stylesheet" href="homepageStyle.css">
    <title>My Scores</title>
  </head>
<body>
<div id="viewport">
  <!-- Sidebar -->
  <div id="sidebar">
    <header><a href="#">Menu</a></header>
    <ul class="nav">
      <li><a href="homepage.php"><i class="zmdi zmdi-view-dashboard"></i>Dashboard</a></li>
      <li><a href="playGame.php"><i class="zmdi zmdi-play"></i>Play Treasure Hunt Game</a></li>
      <li><a href="myScores.php"><i class="zmdi zmdi-format-list-numbered"></i>My Scores</a></li>
      <li><a href="comingSoon.html"><i class="zmdi zmdi-account-circle"></i>My Profile Info </a></li>
      <li><a href="comingSoon.html"><i class="zmdi zmdi-settings"></i>Settings</a></li>
      <li><a href="comingSoon.html"><i class="zmdi zmdi-info-outline"></i>Privacy</a></li>
      <li><a href="login.php"><i class="zmdi zmdi-sign-in"></i>Logout</a></li>
      <section>
        <header><a href="#">Get In Touch:</a></header>
      </section>
      <li><a href="#"><i class="zmdi zmdi-email"></i>Support@THLSTHG.com</a></li>
      <li><a href="#"><i class="zmdi zmdi-phone"></i>(800)-637-855</a></li>
      <li><a href="#"><i class="zmdi zmdi-pin-drop"></i>The College of Saint Rose,<br> 432 Western Ave, Albany, NY 12203</a></li>
    </ul> 
    <!--Footer-->
    <footer id="footer">
      <p>&copy: Hungry Lion Studios. 2020 CSC434</p>
    </footer>
    <a class="toggle" href="#sidebar">
    </a>
  </div>
  <!-- Content -->
  <div id="content">
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <h1>Treasure Hunt Game</h1>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#"><i class="zmdi zmdi-notifications text-danger"></i></a></li>
          <li><a href="#"><?php session_start();echo $_SESSION['username'];?></a></li>
        </ul>
      </div>
    </nav>
    <div class="container-fluid">
      <h1>My Scores:</h1>
      <p>Here you can view your scores for each game difficulty.</p>
      <ul class="actions">
          <li><a class="button primary large" href="myScores.php?Easy=true">Easy</a></li>
          <li><a class="button primary large" href="myScores.php?Medium=true">Medium</a></li>
          <li><a class="button primary large" href="myScores.php?Hard=true">Hard</a></li>
      </ul>
      <div class="table-wrapper">
                <?php
                session_start();
                if (isset($_GET['Easy']))
                        {
                            easyL();
                        }

                function easyL()
                {
                    echo 'Easy Difficulty';
                    $servername = "localhost";
                    $username = "yolbarsovi677";
                    $password = "";
                    $dbname = "HungryLionsSoftwareEngineProject";

                    $conn = mysqli_connect($servername, $username, $password, $dbname);

                    if (!$conn)
                    {
                        die("Connection failed: " . mysqli_connect_error());
                    }
					          $login_user = mysqli_real_escape_string( $conn, $_REQUEST[ 'username' ] );
                    // $query = " SELECT * FROM EasyScores ORDER BY score DESC";
					          $login_user = $_SESSION['username'];
                    $query = "SELECT * FROM EasyScores WHERE username = '$login_user' ";
                    

                    $result = mysqli_query($conn, $query);
                    $rank = 0;
                    $temp_score = 0;

                    if (mysqli_num_rows($result) > 0): ?>
                        <table>
                            <tr>
                                <th>Rank</th>
                                <th>Username</th>
                                <th>Score</th>
                            <tr>
                            <?php while ($row = mysqli_fetch_assoc($result)):
                            if ($temp_score != $row['score']) $rank++;
                            ?>
                            <tr>
                            <td style="font-weight: bold; text-align:center; color: #FB2525;"><?php echo "".$rank; ?></td>
                            <td><?php echo $row['username']; ?></td>
                            <td style="font-weight: bold;"><?php echo $row['score']; ?></td>
                            </tr>
                            <?php
                            $temp_score = $row['score'];
                            endwhile; ?>
                        </table>
                    <?php endif;
                }?>
                <?php
                if (isset($_GET['Medium']))
                        {
                            mediumL();
                        }

                function mediumL()
                {
                  echo "Medium Difficulty";
                    $databaseName = "HungryLionsSoftwareEngineProject";
                    $hostname = "localhost";
                    $user = "yolbarsovi677";
                    $password = "";

                    $conn = mysqli_connect($hostname, $user, $password, $databaseName);

                    if (!$conn)
                    {
                        die("Connection failed: " . mysqli_connect_error());
                    }
                    $login_user = $_SESSION['username'];
                    $query = "SELECT * FROM MediumScores WHERE username = '$login_user' ";
                    $result = mysqli_query($conn, $query);
                    $rank = 0;
                    $temp_score = 0;

                    if (mysqli_num_rows($result) > 0): ?>
                        <table>
                            <tr>
                                <th>Rank</th>
                                <th>Username</th>
                                <th>Score</th>
                            <tr>
                            <?php while ($row = mysqli_fetch_assoc($result)):
                            if ($temp_score != $row['score']) $rank++;
                            ?>
                            <tr>
                            <td style="font-weight: bold; text-align:center; color: #FB2525;"><?php echo "".$rank; ?></td>
                            <td><?php echo $row['username']; ?></td>
                            <td style="font-weight: bold;"><?php echo $row['score']; ?></td>
                            </tr>
                            <?php
                            $temp_score = $row['score'];
                            endwhile; ?>
                        </table>
                    <?php endif; 
                }?>
                <?php
                if (isset($_GET['Hard']))
                        {
                            hardL();
                        }

                function hardL()
                {
                    echo 'Hard Difficulty';
                    $databaseName = "HungryLionsSoftwareEngineProject";
                    $hostname = "localhost";
                    $user = "yolbarsovi677";
                    $password = "";

                    $conn = mysqli_connect($hostname, $user, $password, $databaseName);

                    if (!$conn)
                    {
                        die("Connection failed: " . mysqli_connect_error());
                    }
                    $login_user = $_SESSION['username'];
                    $query = "SELECT * FROM HardScores WHERE username = '$login_user' ";
                    $result = mysqli_query($conn, $query);
                    $rank = 0;
                    $temp_score = 0;

                    if (mysqli_num_rows($result) > 0): ?>
                        <table>
                            <tr>
                                <th>Rank</th>
                                <th>Username</th>
                                <th>Score</th>
                            <tr>
                            <?php while ($row = mysqli_fetch_assoc($result)):
                            if ($temp_score != $row['score']) $rank++;
                            ?>
                            <tr>
                            <td style="font-weight: bold; text-align:center; color: #FB2525;"><?php echo "".$rank; ?></td>
                            <td><?php echo $row['username']; ?></td>
                            <td style="font-weight: bold;"><?php echo $row['score']; ?></td>
                            </tr>
                            <?php
                            $temp_score = $row['score'];
                            endwhile; ?>
                        </table>
                    <?php endif; 
                }?>
            </div>
    </div>
  </div>
</div>
</body>
</html>