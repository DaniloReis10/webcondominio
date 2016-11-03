var valores = $(".last-col");
var $date = $("#input-data-lancamento");
var $lancar = $("#lancamento");

var $alertAntigo = $("#alerta-data-antigo");
var $alertFrente = $("#alerta-data-frente");
var $alertNegativo = $("#alerta-negativo");
var $alertSemData = $("#alerta-sem-data");

// Validar os valores digitados
var getDataLancamento = function() {
	var data = $date[0].value;
	return data;
}

var validaData = function() {
	var data = getDataLancamento();

	if(data == ""){
		console.log("data");
		$alertSemData.css("display", "flex");
		return false;
	}

	var year = data.split("-")[0];
	var month = data.split("-")[1];

	var today = new Date();
	var todayYear = today.getFullYear();


	if(year > todayYear + 2) {
		$alertFrente.css("display", "flex");
		return false;
	}

	if(year < todayYear - 2) {
		$alertAntigo.css("display", "flex");
		return false;
	}

	return true;
}

var validaValores = function() {
	for (var i = 0; i < valores.length; i++) {
		var valor = parseFloat(valores[i].value);
		if(valor < 0) {
			console.log("valor");
			$alertNegativo.css("display", "flex");
			return false;
		}
	}
	return true;
}

// Calcula o valor do lançamento
var calculaLancamento = function() {
	var soma = 0;
	for (var i = 0; i < valores.length; i++) {
		if(valores[i].value != ""){
			var valor = parseFloat(valores[i].value);
			soma = soma + valor;
		}
	}

	return soma;
}

//Callback functions
var onCalcularClick = function() {

	$alertAntigo.css("display", "none");
	$alertFrente.css("display", "none");
	$alertNegativo.css("display", "none");
	$alertSemData.css("display", "none");

	if(validaValores()) {
		var total = calculaLancamento();
		$("#total-input").text("R$ " + total);
	}
}

var onLancarClick = function() {
	
	$alertAntigo.css("display", "none");
	$alertFrente.css("display", "none");
	$alertNegativo.css("display", "none");
	$alertSemData.css("display", "none");

	var okValores = validaValores();
	var okData = validaData();

	ok = okValores && okData;
	
	if(ok) {
		var total = calculaLancamento();
		var data = getDataLancamento();

		var msg = "Lançamento de " + data + " com valor de R$ " + total + " foi lançado com sucesso!";
		var html = "<div class='alert alert-success' role='alert' style='margin: 10px 10px 10px 10px'>" + msg +" </div>";

		$("#wrapper-lancamento").html(html);
	}
}

//Eventos
$("#calcula-lancamento").on("click", onCalcularClick);
$("#lancamento").on("click", onLancarClick);