<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Reservas</title>
</head>
<body>
	<p>Bienvenido ${nombreUsuario}</p>
	<table border="1">
		<tr>
			<td><a href="/GestionClientes/destacados">Destacados</a></td>
			<td rowspan="2"><a href="/GestionEventos/tiposEventos">Tipos de evento</a></td>
			<td rowspan="2"><a href="/GestionClientes/misreservas">Mis Reservas</a></td>
			<td rowspan="2"><a href="/GestionClientes/login">Login</a></td>
			<td rowspan="2"><a href="#">Registro</a></td>
			<td rowspan="2"><a href="/GestionClientes/cerrarSesion">Salir</a></td>
		</tr>
		<tr>
			<td><a href="/GestionClientes/activos">Activos</a></td>
		</tr>
	</table>
	<br>
	<h3>RESERVAS</h3>
	<table border=1>
		<thead>
			<tr>
				<th>Id Reserva</th>
				<th>Id Evento</th>
				<th>Evento</th>
				<th>Nombre Usuario</th>
				<th>Precio Total</th>
				<th>Plazas Reservadas</th>
			<tr>
		</thead>
		<tbody>
		<c:forEach var="ele" items="${listaReservas}">
			<tr>
				<td>${ele.idReserva}</td>
				<td>${ele.evento.id_Evento}</td>
				<td>${ele.evento.nombre}</td>
				<td>${ele.usuario.nombre}</td>
				<td>${ele.precioVenta}</td>
				<td>${ele.cantidad}</td>
			</tr>
			
		</c:forEach>	
		
		</tbody>
	</table>
</body>
</html>