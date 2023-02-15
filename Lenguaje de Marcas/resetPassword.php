
<?php


        require_once "conexion.php";


//si hay recepción
if(isset($_POST['forgotSubmit']))
	//validar que no este vacio
    if(!empty($_POST['email'])){
        $email = $_POST['email'];
      
		//ver si existe el usuario
        $query = mysqli_query($conection,"SELECT * FROM usuariosweb WHERE correo = '$email'");
        $result = mysqli_num_rows($query);
        $data = mysqli_fetch_array($query);
        session_start();
       $_SESSION['email'] = $data['correo'];
        echo $_SESSION['email'];


        if($data > 0){


        if($result > 0){
            $_SESSION['active2'] = true; //SOLICITAMOS EL CAMBIO DE PASSWORD

            //generat unique string
                    $uniqidStr = md5(uniqid(mt_rand()));;
                    $resetPassLink = 'http://192.168.1.155/JDOCXdef/resetPassword2.php?fp_code='.$uniqidStr;
        
                    //send reset password email
                    $to = $_POST['email'];
                    $subject = "Solicitud de Cambio de Contraseña";
                    $mailContent = 'Estimad@ '.$email.', 
                    <br/><br/>Recientemente se envió una solicitud para restablecer una contraseña para su cuenta. Si esto fue un error, simplemente ignore este correo electrónico y no pasará nada.
                    <br/>Para restablecer su contraseña, visite el siguiente enlace: <a href="'.$resetPassLink.'">'.$resetPassLink.'</a>
                    <br/><br/>Saludos';                ;
                    
                    //set content-type header for sending HTML email
                    $headers = "MIME-Version: 1.0" . "\r\n";
                    $headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
                    //additional headers
                    $headers .= 'From: JDOCX<sender@example.com>' . "\r\n";
                    //send email
                    mail($to,$subject,$mailContent,$headers);
                    $alert='<p class="msg_error">Le hemos mandado un correo</p>';
                    //echo "le hemos mandado un correo";    
            //header("location: resetPassword2.php");
                    

            }else{
                echo "no estar registrado";
            }


        }else{
            $alert = '<p class="msg_error">error</p>';
            echo "no estas registrado";
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
		<h2>Ingresa tu Dirección de Correo Electrónico para Resetear tu Contraseña</h2>
        <?php echo !empty($statusMsg)?'<p class="'.$statusMsgType.'">'.$statusMsg.'</p>':''; ?>
		<div class="regisFrm">
        <div class="alert"><?php echo isset($alert) ? $alert : ''; ?></div>
			<form action="resetPassword.php" method="post">
				<input class="form-control" type="email" name="email" placeholder="Correo" required="">
				<div class="send-button">
					<input class="btn_save" type="submit" name="forgotSubmit" value="Continuar">
				</div>
			</form>
		</div>
	</div>
</body>
</html>