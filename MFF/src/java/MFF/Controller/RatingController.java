
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
public class RatingController implements ControllerInterface {
	RSManagement model;
	public RatingController() {
		model=new RSManagement();
	}
	@Override
	public HashMap<String, Object> call(String action, HashMap<String, Object> parameters) {
		if (action.equals("rate")) {
			return this.rate(parameters);
		} else if(action.equals("editRate")) {
			return this.editRate(parameters);
		} else if(action.equals("getBestRatedFilms")) {
			return this.getBestRatedFilms(parameters);
		}
		return null;
	}
	protected HashMap<String, Object> rate(HashMap<String, Object> parameters) {
		return null;
	}
	protected HashMap<String, Object> editRate(HashMap<String, Object> parameters) {
		
		return null;
	}
	protected HashMap<String, Object> getBestRatedFilms(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		int max=10; //Máximo de películas a devolver
		ArrayList<Film> films=model.getBestRatedFilms(max);
		toRet.put("films", films);
		toRet.put("address", "bestRated.jsp"); //TODO es posible que haya que cambiar el nombre de la vista
		return toRet;
	}
}
