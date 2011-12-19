/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import MFF.Exceptions.DuplicateUser;
import MFF.Exceptions.NotLoginUser;
import MFF.Model.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
	@Override
	public HashMap<String, Object> call(String action, HashMap<String, Object> parameters) {
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
		} else if(action.equals("searchUserByNick")) {
			return this.search(parameters);
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
		toRet.put("address", "View_LoginRegister.jsp"); //TODO falta que me digas la página a la que lo manda.
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
		toRet.put("users", model.searchUserByNick((String) parameters.get("search")));
		toRet.put("address", "View_UsersSearchResults.jsp"); //TODO Vista para mostrar resultados de buscar usuario
		toRet.put("title", "MFF :: Búsqueda de usuarios");
		return toRet;
	}
	//param: "id"
	//Return: "user", User, usuario coincidente.
	protected HashMap<String, Object> getUser(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		toRet.put("users", model.getAnUser((String) parameters.get("nick")));
		//Si hay que extraer también las valoraciones dadas por el usuario, hay que hacer más cosas aquí en el controlador
		toRet.put("address", "View_search_User.jsp"); //TODO @skuark, tócala XD
		toRet.put("title", "MFF :: Ficha de usuario");
		return toRet;
	}

}
