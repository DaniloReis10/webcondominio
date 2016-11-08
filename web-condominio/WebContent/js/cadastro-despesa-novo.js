var $nomeDespesa = $("#nome-despesa");
var $fornecedor = $("#sel-fornecedor");
var $tipoDespesa = $("#sel-tipo");
var $mensagemErro = $("#mensagem-erro");
var $mensagemSucesso = $("#mensagem-sucesso");

// Validação
var validaNovaDespesa = function() {

	if($nomeDespesa.val() == ""){
		return false;
	} else if( $.isNumeric($nomeDespesa.val())) {
		return false;
	}

	return true;
}

// Cadastrar
var onCadastrarClick = function(e) {
	
	console.log("clicou");

	e.preventDefault();
	
	var ok = validaNovaDespesa();

	$mensagemSucesso.css("display", "none");
	$mensagemErro.css("display", "none");

	if(ok) {
		console.log("passou");
		$mensagemSucesso.css("display", "flex");
		location.href = "cadastrar-despesa";
		
	} else {
		$mensagemErro.css("display", "flex");
	}
}

$("#cadastrar-button").on("click", onCadastrarClick);