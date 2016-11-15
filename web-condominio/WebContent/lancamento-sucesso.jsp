<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Web Condominio - Lançamento de Despesa</title>
	
	<link rel="stylesheet" type="text/css" href="css/lancamento-despesa.css">
</head>
<body>
	
	<jsp:include page="menu.html"/>
	
	<div class="panel panel-info" id="resultado-lancamento">
		<div class="panel-heading">Laçamento de Despesa</div>
		<div class="alert alert-success" role="alert">Lançamento com valor total ${total} da data ${data} foi lançado com sucesso!</div>	
		<a href="homepage.jsp" id="volta" type="button" class="btn btn-success" >Home</a>
	</div>
	
	
	
</body>
</html>