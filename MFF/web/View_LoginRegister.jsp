<%@page import="MFF.Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp" %>
<%
	if (request.getAttribute("user") != null || session.getAttribute("user") != null){
		User u = (User)request.getAttribute("user");
		session.setAttribute("user", u);
		response.sendRedirect(response.encodeRedirectURL("index")) // No mantiene la sesión;
	}
%>
<div id="content">
		
	<div id="loginForm">
		<h1>Identifícate:</h1>
		<form action="index?c=User&a=loginUser" method="POST">
			<div class="formInputBox">
				<label for="loginUser">Usuario:</label>
				<input type="text" name="nick" id="loginUser" class="text loginValidate" />
			</div>
			<div class="formInputBox">
				<label for="loginPass">Contraseña:</label>
				<input type="password" name="pass" id="loginPass" class="text loginValidate" />
			</div>
			<div class="formInputBox">
				<input type="submit" id="loginSubmit" value="Identificarme" class="submit" disabled="disabled" />
			</div>
		</form>
		<% if (request.getAttribute("loginFailed") != null && (Boolean)request.getAttribute("loginFailed") == true) { %>
			<span class="errorMessage">El usuario o la contraseña son incorrectos. Vuelva a intentarlo.</span>
		<% } %>
	</div>

	<div id="registerForm">
		<h1>O crea una cuenta de usuario ahora:</h1>
		<form action="index?c=User&a=addUser" method="POST">
			<div class="formInputBox">
				<label for="registerUser">Usuario:</label>
				<input type="text" name="nick" id="registerUser" class="text registerValidate" />
			</div>
			<div class="formInputBox">
				<label for="registerPass">Contraseña:</label>
				<input type="password" name="pass" id="registerPass" class="text registerValidate" />
			</div>
			<div class="formInputBox">
				<label for="registerPassRepeat">Repite la contraseña:</label>
				<input type="password" name="passrepeat" id="registerPassRepeat" class="text registerValidate" />
			</div>
			<div class="formInputBox">
				<input type="submit" id="registerSubmit" value="Crear mi cuenta de usuario" class="submit" disabled="disabled" />
			</div>
		</form>
		<% if (request.getAttribute("registerFailed") != null && (Boolean)request.getAttribute("registerFailed") == true) { %>
			<span class="errorMessage">Ya existe un usuario con este nombre de usuario. Elija otro distinto.</span>
		<% } %>
	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>