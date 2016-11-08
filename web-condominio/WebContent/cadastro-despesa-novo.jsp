<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Web Condominio - Nova Despesa</title>
	
	<link rel="stylesheet" type="text/css" href="libs/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">	
	<link rel="stylesheet" type="text/css" href="css/cadastro-despesa.css">
	
</head>
<body>

	<jsp:include page="menu.html"/>
	
	<div id="page-cad-nova-despesa">

		<div class="alert alert-success" role="alert" style="display: none" id="mensagem-sucesso">
  				<span class="glyphicon glyphicon-ok" aria-hidden="true"> </span>
  				<span>Nova despesa cadastrada com sucesso!</span>
  		</div>

		<div class="alert alert-danger" role="alert" style="display: none" id="mensagem-erro">
  			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  			<span class="sr-only">Error:</span> Digite um nome válido para a despesa!
		</div>

		<form method="get" action="cadastrar-despesa" class="form-inline">
			<div class="panel panel-info">
  				<div class="panel-heading">Nova Despesa</div>
  				<div class="panel-body">
  					
	  				<table id="table-inputs">
	  					<tbody>
	  						<tr>
	  							<td class="column-labels"><label>Nome da Despesa: </label></td>				  						
	  							<td class="column-inputs"><input name="nome" class="form-control" id="nome-despesa"></td>
	  						</tr>
	  						<tr>
	  							<td class="column-labels"><label>Fornecedor: </label></td>
	  							<td class="column-inputs">
	  							
	  								<select name="idFornecedor" class="form-control" id="sel-fornecedor">
		  								<c:forEach items="${fornecedores}" var="fornecedor">
		  									<option value="${fornecedor.id}">${fornecedor.nome}</option>
		  								</c:forEach>
									</select>
	  							</td>
	  						</tr>
	  						<tr>
	  							<td class="column-labels"><label>Tipo de Despesa: </label></td>
	  							<td class="column-inputs">
	  								<select name="idTipo" class="form-control" id="sel-tipo">
	  									<c:forEach items="${tipos}" var="tipo">
		  									<option value="${tipo.id}">${tipo.descricao}</option>
		  								</c:forEach>
									</select>
	  							</td>
	  						</tr>
	  						<tr>
	  							<td class="column-labels"><label>Periodicidade: </label></td>
	  							<td class="column-inputs">
	  								<select name="idPeriodicidade" class="form-control" id="sel-tipo">
	  									<c:forEach items="${periodicidades}" var="periodicidade">
		  									<option value="${periodicidade.id}">${periodicidade.descricao}</option>
		  								</c:forEach>
									</select>
	  							</td>
	  						</tr>
	  					</tbody>		  					
	  				</table>

					<a id="cadastrar-button" type="submit" class="btn btn-success" href="cadastrar-despesa">Cadastrar</a>

  				</div>
  			</div>
		</form>
	</div>
	
	<script type="text/javascript" src="libs/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/cadastro-despesa-novo.js"></script>
	
</body>
</html>