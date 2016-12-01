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

	<jsp:include page="../menu.html"/>

	<div class="container"  style="padding-top: 15px;">

		<form>
			<div class="panel panel-default">
				<div class="panel-heading">
					<p class="panel-title">Todos os Fornecedores</p>
				</div>
				<div class="panel-body">

					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Logradouro</th>
								<th>Número</th>
								<th>CEP</th>
								<th style="width:100px">Ações</th>
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
									<td>
										<button class="btn btn-info btnEditar" title="Editar" type="button" data-id="${fornecedor.getId()}">
											<span class="glyphicon glyphicon-pencil"></span>
										</button>
										<button class="btn btn-danger btnDeletar" title="Deletar" type="button" data-id="${fornecedor.getId()}">
											<span class="glyphicon glyphicon-remove"></span>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfooter>
						<tr>
							<td colspan="7" style=""">
								<button id="btnNovo" class="btn btn-success"
									stylle="margin-left: 45%" type="button">
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

	<script src="libs/jquery-3.1.1.js"></script>
	<script src="libs/jquery.dataTables.min.js"></script>

	<script src="libs/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<!-- 
    <script src="../Scripts/library/toastr/toastr.min.js"></script>
    <script src="../Scripts/tools/toastrOptions.js"></script>
    <script src="../Scripts/app/dataAccess/login.js"></script>
    <script src="../Scripts/app/dataAccess/fornecedorRepository.js"></script>
 	-->
	<script src="js/cadastroFornecedor/listarFornecedor.js"></script>


	<script src="js/formValidation.js"></script>

</body>
</html>