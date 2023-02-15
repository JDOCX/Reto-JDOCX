<!--plantilla-->

<!-- ESTO NO FUNCIONA -->

<?php
require('required.php');
require('requiredVerif.php');
?>
<?php
if(!empty($_POST)){
    $alert='';
    
    $nombre = $_POST['nombre'];
    $email  = $_POST['correo'];
    $user   = $_POST['usuario'];











    
   


}else{
    
}


?>

<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editar Perfil</title>
<?php include "js/scripts.php"; ?>

<body>

<?php include "header2.php"; ?>

	<section id="container">
    <div class="form_register">
    <h2>Editar Pefil</h2>

    <div class="alert"><?php //echo isset($alert) ? $alert : ''; ?></div>

    <form action="editarPerfil.php" method="post">
    <label for="nombre">Nombre</label>
    <input type="text" name="nombre" id="nombre" value="<?php echo $_SESSION['nombre']; ?>">
    <br>
    <label for="correo">Email</label>
    <input type="email" name="correo" id="correo" pattern="/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/" value="<?php echo $_SESSION['email']; ?>">
    <br>
    <label for="usuario">Usuario</label>
    <input type="text" name="usuario" id="usuario" placeholder="usuario" value="<?php echo $_SESSION['user']; ?>">
    <br>
    <br>
    <a href="resetPassword.php"><h3>Cambiar Contraseña</h3></a>
    <br>
    <input type="submit" value="Guardar" class="btn_save">
	</section>
    </select>
    
    </fomr>
</div>
<?php include "footer.php"; ?>

</body>
</html>
