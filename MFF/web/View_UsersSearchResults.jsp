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
                
                        
                <a href="index?c=User&a=get&id=<%=id%>"><div class="user userbusquedar" style="background:url('images/profile.png'); width: 128px; height: 128px; float:left;"></div> </a>
		<%
				}
			}
		%>
        </div>
	
</div>
<%@include file="/includes/footer.jsp" %>