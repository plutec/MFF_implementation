<%@page import="MFF.Model.Film"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<% ArrayList filmsList = (ArrayList) request.getAttribute("films"); %>
<%
	if (filmsList != null) {
		for (int i=0; i<filmsList.size(); i++) {
			int id = ((Film)filmsList.get(i)).getId();
			String title = ((Film)filmsList.get(i)).getTitle();
			int year = ((Film)filmsList.get(i)).getYear();
			float rating = ((Film)filmsList.get(i)).getRatingAverage();
%>

			<div class="filmResultsItem" data-id="<%=id%>" data-title="<%=title%>" data-year="<%=year%>"><%=title%></div>

<%
		}
	}
%>
