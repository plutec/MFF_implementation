<%@page import="MFF.Model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp" %>
<% ArrayList usersList = (ArrayList) request.getAttribute("users"); %>
<div id="content">
	<h1>Se han encontrado <%= usersList.size() %> usuarios coincidentes con la búsqueda "<%= request.getParameter("search") %>"</h1>
	<div class="usersSearchResults">
		<%
			if (usersList != null) {
                            for (int i=0; i<usersList.size(); i++) {
				//mostramos el nombre	
                                String id = ((User)usersList.get(i)).getId();		
		%>
                
                        
                <a href="index?c=User&a=get&id=<%=id%>" class="user userbusquedar" data-id"<%=id%>"> </a>
				//falta meter el user en el css
		<%
				}
			}
		%>
        </div>
	
</div>
<%@include file="/includes/footer.jsp" %>