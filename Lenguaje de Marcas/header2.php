
	<header>
		<div class="header">
			
			<h1>JDOCX</h1>
			<div class="optionsBar">
				<p>Donostia, <?php echo fechaC(); ?></p>
				<span>|</span>
				<span class="user"> <?php echo $_SESSION['user'] ?></span>
				<?php echo '<p><img class="photouser" src="images/'.$_SESSION['archivo'].'"></p>'?>
				<a href="logout.php"><img class="close" src="img/salir.png" alt="Salir del sistema" title="Salir">cerrar</a>
			</div>
		</div>  
		<?php include "nav.php"; ?>
	</header>
