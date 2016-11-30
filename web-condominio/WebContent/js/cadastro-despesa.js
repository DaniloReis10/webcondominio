function post(path, params) {
    
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", path);

    for(var key in params) {
        if(params.hasOwnProperty(key)) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
         }
    }

    document.body.appendChild(form);
    form.submit();
}

var onEditClick = function(e) {	
	
	var idDespesa = e.currentTarget.id;
    idDespesa = idDespesa.split("-")[1];
    
    var set = {
    	id: idDespesa	
    };
    
    post("tela-edicao-despesa", set);
}

var onDeleteClick = function(e) {
	var result = confirm("Realmente deseja excluir o item selecionado?");
	if (result) {
		
	    var idDespesa = e.currentTarget.id;
	    idDespesa = idDespesa.split("-")[1];
	    console.log(idDespesa);
	    
	    var set = {
	    	id: idDespesa	
	    };
	    
	    post("excluir-despesa", set);
	}
}

$(".editar").each( function(i, element) {
	$(element).on("click", onEditClick);
});

$(".excluir").each( function(i, element) {
	$(element).on("click", onDeleteClick);
});