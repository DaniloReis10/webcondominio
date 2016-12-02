<%@ page language="java"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link  rel="stylesheet" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatorio Inadimplencia</title>
</head>
<body>
	
	<body>
	
	<jsp:include page="../menu.html"/>
	
		<div class='container' style="padding-top: 15px;">
        <div class="offsetpage-header">
            <h1>Relatório de Inadimplencias</h1>
            <div id="carregando">Carregando inadimplentes</div>
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
        <canvas id="graficoInadimplencia" width="400" height="300"></canvas>
    </div>
	
	<!-- metodo criador de graficos -->
	<script type="text/javascript">
    
    var graphCreator = (function () {
        'use strict';

        function create(canvas, label, data, range, type){
            var config = {
            type: type,
            data: {
                labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"].slice(range.mesDe, range.mesAte),
                datasets: [{
                    label: label,
                    data: data.splice(range.mesDe, range.mesAte),
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)',
                        'rgba(219, 10, 91, 0.2)',
                        'rgba(102, 51, 153, 0.2)',
                        'rgba(242, 120, 75, 0.2)',
                        'rgba(51, 110, 123, 0.2)',
                        'rgba(31, 58, 147, 0.2)',
                        'rgba(46, 204, 113, 0.2)',
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)',
                        'rgba(219, 10, 91, 1)',
                        'rgba(102, 51, 153, 1)',
                        'rgba(242, 120, 75, 1)',
                        'rgba(51, 110, 123, 1)',
                        'rgba(31, 58, 147, 1)',
                        'rgba(46, 204, 113, 1)',
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        };

            var grafico = new Chart(canvas, config);
        }

        return{
            create : create
        };

    })();
    
    </script>
    
    
    
    <script src="libs/jquery-3.1.1.js"></script>
    <script src="libs/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="libs/chart.js"></script>
    <script src="js/graphCreator.js"></script>
    
    <!-- relatorio inadimplencia script -->
    <script type="text/javascript">
    (function () {
        'use strict';

        var _inadimplentes = [];
		$('#btnExibir').attr("disabled", true);
		
     	$.get("/web-condominio/RelatorioInadimplenciaAjax", function(response) {
     		console.log(response)
     		_inadimplentes = response;
     		$('#btnExibir').attr("disabled", false);
     		$("#carregando").hide()
    	});
        
        // escuta o click nos dois dropdowns e chama a função generateGraph
        $('#btnExibir').on('click', function () {
        	
        	
			var objInadimplencias = {Janeiro : 0, Fevereiro : 0, Marco : 0, Abril : 0, Maio : 0, Junho: 0, Julho : 0, Agosto : 0, Setembro : 0, Outubro : 0, Novembro : 0, Dezembro : 0};
        	
        	for(var i = 0 ; i < _inadimplentes.length; i++) {
        		switch(_inadimplentes[i].mes) {
        		case 'Janeiro':
        			objInadimplencias.Janeiro++;
        			break;
        		case 'Fevereiro':
        			objInadimplencias.Fevereiro++;
        			break;
        		case 'Marco':
        			objInadimplencias.Marco++;
        			break;
        		case 'Abril':
        			objInadimplencias.Abril++;
        			break;
        		case 'Maio':
        			objInadimplencias.Maio++;
        			break;
        		case 'Junho':
        			objInadimplencias.Junho++;
        			break;
        		case 'Julho':
        			objInadimplencias.Julho++;
        			break;
        		case 'Agosto':
        			objInadimplencias.Agosto++;
        			break;
        		case 'Setembro':
        			objInadimplencias.Setembro++;
        			break;
        		case 'Outubro':
        			objInadimplencias.Outubro++;
        			break;
        		case 'Novembro':
        			objInadimplencias.Novembro++;
        			break;
        		case 'Dezembro':
        			objInadimplencias.Dezembro++;
        			break;
        		}
        	}
        	
        	var arrayInadimplencias = $.map(objInadimplencias, function(valor, index) {
        		return [valor]
        	})
        	console.log(arrayInadimplencias)
        	
        	
            generateGraph( $('#mesDe').val(), $('#mesAte').val(), arrayInadimplencias);
        });
	

        function generateGraph(mesDe, mesAte, data) {

            mesDe = parseInt(mesDe);
            mesAte = parseInt(mesAte);

            if(mesDe > mesAte){
                $('#selectionErrorModal').modal();
                return;
            }

            // caso algum grafico ja tenha sido criado anteriormente
            // é necessario remover o canvas e criar um novo
            if( $('#graficoInadimplencia').length) {
                $('#graficoInadimplencia').remove();
                $('div.container').append( $('<canvas id="graficoInadimplencia" width="400" height="300"></canvas>') );
            }
            var canvas = $('#graficoInadimplencia')[0];

            // numeroInadimplentes é um vetor com a quantidade de inadimplentes de cada mês
            // o primeiro index correponde a janeiro, e assim em diante.
            // esse vetor será preenchido a partir do local storage
            var numeroInadimplentes = data;

            // numeroInadimplentesFiltrado possui somente o numero dos meses que o usuario selecionou
            var numeroInadimplentesFiltrado = numeroInadimplentes.slice(mesDe, mesAte+1);

            // range informa para a função create quais colunas devem aparecer
            var range = {
                mesDe : mesDe,
                mesAte : mesAte + 1
            };

            // criação do grafico
            // primeiro argumento = espaço na view para desenhar o grafico
            // segundo argumento = legenda do grafico
            // terceiro argumento = um vetor com tamanho de cada coluna
            // quarto argumento = quais colunas devem aparecer
            // quinto argumento = estilo do grafico
            graphCreator.create(canvas, 'N de inadimplentes', numeroInadimplentesFiltrado, range, 'bar');
        }

    })();
	</script>
	
</body>
</html>