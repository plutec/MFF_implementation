package MFF.Controller;

import MFF.Model.RSManagement;
import MFF.Model.User;
import java.util.HashMap;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class SimilarityController implements ControllerInterface {
	
	RSManagement model;
	
	public SimilarityController() {
		model = new RSManagement();
	}
	
	public HashMap<String, Object> call(String action, HashMap parameters) {
		if (action.equals("getRecommendations")) {
			return this.getRecommendations(parameters);
		} else if (action.equals("updateModel")) {
			return this.updateModel(parameters);
		}
		return null;
	}
	
	protected HashMap<String, Object> getRecommendations(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet= new HashMap<String, Object>();
		toRet.put("recommendations", model.getRecommendations(new User((String) parameters.get("sessionUserID"),null,null)));
		toRet.put("address", "View_FrontPage.jsp");
		return toRet;
	}
	
	protected HashMap<String, Object> updateModel(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet= new HashMap<String, Object>();
		
		toRet.put("address", "View_Admin.jsp");
		return toRet;
	}
}
