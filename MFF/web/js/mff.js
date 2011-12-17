$(document).ready(function() {
	
	// Carga de imágenes desde la API de IMDB
	$('.filmposter').each(function() {
		var title = $(this).data("title");
		var year = $(this).data("year");
		var aObj = $(this);
		$.ajax({
			dataType: "jsonp",
			data: "",
			url: "http://www.imdbapi.com/?t=" + title + "&y=" + year,
			success: function(json){
				$(aObj).css('background-image', "url(" + json.Poster + ")");
			}
		});
	});
	
	$('.loginValidate').keyup(function() {
		if ($("#loginUser").val() != "" && $("#loginPass").val() != "") {
			$("#loginSubmit").attr("disabled", false);
		}else{
			$("#loginSubmit").attr("disabled", true);
		}
	});
	
	$('.registerValidate').keyup(function() {
		if ($("#registerUser").val() != "" && $("#registerPass").val() != "" && $("#registerPass").val() == $("#registerPassRepeat").val()) {
			$("#registerSubmit").attr("disabled", false);
		}else{
			$("#registerSubmit").attr("disabled", true);
		}
	});
	
});
