<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Usuario</title>
</head>
<body>
<div class="container text-center">
    <h1>Formulario de Usuario</h1>
    <form action="formulario-usuario" method="post" >
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        
        <label for="correo">Correo electrónico:</label>
        <input type="email" id="correo" name="correo" required><br><br>
        
        <label for="clave">Clave:</label>
        <input type="password" id="clave" name="clave" required><br><br>
        
        <label for="saldo">Saldo:</label>
        <input type="number" id="saldo" name="saldo" required><br><br>
        
        <button type="submit">Crear Usuario</button>
        <br>
         <button onclick="window.location.href = 'inicio_sesion.jsp';">Volver a inicio de sesión</button>    

    </form>
    </div>
</body>
</html>