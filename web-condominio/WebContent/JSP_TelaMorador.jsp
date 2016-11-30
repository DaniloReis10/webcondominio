<%@page import="servlets.LoginAuthentication"%>
<%@ page import="model.CadastroCondominosDados" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Object obj = request.getAttribute("nomeUsuario");
	

%>
<html>
	<!-- status pagamentos, relatorios,  -->
	<head>
		<title>Morador - <% out.println(obj); %></title>
		<link rel="stylesheet" type="text/css" href="css/menu-estilo.css">
		<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">
		
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	</head>
	<body>
		Bem - Vindo <% out.println(obj); %>
		<jsp:include page="menuMorador.html"/>
		
	</body>
</html>
