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
public class FilmController implements ControllerInterface{

    @Override
    public HashMap<String, Object> call(String action, HashMap<String, Object> parameters) {
	if (action.equals("searchFilm")) {
	    return this.searchFilm(parameters);
	} else if(action.equals("add")) {
	    return this.add(parameters);
	} else if(action.equals("edit")) {
	    return this.edit(parameters);
	} else if(action.equals("delete")) {
	    return this.delete(parameters);
	}
	return new HashMap<String, Object>();
    }
    protected HashMap<String, Object> searchFilm(HashMap<String, Object> parameters) {
	return null;
    }
    protected HashMap<String, Object> add(HashMap<String, Object> parameters) {
	return null;
    }
    protected HashMap<String, Object> edit(HashMap<String, Object> parameters) {
	return null;
    }
    protected HashMap<String, Object> delete(HashMap<String, Object> parameters) {
	return null;
    }
}
