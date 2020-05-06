<html>
<head>
<title>Treasure Hunt - Easy Mode</title>
<script>
	var GRID = 
   [['*', '*', '*', '*', '*'],
  	['*', '*', '*', '*', '*'],
  	['*', '*', '*', '*', '*'],
  	['*', '*', '*', '*', '*'],
  	['*', '*', '*', '*', '*']];
	var plrposR = 2;
	var plrposC = 2;

function Begin(GRID){
  plrposR = 2;
	plrposC = 2;
  document.getElementById("health").value = 100;
  
  for (var p = 0; p < 5; p++) {
	  for (var q = 0; q < 5; q++) {
				GRID[p][q] = "*";
			}
		}
	
  for (var g = 0; g < 2; g++) {
				var FPA = Math.floor(Math.random() * 5);
				var FPB = Math.floor(Math.random() * 5);
				
				GRID[FPA][FPB] = '[ ]';
        GRID[FPA][FPB+1] = '[ ]';
        GRID[FPA+1][FPB] = '[ ]';
        GRID[FPA+1][FPB+1] = '[ ]';
	}
  GRID[plrposR][plrposC] = "[ ]";
  var goodPlace = false;
		while (goodPlace == false) {
			var TrezA = Math.floor(Math.random() * 5);
			var TrezB = Math.floor(Math.random() * 5);
			
			if (GRID[TrezA][TrezB] == "*") {
				GRID[TrezA][TrezB] = "[$]";
				goodPlace = true;
			}
		}
  //alert("Updating grid...");
  for (var p = 0; p < 5; p++) {
	  for (var q = 0; q < 5; q++) {
      if (GRID[p][q] == "[ ]"){
          document.getElementById(p + "-" + q).innerHTML = GRID[p][q];
        } else {
          document.getElementById(p + "-" + q).innerHTML = "?";
        }
			}
		}
  button = document.getElementById('begin');
  button.style="color: white;";
  button.disabled="disabled";
}

  
  
function Guess(GRID, row, col){
  var theSpace = document.getElementById(row + "-" + col);
  
  if (theSpace.innerHTML == "-" || theSpace.innerHTML == "~" || theSpace.innerHTML == "O" || theSpace.innerHTML == "^"){
    if (theSpace.innerHTML == "-" || theSpace.innerHTML == "~"){
      alert("Click the 'START!' button to play.");
    }
    if (theSpace.innerHTML == "O"){
      alert("GAME OVER! Click 'Quit Game' to submit your score or refresh this page to try again.");
    }
    if (theSpace.innerHTML == "^"){
      alert("Level Complete! Click 'NEXT LEVEL!' to advance!");
    }
  }else if (theSpace.innerHTML == "?"){
  	if (GRID[row][col] == "[$]"){
	  alert("Treasure Found! Level Complete!");
      calculateScore();
      Crlevel = document.getElementById('level');
      Crlevel.value = parseInt(Crlevel.value) + 1;
	  Victory();
	  }
	if (GRID[row][col] == "*"){
	  Crhealth = document.getElementById('health');
  	  Crhealth.value = parseInt(Crhealth.value) - 6;
	  if (Crhealth.value <= 0){
		alert("You exploded! GAME OVER");
        Crhealth.value = 0;
        for (var p = 0; p < 5; p++) {
	      for (var q = 0; q < 5; q++) {
			document.getElementById(p + "-" + q).innerHTML = "O";
		  }
	    }
        for (var p = 0; p < 5; p++) {
	      for (var q = 0; q < 5; q++) {
			GRID[p][q] = "O";
		  }
	    }
		}else{
          document.getElementById(plrposR + "-" + plrposC).innerHTML = "X";
		  theSpace.innerHTML = ":)";
          plrposR = row;
          plrposC = col;
        }
	}
  }else if (theSpace.innerHTML == "[ ]" || theSpace.innerHTML == "X"){
  	 document.getElementById(plrposR + "-" + plrposC).innerHTML = "X";
	 theSpace.innerHTML = ":)";
     plrposR = row;
     plrposC = col;
  }
}
  
function calculateScore(){
  var HP = document.getElementById('health').value * 2;
  var newScore = 500 + HP;
  var oldScore = document.getElementById('score');
  oldScore.value = parseInt(oldScore.value) + newScore;
  alert("Level Score: " + newScore);
}
  
function Victory(){
  Crlevel = document.getElementById('level');
  if (Crlevel.value == 4){
    alert("YOU WIN!  Final Score: " + document.getElementById('score').value);
    document.getElementById('level').value = "GAME OVER!";
    button = document.getElementById('begin');
    button.value = "FINISH!";
    for (var p = 0; p < 5; p++) {
	     for (var q = 0; q < 5; q++) {
				  document.getElementById(p + "-" + q).innerHTML = "O";
		   }
	  }
    for (var p = 0; p < 5; p++) {
	     for (var q = 0; q < 5; q++) {
				  GRID[p][q] = "O";
		    }
	   }
  } else {
      button = document.getElementById('begin');
      button.value = "NEXT LEVEL!";
  	  button.style="color: black;";
      button.disabled=false;
      for (var p = 0; p < 5; p++) {
	      for (var q = 0; q < 5; q++) {
				  document.getElementById(p + "-" + q).innerHTML = "^";
		    }
	    }
      for (var p = 0; p < 5; p++) {
	      for (var q = 0; q < 5; q++) {
				  GRID[p][q] = "^";
		    }
	    }
  }
}
  
