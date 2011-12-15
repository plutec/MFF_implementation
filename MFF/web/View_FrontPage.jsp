<%@page import="MFF.Model.Film"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp" %>
<div id="presentationWrapper">
	<div id="presentation">
		<p id="sentence">“Ezequiel, 25-17: El camino del hombre recto está por todos lados rodeado por la avaricia de los egoístas y la tiranía de los hombres malos. Bendito sea aquel pastor que, en nombre de la caridad y de la buena voluntad, saque a los débiles del Valle de la Oscuridad. Porque él es el verdadero guardián de su hermano y el descubridor de los niños perdidos. ¡Y os aseguro que vendré a castigar con gran venganza y furiosa cólera a aquéllos que pretendan envenenar y destruir a mis hermanos! ¡Y tú sabrás que mi nombre es Yavé, cuando mi venganza caiga sobre ti!.”</p>
	</div>
</div>
<div id="content">
	<h1>¿Qué películas recomiendan nuestros usuarios?</h1>
	
	<div class="mostRatedFilms">
		<%
			ArrayList filmsList = (ArrayList) request.getAttribute("films");
			for (int i=0; i<filmsList.size(); i++) {
				String title = ((Film)filmsList.get(i)).getTitle();
				int year = ((Film)filmsList.get(i)).getYear();
				float rating = ((Film)filmsList.get(i)).getRatingAverage();
				out.println("<div class=\"film filmposter\"data-title=\"" + title.split(":")[0] + "\" data-year=\"" + year + "\">");
				out.println("<div class=\"metadata\">" + title + " (" + year + ")"
						+ "<div class=\"stars_grey\"><div class=\"stars_yellow\" style=\"width:" + rating*100/5 + "%\">"
						+ "</div></div></div>");
				out.println("</div>");
			}

		%>
	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>