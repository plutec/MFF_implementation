/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

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
	protected HashMap<String, Object> addUser(HashMap<String, Object> parameters) {
		return null;
	}
	protected HashMap<String, Object> loginUser(HashMap<String, Object> parameters) {
		return null;
	}
	protected HashMap<String, Object> getBestRatedFilmsByUser(HashMap<String, Object> parameters) {
		return null;
	}
	protected HashMap<String, Object> searchUserByNick(HashMap<String, Object> parameters) {
		return null;
	}

}
