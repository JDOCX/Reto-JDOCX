
<!-- SI NO HAY NINGUNA SESION INICIADA NOS REDIRECCIONA AL LOGIN.PHP -->
<?php
session_start();
if(!isset($_SESSION['active'])){
    header("Location: login.php");
    exit;
}
?>
