<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pantalla de Login</title>
</head>
<body>
	<form action="/GestionClientes/login" method="post">
		<label for id="username">Nombre de usuario</label>
		<input type="text" id="username" name="username" >
		
		<label for id="password">Contrase�a</label>
		<input type="text" id="password" name="password">
		
		<input type="submit" value="Entrar">
	</form>
	<p>Mensaje: ${mensaje}</p>
</body>
</html>