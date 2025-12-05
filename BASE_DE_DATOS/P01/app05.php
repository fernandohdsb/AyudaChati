<?php 
require_once("dbutils.php");
$miConexion = conectarDB();
//var_export($_POST);
$insercionOk = insertarJuego($miConexion,$_POST['nombre'],$_POST['desc'],$_POST['categoria']);


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>LA INSERCIÓN HA IDO: <?php echo ($insercionOk)?"OK":"KO" ?></h1>
</body>
</html>