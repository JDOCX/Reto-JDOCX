<!--plantilla-->

<?php
//require('required.php');
//require('registrarse.php');
include "conexion.php";

?>


<?php
 session_start();

if(!empty($_POST)){
                        //comprobar si existe y si esta vacia
                        if(isset($_SESSION['user']) && !empty($_SESSION['user'])){
                            $user = $_SESSION['user'];
                            $otp = $_POST['verif'];


                    echo $user."\n";
                    echo $otp."\n";
                                $query = mysqli_query($conection,"SELECT * FROM usuariosweb WHERE nombreUsuario='$user' AND otp='$otp'");
                                $result = mysqli_num_rows($query);

                                        if ($result > 0){
                                            echo "TODO CORRECTO";
                                            $query2= mysqli_query($conection,"UPDATE usuariosweb SET verification_status = 1 WHERE nombreUsuario='$user'");
                                            session_unset();
                                           session_destroy();                                       
                                                              
                                        }else{
                                            echo "codigo incorrecto";
                                        }
                            
                    }else{
                        echo "no hay una var de sesion establecida";
                        echo "  o la var de sesion esta vacia";
                    }
     //$email =  $_SESSION['email'];
    //$user = $_SESSION['usuario'];
    

           


}else{
    echo "pon el code xd";
}

?>
<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CRUD</title>
<?php include "js/scripts.php"; ?>

<body>

<?php include "header.php"; ?>
<div class="form_register">

	<section id="container">
    <form action="verificar.php" method="post">
        code de verificación
    <input type="text" name="verif" class="form-control">
    <br>
    <input type="submit" class="form-control">
    <a href='login.php'>Ir a login</a>
    </form>
</div>
<br>

	</section>

<?php include "footer.php"; ?>

</body>
</html>
<?php exit(); ?>
