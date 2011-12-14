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
	
});
