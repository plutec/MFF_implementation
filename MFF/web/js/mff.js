$(document).ready(function() {
	
	// Carga de imágenes desde la API de IMDB
	$('.filmposter').each(function() {
		var title = $(this).data("title");
		var year = $(this).data("year");
		$.get("http://www.imdbapi.com/?t=" + title + "&y=" + year, function(data) {
			alert(data);
		});
	});
	
});
