/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import MFF.Model.Film;
import MFF.Model.RSManagement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class IndexController implements ControllerInterface {
    RSManagement model;
    public IndexController() {
	model=new RSManagement();
    }
    @Override
    public HashMap<String, Object> call(String action, HashMap<String, Object> parameters) {
	if (action.equals("index")) {
	    return this.index(parameters);
	}
	return new HashMap<String, Object>();

	
    }
    protected HashMap<String, Object> index(HashMap<String, Object> parameters) {
	HashMap<String, Object> toRet=new HashMap<String, Object>();
	toRet.put("address", "index.jsp");
	int max=10; //Máximo de películas a devolver
	ArrayList<Film> films=model.getBestRatedFilms(max);
	toRet.put("films", films);
	//Indicamos la vista
	toRet.put("address", "index.jsp");
	return toRet;

    }
}
