<?php
//require('required.php');
include "conexion.php";

?>

<?php
$lifetime = 7200;
session_set_cookie_params($lifetime);
 session_start();
 //session_cache_expire(1);

 //si hay recepcion
 if(!empty($_POST)){
        $alert='';
        //validar q todos los campos vayan llenosñ
        if(empty($_POST['nombre']) || empty($_POST['correo']) || empty($_POST['nombreUsuario']) || empty($_POST['contrasena']) || empty($_POST['cclave']))
        {
            $alert='<p class="msg_error">Todos los campos son obligatorios.</p>';
        }else{

            //$idUsuario = $_POST['idUsuario'];
            //guardamos todos los datos recepcionados
            $nombre = $_POST['nombre'];
            $email  = $_POST['correo'];
            $user   = $_POST['nombreUsuario'];
            $archivo = $_FILES['archivo']['name'];
            $clave  = md5($_POST['contrasena']);
            $cclave = md5($_POST['cclave']);
            $verification_status = '';
             //creamos id unico
             $random_id = rand(time(),100000000);
             //creamos 4 digitos
             $otp = mt_rand(1111,9999);

            //validacion PHP email
            if(filter_var($email,FILTER_VALIDATE_EMAIL)){
                            //consultamos si existe ya algun usuario o mismo correo
                            $query = mysqli_query($conection,"SELECT * FROM usuariosweb WHERE nombreUsuario = '$user' OR correo = '$email' ");
                            $result = mysqli_num_rows($query);
                            $data = mysqli_fetch_array($query);   

                            //echo $data['usuario'];

                            //si el num de linas es mayor q 0 significa q existe ya un usuario
                            if($result > 0){         

                                $alert = '<p class="msg_error">El usuario o correo ya existe</p>';
                            }else{
                                                             
                                //variables de sesion para requiredVerif y verificar
                                //$_SESSION['email']  = $data['correo'];
                                //$_SESSION['user']  = $data['usuario'];
                                //$user = $_SESSION['user'];
                                //echo $_SESSION['user'];
                                echo $user;
                                //session_destroy();


    //COMPROBAMOS LA FOTO RECEPCIONADA
    
   //Si el archivo contiene algo y es diferente de vacio
   if (isset($archivo) && $archivo != "") {
    //Obtenemos algunos datos necesarios sobre el archivo
    $tipo = $_FILES['archivo']['type'];
    $tamano = $_FILES['archivo']['size'];
    $temp = $_FILES['archivo']['tmp_name'];
    //Se comprueba si el archivo a cargar es correcto observando su extensión y tamaño
   if (!((strpos($tipo, "gif") || strpos($tipo, "jpeg") || strpos($tipo, "jpg") || strpos($tipo, "png")) && ($tamano < 2000000))) {
      echo '<div><b>Error. La extensión o el tamaño de los archivos no es correcta.<br/>
      - Se permiten archivos .gif, .jpg, .png. y de 200 kb como máximo.</b></div>';
   }
   else {
      //Si la imagen es correcta en tamaño y tipo
      //Se intenta subir al servidor
      if (move_uploaded_file($temp, 'images/'.$archivo)) {
          //Cambiamos los permisos del archivo a 777 para poder modificarlo posteriormente
          chmod('images/'.$archivo, 0777);


          //confirmar contraseña
          if($clave == $cclave){                            

            //insertamos
            $query_insert = mysqli_query($conection,"INSERT INTO usuariosweb (nombre,correo,nombreUsuario,contrasena,fotoPerfil,otp,verification_status)
                                                            VALUES ('$nombre','$email','$user','$clave','$archivo','$otp','$verification_status')");
                               
    
                    //CORREOS
                    //mandamos correo comunicando que te has registrado
                     //generat unique string
$uniqidStr = md5(uniqid(mt_rand()));;
$verificar = 'http://192.168.1.155/JDOCXdef/verificar.php?fp_code='.$uniqidStr;
                    $asunto = 'TE HAS REGISTRADO A JDOCX';
                    $mailContent = 'Estimad@ '.$nombre.', 
                    <br/><br/>Para activar su cuenta tendras que verificarla. Si esto fue un error, simplemente ignore este correo electrónico y no pasará nada.
                    <br/>Para verificar su cuenta, visite el siguiente enlace: <a href="'.$verificar.'">'.$verificar.'</a>
                    <br/>Code verif: '.$otp.'
                    <br/><br/>Saludos';    
                    //$code = "code verif: ".$otp;
                    //set content-type header for sending HTML email
                    $headers = "MIME-Version: 1.0" . "\r\n";
                    $headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
                    $de = 'From: jo.gonzalez@aulanz.net';
                    
                    if (mail($email, $asunto, $mailContent, $headers,$de))
                        {
                    //echo "Correo enviado satisfactoriamente";
                        }

                    //se nos notificará que el usuario se ha registrado con sus datos
                    $empresaEmail = 'jo.gonzalez@aulanz.net';
                    $asunto2 = $nombre.' SE HA REGISTRADO';
                    $datos = "nombre: ".$nombre."\n"."email: ".$email."\n"."usuario: ".$user;
                    if(mail($empresaEmail,$asunto2,$datos)){
                    //    echo "nos ha llegao su inf";
                    }
               

                    
    

                    if($query_insert){
                        $alert='<p class="msg_save"> Revise su correo para activar la cuenta.</p>';

                        echo "sesion de: ".$user;
                        //var de sesion
                        
                        //var de sesion
                        $_SESSION['archivo'] =  $archivo;

                       $_SESSION['user'] = $user;
                        echo $_SESSION['user'];
                       
                        //echo "revisa tu correo para verificar tu cuenta";
                       
                    }else{
                        $alert='<p class="msg_error"> Error al crear el usuario</p>';
                    }

}else{
    $alert = '<p class="msg_error">La clave tiene que ser la misma</p>';
   // session_destroy();
}

      }                                                                  
      }        
    }
                                
                        
                                
                            }
                    }else{
                        $alert = '<p class="msg_error">correo raro</p>';
                    }

    }
}

?>



<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registro Usuario</title>
<?php include "js/scripts.php"; ?>

<body>

<?php include "header.php"; ?>


<br>
	<section id="container">
		
    <div class="form_register">
    <h1>REGISTRARSE</h1>
    <hr>
    <div class="alert"><?php echo isset($alert) ? $alert : ''; ?></div>

    <form action="" method="post" enctype="multipart/form-data"/>
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre" id="nombre" placeholder="nombre completo">
    <br>
    <label for="correo">Email</label>
    <input type="email" name="correo" id="correo" pattern="/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/" placeholder="correo electronico">
    <br>
    <label for="usuario">Usuario</label>
    <input type="text" name="nombreUsuario" id="usuario" placeholder="usuario">
    <br>
    <label for="clave">Contraseña</label>
    <input type="password" name="contrasena" id="clave" placeholder="contraseña">
    <br>
    <label for="clave">Confirmar Contraseña</label>
    <input type="password" name="cclave" id="clave" placeholder="contraseña">
    <br>

    <br>
    <input type="checkbox" name="condiciones" value="condiciones" required="required">aceptar términos y condiciones de la ley de protección de datos 
    <a href="https://www.boe.es/buscar/act.php?id=BOE-A-2018-16673">link</a>
    <br>
    <br>
    Añadir imagen: <input name="archivo" id="archivo" type="file"/>

    
</select>
    <input type="submit" name="subir" value="Crear Usuario" class="btn_save">
    </fomr>

    </div>
	</section>

<?php include "footer.php"; ?>

</body>
</html>

