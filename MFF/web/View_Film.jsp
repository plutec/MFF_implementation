<%@page import="MFF.Model.Film"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@include file="/includes/header.jsp" %>
<% Film film = (Film)request.getAttribute("film"); %>
<%
	int userRate = 0;
	if (request.getAttribute("userrate") != null)
		userRate = (Integer)request.getAttribute("userrate");
%>
<div id="content">
	
	<h1><%=film.getTitle()%> (<%=film.getYear()%>)</h1>
	
	<div class="filmCard">
		<%
			int id = film.getId();
			String title = film.getTitle();
			int year = film.getYear();
			float rating = film.getRatingAverage();
		%>
				
		<div class="film filmposter" data-id="<%=id%>" data-title="<%=title%>" data-year="<%=year%>">
			<div class="metadata">
				<span><%=title%> (<%=year%>)</span>
				<div class="stars_grey"><div class="stars_yellow" style="width:<%=rating*100/5%>%"></div></div>
			</div>
		</div>
		
		<% if (session.getAttribute("user") != null) { %>
		
		<div class="rateFilm" data-userrate="<%=userRate%>">
			<%
				for (int i=1; i<=5; i++) {
					if (i<=userRate) {
			%>
						<div class="rateFilmStar rateFilm<%=i%>" data-value="<%=i%>" style="background-position:top;"></div>
			<%
					} else {
			%>
						<div class="rateFilmStar rateFilm<%=i%>" data-value="<%=i%>" style="background-position:bottom;"></div>
			<%
					}
				}
			%>
			<input type="button" value="Eliminar mi valoración" id="removeRateButton" class="submit" />
		</div>
			
		<% } %>
		
	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>