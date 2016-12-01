<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebCondominio - Cadastro Fornecedor</title>

<link rel="stylesheet"
	href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="libs/jquery.dataTables.min.css">
<!-- <link rel="stylesheet" href="../Styles/toastr/toastr.min.css"> -->

</head>
<body>

<jsp:include page="../menu.html"/>

	<div class="container" style="padding-top: 15px;">

		<form class="" data-valid="false" method="POST">

			<div class="panel panel-default">

				<div class="panel-heading">
					<p class="panel-title">Cadastrar Fornecedor</p>
				</div>

				<div class="panel-body">

					<c:if test="${mensagem != null && mensagem.length() > 0}">
						<div id="mensagemCadastro" class="alert alert-danger">${mensagem}</div>
					</c:if>

					<input type="hidden" name="id" value="${fornecedor.getId()}"/>

					<div class="row">
						<!-- Nome Fornecedor -->
						<div class="form-group col-md-4">
							<label for="NomeFornecedor">Nome do Fornecedor</label> <input
								type="text" id="NomeFornecedor" name="NomeFornecedor"
								class="form-control" required minlength="3" maxlength="80"/>
						</div>

						<!-- Email Fornecedor -->
						<div class="form-group col-md-4">
							<label for="Email">E-mail do Fornecedor</label> <input
								type="text" id="Email" name="Email" class="form-control"
								required minlength="3" maxlength="80"/>
						</div>

						<div class="clearfix"></div>

						<!-- Tipo de Logradouro
						<div class="form-group col-md-2">
							<label for="TipoLogradouro">Tipo Logradouro</label> <select
								name="TipoLogradouro" id="TipoLogradouro" class="form-control"
								required>
								<option value="">Selecione...</option>
								<option value="1">Rua</option>
								<option value="2">Avenida</option>
							</select>
						</div>
 						-->

						<!-- Logradouro -->
						<div class="form-group col-md-5">
							<label for="Logradouro">Logradouro</label> <input type="text"
								id="Logradouro" name="Logradouro" class="form-control" required
								minlength="3" maxlength="150" />
						</div>

						<!-- Numero Logradouro -->
						<div class="form-group col-md-2">
							<label for="Numero">Número</label> <input type="text" id="Numero"
								name="Numero" class="form-control" required minlength="1" />
						</div>

						<!-- CEP -->
						<div class="form-group col-md-2">
							<label for="Cep">CEP</label> <input type="text" id="Cep"
								name="Cep" class="form-control inputmask-cep" required
								minlength="10" maxlength="10"
								pattern="[0-9]{2}.[0-9]{3}-[0-9]{3}$" />
						</div>

						<!-- Telefone Contato 
						<div class="form-group col-md-2">
							<label for="Telefone">Telefone</label> <input type="tel"
								id="Telefone" name="Telefone"
								class="form-control inputmask-phone" required minlength="14"
								maxlength="15" pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,5}$" />
						</div>
						-->
						<div class="clearfix"></div>

					</div>

				</div>

				<div class="panel-footer">
					<a href="ListaFornecedor"><button
							class="btn btn-danger" type="button">Voltar</button></a>
					<button id="btnCadastrarFornecedor"
						class="btn btn-success btn-formvalid centralizar-direita"
						type="submit" disabled>Cadastrar</button>
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
	<script src="js/cadastroFornecedor/cadastroFornecedor.js"></script>

	<script src="js/MaskedInputPlugin.js"></script>

	<script src="js/input-mask.js"></script>
	<script src="js/formValidation.js"></script>

</body>
</html>