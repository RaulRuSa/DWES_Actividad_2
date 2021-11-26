<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<td rowspan="2"><a href="/GestionEventos/tiposEventos">Tipos de evento</a></td>
			<td rowspan="2"><a href="/GestionClientes/misreservas">Mis Reservas</a></td>
			<td rowspan="2"><a href="/GestionClientes/login">Login</a></td>
			<td rowspan="2"><a href="/GestionClientes/registrarse">Registro</a></td>
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
			<td>Id Evento</td>
			<td>${evento.id_Evento}</td>
			</tr>
		<tr>
		<tr>
			<td>Nombre</td>
			<td>${evento.nombre}</td>
			</tr>
		<tr>
			<td>Descripci�n</td>
			<td>${evento.descripcion}</td>
		</tr>
		<tr>
			<td>Direcci�n</td>
			<td>${evento.direccion}</td>
		</tr>
		<tr>
			<td>Fecha Inicio</td>
			<td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${ele.fecha_Inicio}"/></td>
		</tr>
		<tr>
			<td>Duraci�n</td>
			<td>${evento.duracion}</td>
			 </tr>
		<tr>
			<td>Aforo M�ximo</td>
			<td>${evento.aforo_maximo}</td>
		</tr>
		<tr>
			<td>M�nima Asistencia</td>
			<td>${evento.minimo_asistencia}</td>
		</tr>
		<tr>
			<td>Precio unitario</td>
			<td>${evento.precio_decimal}</td>
		</tr>
	</table>
	<br>
	<form action="/GestionClientes/reservar/${evento.id_Evento}" method="post">
		<label for="cantidad">Cantidad</label>
		<input type="number" id="cantidad" name="cantidad">
		<input type="hidden" name="id_Evento" value="${evento.id_Evento}">
		<input type="submit" value="Reservar">
	</form>
	
	<p>Mensaje: ${mensaje} </p>
</body>
</html>