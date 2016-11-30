<%@ page import="model.CadastroCondominosDados" %>
<%@page import="servlets.LoginAuthentication"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Object obj = request.getSession().getAttribute("nomeUsuario");
%>
<html>
	<head>
		<title><% if(obj!=null){out.println("Admin: "+obj);} %></title>
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
		<h3><% if(obj!=null){out.println("Admin: "+obj);} %></h3>
		<div id="wrapper">
				
		<div id="menu-wrapper">
			<div id="menu">
				<ul>
					<li><a href="#" class="menu-item">Cadastros</a></li>
					<li><a href="#" class="menu-item">Relatórios</a></li>
					<li><a href="lancamento">Lançamentos</a></li>
					<li><a id="menu-login" href="homepage.jsp">Log out</a></li>
				</ul>
			</div>
		</div>
	</div>

		<div class="submenu" id="submenu-cad">
			<ul>
				<li><a href="cadastroCondominos.jsp">Moradores</a></li>
				<li><a href="#">Funcionários</a></li>
				<li><a href="despesa">Despesas</a></li>
				<li><a href="JSP_ListarNomesMoradores.jsp">Listar os moradores</a></li>
				
			</ul>
		</div>

		<div class="submenu" id="submenu-rel">
			<ul>
				<li><a href="#">Mensal por tipo de despesa</a></li>
				<li><a href="#">Inadiplência</a></li>
				<li><a href="#">Fundo de Caixa</a></li>
				<li><a href="#">Gráfico despesa/receita</a></li>
			</ul>
		</div>
	</div>
	
	<script type="text/javascript" src="libs/jquery-3.1.1.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	
		
	</body>
</html>
