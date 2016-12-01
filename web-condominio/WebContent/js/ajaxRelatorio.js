function buscarRelatorio(id){
	
	
	
	$.ajax({
		url:'relatorioMes',
		type:'post',
		data: {id : id},
	    success: function(data) {
	    	window.location = 'relatorioMes?id='+id
        },
        
		});
	
}