<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Inicio Sesión</title>
</head>
<body>
    <h2>Inicio de sesión </h2>
    <form action="InicioSesion" method="post">
        <label for="correo">Correo Eléctronico:</label>
        <input type="text" id="correo" name="correo" required><br>
        <label for="clave">Clave:</label>
        <input type="password" id="clave" name="clave" required><br>
        <button type="submit">Entrar</button>
    
     
    <button onclick="window.location.href = 'usuario-formulario.jsp';">Crear usuario</button>    
    </form>
     <%
    String error = request.getParameter("error");
    if (error != null && error.equals("true")) {
%>
   <div class="alert alert-danger" role="alert">
  Credeciales incorrectas, por favor intenta ingresar nuevamente.
</div>
<%
    }
%>
</body>
</html>