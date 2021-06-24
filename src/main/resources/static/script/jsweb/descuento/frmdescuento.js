$(document).on("click", ".btn_editar_descuento", function() {
	$("#idprecio").val($(this).attr("data-idprecio"))
	
	$("#descuento").val($(this).attr("data-descuento"))
	
	$("#txtprecio_base").text($(this).attr("data-precio_base"))
	
	$("#txtprecio_descontado").text($(this).attr("data-precio_descuento"))
	
	$("#txtdiferencia").text($(this).attr("data-diferencia"))
	
	$("#modalDescuento").modal("show");


});






$(document).on("click", "#btn_actualizar", function() {
	
	$.ajax({
		type:"POST",
		contentType:"application/json",
		url:"/actualizar",
		data:JSON.stringify({
			idprecio: $("#idprecio").val(),
			descuento:$("#descuento").val()
		}),
		
		success: function() {
			location.reload();
			$("#modalDescuento").modal("hide")

		}
		
	});
	
	
	
	
	
	

});


$(document).on("click", "#btn_actualizar", function() {
	
	$.ajax({
		type:"POST",
		contentType:"application/json",
		url:"/actualizar_tempc",
		data:JSON.stringify({
			idprecio: $("#idprecio").val(),
			descuento:$("#descuento").val()
		}),
		
		success: function() {
			location.reload();
			$("#modalDescuento").modal("hide")

		}
		
	});
	
	
	
	
	
	

});




