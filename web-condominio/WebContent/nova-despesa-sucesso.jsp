<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="model.Despesa" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Web Condominio - Nova Despesa Sucessp</title>
	
	<link rel="stylesheet" type="text/css" href="libs/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">	
	<link rel="stylesheet" type="text/css" href="css/cadastro-despesa.css">
	
</head>
<body>

	<jsp:include page="menu.html"/>
	
	<div id="page-cad-nova-despesa">
		<div class="panel panel-info">
				
			<div class="alert alert-success" role="alert" id="mensagem-sucesso">
	 				<span class="glyphicon glyphicon-ok" aria-hidden="true"> </span>
	 				<span>Despesa ${despesa.nome} cadastrada com sucesso!</span>
	 		</div>
	 		
 			<div class="panel-body">
  				<div class="alert alert-success" role="alert" style="display: none" id="mensagem-sucesso">
		  			<span class="glyphicon glyphicon-ok" aria-hidden="true"> </span>
		  			<span>Nova despesa cadastrada com sucesso!</span>
		  		</div>

				<a href="despesa" id="volta" type="button" class="btn btn-success" >Voltar</a>
			</div>  				
 		</div>		
	</div>
	
	<script type="text/javascript" src="libs/jquery.dataTables.min.js"></script>
	
</body>
</html>