<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
body {
	background-color: #f8f9fa;
	color: #343a40;
	padding-top: 23px;
}

.container {
	background-color: #fff;
	border-radius: 9px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	padding: 40px;
	text-align: center
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

.formulario {
	display: inline-block;
	text-align: left;
	.
	btn
	{
	width
	:
	100%;
}
}
</style>
</head>
<title>Formulario de Usuario</title>
</head>
<body>
	<div class="container">
		<h1>Formulario de Usuario</h1>
		<form class="formulario" action="formulario-usuario" method="post">
			<label for="nombre">Nombre:</label> <br> <input type="text"
				id="nombre" name="nombre" required><br>
			<br> <label for="correo">Correo electrónico:</label> <br> <input
				type="email" id="correo" name="correo" required><br>
			<br> <label for="clave">Clave:</label> <br> <input
				type="password" id="clave" name="clave" required><br>
			<br> <br>
			<button class="btn btn-primary" type="submit">Crear Usuario</button>

			<br>
			<br>
			<button onclick="window.location.href = 'inicio_sesion.jsp';"
				class="btn btn-secondary">Volver a inicio de sesión</button>

		</form>
	</div>
</body>
</html>