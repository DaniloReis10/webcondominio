var onEditClick = function(event) {	
	
	var nomeDespesa;
	
	var list = event.originalEvent.path;
	for (var i = 0; i < list.length; i++) {
		var tagName = list[i].tagName;
		if(tagName == "TR"){
			nomeDespesa = list[i].children[1].innerText;
		}
	}

	setTimeout(function(){
		console.log("teste");
		$("#nome-despesa").text(nomeDespesa);
	},1000);

	
}

$(".editar").each( function(i, element) {
	$(element).on("click", onEditClick);
});