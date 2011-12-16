/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import MFF.Model.DAO.*;
import MFF.Model.Film;
import java.util.HashMap;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class FilmController implements ControllerInterface{
	
	@Override
	public HashMap<String, Object> call(String action, HashMap<String, Object> parameters) {
		if (action.equals("search")) {
			return this.searchFilm(parameters);
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
		String search;
		DAOFilm dF;
		if (parameters.containsKey("search") && (!parameters.get("search").equals(""))) { //Si se está realizando una búsqueda, hacemos las cosas oportunas (al modelo)
			search=(String) parameters.get("search");
			dF=new DAOFilm();
			toRet.put("films", dF.search(search));
		}
		toRet.put("title", "MFF :: Resultados búsqueda");
		toRet.put("address", "View_FilmsSearchResults.jsp");
		return toRet;
	}
	protected Film get(HashMap<String, Object> parameters) { // TODO: le paso el id de la película que quiero consultar como "id"
		return null;
	}
	protected HashMap<String, Object> add(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet=new HashMap<String, Object>();
		if (parameters.containsKey("add")) { //Si está este parámetro en get, es para añadir la película a la BDD
			
		} else {
			//Si no aparece, es para mostrar la pantalla de administración
		}
		return toRet;
	}
	protected HashMap<String, Object> edit(HashMap<String, Object> parameters) {
		return null;
	}
	protected HashMap<String, Object> delete(HashMap<String, Object> parameters) {
		return null;
	}
}
