<!--plantilla-->

<?php
//require('required.php');
?>
<?php
//SOLICITUD DE INFORMACIÓN
if(!empty($_POST)){
    $alert='';
    //validar q todos los campos vayan llenos
    if(empty($_POST['nombre']) || empty($_POST['email']))
    {
        $alert='<p class="msg_save">Todos los campos son obligatorios.</p>';
    }else{
                    //correo informativo para el usuario que lo ha solicitado
                    $nombre    = $_POST['nombre'];
                    $para      = $_POST['email'];
                    $asunto    = 'SOLICITUD DE INFORMACIÓN';
                    $informacion = 'Estimad@ '.$nombre.', 
                    <br/><br/>Una de las ventajas de ser socio... Si esto fue un error, simplemente ignore este correo electrónico y no pasará nada.
                    <br/><br/>Saludos';
                    $de = 'From: jo.gonzalez@aulanz.net'; //correo de empresa
                    //set content-type header for sending HTML email
                    $headers = "MIME-Version: 1.0" . "\r\n";
                    $headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";

                    if (mail($para, $asunto, $informacion, $headers, $de))
                    {
                        $alert='<p class="msg_save">Le hemos mandado la inf</p>';
                    //echo "Le hemos mandado la inf"."<br/>";
                    }

                    //PARA QUE NOS LLEGE LA INF DEL USUARIO QUE HA SOLICITADO LA INF
                    $nombre = $_POST['nombre'];
                    $email = $_POST['email'];

                    $asunto2 = $nombre.' ha solicitado inf';
                    $datos = "nombre: ".$nombre."\n"."email: ".$email;
                    $empresaEmail = 'jo.gonzalez@aulanz.net';

                    if (mail($empresaEmail, $asunto2, $datos)){
                        //echo $nombre."ha solicitado información""<br/>";
                    }

	}
}
//FORMULARIO DE CONTACTO
    //si la recepcion no esta vacia
    if(!empty($_GET)){
    $alert2='';
    //validamos q los campos van llenos
    if(empty($_GET['nombre']) || empty($_GET['telefono']) || empty($_GET['email']) || empty($_GET['comentarios'])){
        $alert2='<p class="msg_save2">Todos los campos son obligatorios.</p>';
    }else{
                //le avisamo de q nos ha llegado la duda del usuaio
                    $nombre    = $_GET['nombre'];
                    $para      = $_GET['email'];
                    $asunto    = 'FORMULARIO DE CONTACTO';
                    $informacion = 
                    'Estimad@ '.$nombre.', 
                    <br/><br/>nos ha llegado su duda, le intentaremos responderemos a la mayor brevedad posibl... Si esto fue un error, simplemente ignore este correo electrónico y no pasará nada.
                    <br/><br/>Saludos';
                    //set content-type header for sending HTML email
                    $headers = "MIME-Version: 1.0" . "\r\n";
                    $headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
                    $de = 'From: jo.gonzalez@aulanz.net'; //correo de empresa


                    if (mail($para, $asunto, $informacion, $headers, $de))
                    {
                        $alert2='<p class="msg_save2">Le hemos mandado la inf</p>';
                    //echo "Le hemos mandado la inf"."<br/>";
                    }

                //para que nos llegue la duda del usuario
                    $nombre = $_GET['nombre'];
                    $telefono = $_GET['telefono'];
                    $email = $_GET['email'];
                    $duda = $_GET['comentarios'];

                    $asunto2 = $nombre.' ha realizado el formulario de contacto';
                    $datos = "nombre: ".$nombre."\n"."telefono: ".$telefono."\n"."email: ".$email."\n"."duda: ".$duda;
                    $empresaEmail = 'jo.gonzalez@aulanz.net';

                    if (mail($empresaEmail, $asunto2, $datos)){
                        //echo $nombre."ha solicitado información""<br/>";
                    }

    }


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

<!-- Solicitud de Información-->
<br>
<div class="form_register">
	<section id="container">
		<h1>Solicitud de Información</h1>
	</section>

<div class="alert"><?php echo isset($alert) ? $alert : ''; ?></div>

<form action="contacto.php" method="post">
        <br>
        nombre completo
        <input class="form-control" type="text" name='nombre' class="form-control" placeholder="nombre...">
      <br>
        email
        <input class="form-control" type="email" name='email' class="form-control" placeholder="email...">
        <br>
        <br>
		<input class="btn_save" type="checkbox" name="condiciones" value="condiciones" required="required">
        pulsa en enviar para que le mandemos información a su correo
        <br>
        <button type="submit" class="btn_save">Enviar</button>
</div>

    </form>


    
<!-- Formulario de Contacto-->
<div class="form_register">
	<section id="container">
		<h1>Formulario de Contacto</h1>
	</section>

<div class="alert2"><?php echo isset($alert2) ? $alert2 : ''; ?></div>
<form action="contacto.php" method="get">
        <p>Rellene el siguiente formulario de contacto y le responderemos a la mayor brevedad posible. Si lo prefiere,
            también puede ponerse en contacto con nostros en el teléfono 943 32 66 66.</p>
        <br>
        nombre completo
        <input type="text" name='nombre' class="form-control" placeholder="nombre...">
      <br>
        telefono
        <input type="text" name="telefono" class="form-control" placeholder="telefono">
        <br>
        email
        <input type="email" name='email' class="form-control" placeholder="email...">
        <br>
        <br>
        <div class="form_register" class="campo">
            <div class="campoLeft"><label for="comentarios">dudas?</label></div>
            <div class="campoRight">
                <textarea name="comentarios" rows="8" id="comentarios" class="txt_input"></textarea>
                            </div>
            <div class="limpiar"></div>
        </div>
        <br>
        <button type="submit" class="btn_save2">Enviar</button>
</div>

    </form>
    <br>
     <!--MAPS-->
    
     <div style="text-align:center;">

<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d23221.78898805711!2d-2.006960920898456!3d43.320044700000004!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd51a55cf327505d%3A0x566d74618bc8bd9c!2sNazaret%20Fundazioa!5e0!3m2!1ses!2ses!4v1676276017391!5m2!1ses!2ses" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>

</div>

<BR>
    <?php include "footer.php"; ?>

</body>
</html>
