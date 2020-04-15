<?php 
$databaseName = "HungryLionStudios";
$hostname = "hlsthp.ckfkbibakfnp.us-east-1.rds.amazonaws.com:3306";
$user = "root";
$password = "737262580";


$conn = mysqli_connect($hostname, $user, $password, $databaseName);

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
$query = " SELECT * FROM EasyScores ORDER BY score DESC LIMIT 10";
$result=mysqli_query($conn, $query);
$rank=0;
$temp_score=0;

if(mysqli_num_rows($result) > 0): ?>
<table>
    <tr>
        <th>Rank</th>
        <th>Username</th>
        <th>Score</th>
    <tr>
    <?php while($row = mysqli_fetch_assoc($result)): 
         if($temp_score!=$row['score'])
             $rank++;
    ?>
    <tr>
     <td style="font-weight: bold; text-align:center; color: #FB2525;"><?php echo "".$rank; ?></td>
     <td><?php echo $row['username']; ?></td>
     <td style="font-weight: bold;"><?php echo $row['score']; ?></td>
    </tr>
    <?php 
         $temp_score=$row['score'];
      endwhile; ?>
</table>
<?php endif; ?>