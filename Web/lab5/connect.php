<?php
$hostname = "moon.scs.ryerson.ca";
$username = "d2eliopo";
$password = "K@rt00nK0mb@t";
$database = "webdev";
 
// Create connection
$conn = new mysqli($hostname, $username, $password);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
echo "Connected successfully";
?>