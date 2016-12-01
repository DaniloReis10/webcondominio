<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Web Condominio - Despesa</title>
	
	<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="libs/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="css/cadastro-despesa.css">
	<link rel="stylesheet" type="text/css" href="css/menu-estilo.css">

	<script type="text/javascript" src="libs/jquery-3.1.1.js"></script>
	
</head>
<body>
	
<%-- 	<jsp:include page="menu.html"/> --%>
	 <c:import  url="menu.html"/> 
	<br><br><br><br>
		<div class="row">
			<div class="col-lg-offset-2 col-lg-2">
				<ul class="nav nav-pills nav-stacked">
				  <li class="active"><a href="#">Tipo de Despesa</a></li>
				  <li><a href="#">Loren Ipsun </a></li>
				  <li><a href="#">Loren Ipsun </a></li>
				  <li><a href="#">Loren Ipsun </a></li>
				</ul>
			</div>
			<div class="col-lg-6">
						<div class="panel panel-default">
 			<div class="panel-heading">Relatorio mensal</div>
			<table class="table table-hover" id="table-cad">
			  	<thead>
			  		<tr>
			  			<th>Nome</th>
			  			<th>Tipo</th>
			  			<th>Visualisar</th>
			  		</tr>
			  	</thead>
			  	<tbody>
			  	
			  		<c:forEach items="${despesas}" var="despesa">
					 	
					 	<tr>
					  		<td>${despesa.nome}</td>
					  		<td>${despesa.tipo.descricao}</td>
					  		<td class="text-center">
					  			<ul class="option-list-table-icons">
					  				<li>
					  					<a type="button" class="btn btn-danger btn-xs" onclick="buscarRelatorio('${despesa.id}')">
					  						<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
					  					</a>
					  				</li>
					  			</ul>
					  		</td>
					 	
					 	</tr>				 	
				 	</c:forEach>
			  	</tbody>
			</table>
		</div>
			</div>
		</div>
		
	
	
	<script type="text/javascript" src="libs/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/tabela-despesa.js"></script>
	<script type="text/javascript" src="js/ajaxRelatorio.js"></script>

</body>
</html>