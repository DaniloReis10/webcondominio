$(document).ready(function(){
	'use strict';
	
	$("#btnNovo").on("click", function(){
		window.location.href = "/web-condominio/CadastroFornecedor";
		
	});
	
	$(".btnDeletar").on("click", function(){
		var id = $(this).data("id");
		window.location.href = "/web-condominio/DeletarFornecedor?id="+id;		
	});
	
	$(".btnEditar").on("click", function(){
		var id = $(this).data("id");
		window.location.href = "/web-condominio/EditarFornecedor?id="+id;
	});
	
});