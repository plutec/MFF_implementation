<%@page import="MFF.Model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@include file="/includes/header.jsp" %>
<% User user = (User)request.getAttribute("user"); %>
<% ArrayList<Rating> ratingList = (ArrayList) user.getRatings(); %>

<div id="content">
	.
        <h1><%=user.getId()%></h1>
        <div class="userCard">
		<%
                    String id = user.getId();
                    if (ratingList != null) {
				for (int i=0; i<ratingList.size(); i++) {
					Rating r=ratingList.get(i);
					Film f=r.getFilm();
					int id_film = f.getId();
					String title = f.getTitle();
					int year = f.getYear();
					float rating = r.getRate();
                %>
                <a href="index?c=User&a=get&id=<%=id%>" class="user userposter" data-id="<%=id%>" data-title="<%=title%>" data-year="<%=year%>">
			<div class="metadata">
				<span><%=id_film%> </span>
                                <span><%=title%> (<%=year%>)</span>
				<div class="stars_grey"><div class="stars_yellow" style="width:<%=rating*100/5%>px"></div></div>
			</div>
		</a>

                 <%
		   }
		}
		%>
        </div>
</div>
<%@include file="/includes/footer.jsp" %>


