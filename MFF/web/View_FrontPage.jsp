<%@page import="MFF.Model.Film"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@include file="/includes/header.jsp" %>
<div id="presentationWrapper">
	<div id="presentation">
		<p id="sentence">“Ezequiel, 25-17: El camino del hombre recto está por todos lados rodeado por la avaricia de los egoístas y la tiranía de los hombres malos. Bendito sea aquel pastor que, en nombre de la caridad y de la buena voluntad, saque a los débiles del Valle de la Oscuridad. Porque él es el verdadero guardián de su hermano y el descubridor de los niños perdidos. ¡Y os aseguro que vendré a castigar con gran venganza y furiosa cólera a aquéllos que pretendan envenenar y destruir a mis hermanos! ¡Y tú sabrás que mi nombre es Yavé, cuando mi venganza caiga sobre ti!.”</p>
	</div>
</div>
<div id="content">
	
	<% if (request.getAttribute("recommendations") != null) { %>
	
	<h1>Por tus valoraciones, seguramente te gusten estas películas:</h1>
	
	<div class="mostRatedFilms">
		<%
			ArrayList recommendations = (ArrayList) request.getAttribute("recommendations");
			for (int i=0; i<recommendations.size(); i++) {
				int id = ((Film)recommendations.get(i)).getId();
				String title = ((Film)recommendations.get(i)).getTitle();
				int year = ((Film)recommendations.get(i)).getYear();
				float rating = ((Film)recommendations.get(i)).getRatingAverage();
		%>
				
				<a href="index?c=Film&a=get&id=<%=id%>" class="film filmposter" data-title="<%=title%>" data-year="<%=year%>">
					<div class="metadata">
						<span><%=title%> (<%=year%>)</span>
						<div class="stars_grey"><div class="stars_yellow" style="width:<%=rating*100/5%>%"></div></div>
					</div>
				</a>
				
		<%
			}
		%>
	</div>
	
	<% } %>
	
	<h1>¿Qué películas recomiendan nuestros usuarios?</h1>
	
	<div class="mostRatedFilms">
		<%
			ArrayList filmsList = (ArrayList) request.getAttribute("films");
			for (int i=0; i<filmsList.size(); i++) {
				int id = ((Film)filmsList.get(i)).getId();
				String title = ((Film)filmsList.get(i)).getTitle();
				int year = ((Film)filmsList.get(i)).getYear();
				float rating = ((Film)filmsList.get(i)).getRatingAverage();
		%>
				
				<a href="index?c=Film&a=get&id=<%=id%>" class="film filmposter" data-title="<%=title%>" data-year="<%=year%>">
					<div class="metadata">
						<span><%=title%> (<%=year%>)</span>
						<div class="stars_grey"><div class="stars_yellow" style="width:<%=rating*100/5%>%"></div></div>
					</div>
				</a>
				
		<%
			}
		%>
	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>