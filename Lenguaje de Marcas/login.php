<?php

session_start();
// si hay rececpcion
if(!empty($_POST)){
    //verificar si el user y passwd no estan vacios enviados por post
    if(empty($_POST['nombreUsuario']) || empty($_POST['contrasena'])) {
        $alert='<p class="msg_error">Ingrese sus credenciales</p>';

    }else{
        //nos conectamos
        require_once "conexion.php";
        //guardar lo que se envia en metodo  post  con la funcion de encriptación para evitar mysql injection
        //en mysql cambiar varchar a md5
        $user = mysqli_real_escape_string($conection,$_POST['nombreUsuario']);
        $pass = md5(mysqli_real_escape_string($conection,$_POST['contrasena']));
        //comprobamos si estas credenciales estan en la db
        $query = mysqli_query($conection,"SELECT * FROM usuariosweb WHERE nombreUsuario='$user' AND contrasena='$pass'");
        //guardar el resultado
        $result = mysqli_num_rows($query);
        //si encontramos un registro (sera mayor a 0)
        if($result > 0){
            //almacenamos los datos en el array data
            $data = mysqli_fetch_array($query);
            print_r($data);
            echo "<br/>";
            echo "perteneces a la db";
            //iniciamos las variables de sesion
            session_start();
            $_SESSION['active'] = true; //para validar si hay una sesion activa
            $_SESSION['idUser'] = $data['id'];
            $_SESSION['nombre'] = $data['nombre'];
            $_SESSION['email']  = $data['correo'];
            $_SESSION['user']  = $data['nombreUsuario'];
            $_SESSION['rol']  = $data['rol'];
                 //var de sesion
                 $_SESSION['archivo'] =  $data['fotoPerfil'];
            //si todo va bien, redireccionaremos al sistema
            header('location: index2.php');
        }else{
            session_destroy();
            //echo "<br/>";
            //echo "tu no peltenecel a la bazededatoz pailazooo";
            $alert='<p class="msg_error">No estás registrado</p>';
            //cerrar sesion si las credenciales son incorrectas
        
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
    <title>login</title>
</head>
<body>
<?php include "js/scripts.php"; ?>
<?php include "header.php"; ?>

<br>
<br>
<br>
<br>
<div class="form_register">
    <h1>Iniciar Sesión</h1>

    <div class="alert"><?php echo isset($alert) ? $alert : ''; ?></div>
<form action="login.php" method="post">

Usuario: <input class="form-control" type="text" name="nombreUsuario" id="nombre">
<br/>
Contraseña: <input class="form-control" type="password" name="contrasena" id="nombre">
<br/>
<input class="btn_save" type="submit" value="login"></input>
<a href="resetPassword.php"><h6>Cambiar Contraseña</h6></a>
</form>

</div>





</body>
</html>