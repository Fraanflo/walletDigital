<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Inicio Sesión</title>
<style>
    body {
      background-color: #f8f9fa;
      color: #343a40;
      padding-top: 23px;
    }
    .container {
      background-color: #fff;
      border-radius: 9px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
      padding: 40px;
    
    }
    h1 {
      color: #007bff;
    }
    footer {
      background-color: #007bff;
      color: #fff;
      padding: 10px 10px;
      border-radius: 5px;
     
    }
  </style>
</head>
<body>
   <div class="container text-center">
   <header>
           <h1> Billetera Digital</h1>
           <p>Bienvenido/a a tu Billetera, ¡Nos alegra verte nuevamente!</p>
           <h3> Inicia sesión: </h3>
       </header>
          
         <div class="form-group">
    <form action="InicioSesion" method="post">
        <label for="correo">Correo Eléctronico:</label>
        <input type="text" class="form-control" id="correo" name="correo" required><br>
        <label for="clave">Clave:</label>
        <input type="password"class="form-control" id="clave" name="clave" required><br>
        
             <%
    String error = request.getParameter("error");
    if (error != null && error.equals("true")) {
%>
   <div class="alert alert-danger" role="alert">

  Credenciales incorrectas, por favor intenta ingresar nuevamente.

      
<%
    }
%>
</div>
       <!--   <button type="submit">Entrar</button>-->
    <div class="d-grid gap-2 col-4 mx-auto">
  <button class="btn btn-primary" type="submit">Entrar</button>
  <button onclick="window.location.href = 'usuario-formulario.jsp';" class="btn btn-primary" type="button">Crear Usuario</button>
</div>
     
    <!--<button onclick="window.location.href = 'usuario-formulario.jsp';">Crear usuario</button>   --> 



 </form>
      </div>
     
<div class="container">
<footer class="text-center">
    
      <p>&copy; 2024, Billetera Digital. Todos los derechos reservados.</p>
        </footer>
    </div>
      
     </div>

</body>
</html>