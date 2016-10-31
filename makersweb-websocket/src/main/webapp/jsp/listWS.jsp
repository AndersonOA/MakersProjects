<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8" />
		<title>MakersWeb - Websockets</title>
		<script type="text/javascript" src="./_cdn/_js/contactws.js"></script>
	</head>
	<body>
		<h2 style="text-align: center;">Contacts:</h2>
		
		<table border="1" style="width: 100%;" id="contactTable">
			<thead>
				<tr>
					<th>Id:</th>
					<th>First Name:</th>
					<th>Last Name:</th>
					<th>E-mail:</th>
					<th>Phone:</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${contacts}">
					<tr>
						<td>${c.id}</td>
						<td>${c.firstName}</td>
						<td>${c.lastName}</td>
						<td>${c.email}</td>
						<td>${c.phone}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>