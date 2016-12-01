<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar</title>
	<link rel="stylesheet" type="text/css" href="css/menu-estilo.css">
	<link rel="stylesheet" type="text/css"
	href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">
	
</head>
<body>
	<jsp:include page="Menu.html"/>

	<form method="post" action="cadastrar-funcionario" class="form-inline"
		id="form-despesa">
		<div class="panel panel-info">
			<div class="panel-heading">Novo Funcionario</div>
			<div class="panel-body">

				<table id="table-inputs">
					<tbody>
						<tr>
							<td class="column-labels"><label>Nome</label></td>
							<td class="column-inputs"><input type="text"
								name="nome" class="form-control" id="nome">
							</td>
						</tr>
						<tr>
						<tr>
							<td class="column-labels"><label>Email</label></td>
							<td class="column-inputs"><input type="text"
								name="email" class="form-control" id="email">
							</td>
						</tr>
						<tr>
						
						<tr>
					<td>Sexo:</td>
					<td><input name="sexo" type="radio" value="Masculino"
						checked="checked" /> Masculino <input name="sexo" type="radio"
						value="Feminino" /> Feminino <span class="style1">*</span></td>
				</tr>
			
						
						<tr>
							<td class="column-labels"><label>Data Nascimento</label></td>
							<td class="column-inputs"><input type="text"
								name="datanascimento" class="form-control" id="datanascimento">
							</td>
						</tr>	
						
					
    				
						
						<tr>
							<td class="column-labels"><label>telefone</label></td>
							<td class="column-inputs"><input type="text"
								name="telefone" class="form-control" id="telefone">
							</td>
						</tr>		
						
						<tr>
							<td class="column-labels"><label>RG</label></td>
							<td class="column-inputs"><input type="text"
								name="rg" class="form-control" id="rg">
							</td>
						</tr>		
						
						<tr>
							<td class="column-labels"><label>CPF</label></td>
							<td class="column-inputs"><input type="text"
								name="cpf" class="form-control" id="cpf">
							</td>
						</tr>		
						
						
						<tr>
							<td class="column-labels"><label>Endereço</label></td>
							<td class="column-inputs"><input type="text"
								name="endereco" class="form-control" id="endereco">
							</td>
						</tr>		
						
						<tr>
							<td class="column-labels"><label>Bairro</label></td>
							<td class="column-inputs"><input type="text"
								name="bairro" class="form-control" id="bairro">
							</td>
						</tr>		
						
						<tr>
							<td class="column-labels"><label>Cidade</label></td>
							<td class="column-inputs"><input type="text"
								name="cidade" class="form-control" id="cidade">
							</td>
						</tr>	
						
						<tr>
					<td>Estado:</td>
					<td><select name="estado" id="estado" style="height: 25px ">
							<option>Selecione...</option>
							<option value="AC">AC</option>
							<option value="AL">AL</option>
							<option value="AP">AP</option>
							<option value="AM">AM</option>
							<option value="BA">BA</option>
							<option value="CE">CE</option>
							<option value="ES">ES</option>
							<option value="DF">DF</option>
							<option value="MA">MA</option>
							<option value="MT">MT</option>
							<option value="MS">MS</option>
							<option value="MG">MG</option>
							<option value="PA">PA</option>
							<option value="PB">PB</option>
							<option value="PR">PR</option>
							<option value="PE">PE</option>
							<option value="PI">PI</option>
							<option value="RJ">RJ</option>
							<option value="RN">RN</option>
							<option value="RS">RS</option>
							<option value="RO">RO</option>
							<option value="RR">RR</option>
							<option value="SC">SC</option>
							<option value="SP">SP</option>
							<option value="SE">SE</option>
							<option value="TO">TO</option>
					</select> </td>
				</tr>	
						
						<tr>
							<td class="column-labels"><label>Pais</label></td>
							<td class="column-inputs"><input type="text"
								name="pais" class="form-control" id="pais">
							</td>
						</tr>		
						<tr>
					<td>Cargo:</td>
					<td><select name="cargo" id="cargo" style="height: 25px">
							<option>Selecione...</option>
							<option value="Recepcionista">Recepcionista</option>
							<option value="Segurança">Segurança</option>
							<option value="Porteiro">Porteiro</option>
							<option value="Jardineiro">Jardineiro</option>
						</select>
								
						<tr>
							<td class="column-labels"><label>Data de Contratação</label></td>
							<td class="column-inputs"><input type="text"
								name="datacontratacao" class="form-control" id="datacontratacao">
							</td>
						</tr>		
						
							
						
						<tr> 
					<td>Estado Civil:</td>
					<td><select name="estadocivil" id="estadocivil"
						style="height: 25px">
							<option>Selecione...</option>
							<option value="Solteiro(a)">Solteiro(a)</option>
							<option value="Casado(a)">Casado(a)</option>
							<option value="Divorciado(a)">Divorciado(a)</option>
							<option value="Viúvo(a)">Viúvo(a)</option>
					</select> <span class="style1">* </span> 	
					</td>
					</tr>	
						
						<tr>
							<td class="column-labels"><label>Quantidade de Filhos</label></td>
							<td class="column-inputs"><input type="text"
								name="qtdFilhos" class="form-control" id="qtdFilhos">
							</td>
						</tr>		
						
						
						<tr>
							<td class="column-labels"><label>Nº Carteira de Trabalho</label></td>
							<td class="column-inputs"><input type="text"
								name="carteiratrabalho" class="form-control" id="carteiratrabalho">
							</td>
						</tr>		
						
						<tr>
							<td class="column-labels"><label>Salario</label></td>
							<td class="column-inputs"><input type="text"
								name="salario" class="form-control" id="salario">
							</td>
						</tr>		
						
						<tr>
							<td class="column-labels"><label>Carga Horaria</label></td>
							<td class="column-inputs"><input type="text"
								name="cargahoraria" class="form-control" id="cargahoraria">
							</td>
						</tr>		
						<tr>
						
						
						
					</tbody>
				</table>
				
					<tbody>
			  	
			  		<c:forEach items="${funcionarios}" var="fun">
					 	
					 	<tr>
					 		<td>${fun.nome}</td>
					  		<td>${fun.cpf}</td>
					  		<td>${fun.email}</td>
					  		<td>${fun.cargo}</td>
					  		
					  	
					 	</tr>				 	
				 	</c:forEach>
			  	</tbody>
				
				
				<a href="Menu.html" id="cadastrar-button" type="submit" class="btn btn-success" value="Cadastrar">Voltar</a>
				
				
				<input id="cadastrar-button" type="submit" class="btn btn-success"
					value="Cadastrar" /> 
				<!-- <button id="botao-novo" type="submit" class="btn btn-success">Cadastrar2</button>--> 

			</div>
		</div>
	</form>


</body>
</html>
