<%@ page language="java"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link  rel="stylesheet" href="../libs/bootstrap-3.3.7-dist/css/bootstrap.css"/>

	<title>Relatorio Despesas</title>
</head>
	
	<body>
		<div class='container'>
        <div class="offsetpage-header">
            <h1>Relatório de despesas</h1>
        </div>
        <div class="input-group">
            <span class="input-group-addon">De:</span>
            <select class="form-control" id="mesDe">
                <option value="0">Janeiro</option>
                <option value="1">Fevereiro</option>
                <option value="2">Marco</option>
                <option value="3">Abril</option>
                <option value="4">Maio</option>
                <option value="5">Junho</option>
                <option value="6">Julho</option>
                <option value="7">Agosto</option>
                <option value="8">Setembro</option>
                <option value="9">Outubro</option>
                <option value="10">Novembro</option>
                <option value="11">Dezembro</option>
            </select>

            <span class="input-group-addon">Até:</span>
            <select class="form-control" id="mesAte">
                <option value="0">Janeiro</option>
                <option value="1">Fevereiro</option>
                <option value="2">Março</option>
                <option value="3">Abril</option>
                <option value="4">Maio</option>
                <option value="5">Junho</option>
                <option value="6">Julho</option>
                <option value="7">Agosto</option>
                <option value="8">Setembro</option>
                <option value="9">Outubro</option>
                <option value="10">Novembro</option>
                <option value="11">Dezembro</option>
            </select>
        </div>
         <button class="form-control" id="btnExibir">Exibir</button>
         
        <div id="selectionErrorModal" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Erro</h4>
                    </div>
                    <div class="modal-body">
                        <p>Por favor selecione um intervalo de meses válido</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
        
        <canvas id="graficoDespesas" width="400" height="300"></canvas>
    </div>


    <script src="../libs/jquery-3.1.1.js"></script>
    <script src="../libs/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="../libs/chart.js"></script>
    <script src="../js/graphCreator.js"></script>
    <script src="../js/relatorios_despesas.js"></script>
	</body>
</html>