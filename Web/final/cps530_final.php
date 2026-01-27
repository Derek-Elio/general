

<html>
 <head>
  <title>CPS 530 Final Exam</title>
  
  <style>
	body {
    background-color: powderblue;
    font-family: Arial, Helvetica, sans-serif;
    
    margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;
    text-align: center;
    font-size: 24px;
    }
    

</style>
 </head>
 <body>
 
 <?php

$now = new DateTime();

function getGoodFriday($year) {
    $base = new DateTime("$year-03-21");
    $days = easter_days($year) - 2;

    return $base->add(new DateInterval("P{$days}D"));
}


$year = date("Y");
$GF = getGoodFriday($year);
if ($now > $GF) {$GF = getGoodFriday($year + 1);}

$interval = $now->diff($GF);
$days = $interval->format('%R%a');

echo "<p>Next Good Friday will be on: ";
echo $GF->format('Y-m-d');
echo "</p>";
echo "<p>That's only ";
echo $days;
echo " days away!</p>";


?>
 </body>
</html>