/**
 * 
 */

$(document).ready(function(){
	$(".selectCategoria").prop('disabled', true);
	
	$.ajax({
		url: './json/listaCategoriasJson',
		method: 'GET',
		success: function(data){
			let list = $.parseJSON(data);
			
			$.each(list, function(key,value){
				$('.selectCategoria').append('<option value="' + value.idCategoria + '">' + value.nome + '</option>');
			});
			
			$(".selectCategoria").prop('disabled', false);
			$('.selectCategoria').prop('selectedIndex', 0).change();	
		},
		error: function(){
			$('.selectCategoria').append('<option value=""> Erro ao carregar categorias </option>');
		}
	});
});

var selectInitialized = false;

function setSelectedOption(categoriaId){
	if(!selectInitialized && categoriaId){
		$(".selectCategoria").val(categoriaId);
		selectInitialized = true;
	}
}