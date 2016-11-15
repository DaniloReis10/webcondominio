<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Web Condominio - Editar Despesas</title>
	
	<link rel="stylesheet" type="text/css" href="libs/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">	
	<link rel="stylesheet" type="text/css" href="css/cadastro-despesa.css">
	
</head>
<body>

	<jsp:include page="menu.html"/>
	
	<div id="page-cad-nova-despesa">

		<div class="alert alert-success" role="alert" style="display: none" id="mensagem-sucesso">
  				<span class="glyphicon glyphicon-ok" aria-hidden="true"> </span>
  				<span>Despesa editada com sucesso!</span>
  		</div>

		<div class="alert alert-danger" role="alert" style="display: none" id="mensagem-erro">
  			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  			<span class="sr-only">Error:</span> Digite um novo nome válido para a despesa!
		</div>

		<form class="form-inline" method="post" action="editar-despesa">
		
			<input name="idDespesa" type="hidden" class="form-control" id="id" value="${despesa.id}">
			
			<div class="panel panel-info">
  				<div class="panel-heading">Editar Despesa</div>
  				<div class="panel-body">
  					
	  				<table id="table-inputs">
	  					<tbody>
	  						
	  						<tr>
	  							<td class="column-labels"><label>Nome da Despesa: </label></td>				  						
	  							<td class="column-inputs"><input name="nomeDespesa" type="text" class="form-control" id="nome-despesa" value="${despesa.nome}"></td>
	  						</tr>
	  						<tr>
	  							<td class="column-labels"><label>Fornecedor: </label></td>
	  							<td class="column-inputs">
	  								<select name="idFornecedor" class="form-control" id="sel-fornecedor">
	  								
	  									
	  									<c:forEach items="${fornecedores}" var="fornecedor">
	  										<c:choose>
	  										<c:when test="${fornecedor.id eq despesa.fornecedor.id}">
	  											<option selected="selected" value="${fornecedor.id}">${fornecedor.nome}</option>
	  										</c:when>
	  										<c:otherwise>
	  											<option value="${fornecedor.id}">${fornecedor.nome}</option>
	  										</c:otherwise>
	  										</c:choose>
		  								</c:forEach>
		  								
		  								
									</select>
	  							</td>
	  						</tr>
	  						<tr>
	  							<td class="column-labels"><label>Tipo de Despesa: </label></td>
	  							<td class="column-inputs">
	  								<select name="idTipo" class="form-control" id="sel-tipo">
	  								
										<c:forEach items="${tipos}" var="tipo">
	  										<c:choose>
	  										<c:when test="${tipo.id eq despesa.tipo.id}">
	  											<option selected="selected" value="${tipo.id}">${tipo.descricao}</option>
	  										</c:when>
	  										<c:otherwise>
	  											<option value="${tipo.id}">${tipo.descricao}</option>
	  										</c:otherwise>
	  										</c:choose>
		  								</c:forEach>
		  								
									</select>
	  							</td>
	  						</tr>
	  						<tr>
	  							<td class="column-labels"><label>Periodicidade: </label></td>
	  							<td class="column-inputs">
	  								<select name="idPeriodicidade" class="form-control" id="sel-tipo">
	  									
	  									<c:forEach items="${periodicidades}" var="periodicidade">
	  										<c:choose>
	  										<c:when test="${periodicidade.id eq despesa.periodicidade.id}">
	  											<option selected="selected" value="${periodicidade.id}">${periodicidade.descricao}</option>
	  										</c:when>
	  										<c:otherwise>
	  											<option value="${periodicidade.id}">${periodicidade.descricao}</option>
	  										</c:otherwise>
	  										</c:choose>
		  								</c:forEach>
	  									
									</select>
	  							</td>
	  						</tr>
	  					</tbody>		  					
	  				</table>

					<!-- <button id="cadastrar-button" type="button" class="btn btn-success">Editar</button> -->
					<input id="cadastrar-button" type="submit" class="btn btn-success" value="Editar" />

  				</div>
  			</div>
		</form>
	</div>
	
	<script type="text/javascript" src="libs/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/cadastro-despesa-novo.js"></script>
	
</body>
</html>