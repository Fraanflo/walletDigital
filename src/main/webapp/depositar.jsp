<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Depositar</title>
</head>
<body>
 <h2>Depositar</h2>
       <form action="depositar" method="post"> 
        Monto a depositar: <input type="text" name="monto">
        <input type="hidden" name="accion" value="depositar"> 
        <input type="submit" value="Depositar">
    </form>

</body>
</html>