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

	var ok = validaNovaDespesa();

	$mensagemErro.css("display", "none");

	if(!ok) {
		e.preventDefault();
		$mensagemErro.css("display", "flex");		
	}
}

$("#cadastrar-button").on("click", onCadastrarClick);