<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/functions.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">






    <?php
    //date_default_timezone_get('Europe/London');
    function fechaC(){
        $mes = array("","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");


        return date('d')." de ".$mes[date('n')]." de ".date('Y');


    }


    ?>

