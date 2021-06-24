$(document).on("click", ".btn_editar_nivel", function() {
	$("#idnivel").val($(this).attr("data-idnivel"))
	
	$("#numpiso").val($(this).attr("data-numpiso"))
	
	$("#capacidad").val($(this).attr("data-capacidad"))
	
	$("#estado").val($(this).attr("data-estado"))
	

	
	$("#modalNivel_Actualizar").modal("show");


});



						

$(document).on("click", "#btn_actualizar", function() {
	
	$.ajax({
		type:"POST",
		contentType:"application/json",
		url:"/actua_nivel",
		data:JSON.stringify({
			idnivel: $("#idnivel").val(),
			numpiso:$("#numpiso").val(),
			capacidad: $("#capacidad").val(),
			estado:$("#estado").val()
			
		}),
		
		success: function() {
			location.reload();
			$("#modalNivel_Actualizar").modal("hide")

		}
		
	});
	
	
	
	
	
	

});






$(document).on("click", ".btn_crear_nivel", function() {
	
	
	$("#numpiso").val("")
	
	$("#capacidad").val(0)
	
	$("#estado").val("")
	


	$("#modalNivel_Crear").modal("show");


});




$(document).on("click", "#btn_crear", function() {
	
	$.ajax({
		type:"POST",
		contentType:"application/json",
		url:"/generar_nivel",
		data:JSON.stringify({
			
			numpiso: $("#piso").val(),
			capacidad: $("#capaci").val(),
			estado: $("#estados").val()
			
		}),
		
		success: function() {
			location.reload();
			$("#modalNivel_Crear").modal("hide")

		}
		
	});
	
	
	
	
	
	

});






