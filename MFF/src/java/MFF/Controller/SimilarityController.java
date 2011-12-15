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
public class SimilarityController implements ControllerInterface {
	
	@Override
	public HashMap<String, Object> call(String action, HashMap<String, Object> parameters) {
		if (action.equals("getRecommendations")) {
			return this.getRecommendations(parameters);
		} else if(action.equals("updateModel")) {
			return this.updateModel(parameters);
		}
		return new HashMap<String, Object>();
	}
	protected HashMap<String, Object> getRecommendations(HashMap<String, Object> parameters) {
		return null;
	}
	protected HashMap<String, Object> updateModel(HashMap<String, Object> parameters) {
		return null;
	}
}
