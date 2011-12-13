/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import MFF.Model.Film;
import java.util.HashMap;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class IndexController implements ControllerInterface {

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
	Film film=new Film(5,"Más adentro", 2003);
	toRet.put("prueba", film);
	//Llamamos al modelo
	//...

	//Ahora llamamos a la vista
	return toRet;
    }
}
