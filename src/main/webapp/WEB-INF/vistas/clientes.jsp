<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Esta es la vista clientes</title>
</head>
<body>
	<h1>Zona Clientes</h1>
	<p>Bienvenido ${nombreUsuario}</p>
	
	<p><a href="/GestionClientes/eventos">Eventos</a></p>
	
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
	
	
	<h2>Lista de Eventos ${titulo}</h2>
	<table border=1>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Aforo</th>
				<th>Fecha</th>
				<th>Opciones</th>
			<tr>
		</thead>
		<tbody>
		
		<c:forEach var="ele" items="${listaEventos}">
			<tr>
				<td>${ele.nombre}</td>
				<td>${ele.aforo_maximo}</td>
				<td>${ele.fecha_Inicio}</td>
				<td><a href="/GestionClientes/detalle/${ele.id_Evento}">Detalle</a></td>
			</tr>
			
		</c:forEach>	
		
		</tbody>
	</table>
</body>
</html>