
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
public class RatingController implements ControllerInterface {
	RSManagement model;
	public RatingController() {
		model=new RSManagement();
	}
	public HashMap<String, Object> call(String action, HashMap parameters) {
		if (action.equals("rate")) {
			return this.rate(parameters);
		} else if(action.equals("delete")) {
			return this.delete(parameters);
		} else if(action.equals("getBestRatedFilms")) {
			return this.getBestRatedFilms(parameters);
		}
		return null;
	}
	protected HashMap<String, Object> rate(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		Film f = new Film(Integer.parseInt((String)parameters.get("film")), "", 0);
		User u = new User((String)parameters.get("sessionUserID"), "", false);
		int rate = Integer.parseInt((String)parameters.get("rate"));
		model.rate(u, f, rate);
		return toRet;
	}
	protected HashMap<String, Object> delete(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		Film f = new Film(Integer.parseInt((String)parameters.get("film")), "", 0);
		User u = new User((String)parameters.get("sessionUserID"), "", false);
		model.deleteRating(u, f);
		return toRet;
	}
	protected HashMap<String, Object> getBestRatedFilms(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		int max=10; //Máximo de películas a devolver
		ArrayList<Film> films=model.getBestRatedFilms(max);
		toRet.put("films", films);
		toRet.put("address", "bestRated.jsp");
		return toRet;
	}
}
