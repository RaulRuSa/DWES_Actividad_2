<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Editar Evento</h2>
	<table border=1>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Descripcion</th>
				<th>Fecha Inicio</th>
				<th>Duracion</th>
				<th>Direccion</th>
				<th>Estado</th>
				<th>Destacado</th>
				<th>Aforo Maximo</th>
				<th>Minimo Asistencia</th>
				<th>Precio</th>
				<th>Id Tipo </th>
				<th>Id Nombre</th>
				<th>Id Descripción</th>
			<tr>
		</thead>
		<tbody>
			<tr>
				<td>${evento.id_Evento}</td>
				<td>${evento.nombre}</td>
				<td>${evento.descripcion}</td>	
				<fmt:formatDate pattern = "dd-MM-yyyy" value = "${eleEvento.fecha_Inicio}"/>		
				<td>${evento.duracion}</td>
				<td>${evento.direccion}</td>
				<td>${evento.estado}</td>
				<td>${evento.destacado}</td>
				<td>${evento.aforo_maximo}</td>
				<td>${evento.minimo_asistencia}</td>
				<td>${evento.precio_decimal}</td>
				<td>${evento.tipo.id_Tipo}</td>
				<td>${evento.tipo.nombre}</td>
				<td>${evento.tipo.descripcion}</td>
			<tr>
		</tbody>
	</table>
	<p><a href="/inicio">Volver a Inicio</a></p>
</body>
</html>