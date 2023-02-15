<!--plantilla-->

<?php
require('required.php');
require('requiredVerif.php');
?>


<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CRUD</title>
<?php include "js/scripts.php"; ?>

<body>

<?php include "header2.php"; ?>

	<section id="container">

		<h1>Bienvenido <?php 
       
        echo $_SESSION['user'];
     
        echo '<p><img src="images/'.$_SESSION['archivo'].'"></p>';
        
        echo $_SESSION['nombre']."<br/>";
        echo $_SESSION['email'];
 
        
        ?></h1>
        <br>
        <br>

        <a href="socio.php">Quiro ser socio</a>
        <br>
        <a href="editarPerfil.php">Editar Perfil</a>

	</section>

<?php include "footer.php"; ?>

</body>
</html>
