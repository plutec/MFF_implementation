/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import MFF.Model.*;
import java.util.HashMap;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class UserController implements ControllerInterface {
	
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
	//TODO
	protected HashMap<String, Object> addUser(HashMap<String, Object> parameters) {
		return null;
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
	    RSManagement rsm=new RSManagement();
	    try { 
		u=rsm.login(u);
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
	//TODO hacer para mañana
	protected HashMap<String, Object> searchUserByNick(HashMap<String, Object> parameters) {
		return null;
	}
	//param: "id"
	protected HashMap<String, Object> getUser(HashMap<String, Object> parameters) {
		return null;
	}

}
