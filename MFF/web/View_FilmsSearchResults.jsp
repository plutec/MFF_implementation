<%@page import="MFF.Model.Film"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp" %>
<div id="content">
	<h1>Resultados de la búsqueda</h1>
	
	<div class="filmsSearchResults">
		<%
			ArrayList filmsList = (ArrayList) request.getAttribute("films");
			System.out.println(filmsList.size());
			for (int i=0; i<filmsList.size(); i++) {
				String title = ((Film)filmsList.get(i)).getTitle();
				int year = ((Film)filmsList.get(i)).getYear();
				float rating = ((Film)filmsList.get(i)).getRatingAverage();
				out.println("<div class=\"film filmposter\"data-title=\"" + title + "\" data-year=\"" + year + "\">");
				out.println("<div class=\"metadata\">" + title + " (" + year + ")"
						+ "<div class=\"stars_grey\"><div class=\"stars_yellow\" style=\"width:" + rating*100/5 + "%\">"
						+ "</div></div></div>");
				out.println("</div>");
			}

		%>
	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>