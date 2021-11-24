<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista detalle de Evento</title>
</head>
<body>
	<p>Bienvenido ${nombreUsuario}</p>
	<table border="1">
		<tr>
			<td><a href="/GestionClientes/destacados">Destacados</a></td>
			<td rowspan="2"><a href="#">Tipos de evento</a></td>
			<td rowspan="2"><a href="#">Mis Reservas</a></td>
			<td rowspan="2"><a href="/GestionClientes/login">Login</a></td>
			<td rowspan="2"><a href="#">Registro</a></td>
			<td rowspan="2"><a href="/GestionClientes/cerrarSesion">Salir</a></td>
		</tr>
		<tr>
			<td><a href="/GestionClientes/activos">Activos</a></td>
		</tr>
	</table>
	<br>
	<h2>Detalle del Evento Seleccionado</h2>
	
	
	<br>
	<table border="1">
		<tr>
			<td>Nombre</td>
			<td>${evento.nombre}</td>
			</tr>
		<tr>
			<td>Descripcion</td>
			<td>${evento.descripcion}</td>
		</tr>
		<tr>
			<td>Direccion</td>
			<td>${evento.direccion}</td>
		</tr>
		<tr>
			<td>Fecha Inicio</td>
			<td>${evento.fecha_Inicio}</td>
		</tr>
		<tr>
			<td>Duracion</td>
			<td>${evento.duracion}</td>
			 </tr>
		<tr>
			<td>Aforo Máximo</td>
			<td>${evento.aforo_maximo}</td>
		</tr>
		<tr>
			<td>Mínima Asistencia</td>
			<td>${evento.minimo_asistencia}</td>
		</tr>
		<tr>
			<td>Precio unitario</td>
			<td>${evento.precio_decimal}</td>
		</tr>
	</table>
	
	<form method="/detalle" action="post">
		<label for="cantidad">Cantidad</label>
		<input type="number" id="cantidad" name="cantidad">
		<input type="submit" value="Reservar">
	</form>
	
	<!--
		 <form action="">
		<label for="cantidad">Cantidad</label>
		<input type="number" id="cantidad" name="cantidad">
		<a href="">
	</form>
	
	/GestionClientes/detalle/cantidad??????? como mando cantidad para /reservar/{id}
	 -->
	
	
	<p>Mensaje: </p>
</body>
</html>