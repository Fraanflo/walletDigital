<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<head>
<meta charset="UTF-8">
<title>Retirar</title>
<style type="text/css">
 body {
      background-color: #f8f9fa;
      color: #343a40;
      padding-top: 23px;
    }
    .container {
      background-color: #fff;
      border-radius: 20px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
      padding: 40px;
    
    }
    h1 {
      color: #007bff;
    }
    h2{
     background-color: #007bff;
     border-radius: 9px;
     margin-left: 170px;
     margin-right: 170px;
     padding: 10px 10px;
     color: #fff;
     
    }
    footer {
      background-color: #007bff;
      color: #fff;
      padding: 10px 10px;
      border-radius: 5px;
      margin-left: 5px;
      margin-right: 5px;
     
    }
    </style>
</head>
<body>
<div class="container text-center">
<h2>Retirar</h2>
<h4>Por favor, ingresa un monto:</h4>
 <br>
    <form action="retirar" method="post">
        Monto a Retirar: <input type="text" name="monto">
      
      <div class="d-grid gap-2 col-4 mx-auto">
       <br>
     <button type="submit" class="btn btn-primary"  name="accion" value="depositar">Retirar Dinero</button>
<a class="btn btn-secondary" href="menu.jsp" role="button">Volver al menú</a>     </div>
        </form>
 
    <div class="container">
<footer class="text-center">
   
    
      <p>&copy; 2024, Billetera Digital. Todos los derechos reservados.</p>
        </footer>
        </div>
</div>


</body>
</html>