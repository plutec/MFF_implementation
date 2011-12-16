/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import MFF.Exceptions.DuplicateUser;
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
		if (action.equals("addUser")) {
		    return this.addUser(parameters);
		} else if(action.equals("loginUser")) {
		    return this.loginUser(parameters);
		} else if(action.equals("getBestRatedFilmsByUser")) {
		    return this.getBestRatedFilmsByUser(parameters);
		} else if(action.equals("searchUserByNick")) {
		    return this.searchUserByNick(parameters);
		}
		return new HashMap<String, Object>();
	}
	//Params: "nick", "pass"
	//Return: "user" -> Objecto del usuario creado
	//Return: "user" -> null si la inserción no ha sido válida
	protected HashMap<String, Object> addUser(HashMap<String, Object> parameters) {
	    HashMap<String, Object> toRet=new HashMap<String, Object>();
	    User toInsert=new User((String)parameters.get("nick"), (String)parameters.get("pass"), false);
	try {
	    model.addUser(toInsert);
	    toRet.put("user", toInsert);

	} catch (DuplicateUser ex) {
	    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
	    toRet.put("user", null);
	}
	    toRet.put("address", "Views_addUser.jsp");
	    toRet.put("title", "MFF :: Usuario creado correctamente");
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
	    } catch(Exception e) {
		u=null;
	    }
	    toRet.put("address", "login_ok.jsp"); //TODO falta que me digas la página a la que lo manda.
	    toRet.put("user", u);
	    return toRet;
	}
	protected HashMap<String, Object> getBestRatedFilmsByUser(HashMap<String, Object> parameters) {
		return null;
	}
	//Params
	//"nick", nick del usuario a buscar, puede ser parcial
	//"users" ArrayList de usuarios coincidentes con la búsqueda
	protected HashMap<String, Object> searchUserByNick(HashMap<String, Object> parameters) {
	    HashMap<String, Object> toRet=new HashMap<String, Object>();
	    toRet.put("users", model.searchUserByNick((String) parameters.get("nick")));
	    toRet.put("address", "View_search_Users.jsp"); //TODO @skuark, tócala XD
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
