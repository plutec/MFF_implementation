<%@page import="MFF.Model.Film"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@include file="/includes/header.jsp" %>
<% ArrayList filmsList = (ArrayList) request.getAttribute("films");
int number=0;
if (filmsList!=null) { number=filmsList.size(); }
%>

<div id="content">
	<h1>Se han encontrado <%= number %> películas coincidentes con la búsqueda "<%= request.getParameter("search") %>"</h1>
	
	<div class="filmsSearchResults">
		<%
			if (filmsList != null) {
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
			}
		%>
	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>