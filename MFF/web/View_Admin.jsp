<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@include file="/includes/header.jsp"%>
<div id="content">
	
	<div id="manageFilmsForm">
		
		<h1>Gestión de películas</h1>
		
		<form id="addFilmForm">
			<input type="button" value="Añadir película" id="addFilmButton" class="submit" />
		</form>
		
		<input type="text" name="searchAdmin" id="searchFilmsInput" class="text" autocomplete="off" />
		<div id="searchResults"></div>
		
		<div id="manageFilmsSubForm">
			<form>
				<div class="formInputBox">
					<label for="title">Id:</label>
					<input type="text" name="title" class="text field_id" disabled />
				</div>
				<div class="formInputBox">
					<label for="title">Título:</label>
					<input type="text" name="title" class="text field_title" />
				</div>
				<div class="formInputBox">
					<label for="year">Año:</label>
					<input type="text" name="year" class="text field_year" />
				</div>
				<div class="formInputBox">
					<input type="button" value="Eliminar" id="deleteFilmSubButton" class="submit submit_delete" />
					<input type="button" value="Guardar" id="addFilmSubButton" class="submit submit_save" />
				</div>
			</form>
			
			<span class="message" style="display: none;"></span>
		</div>
	</div>
	
	<div id="manageModelForm">
		<h1>Gestión del modelo</h1>
		
		<form action="index?c=Similarity&action=updateModel">
			<input type="button" value="Actualizar Modelo" class="submit" />
		</form>
		
	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>
