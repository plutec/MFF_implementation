/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import MFF.Model.DAO.*;
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
		if (parameters.containsKey("search")) { //Si se está realizando una búsqueda, hacemos las cosas oportunas (al modelo)
			search=(String) parameters.get("search");
			dF=new DAOFilm();
			toRet.put("films", dF.search(search));
			toRet.put("title", "MFF :: Resultados búsqueda");
			toRet.put("address", "View_FilmsSearchResults.jsp");
		} else { //Sólo mostramos la vista para buscar
			toRet.put("title", "MFF :: Búsqueda de películas");
			toRet.put("address", "searchFilm.jsp"); //TODO: Debe ir a la portada
		}
		return toRet;
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
