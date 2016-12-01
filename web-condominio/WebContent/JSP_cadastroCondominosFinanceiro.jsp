<!-- Pagina responsavel por receber dados financeiros dos moradores -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Object obj = request.getSession().getAttribute("nomeUsuario");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="JSP_TelaAdmin.jsp" />
<div class="row">
		<div class="col-lg-9 col-lg-offset-5">
			<div class="container">
				<form name="cadastroCondominosFinanceiro" method="POST"
					action="Servlet_VerificarStatusPagamento"
					class="form-horizontal">
					
					<div class="control-group">
						<label class="control-label" for="inputMes">Mês</label>
						<div class="controls">
							<select class="selectpicker" id="inputMes" name="mes">
								<option selected value="Janeiro">Janeiro</option>
								<option value="Fevereiro">Fevereiro</option>
								<option value="Março">Março</option>
								<option value="Abril">Abril</option>
								<option value="Maio">Maio</option>
								<option value="Junho">Junho</option>
								<option value="Junho">Junho</option>
								<option value="Agosto">Agosto</option>
								<option value="Setembro">Setembro</option>
								<option value="Outubro">Outubro</option>
								<option value="Novembro">Novembro</option>
								<option value="Dezembro">Dezembro</option>
							</select>

						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="inputfk_CPF">CPF</label>
						<div class="controls">
							<input id="inputfk_CPF" type="text" name="fk_CPF"
								placeholder="Somente números" pattern="[0-9]{11}" required
								autofocus />
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="inputvencimento">Data
							Vencimento</label>
						<div class="controls">
							<input id="inputvencimento" type="Date"
								name="vencimento" required autofocus />
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="inputpagEfetuado">Pagamento Realizado</label>
						<div class="controls">
							<select class="selectpicker" id="inputpagEfetuado"
								name="pagEfetuado">
								<option selected value="sim">Sim</option>
								<option value="não">Não</option>
							</select>

						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="inputdataPagamento">Data
							Pagamento</label>
						<div class="controls">
							<input id="inputdataPagamento" type="Date"
								name="dataPagamento" required autofocus />
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="inputboletoURL">CPF</label>
						<div class="controls">
							<input id="inputboletoURL" type="text" name="boletoURL"
								placeholder="Somente números" required
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
