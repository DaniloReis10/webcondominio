<%@page import="servlets.LoginAuthentication"%>
<%@ page import="model.CadastroCondominosDados" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Object obj = request.getSession().getAttribute("nomeUsuario");
%>
<html>
	<!-- status pagamentos, relatorios,  -->
	<head>
		<title><% if(obj!=null){out.println("Morador: "+obj);} %></title>
		<link rel="stylesheet" type="text/css" href="css/menu-estilo.css">
		<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">
		<style>
			h3{
				text-align: center;
			}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	</head>
	<body>
		<h3><% if(obj!=null){out.println("Bem Vindo "+obj+"!");} %></h3>
		<div id="wrapper">
				
		<div id="menu-wrapper">
			<div id="menu">
				<ul>
					
					<li><a href="#" class="menu-item">Cadastros</a></li>
					<li><a id="menu-login" href="homepage.jsp">Logout (sair)</a></li>
					
				</ul>
			</div>
		</div>

		<div class="submenu" id="submenu-cad">
			<ul>
				<li><a href="JSP_EmitirConsultarBoleto_e_StatusPagamento.jsp">Emitir/Consultar Boleto e status de Pagamentos</a></li>
				<li><a href="JSP_AlterarDadosCadastrados.jsp">Alterar Dados Cadastrados</a></li>
				
				
			</ul>
		</div>

	</div>
	
	
	
	<script type="text/javascript" src="libs/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
		
	</body>
</html>
