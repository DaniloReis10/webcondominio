var $nomeDespesa = $("#nome-despesa");
var $fornecedor = $("#sel-fornecedor");
var $tipoDespesa = $("#sel-tipo");
var $mensagemErro = $("#mensagem-erro");
var $mensagemSucesso = $("#mensagem-sucesso");

// Validação
var validaNovaDespesa = function() {

	if($nomeDespesa[0].value == ""){
		return false;
	} else if( $.isNumeric($nomeDespesa[0].value)) {
		return false;
	}

	return true;
}

// Cadastrar
var onCadastrarClick = function() {

	var ok = validaNovaDespesa();

	$mensagemSucesso.css("display", "none");
	$mensagemErro.css("display", "none");

	if(ok) {
		$mensagemSucesso.css("display", "flex");
		$nomeDespesa.val("");
	} else {
		$mensagemErro.css("display", "flex");
	}
}

$("#cadastrar-button").on("click", onCadastrarClick);