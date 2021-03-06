<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8" />
		<title>MakersWeb - Cadastrar um Contato</title>
		<link rel="stylesheet" href="./_cdn/_css/reset.css" />
		<link rel="stylesheet" href="./_cdn/_css/style.css" />
		<link rel="stylesheet" href="./_cdn/_css/fonticon.css" />
	
		<script type="text/javascript" src="./_cdn/_js/jquery.js"></script>
		<script type="text/javascript" src="./_cdn/_js/controller.js"></script>
	</head>
	<body class="dashboard_main">
		<div class="dashboard_content">
			<article class="box box100">
				<header>
		            <h1>Cadastrar Contato:</h1>
		        </header>
				<div class="box_content">
					<form name="contato_add" action="" method="post" enctype="multipart/form-data">
						<input type="hidden" name="callback" value="contact"/> 
						 <c:if test="${not empty contact.id}">
							<input type="hidden" name="id" value="<c:out value="${contact.id}"></c:out>" />
							<input type="hidden" name="callback_action" value="update"/> 
						</c:if>
						<div class="callback_return"></div>
						<label class="label">
							<span class="legend">Primeiro Nome:</span>
							<input type="text" name="firstName" placeholder="Primeiro Nome:" value="<c:out value="${contact.firstName}"></c:out>" /> 
						</label>
						<label class="label">
							<span class="legend">Segundo Nome:</span>
							<input type="text" name="lastName" placeholder="Segundo Nome:" value="<c:out value="${contact.lastName}"></c:out>" /> 
						</label>
						<label class="label">
							<span class="legend">E-mail:</span>
							<input type="email" name="email" placeholder="E-mail:" value="<c:out value="${contact.email}"></c:out>" /> 
						</label>
						<label class="label">
							<span class="legend">Telefone:</span>
							<input type="text" name="phone" placeholder="Telefone:" value="<c:out value="${contact.phone}"></c:out>" /> 
						</label>
						
						<div class="m_top">&nbsp;</div>
						<img class="form_load none" style="float: right; margin-top: 3px; margin-left: 10px;" alt="Enviando Requisição!" title="Enviando Requisição!" src="./_cdn/_img/load.gif"/>
		            	<button class="btn btn_green fl_right"><c:out value="${empty contact.id ? 'Cadastrar' : 'Atualizar'}"></c:out>!</button>
		                <div class="clear"></div>
					</form>
				</div>
			</article>
		</div>
	</body>
</html>