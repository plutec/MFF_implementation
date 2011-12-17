<%@page import="MFF.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<head>
	<title><%= request.getAttribute("title") %></title>
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/mff.js"></script>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Marvel:400,700' rel='stylesheet' type='text/css'>
</head>
<body>
	<header>
		<div id="loginBox">
			<%
				User user = (User) session.getAttribute("user");
				if (user == null) {
			%>
					<a href="index?c=User&a=loginRegisterForms">Login</a>
					<a href="index?c=User&a=loginRegisterForms">Registro</a>
			<%
				}else{
			%>
					<span>
						Bienvenido <%= user.getId() %>
						<% if (user.getIsAdmin()) { %> | <a href="#">Administrar</a> <% } %>
						<a href="#">Salir</a>
					</span>
			<%
				}
			%>
		</div>
		<div id="searchBox">
			<form action="index" method="get">
				<select name="c" size="1">
					<option value="Film">Películas</option>
					<option value="User">Usuarios</option>
				</select>
				<input type="hidden" name="a" value="search" />
				<input type="text" name="search" class="text" />
				<input type="submit" value="Buscar" class="submit" />
			</form>
		</div>
		<div id="logo">
			<a href="index"><img src="images/logo.png" alt="Logo" /></a>
		</div>
	</header>
