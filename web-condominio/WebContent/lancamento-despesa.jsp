<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Web Condominio - Lancamento de Despesa</title>
	
	<link rel="stylesheet" type="text/css" href="libs/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">	
	<link rel="stylesheet" type="text/css" href="css/lancamento-despesa.css">
</head>
<body>

	<jsp:include page="menu.html"/>
	
	<div id="lista-lancamentos">

			<div class="panel panel-info">
		  		<div class="panel-heading">Laçamento de Despesa</div>

		  		<div id="wrapper-lancamento">

		  		<div class="alert alert-danger" role="alert" id="alerta-data-antigo">
  					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"> </span> Data muito antiga! Coloque uma data mais recente.		
				</div>

				<div class="alert alert-danger" role="alert" id="alerta-data-frente">
  					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"> </span> Data muito à frente! Coloque uma data mais recente.	
				</div>

				<div class="alert alert-danger" role="alert" id="alerta-negativo">
  					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"> </span> Não é possível o lançamento de despesa negativa.
				</div>

				<div class="alert alert-danger" role="alert" id="alerta-sem-data">
  					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"> </span> Entre com uma data.
				</div>

		  		<table id="data-lancamento">
		  			<tbody>
		  				<tr>
		  					<td id="col-label"><label>Data de Lançamento:</label></td>
		  					<td><input type="month" class="form-control" id="input-data-lancamento"></td>
		  				</tr>
		  			</tbody>
		  		</table>
		  		

		  		<ul class="list-group" id="lista-lancamento">
				 	
				 	<c:forEach items="${despesas}" var="despesa">
					 	<li class="list-group-item list-group-item-warning">
					 		<table>
					 			<tbody>
					 				<tr>
					 					<td class="first-col">${despesa.nome}</td>
					 					<td><input type="number" class="form-control last-col" placeholder="R$"></td>
					 				</tr>
					 			</tbody>
					 		</table>
					 	</li>				 	
				 	</c:forEach>
				 	
				 	
				</ul>

				<div id="calcula-lancamento">
					<button class="btn btn-default btn-lg">
  						<span class="glyphicon glyphicon-euro" aria-hidden="true"></span> Calcular
					</button>
					<div id="total-input"></div>
				</div>

				<div id="lancamento">
					<button class="btn btn-default btn-lg">
  						<span class="glyphicon glyphicon-check" aria-hidden="true"></span> Realizar Lançamento
					</button>
				</div>
				</div>

		  	</div>
			
		</div>
		
		<script type="text/javascript" src="libs/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="js/lancamento-despesa.js"></script>
</body>
</html>