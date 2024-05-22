<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<head>
<meta charset="UTF-8">
<title>Retirar</title>
</head>
<body>
    <form action="retirar" method="post">
        Monto a Retirar: <input type="text" name="monto">
        <input type="hidden" name="accion" value="retirar">
        <input type="submit" value="Retirar">
    </form>

</body>
</html>