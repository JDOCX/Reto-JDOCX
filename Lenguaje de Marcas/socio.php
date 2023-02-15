
<?php
require('required.php');
?>


<?php

if(!empty($_POST)){
    $alert='';
    //validar q todos los campos vayan llenos
    if(empty($_POST['nombre']) || empty($_POST['apellido1']) || empty($_POST['apellido2']) || empty($_POST['dni']) || empty($_POST['email']) || empty($_POST['telefono']) || empty($_POST['iban']))
    {
        $alert='<p class="msg_save">Todos los campos son obligatorios.</p>';
    }else{

      
//nos llegara un correo con los datos de inscripción
$nombre = $_POST['nombre'];
$apellido1 = $_POST['apellido1'];
$apellido2 = $_POST['apellido2'];
$dni = $_POST['dni'];
$email = $_POST['email'];
$telefono = $_POST['telefono'];
$iban = $_POST['iban'];


$asunto2 = 'solicitud de inscripción de '.$nombre;
$datos = "nombre: ".$nombre."\n"."apellido 1: ".$apellido1."\n"."apellido 2: ".$apellido2."\n"."dni: ".$dni."\n"."email: ".$email."\n"."telefono: ".$telefono."\n"."num de iban: ".$iban;
$empresaEmail = 'di.piedra@aulanz.net'; //correo de empresa jdocx


    //solo se puede mandar max 5 argumentos
    //estos datos del cliente iran a un correo de JDOCX
if (mail($empresaEmail, $asunto2, $datos)){
    $alert='<p class="msg_save">nos ha llegado tu inf.</p>';

}
        //le comunicamos que se ha inscrito y le informaremos si podra abonarse
                $asunto = 'SOLICITUD DE INSCRIPCIÓN RECIBIDA '.$nombre;
                $mailContent = 'Estimad@ '.$email.', 
                                    <br/><br/>Te informaresmos si hay sito para usted. Si esto fue un error, simplemente ignore este correo electrónico y no pasará nada.
                                    <br/><br/>Saludos';        
                $informacion = 'te informaremos si hay sitio para usted';
                //set content-type header for sending HTML email
                $headers = "MIME-Version: 1.0" . "\r\n";
                $headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
                if (mail($email,$asunto,$mailContent,$headers)){
                //$alert='<p class="msg_save">le informaremos</p>';
        }
   
       
        }
    }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Socios</title>
</head>
<body>
    
<?php include "js/scripts.php"; ?>

<body>

<?php include "header2.php"; ?>


<br>
	<section id="container">
		
    <div class="form_register">
    <h1>Inscribirse para ser Socio</h1>
    <hr>
    <div class="alert"><?php echo isset($alert) ? $alert : ''; ?></div>

    <form action="socio.php" method="post">
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre" id="nombre" pattern="[A-Za-Z]{15}" placeholder="nombre">
    <br>
    <label for="nombre">Apellido 1</label>
    <input type="text" name="apellido1" id="apellido1" placeholder="primer apellido">
    <br>
    <label for="nombre">Apellido 2</label>
    <input type="text" name="apellido2" id="nombre" placeholder="segundo apellido">
    <br>
    <label for="nombre">DNI</label>
    <input type="text" name="dni" id="nombre" pattern="[0-9]{8}[A-Z]{1}" placeholder="dni">
    <br>
    <label for="correo">Email</label>
    <input type="email" name="email" id="correo" value="<?php echo $_SESSION['email']; ?>">
    <br>
    <label for="nombre">Telefono</label>
    <input type="text" name="telefono" id="telefono" pattern="[0-9]{9}" placeholder="nombre completo">
    <br>
    <label for="nombre">Numero de IBAN</label>
    <input type="text" name="iban" id="iban" placeholder="num de iban">
    <br>
    <input type="submit" value="Inscribirse" class="btn_save">

</form>
</body>
</html>

