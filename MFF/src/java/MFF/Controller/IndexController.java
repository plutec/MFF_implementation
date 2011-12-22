/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import MFF.Model.Film;
import MFF.Model.RSManagement;
import MFF.Model.User;
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
	public HashMap<String, Object> call(String action, HashMap parameters) {
		if (action.equals("index")) {
			return this.index(parameters);
		}
		return null;
		
		
	}
	protected HashMap<String, Object> index(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		toRet.put("address", "View_FrontPage.jsp");
		int max=10; //Máximo de películas a devolver
		ArrayList<Film> films=model.getBestRatedFilms(max);
		toRet.put("films", films);
		//Recomendaciones si el usuario está logueado
		if (parameters.containsKey("sessionUserID"))
		    toRet.put("recommendations", model.getRecommendations(new User((String) parameters.get("sessionUserID"),null,null)));
		//Indicamos el título
		toRet.put("title", "MFF :: Inicio");
		//Indicamos la vista
		toRet.put("address", "View_FrontPage.jsp");
		return toRet;
		
	}
}
