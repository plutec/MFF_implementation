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
				$(aObj).css("background-image", "url(" + json.Poster + ")");
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
	
	$('#addFilmButton').click(function() {
		$('.field_id').val("");
		$('.field_title').val("");
		$('.field_year').val("");
		$('#manageFilmsSubForm').css("visibility", "visible");
	});
	
	$('#searchFilmsInput').keyup(function() {
		$.ajax({
			url: "index?c=Film&a=searchFilmsAdmin&search=" + $('#searchFilmsInput').val(),
			success: function(data) {
				$('#searchResults').html(data);
				$('#searchResults').css("visibility", "visible");
				$('.filmResultsItem').click(function() {
					var id = $(this).data("id");
					var title = $(this).data("title");
					var year = $(this).data("year");
					$(this).parent().css("visibility", "hidden");
					$('#manageFilmsSubForm').css("visibility", "visible");
					$('.field_id').val(id);
					$('.field_title').val(title);
					$('.field_year').val(year);
				});
			}
		})
	});
	
	$('#searchResults').focusout(function() {
		$('#searchResults').css("visibility", "hidden");
	})
	
	$('#addFilmSubButton').click(function() {
		var id = $('.field_id').val();
		var title = $('.field_title').val();
		var year = $('.field_year').val();
		
		if (id == "") {
		
			$.ajax({
				url: "index?c=Film&a=add&title=" + title + "&year=" + year,
				success: function() {
					$('#manageFilmsSubForm > .message').text("La película se ha añadido correctamente.");
					$('#manageFilmsSubForm > .message').removeClass("errorMessage");
					$('#manageFilmsSubForm > .message').addClass("okMessage");
					$('#manageFilmsSubForm > .message').slideDown('slow');
					$('#manageFilmsSubForm > .message').delay(2000).slideUp('slow');
					$('.field_id').val("");
					$('.field_title').val("");
					$('.field_year').val("");
				},
				error: function() {
					$('#manageFilmsSubForm > .message').text("La película no se ha podido añadir. Revise los datos introducidos.");
					$('#manageFilmsSubForm > .message').removeClass("okMessage");
					$('#manageFilmsSubForm > .message').addClass("errorMessage");
					$('#manageFilmsSubForm > .message').slideDown('slow');
					$('#manageFilmsSubForm > .message').delay(2000).slideUp('slow');
				}
			})
			
		} else {
			
			$.ajax({
				url: "index?c=Film&a=edit&id=" + id + "&title=" + title + "&year=" + year,
				success: function() {
					$('#manageFilmsSubForm > .message').text("La película se ha actualizado correctamente.");
					$('#manageFilmsSubForm > .message').removeClass("errorMessage");
					$('#manageFilmsSubForm > .message').addClass("okMessage");
					$('#manageFilmsSubForm > .message').slideDown('slow');
					$('#manageFilmsSubForm > .message').delay(2000).slideUp('slow');
				},
				error: function() {
					$('#manageFilmsSubForm > .message').text("La película no se ha podido actualizar. Revise los datos introducidos.");
					$('#manageFilmsSubForm > .message').removeClass("okMessage");
					$('#manageFilmsSubForm > .message').addClass("errorMessage");
					$('#manageFilmsSubForm > .message').slideDown('slow');
					$('#manageFilmsSubForm > .message').delay(2000).slideUp('slow');
				}
			})
			
		}
	});
	
	$('#deleteFilmSubButton').click(function() {
		var id = $('.field_id').val();
		
		$.ajax({
			url: "index?c=Film&a=delete&id=" + id,
			success: function() {
				$('#manageFilmsSubForm > .message').text("La película se ha eliminado correctamente.");
				$('#manageFilmsSubForm > .message').removeClass("errorMessage");
				$('#manageFilmsSubForm > .message').addClass("okMessage");
				$('#manageFilmsSubForm > .message').slideDown('slow');
				$('#manageFilmsSubForm > .message').delay(2000).slideUp('slow');
			},
			error: function() {
				$('#manageFilmsSubForm > .message').text("La película no se ha podido eliminar.");
				$('#manageFilmsSubForm > .message').removeClass("okMessage");
				$('#manageFilmsSubForm > .message').addClass("errorMessage");
				$('#manageFilmsSubForm > .message').slideDown('slow');
				$('#manageFilmsSubForm > .message').delay(2000).slideUp('slow');
			}
		})
	});
	
	$('.rateFilmStar').mouseout(function() {
		var rate = $('.rateFilm').data("userrate");
		for (i=1; i<=5; i++) {
			if (i<=rate) {
				$('.rateFilm' + i).css('background-position', 'top');
			}else{
				$('.rateFilm' + i).css('background-position', 'bottom');
			}
		}
	});
	
	$('.rateFilmStar').mouseover(function() {
		var value = $(this).data("value");
		for (i=1; i<=5; i++) {
			if (i<=value){
				$('.rateFilm' + i).css('background-position', 'top');
			}else{
				$('.rateFilm' + i).css('background-position', 'bottom');
			}
		}
	});
	
	$('.rateFilmStar').click(function() {
		var value = $(this).data("value");
		$('.rateFilm').data("userrate", value);
		$.ajax({
			url: "index?c=Rating&a=rate&film=" + $('.film').data("id") + "&rate=" + value,
			success: function() {
				for (i=1; i<=5; i++) {
					if (i<=value) {
						$('.rateFilm' + i).css('background-position', 'top');
					}else{
						$('.rateFilm' + i).css('background-position', 'bottom');
					}
				}
			},
			error: function() {
				
			}
		})
	});
	
	$('#removeRateButton').click(function() {
		$.ajax({
			url: "index?c=Rating&a=delete&film=" + $('.film').data("id"),
			success: function() {
				for (i=1; i<=5; i++) {
					$('.rateFilm' + i).css('background-position', 'bottom');
				}
			},
			error: function() {
				
			}
		})
	});
	
});