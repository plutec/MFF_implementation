<%@page import="MFF.Model.Film"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@include file="/includes/header.jsp" %>
<div id="presentationWrapper">
	<div id="presentation">
		<p id="sentence">Con MFF podrás encontrar las películas que seguro te van a entusiasmar. Regístrate gratis y pruébalo.</p>
	</div>
</div>
<div id="content">
	
	<%
		if (request.getAttribute("recommendations") != null) {
			
			ArrayList recommendations = (ArrayList) request.getAttribute("recommendations");
			if (recommendations.size() == 0) {
	%>
				<h1>Antes de que podamos darte recomendaciones debes valorar algunas películas.</h1>
				<div style="text-align: center;">
					<form action="index" method="get">
						<input type="hidden" name="c" value="Film" />
						<input type="hidden" name="a" value="search" />
						<input type="text" name="search" class="text" />
						<input type="submit" value="Buscar" class="submit" />
					</form>
				</div>
	<%
			}else{
	%>
				<h1>Por tus valoraciones, seguramente te gusten estas películas:</h1>
				<div class="mostRatedFilms">
	<%
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
	<%
			}
		}
	%>
	
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