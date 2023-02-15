<!--plantilla-->


<?php
//require('required.php');
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






  <section id="container">
        <!--baner-->
  </section>




  <!--carousel--->
  <!--script para q funcione el carousel-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


  <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="img/pexels-alexander-nadrilyanski-3684122.jpg"  class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>JDOCX</h5>
          <p>Gracias a nosotros podrás disfrutar todos los partidos de esta temporada, solo tines que darte de alta de socio. </p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="img/pexels-franco-monsalvo-14030573.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>PARTIDOS JUGADOS</h5>
          <p>En Fútbol hoy podrás consultar la agenda deportiva de partidos de fútbol que se transmiten en directo por televisión</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="img/pexels-franco-monsalvo-14030575.jpg" class="d-block w-100" alt="...">
        <div class="carousel-caption d-none d-md-block">
          <h5>CAMPEONATOS</h5>
          <p> ofrecemos distintas ventajas a diferentes colectivos que construyen la familia txuri urdin para que acudan a Anoeta y, todos juntos, nos emocionemos y vibremos en directo con el equipo de nuestros amores</p>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
     


 
<!---cartas--->
<div class="card-group">
    <div class="card">
      <img src="img/images.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">NUESTRO CAMPO</h5>
        <p class="card-text">Nuestro campo es un recinto deportivo propiedad del Real Madrid Club de Fútbol, situado en pleno paseo de la Castellana, en el distrito de Chamartín de Madrid, España. Se inauguró el 14 de diciembre de 1947 y su aforo actualmente es de 81 044 espectadores.​.</p>
        <button class="btn btn-dark" type="button">para mas información</button>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
    <div class="card">
      <img src="img/CAROUSEL.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">CANTERA</h5>
        <p class="card-text">La Real Sociedad es el club que más jugadores de su cantera ha utilizado en lo que llevamos de campeonato, 17, de las cinco principales Ligas de Europa, según un estudio realizado por el CIES Football Observatory. El club txuriurdin pelea por volver a un torneo continental por tercer curso consecutivo, algo que no logra desde los 80, y lo sigue haciendo tirando de los jóvenes de Zubieta.</p>
        <button class="btn btn-dark" type="button">para mas información</button>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
    <div class="card">
      <img src="img/CAROUSEL1.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">TÁCTICAS</h5>
        <p class="card-text">La táctica son todos aquellas acciones de ataque y defensa que se pueden realizar para sorprender (combatir) o contrarrestar (neutralizar) a los adversarios en el transcurso del partido, mientras el balón está en juego. Existen dos tipos de acciones tácticas individuales y colectivas</p>
        <button class="btn btn-dark" type="button">para mas información</button>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
  </div>
 
  <div class="card-group">
    <div class="card">
      <img src="img/CAROUSEL4.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">HISTORIA DEL CLUB</h5>
        <p class="card-text">La Real Sociedad de Fútbol, comúnmente llamada Real Sociedad, es un club de fútbol español de la ciudad de San Sebastián, en Guipúzcoa. Fue fundada en 1909 y juega en la Primera División de España.</p>
        <button class="btn btn-dark" type="button">para mas información</button>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
    <div class="card">
      <img src="img/CAROUSEL5.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">NUESTRA AFICCION</h5>
        <p class="card-text">Decenas de hinchas de la Real se han congregado en el exterior del Reale Arena en la previa europea y el campo ha respondido a la petición de Imanol</p>
        <button class="btn btn-dark" type="button">para mas información</button>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
    <div class="card">
      <img src="img/CAROUSEL6.jpg" class="card-img-top" alt="...">
      <div class="card-body">
        <h5 class="card-title">SIGUENOS</h5>
        <p class="card-text">Te recomendamos que no sigas en nuestras redes sociales.</p>
        <button class="btn btn-dark" type="button">para mas informacion</button>
        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
      </div>
    </div>
  </div>
 
<?php include "footer.php"; ?>


</body>
</html>





