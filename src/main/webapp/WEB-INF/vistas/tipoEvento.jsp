<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<table border="1">
		<thead>
			<tr>
				<th>Id Tipo</th>
				<th>Nombre</th>
				<th>Descripcion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ele" items="${tipoEventoLista}">			
				<tr>
					<td>${ele.id_Tipo}</td>
					<td>${ele.nombre}</td>
					<td>${ele.descripcion}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>