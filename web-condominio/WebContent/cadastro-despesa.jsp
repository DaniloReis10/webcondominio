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

	<jsp:include page="menu.html"/>

	<div id="page-cad-despesa">
			
		<div class="panel panel-default">
 			<div class="panel-heading">Despesas Cadastradas</div>
			<table class="table table-hover" id="table-cad">
			  	<thead>
			  		<tr>
			  			<th>#</th>
			  			<th>Nome</th>
			  			<th>Tipo</th>
			  			<th>Fornecedor</th>
			  			<th>Periodicidade</th>
			  			<th></th>
			  		</tr>
			  	</thead>
			  	<tbody>
			  	
			  		<c:forEach items="${despesas}" var="despesa">
					 	
					 	<tr>
					 		<td>${despesa.id}</td>
					  		<td>${despesa.nome}</td>
					  		<td>${despesa.tipo.descricao}</td>
					  		<td>${despesa.fornecedor.nome}</td>
					  		<td>${despesa.periodicidade.descricao}</td>
					  		<td>
					  			<ul class="option-list-table-icons">
					  				<li>
					  					<a type="button" class="btn btn-info btn-xs editar" id="editar-${despesa.id}">
					  						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					  					</a>
					  				</li>
					  				<li>
					  					<a type="button" class="btn btn-danger btn-xs excluir" id="excluir-${despesa.id}">
					  						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					  					</a>
					  				</li>
					  			</ul>
					  		</td>
					 	
					 	</tr>				 	
				 	</c:forEach>
			  	</tbody>
			</table>
		</div>

		<a href="nova-despesa" class="btn btn-default btn-lg" id="botao-novo">
 				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Novo
		</a>
		
	</div>
	
	<script type="text/javascript" src="libs/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/tabela-despesa.js"></script>
	<script type="text/javascript" src="js/cadastro-despesa.js"></script>

</body>
</html>