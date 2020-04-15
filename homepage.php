<!---DONE-->
<html>
  <head>
    <meta name="author" content="Robinson Acosta">
    <meta name="keywords" content="Treasure, Studios, Lions, Hungry, Hunt, Game">
    <link rel="stylesheet" href="homepageStyle.css">
    <title>Welecome to the Treasure Hunt Game</title>
  </head>
<body>
<div id="viewport">
    <!-- Sidebar -->
    <div id="sidebar">
        <header><a href="#">Menu</a></header>
        <ul class="nav">
        <li><a href="homepage.php"><i class="zmdi zmdi-view-dashboard"></i>Dashboard</a></li>
        <li><a href="playGame.html"><i class="zmdi zmdi-play"></i>Play Treasure Hunt Game</a></li>
        <li><a href="comingSoon.html"><i class="zmdi zmdi-format-list-numbered"></i>My Scores</a></li>
        <li><a href="comingSoon.html"><i class="zmdi zmdi-account-circle"></i>My Profile Info </a></li>
        <li><a href="comingSoon.html"><i class="zmdi zmdi-settings"></i>Settings</a></li>
        <li><a href="comingSoon.html"><i class="zmdi zmdi-info-outline"></i>Privacy</a></li>
        <li><a href="login.php"><i class="zmdi zmdi-sign-in"></i>Logout</a></li>
        <section>
            <header><a href="#">Get In Touch:</a></header>
        </section>
        <li><a href="#"><i class="zmdi zmdi-email"></i>Support@HLSTHG.com</a></li>
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
            <!-- <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><i class="zmdi zmdi-notifications text-danger"></i></a></li>
            <li><a href="#"> User</a></li>
            </ul> -->
        </div>
        </nav>
        <div class="container-fluid">
            <h1>World Leaderboards!</h1>
            <p>Here you can view the top 10 highscores for Easy, Medium and Hard difficulties.</p>
            <ul class="actions">
                <li><a class="button primary large" href="homepage.php?Easy=true">Easy</a></li>
                <li><a class="button primary large" href="homepage.php?Medium=true">Medium</a></li>
                <li><a class="button primary large" href="homepage.php?Hard=true">Hard</a></li>
            </ul>
            <div class="table-wrapper">
                <?php
                if (isset($_GET['Easy']))
                        {
                            easyL();
                        }

                function easyL()
                {
                    echo 'Easy Difficulty';
                    $databaseName = "HungryLionsSoftwareEngineProject";
                    $hostname = "localhost";
                    $user = "yolbarsovi677";
                    $password = "";

                    $conn = mysqli_connect($hostname, $user, $password, $databaseName);

                    if (!$conn)
                    {
                        die("Connection failed: " . mysqli_connect_error());
                    }
                    $query = " SELECT * FROM EasyScores ORDER BY score DESC LIMIT 10";
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
                    $query = " SELECT * FROM MediumScores ORDER BY score DESC LIMIT 10";
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
                    $query = " SELECT * FROM HardScores ORDER BY score DESC LIMIT 10";
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