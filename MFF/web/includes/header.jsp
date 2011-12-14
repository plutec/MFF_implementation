<!DOCTYPE html>
<head>
	<title></title>
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link href='http://fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
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
			<form action="" method="get">
				<input type="text" class="search" />
				<input type="submit" value="Buscar" class="submit" />
			</form>
		</div>
		<div id="logo">
			<a href="index"><img src="images/logo.png" alt="Logo" /></a>
		</div>
	</header>
