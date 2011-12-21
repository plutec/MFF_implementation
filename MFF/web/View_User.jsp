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
                <a href="index?c=Film&a=get&id=<%=id_film%>" class="film filmposter" data-title="<%=title%>" data-year="<%=year%>">
						<div class="metadata">
							<span><%=title%> (<%=year%>)</span>
							<div class="stars_grey"><div class="stars_yellow" style="width:<%=(rating*100/5)%>%"></div></div>
						</div>
					</a>

                 <%
		   }
		}
		%>
        </div>
</div>
<%@include file="/includes/footer.jsp" %>


