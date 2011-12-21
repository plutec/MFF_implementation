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
		$('.formInputBoxAddFilmId').css("visibility", "hidden");
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
					$('.formInputBoxAddFilmId').css("visibility", "visible");
					$('#manageFilmsSubForm').css("visibility", "visible");
					$('.field_id').val(id);
					$('.field_title').val(title);
					$('.field_year').val(year);
				});
			},
			error: function() {
				
			}
		})
	});
	
	$('#addFilmSubButton').click(function() {
		var title = $(this).data("title");
		var year = $(this).data("year");
		$.ajax({
			url: "index?c=Film&a=add&title=" + title + "&year=" + year,
			sucess: function(data) {
				alert("Ok!");
			},
			error: function() {
				alert("Error!");
			}
		})
	});
	
});