function QUIT(){
  	var user = getCookie("CKusername");
  	var pass = getCookie("CKpassword");
  	if (user != "") {
    	alert("Now Submitting score Score");
		<?php
			$databaseName = "HungryLionsSoftwareEngineProject";
            $hostname = "localhost";
			$user = "yolbarsovi677";
			$password = "";

			$conn = mysqli_connect($hostname, $user, $password, $databaseName);

			$username = $_POST["Username"];
			$score= $_POST["Score"];
			if (!$conn)
			{
				die("Connection failed: " . mysqli_connect_error());
			}
			$query = " INSERT INTO EasyScores(username, score) VALUES(?, ?)";
			mysqli_stmt_bind_param($query, $score, $username);
			mysqli_stmt_execute($query);

			mysqli_stmt_close($query);
			mysqli_close($conn);
	
		?>
    	//code for inserting score to database goes here
    	//The program should check if the player submitted a score to the leaderboard
    	//already, if so, update the score with the larger score, if not, insert a new row.
  	} else {
    	alert("error in gathering cookies, we're sorry!");
  }
	window.location.href = './homepage.php'
}
	
</script>
<body bgColor=DeepSkyBlue>
<font size="+2">
<center>
<h2>Easy Mode</h2>
<input onclick="Begin(GRID)" style="font-size : 40px;" type="button" id="begin" value="START!"><p></p>

<b>LEVEL:</b>
<input style="font-size : 20px;" type="text" disabled="disabled" id="level" value="1"><p></p>
<b>Health:</b>
<input style="font-size : 20px;" type="text" disabled="disabled" id="health" value="100"><p></p>
  
<table border = "9", cellspacing="0" style="font-size : 50px;">
<tr>
<td id="0-0", align="center" onclick="Guess(GRID, 0, 0)">-</td>
<td id="0-1", align="center" onclick="Guess(GRID, 0, 1)">-</td>
<td id="0-2", align="center" onclick="Guess(GRID, 0, 2)">-</td>
<td id="0-3", align="center" onclick="Guess(GRID, 0, 3)">-</td>
<td id="0-4", align="center" onclick="Guess(GRID, 0, 4)">-</td>
</tr>
<tr>
<td id="1-0", align="center" onclick="Guess(GRID, 1, 0)">~</td>
<td id="1-1", align="center" onclick="Guess(GRID, 1, 1)">~</td>
<td id="1-2", align="center" onclick="Guess(GRID, 1, 2)">~</td>
<td id="1-3", align="center" onclick="Guess(GRID, 1, 3)">~</td>
<td id="1-4", align="center" onclick="Guess(GRID, 1, 4)">~</td>
</tr>
<tr>
<td id="2-0", align="center" onclick="Guess(GRID, 2, 0)">-</td>
<td id="2-1", align="center" onclick="Guess(GRID, 2, 1)">-</td>
<td id="2-2", align="center" onclick="Guess(GRID, 2, 2)">-</td>
<td id="2-3", align="center" onclick="Guess(GRID, 2, 3)">-</td>
<td id="2-4", align="center" onclick="Guess(GRID, 2, 4)">-</td>
</tr>
<tr>
<td id="3-0", align="center" onclick="Guess(GRID, 3, 0)">~</td>
<td id="3-1", align="center" onclick="Guess(GRID, 3, 1)">~</td>
<td id="3-2", align="center" onclick="Guess(GRID, 3, 2)">~</td>
<td id="3-3", align="center" onclick="Guess(GRID, 3, 3)">~</td>
<td id="3-4", align="center" onclick="Guess(GRID, 3, 4)">~</td>
</tr>
<tr>
<td id="4-0", align="center" onclick="Guess(GRID, 4, 0)">-</td>
<td id="4-1", align="center" onclick="Guess(GRID, 4, 1)">-</td>
<td id="4-2", align="center" onclick="Guess(GRID, 4, 2)">-</td>
<td id="4-3", align="center" onclick="Guess(GRID, 4, 3)">-</td>
<td id="4-4", align="center" onclick="Guess(GRID, 4, 4)">-</td>
</tr>
</table>
<b>Score:</b>
<input style="font-size : 20px;" type="text" disabled="disabled" id="score" value="0">
<input onclick="QUIT()" style="font-size : 50px; color: blue;" type="button" id="quit" value="Quit and Upload Score"><br></br>
<a href="tutorial.html" target="_blank">(How to Play)</a>
</center>
</body>
</html>