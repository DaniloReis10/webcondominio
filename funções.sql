-- TOTAL DE RECEITAS
SELECT SUM(Mensalidade_Valor) AS TOTAL_RECEITA
FROM mensalidade_condominio
WHERE Mensalidade_Pago = 0; 
 
-- TOTAL DA RECEITA POR MÊS
SELECT Mensalidade_Vencimento AS DATA,
	   SUM(Mensalidade_Valor) AS TOTAL
FROM mensalidade_condominio
WHERE (Mensalidade_Pago = 0) AND (Mensalidade_Vencimento = '2016-01-01'); 

-- LISTA - TOTAL DA RECEITA POR MÊS*
SELECT Mensalidade_Vencimento AS DATA,
	   SUM(Mensalidade_Valor) AS TOTAL
FROM mensalidade_condominio
WHERE (Mensalidade_Pago = 0)
GROUP BY Mensalidade_Vencimento;
							 
-- MORADORES INADIMPLENTES*
SELECT CPF, Morador_Nome AS CONDÔMINO,
	   Morador_Email AS EMAIL,
       Morador_DataNascimento AS DATA_NASCIMENTO,
       Morador_Sindico AS SINDICO,
       Morador_Telefone AS TELEFONE,
	   Tipo_Descricao AS TIPO
FROM  morador, tipo_morador
WHERE Morador_Adimplente = 1 AND morador.Tipo_morador_idTipo_morador = tipo_morador.idTipo_morador
ORDER BY Morador_Nome;

-- MORADORES ADIMPLENTES
SELECT CPF, Morador_Nome AS CONDÔMINO,
	   Morador_Email AS EMAIL,
       Morador_DataNascimento AS DATA_NASCIMENTO,
       Morador_Sindico AS SINDICO,
       Morador_Telefone AS TELEFONE,
	   Tipo_Descricao AS TIPO
FROM  morador, tipo_morador
WHERE Morador_Adimplente = 0 AND morador.Tipo_morador_idTipo_morador = tipo_morador.idTipo_morador
ORDER BY Morador_Nome;

-- INADIMPLÊNCIAS DE CADA MORADOR*
SELECT Morador_CPF AS CPF,
	   Morador_Nome AS CONDÔMINO,
       Mensalidade_Vencimento AS DATA_VENCIMENTO 
FROM  morador, mensalidade_condominio
WHERE morador.CPF = mensalidade_condominio.Morador_CPF AND mensalidade_condominio.Mensalidade_Pago = 1;

-- TOTAL DE DESPESAS POR MÊS*
SELECT Gasto_Data AS DATA, 
	   Gasto_Func AS SALÁRIOS,
       Gasto_Serv AS SERVIÇOS,
       (Gasto_Func + Gasto_Serv) AS DESPESAS
FROM gasto;

-- SALDO DO CAIXA POR MÊS*
select *
  ,(select sum(resto) from 
  saldoMes as s2 where s2.id <= s1.id) as SALDO
  from saldoMes as s1 
 
create  view saldoMes as
SELECT idMensalidade_Condominio AS ID,
	   Mensalidade_Vencimento AS DATA,
	   SUM(Mensalidade_Valor) AS RECEITAS,
       Gasto_Func AS SALÁRIOS, 
       Gasto_Serv AS SERVIÇOS,
       (Gasto_Func + Gasto_Serv) AS DESPESAS,
       ((SUM(Mensalidade_Valor)) - (Gasto_Func + Gasto_Serv)) AS RESTO
       FROM mensalidade_condominio AS m, gasto AS g
WHERE (Mensalidade_Pago = 0) AND (m.Mensalidade_Vencimento = g.Gasto_Data)
GROUP BY Mensalidade_Vencimento

-- MAIORES DESPESAS POR TIPO DE SERVIÇO*
SELECT idServico AS ID,
	   Servico_Nome AS DESCRIÇÃO,
       SUM(Servico_Valor) AS TOTAL 
FROM servico
GROUP BY Servico_Nome
ORDER BY TOTAL DESC;

-- SERVICO COM MAIOR DESPESA
SELECT idServico AS ID,
	   Servico_Nome AS DESCRIÇÃO,
       MAX(Servico_Valor) AS VALOR, 
       Servico_Data AS DATA
FROM servico
GROUP BY Servico_Nome
ORDER BY idServico;

-- MESES COM MAIORES DESPESAS DE SERVIÇOS 
SELECT Servico_Data AS DATA, 
	   SUM(Servico_Valor) AS TOTAL 
FROM servico
GROUP BY Servico_Data
ORDER BY idServico;

-- MÊS COM MAIOR INADIMPLÊNCIA 
SELECT Mensalidade_Vencimento AS DATA, 
	   SUM(Mensalidade_Valor) AS TOTAL 
FROM mensalidade_condominio
WHERE (Mensalidade_Pago = 0)
GROUP BY Mensalidade_Vencimento
ORDER BY TOTAL ASC;


-- MÊS COM MAIOR INADIMPLÊNCIA
select DATA, max(TOTAL) VALOR from Mes 
 
create  view Mes as
SELECT Mensalidade_Vencimento AS DATA, 
	   SUM(Mensalidade_Valor) AS TOTAL 
FROM mensalidade_condominio
WHERE (Mensalidade_Pago = 1)
GROUP BY Mensalidade_Vencimento
ORDER BY TOTAL DESC;



-- RESERVA DE ÁREAS*
SELECT Morador_Nome AS CONDÔMINO,
	   Morador_CPF AS CPF,
       Morador_Telefone AS TELEFONE,
       Evento_Data AS DATA, 
       Area_Descricao AS ÁREA_RESERVADA, 
       Evento_HorarioIni AS HORÁRIO_INICIAL, 
       Evento_HorarioFim AS HORÁRIO_FINAL
FROM morador, evento, area
WHERE morador.CPF = evento.Morador_CPF AND evento.Area_idAREA = area.idAREA ;

-- SERVIÇOS E EMPRESAS*
SELECT Empresa_Nome AS EMPRESA, 
	   Servico_Nome AS SERVIÇO,
       Empresa_Fone AS TELEFONE,
       Endereco_Rua AS RUA,
       Endereco_Num AS NÚMERO,
       Endereco_Bairro AS BAIRRO,
       Endereco_Cidade AS FORTALEZA
FROM servico, empresa, endereco
WHERE servico.idServico = empresa.idEmpresa AND empresa.Endereco_idEndereco = endereco.idEndereco;

-- INFORMAÇÃO SOBRE FUNCIONÁRIOS*
SELECT Funcionario_Nome AS FUNCIONÁRIO,
	   Setor_Descricao AS SETOR,
       Funcionario_DataNascimento AS DATA_NASCIMENTO,
       Funcionario_Salario AS SALÁRIO,
       Funcionario_DataAdmissão AS DATA_ADMISSÃO
FROM funcionario, setor
WHERE funcionario.Setor_idSetor = setor.idSetor;

-- DÍVIDA DE CADA MORADOR*
SELECT Morador_Nome AS CONDÔMINO,
	   Morador_CPF AS CPF,
       SUM(Mensalidade_Valor) AS DÉFICIT
FROM  morador, mensalidade_condominio
WHERE morador.CPF = mensalidade_condominio.Morador_CPF AND mensalidade_condominio.Mensalidade_Pago = 1
GROUP BY Morador_Nome;