<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Fornecedor</title>
<link rel="stylesheet"
	href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="libs/jquery.dataTables.min.css">
</head>
<body>

	<div class="container">

		<form>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<p class="panel-title">Todos os Fornecedores</p>
				</div>
				<div class="panel-body">

					<table class="table table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Logradouro</th>
								<th>Número</th>
								<th>CEP</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="fornecedor" items="${fornecedores}">
								<tr>
									<td>${fornecedor.getId()}</td>
									<td>${fornecedor.getNome()}</td>
									<td>${fornecedor.getEmail()}</td>
									<td>${fornecedor.getEndereco().getLogradouro()}</td>
									<td>${fornecedor.getEndereco().getNumero()}</td>
									<td>${fornecedor.getEndereco().getCep()}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfooter>
						<tr>
							<td colspan="6">
								<button id="btnNovo" class="btn btn-success"
									style="margin-left: 45%"">
									<span class="glyphicon glyphicon-plus"></span> Novo
								</button>
							</td>
						</tr>
						</tfooter>
						
					</table>
				</div>
			</div>
		</form>

	</div>

</body>
</html>