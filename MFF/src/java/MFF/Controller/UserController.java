/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import MFF.Exceptions.DuplicateUser;
import MFF.Exceptions.NotLoginUser;
import MFF.Model.*;
import java.util.HashMap;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class UserController implements ControllerInterface {
	RSManagement model;
	public UserController() {
		model=new RSManagement();
	}
	
	public HashMap<String, Object> call(String action, HashMap parameters) {
		if (action.equals("loginRegisterForms")) {
			return this.showLoginRegisterForms();
		} else if (action.equals("addUser")) {
			return this.addUser(parameters);
		} else if(action.equals("loginUser")) {
			return this.loginUser(parameters);
		} else if(action.equals("logoutUser")) {
			return this.logoutUser(parameters);
		} else if(action.equals("getBestRatedFilmsByUser")) {
			return this.getBestRatedFilmsByUser(parameters);
		} else if(action.equals("search")) {
			return this.search(parameters);
		} else if(action.equals("get")) {
			return this.getUser(parameters);
		}
		return null;
	}
	protected HashMap<String, Object> showLoginRegisterForms() {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		toRet.put("address", "View_LoginRegister.jsp");
		toRet.put("title", "MFF :: Login y registro de usuarios");
		return toRet;
	}
	//Params: "nick", "pass"
	//Return: "user" -> Objecto del usuario creado
	//Return: "user" -> null si la inserción no ha sido válida
	protected HashMap<String, Object> addUser(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		User toInsert=new User((String)parameters.get("nick"), (String)parameters.get("pass"), false);
		try {
			model.addUser(toInsert);
			toRet.put("registerOk", true);
		} catch (DuplicateUser ex) {
			toRet.put("registerOk", false);
		}
		toRet.put("address", "View_LoginRegister.jsp");
		toRet.put("title", "MFF :: Login y registro de usuarios");
		return toRet;
	}
	//Params:
	// "nick", "pass"
	//Return
	//"user"-> Objeto User
	//"user" -> null (En caso de que el login sea incorrecto)
	protected HashMap<String, Object> loginUser(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		//Creamos el usuario, para que lo valide
		User u=new User((String)parameters.get("nick"), (String)parameters.get("pass"), false);
		try {
			u=model.login(u);
			toRet.put("loginOk", true);
		} catch(NotLoginUser ex) {
			u=null;
			toRet.put("loginOk", false);
		}
		toRet.put("address", "View_LoginRegister.jsp");
		toRet.put("title", "MFF :: Login y registro de usuarios");
		toRet.put("user", u);
		return toRet;
	}
	protected HashMap<String, Object> logoutUser(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		toRet.put("address", "View_LoginRegister.jsp"); //TODO falta que me digas la página a la que lo manda.
		toRet.put("title", "MFF :: Login y registro de usuarios");
		toRet.put("logout", true);
		return toRet;
	}
	protected HashMap<String, Object> getBestRatedFilmsByUser(HashMap<String, Object> parameters) {
		return null;
	}
	//Params
	//"search", nick del usuario a buscar, puede ser parcial
	//"users" ArrayList de usuarios coincidentes con la búsqueda
	protected HashMap<String, Object> search(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		if (parameters.containsKey("search") && (!parameters.get("search").equals(""))) { //Si se está realizando una búsqueda, hacemos las cosas oportunas (al modelo)
		    toRet.put("users", model.searchUserByNick((String) parameters.get("search")));
		}
		//String cad=(String) parameters.get("search");
		//toRet.put("users", model.searchUserByNick((String) parameters.get("search")));
		if (parameters.get("sessionUserID") != null){
			toRet.put("address", "View_UsersSearchResults.jsp");
			toRet.put("title", "MFF :: Búsqueda de usuarios");
		}else{
			toRet.put("address", "View_Error.jsp");
			toRet.put("title", "MFF :: Acceso denegado");
		}
		return toRet;
	}
	//param: "id"
	//Return: "user", User, usuario coincidente.
	protected HashMap<String, Object> getUser(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		User u=model.getAnUserWithRatings((String) parameters.get("id"));
		toRet.put("user", u);
		//Si hay que extraer también las valoraciones dadas por el usuario, hay que hacer más cosas aquí en el controlador
		if (parameters.get("sessionUserID") != null){
			toRet.put("address", "View_User.jsp");
			toRet.put("title", "MFF :: Ficha de usuario");
		}else{
			toRet.put("address", "View_Error.jsp");
			toRet.put("title", "MFF :: Acceso denegado");
		}
		return toRet;
	}

}
