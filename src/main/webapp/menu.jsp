<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Menú Billetera</title>
</head>
<body>
    <h1>Menú</h1>
    <h3>Bienvenido/a, <%= session.getAttribute("nombre") %></h3>
  
   <br>
    <h2>Saldo actual: <%= session.getAttribute("saldo") %></h2>
    <form action="menu-usuario" method="post">
    
   <br>
   <h4>¿Qué deseas hacer?</h4>
      
    <button type="submit" name="accion" value="depositar">Depositar Dinero</button>
        <button type="submit" name="accion" value="retirar">Retirar Dinero</button>
        
    </form>
</body>
</html>