<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
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

		<form class="form-inline">
			<div class="panel panel-info">
  				<div class="panel-heading">Editar Despesa</div>
  				<div class="panel-body">
  					
	  				<table id="table-inputs">
	  					<tbody>
	  						<tr>
	  							<td class="column-labels"><label>Nome da Despesa: </label></td>				  						
	  							<td class="column-inputs"><input type="text" class="form-control" id="nome-despesa"></td>
	  						</tr>
	  						<tr>
	  							<td class="column-labels"><label>Fornecedor: </label></td>
	  							<td class="column-inputs">
	  								<select class="form-control" id="sel-fornecedor">
										<option value="S/F">S/F</option>
										<option value="Coelce">Coelce</option>
										<option value="Cagece">Cagece</option>
										<option value="Vivo">Vivo</option>
										<option value="Dedetizadora-X">Dedetizadora X</option>
										<option value="Segurança-Z">Segurança Z</option>
									</select>
	  							</td>
	  						</tr>
	  						<tr>
	  							<td class="column-labels"><label>Tipo de Despesa: </label></td>
	  							<td class="column-inputs">
	  								<select class="form-control" id="sel-tipo">
										<option value="Básico">Básico</option>
										<option value="Manutenção">Manutenção</option>
										<option value="Segurança">Segurança</option>
										<option value="Funcionário">Funcionário</option>
										<option value="Imposto">Imposto</option>
									</select>
	  							</td>
	  						</tr>
	  					</tbody>		  					
	  				</table>

					<button id="cadastrar-button" type="button" class="btn btn-success">Editar</button>

  				</div>
  			</div>
		</form>
	</div>
	
	<script type="text/javascript" src="libs/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/cadastro-despesa-novo.js"></script>
	
</body>
</html>