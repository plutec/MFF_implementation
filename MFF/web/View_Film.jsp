<%@page import="MFF.Model.Film"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp" %>
<% Film film = (Film)request.getAttribute("film"); %>
<div id="content">
	
	<h1><%=film.getTitle()%> (<%=film.getYear()%>)</h1>
	
	<div class="filmCard">
		<%
			int id = film.getId();
			String title = film.getTitle();
			int year = film.getYear();
			float rating = film.getRatingAverage();
		%>
				
		<a href="index?c=Film&a=get&id=<%=id%>" class="film filmposter" data-title="<%=title%>" data-year="<%=year%>">
			<div class="metadata">
				<span><%=title%> (<%=year%>)</span>
				<div class="stars_grey"><div class="stars_yellow" style="width:<%=rating*100/5%>"></div></div>
			</div>
		</a>

	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>