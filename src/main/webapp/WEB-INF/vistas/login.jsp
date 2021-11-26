<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pantalla de Login</title>
</head>
<body>
	<h2>PANTALLA DE LOGIN</h2>
	<table border="1">
		<tr>
			<td rowspan="2"><a href="/GestionClientes/login">Login</a></td>
			<td rowspan="2"><a href="/GestionClientes/registrarse">Registro</a></td>
		</tr>
	</table>
	<br>
	<form action="/GestionClientes/login" method="post">
		<label for id="username">Nombre de usuario</label>
		<input type="text" id="username" name="username" >
		
		<label for id="password">Contraseña</label>
		<input type="text" id="password" name="password">
		
		<input type="submit" value="Entrar">
	</form>
	<p>Mensaje: ${mensaje}</p>
</body>
</html>