<?php
require_once("dbutils.php");
$miConexion = conectarDB();
$total_juegos = contarTodosJuegos($miConexion);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
        <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
    <h2>EL NÚMERO TOTAL DE JUEGOS ACTUALMENTE ES <?php echo $total_juegos?></h2>

    <form action="app05.php" method="post">
        <div class="mb-3">
            <label class="form-label">Nombre</label>
            <input type="text" class="form-control" name="nombre">
        </div>
        <div class="mb-3">
            <label class="form-label">Descripción</label>
            <input type="text" class="form-control" name="desc">
        </div>
        <div class="mb-3">
            <label class="form-label">Categoría</label>
            <input type="text" class="form-control" name="categoria">
        </div>
        <button type="submit" class="btn btn-primary">Insertar</button>
    </form>
</body>
</html>