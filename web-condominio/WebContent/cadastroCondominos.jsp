<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%Object obj = request.getSession().getAttribute("nomeUsuario"); %>
<!DOCTYPE html>
<html>
<head>
<title>Admin - cadastroCondominos</title>
<link rel="stylesheet" type="text/css" href="css/menu-estilo.css">
<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<style>
.row {
	margin-top: auto;
}

.masthead {
	background-color: @brand-primary;
}
</style>
</head>

<body>

<jsp:include page="JSP_TelaAdmin.jsp"></jsp:include>
	<div class="row">
		<div class="col-lg-9 col-lg-offset-5">
			<div class="container">
				<form name="cadastroCondominos" method="POST"
					action="ServletExibir_e_SalvarDadosCadastrados"
					class="form-horizontal">
					
					<div class="control-group">
						<label class="control-label" for="inputCPF">CPF</label>
						<div class="controls">
							<input id="inputCPF" type="text" name="CPF"
								placeholder="Somente nÃºmeros" pattern="[0-9]{11}" required
								autofocus />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputMorador_Nome">Nome</label>
						<div class="controls">
							<input id="inputMorador_Nome" type="text" name="Morador_Nome"
								placeholder="Nome Completo" required autofocus />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputMorador_Email">Email</label>
						<div class="controls">
							<input id="inputMorador_Email" type="email" name="Morador_Email"
								placeholder="Digite o email" required autofocus />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputMorador_DataNascimento">Data
							Nascimento</label>
						<div class="controls">
							<input id="inputMorador_DataNascimento" type="Date"
								name="Morador_DataNascimento" required autofocus />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputMorador_Sindico">� sindico? (0-NÃO/1-SIM)</label>
						<div class="controls">
							<select class="selectpicker" id="inputMorador_Sindico"
								name="Morador_Sindico">
								<option selected value="0">0</option>
								<option value="1">1</option>
							</select>

						</div>
					</div>

					<div class="control-group">
						<label class="control-label"
							for="inputTipo_morador_idTipo_morador">Proprietario ou
							Locatario?</label>
						<div class="controls">
							<select class="selectpicker"
								id="inputTipo_morador_idTipo_morador"
								name="Tipo_morador_idTipo_morador">
								<option selected value="proprietario">proprietario</option>
								<option value="locatario">locatario</option>
							</select>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputMorador_Telefone">Telefone
							Fixo</label>
						<div class="controls">
							<input id="inputMorador_Telefone" type="text"
								name="Morador_Telefone" placeholder="Format: xxxx-xxxx"
								pattern="{9}" required autofocus />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputMorador_Senha_Hash">Senha (8
							digitos)</label>
						<div class="controls">
							<input id="inputMorador_Senha_Hash" type="password" name="Morador_Senha_Hash"
								placeholder="" pattern="[0-9]{8}" required autofocus />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="inputConfirmarSenha">Confirmar
							Senha (8 digitos)</label>
						<div class="controls">
							<input id="inputConfirmarSenha" type="password"
								name="confirmarSenha" placeholder="" pattern="[0-9]{8}" required
								autofocus />
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<input id="cadastrar" class="btn" type="submit" value="Cadastrar" name="cadastrar" /> 
							<input id="limpar" class="btn" type="reset" value="Limpar Campos" name="limparCampos" />
						</div>

					</div>

				</form>
				
			</div>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-latest.js"></script>

	<script src="js/bootstrap.min.js"></script>

</body>
	
</html>
