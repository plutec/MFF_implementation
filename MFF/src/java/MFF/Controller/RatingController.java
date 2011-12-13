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
public class RatingController implements ControllerInterface {

    @Override
    public HashMap<String, Object> call(String action, HashMap<String, Object> parameters) {
	if (action.equals("rate")) {
	    return this.rate(parameters);
	} else if(action.equals("editRate")) {
	    return this.editRate(parameters);
	} else if(action.equals("getBestRatedFilms")) {
	    return this.getBestRatedFilms(parameters);
	}
	return new HashMap<String, Object>();
    }
    protected HashMap<String, Object> rate(HashMap<String, Object> parameters) {
	return null;
    }
    protected HashMap<String, Object> editRate(HashMap<String, Object> parameters) {
	return null;
    }
    protected HashMap<String, Object> getBestRatedFilms(HashMap<String, Object> parameters) {
	return null;
    }
}
