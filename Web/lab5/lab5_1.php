<?php

$rows = $_POST["rows"];
$cols = $_POST["columns"];

$path = "https://www2.cs.ryerson.ca/~d2eliopo/countlog.txt";

if($rows < 3) {echo "<p> Rows must be 3 or more!</p>";}
if($rows > 12) {echo "<p> Rows must be 12 or less!</p>";}

if($cols < 3) {echo "<p> Columns must be 3 or more!</p>";}
if($cols > 12) {echo "<p> Columns must be 12 or less!</p>";}


if ($rows > 2 && $rows < 13 && $cols > 2 && $cols < 13){
    echo "<table border=\"1\">";

            for ($r =0; $r < $rows; $r++){

                echo'<tr>';

                for ($c = 0; $c < $cols; $c++)
                    echo '<td>' .($c+1)*($r+1).'</td>';
               echo '</tr>'; // 

            }

      echo"</table>";
}







echo '<a href="https://www2.cs.ryerson.ca/~d2eliopo/lab5_1.html"> Return</a>'



include('counter.php');

?>