<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td rowspan="2"><a href="/GestionClientes/login">Login</a></td>
			<td rowspan="2"><a href="/GestionClientes/registrarse">Registro</a></td>
		</tr>
	</table>
	<h2>BIENVENIDO</h2>
	<p>REGISTRESE COMO USUARIO</p>
	<form action="/GestionClientes/registrarse" method="post">
		<label for id="username">Username </label>
		<input type="text" id="usename" name="username" >
		<label for id="password">Password</label>
		<input type="text" id="password" name="password">
		<br>
		<label for id="email">Email</label>
		<input type="text" id="email" name="email">
		<label for id="nombre">Nombre</label>
		<input type="text" id="nombre" name="nombre">
		<br>
		<label for id="direccion">Direccion</label>
		<input type="text" id="direccion" name="direccion">
		<input type="submit" value="Resgistrarse">
	</form>
</body>
</html>


