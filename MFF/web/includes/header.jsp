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
				String username = (String) session.getAttribute("username");
				if (username == null) {
					%><span><a href="#">Login</a></span><%
				}else{
					%><span><a href="#">Administrar</a> | <a href="#">Salir</a></span><%
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
				<input type="text" name="search" class="search" />
				<input type="submit" value="Buscar" class="submit" />
			</form>
		</div>
		<div id="logo">
			<a href="index"><img src="images/logo.png" alt="Logo" /></a>
		</div>
	</header>
