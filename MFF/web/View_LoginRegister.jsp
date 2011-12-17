<%@page import="MFF.Model.Film"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp" %>
<% Film film = (Film)request.getAttribute("film"); %>
<div id="content">
	
	<div id="loginForm">
		<h1>Identifícate:</h1>
		<form>
			<div class="formInputBox">
				<label for="loginUser">Usuario:</label>
				<input type="text" name="user" id="loginUser" class="text" />
			</div>
			<div class="formInputBox">
				<label for="loginPass">Contraseña:</label>
				<input type="password" name="pass" id="loginPass" class="text" />
			</div>
			<div class="formInputBox">
				<input type="submit" value="Identificarme" class="submit" />
			</div>
		</form>
	</div>
	
	<div id="registerForm">
		<h1>O crea una cuenta de usuario ahora:</h1>
		<form>
			<div class="formInputBox">
				<label for="registerUser">Usuario:</label>
				<input type="text" name="user" id="registerUser" class="text" />
			</div>
			<div class="formInputBox">
				<label for="registerPass">Contraseña:</label>
				<input type="password" name="pass" id="registerPass" class="text" />
			</div>
			<div class="formInputBox">
				<label for="registerPassRepeat">Repite la contraseña:</label>
				<input type="password" name="passrepeat" id="registerPassRepeat" class="text" />
			</div>
			<div class="formInputBox">
				<input type="submit" value="Crear mi cuenta de usuario" class="submit" />
			</div>
		</form>
	</div>
	
</div>
<%@include file="/includes/footer.jsp" %>