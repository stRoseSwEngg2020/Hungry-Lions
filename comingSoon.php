<html>
  <head>
    <meta name="author" content="Robinson Acosta">
    <meta name="keywords" content="Treasure, Studios, Lions, Hungry, Hunt, Game">
    <link rel="stylesheet" href="homepageStyle.css">
    <title>Coming Soon</title>
  </head>
<body>
<div id="viewport">
    <!-- Sidebar -->
    <div id="sidebar">
        <header><a href="#">Menu</a></header>
        <ul class="nav">
        <li><a href="homepage.php"><i class="zmdi zmdi-view-dashboard"></i>Dashboard</a></li>
        <li><a href="playGame.html"><i class="zmdi zmdi-play"></i>Play Treasure Hunt Game</a></li>
        <li><a href="myScores.php"><i class="zmdi zmdi-format-list-numbered"></i>My Scores</a></li>
        <li><a href="comingSoon.html"><i class="zmdi zmdi-account-circle"></i>My Profile Info </a></li>
        <li><a href="comingSoon.html"><i class="zmdi zmdi-settings"></i>Settings</a></li>
        <li><a href="comingSoon.html"><i class="zmdi zmdi-info-outline"></i>Privacy</a></li>
        <li><a href="login.php"><i class="zmdi zmdi-sign-in"></i>Logout</a></li>
        <section>
            <header><a href="#">Get In Touch:</a></header>
        </section>
        <li><a href="#"><i class="zmdi zmdi-email"></i>Email Customer Support</a></li>
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
            <h1>Coming Soon!</h1>
            <p>Check back for updates!</p>
        </div>
    </div>
</div>
</body>
</html>