<?php
session_start();

require_once "conexion.php";
require "requiredChangePassword.php";

if(!empty($_POST)){
    if(empty($_POST['password'])) {
echo "ingresa la nueva contraseña";
    }else{
        
    //actualizar la contraseña
    $email = $_SESSION['email'];

    $clave  = md5($_POST['password']);
    //falta comprobar si la contraseña introducida es la misma
    $update = mysqli_query ($conection,"UPDATE usuariosweb SET contrasena = '$clave' WHERE correo = '$email';");

    if($update){
        echo "contraseña cambiada";
        header("location: logout.php");
             //$alert='</p>contraseña cambiada</p>';



    }else{
        echo "no se pudo cambiar la contraseña";
    }
    }

    }

?>
<!DOCTYPE html>
<html>
<head>
    <title>Cambiar Contraseña</title>
    <?php include "js/scripts.php"; ?>
    
    

</head>
<body>

<?php include "header.php"; ?>
<br>
<br>
<br>
<br>
<br>
<br>
	<div class="form_register">
		<h2>Resetea la Contraseña de tu Cuenta</h2>
        <?php echo !empty($statusMsg)?'<p class="'.$statusMsgType.'">'.$statusMsg.'</p>':''; ?>
		<div class="regisFrm">
			<form action="resetPassword2.php" method="post">
				<input class="form-control" type="password" name="password" placeholder="Contraseña" required="">
				<input class="form_control" type="password" name="confirm_password" placeholder="Confirma tu Contraseña" required="">
				<div class="send-button">
					<input type="hidden" name="fp_code" value="<?php //echo $_REQUEST['fp_code']; ?>"/>
					<input class="btn_save" type="submit" name="resetSubmit" value="Resetea Contraseña">
                    <br>
                    <a href="login.php">ir a login</a>

				</div>
			</form>
		</div>
	</div>
</body>
<?php //include "footer.php"; ?>

</html>