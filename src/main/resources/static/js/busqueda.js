/**
 * 
 */
$(document).ready(function(){
	$('#comboboxDepartamento').on('change', function(){
		var id = $(this).val();
		
		$.ajax({
			
			type: 'GET',
			url: '/provincia/cargarProvinciasPorDep/' + id,
			
			success: function(result) {
				var result = JSON.parse(result);
				var s = '';
				for(var i = 0; i < result.length; i++) {
					s += '<option th:value="' + result[i].id + '">'+ result[i].nombreProvincia +'</option>';
				}
				$('#comboboxProvincia').html(s);
			}
		});
	});
});