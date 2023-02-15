<?php
//no se podrá pasar a resetPassword2.php si no solicitamos el cambio de passwd en resetPassword.php
if(!isset($_SESSION['active2'])){
    header("Location: login.php");
    exit;
}
?>
