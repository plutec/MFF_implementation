<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@include file="/includes/header.jsp" %>
<div id="content">
	
	<div id="manageFilmsForm">
		
		<h1>Gestión de películas</h1>
		
		<form id="addFilmForm">
			<input type="button" value="Añadir película" class="submit" />
		</form>
		<form action="index" method="get" id="searchFilmsForm">
			<input type="hidden" name="a" value="search" />
			<input type="text" name="search" class="text" />
			<input type="submit" value="Buscar" class="submit" />
		</form>
		<div id="results">
			
		</div>
	</div>
	
	<div id="manageModelForm">
		<h1>Gestión del modelo</h1>
	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>
