
<?php
$host = 'localhost';
$user = 'root';
$password = '';
$db = 'jdocxdef';

$conection = @mysqli_connect($host,$user,$password,$db);

if(!$conection){
    echo "error en la conexión";
}else{
    //echo "conexión establecida xd";
    
}
?>
