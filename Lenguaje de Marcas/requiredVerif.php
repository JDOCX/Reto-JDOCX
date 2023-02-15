<?php
include "conexion.php";

//EL USUARIO SOLO PODRA INICIAR SESION SI SU verification_status está en 1.
    //ESTO SE CONSIGUE VERIFICANDO EL CORREO CON EL CODE CORRECTO

//session_start();
$user =   $_SESSION['user'];
//echo $user;
$query = mysqli_query($conection,"SELECT * FROM usuariosweb WHERE nombreUsuario='$user' AND verification_status='1'");
$result = mysqli_num_rows($query);
$data = mysqli_fetch_array($query);

//si el usuario que está logueado tiene verificaton_status = 1 le dejaremos entrar
if($result != 1){
    header("Location: login.php");
    exit();
}

?>
