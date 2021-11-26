<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de Inicio</title>
</head>
<body>
	<h1>Actividad 2 Gestion de Eventos</h1>
	<ul>
		<li><a href="#">Tipos</a></li>
		<li><a href="#">Eventos</a></li>
		<li><a href="#">Usuarios</a></li>
		<li><a href="#">Eventos/tipo</a></li> 
		<li><a href="/GestionClientes/login">Login</a></li>
		<li><a href="/GestionClientes/registrarse">Registro</a></li>
		<li><a href="#">Salir</a></li>
	</ul>
	<h2>Añadir Evento</h2>
	<a href="/GestionEventos/altaEvento">Nuevo Evento</a>
	<h2>Lista de Eventos</h2>
	<table border=1>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th colspan="4">Opciones</th>
			<tr>
		</thead>
		<tbody>
		<!-- Recorro mi lista de eventos y muestro las opciones de editar eliminar y cancelar para cada evento -->
		<!-- Si elijo una de las opciones llamo a GestionEventos pasando la opcion correspondiente junto con -->
		<!-- la id del evento -->
		<c:forEach var="ele" items="${listaEventos}">
			<tr>
				<td>${ele.id_Evento}</td>
				<td>${ele.nombre}</td>
				<td>${ele.precio_decimal}</td>
				<td>${ele.estado}</td>
				<!-- A las opciones de editar entro con RequestParam -->
				<td><a href="/GestionEventos/editar?id=${ele.id_Evento}">Editar</a></td>
				<td><a href="/GestionEventos/eliminar?id=${ele.id_Evento}">Eliminar</a></td>
				<!-- A las opciones de editar entro con Pathvariable -->
				<c:choose>
					<c:when test="${ele.estado == 'activo' }">
						<td><a
							href="/GestionEventos/cancelar/${ele.id_Evento}">Cancelar</a></td>
					</c:when>

					<c:otherwise>
						<td><a
							href="/GestionEventos/cancelar/${ele.id_Evento}">Activar</a></td>
					</c:otherwise>
				</c:choose>
			</tr>
			
		</c:forEach>	
		
		</tbody>
	</table>
</body>
</html>