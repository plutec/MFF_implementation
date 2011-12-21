
package MFF.Controller;

import MFF.Model.Film;
import MFF.Model.RSManagement;
import java.util.HashMap;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class FilmController implements ControllerInterface{
    RSManagement model;
    public FilmController() {
	model=new RSManagement();
    }
	
	@Override
	public HashMap<String, Object> call(String action, HashMap parameters) {
		if (action.equals("search")) {
			return this.searchFilm(parameters);
		} else if(action.equals("searchFilmsAdmin")) {
			return this.searchFilmsAdmin(parameters);
		} else if(action.equals("get")) {
			return this.get(parameters);
		} else if(action.equals("add")) {
			return this.add(parameters);
		} else if(action.equals("edit")) {
			return this.edit(parameters);
		} else if(action.equals("delete")) {
			return this.delete(parameters);
		}
		return null;
	}
	protected HashMap<String, Object> searchFilm(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		if (parameters.containsKey("search") && (!parameters.get("search").equals(""))) { //Si se está realizando una búsqueda, hacemos las cosas oportunas (al modelo)
		    toRet.put("films", model.searchFilm((String) parameters.get("search")));
		}
		toRet.put("title", "MFF :: Resultados búsqueda");
		toRet.put("address", "View_FilmsSearchResults.jsp");
		return toRet;
	}

	private HashMap<String, Object> searchFilmsAdmin(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		if (parameters.containsKey("search") && (!parameters.get("search").equals(""))) {
			RSManagement rsm=new RSManagement();
			toRet.put("films", rsm.searchFilm((String) parameters.get("search")));
		}
		toRet.put("address", "View_AdminFilmsSearch.jsp");
		return toRet;
	}
	
	//le paso el id de la película que quiero consultar como "id"
	//Return en el hashmap te paso con la clave "film" y el objecto de la clase Film.
	protected HashMap<String, Object> get(HashMap<String, Object> parameters) {
	    HashMap<String, Object> toRet=new HashMap<String, Object>();
	    Film f=model.searchFilmById((Integer)parameters.get("id"));
	    toRet.put("film", f);
	    toRet.put("title", "MFF :: Película "+f.getTitle());
	    toRet.put("address", "View_Film.jsp");
	    return toRet;
	}
	//Params: "title", "year"
	//Return "film", Film de la película guardada ya con el ID asociado.
	protected HashMap<String, Object> add(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		Film f=new Film(-1, (String)parameters.get("title"), (Integer)parameters.get("year"));
		model.addFilm(f);
		toRet.put("film", f);
		toRet.put("title", "MFF :: Inserta la película "+f.getTitle());
		toRet.put("address", "Dirección_de_nueva_peli.jsp"); //TODO la dirección después de añadir película
		return toRet;
	}
	protected HashMap<String, Object> edit(HashMap<String, Object> parameters) {
		return null;
	}
	protected HashMap<String, Object> delete(HashMap<String, Object> parameters) {
		return null;
	}
}
