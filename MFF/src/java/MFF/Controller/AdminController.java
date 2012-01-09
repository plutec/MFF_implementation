package MFF.Controller;

import MFF.Model.RSManagement;
import MFF.Model.User;
import java.util.HashMap;

public class AdminController implements ControllerInterface {
	
	RSManagement model;
	
	public AdminController() {
		model = new RSManagement();
	}
	
	public HashMap<String, Object> call(String action, HashMap parameters) {
		
		if (action.equals("adminPanel")) {
			return this.showAdminPanel(parameters);
		}
		return null;
		
	}
	
	private HashMap<String, Object> showAdminPanel(HashMap<String, Object> parameters) {
		HashMap<String, Object> toRet = new HashMap<String, Object>();
		if (parameters.get("sessionUserID") != null){
			User u = model.getAnUser((String)parameters.get("sessionUserID"));
			if (u.getIsAdmin()){
				toRet.put("address", "View_Admin.jsp");
				toRet.put("title", "MFF :: Administración");
			}else{
				toRet.put("address", "View_Error.jsp");
				toRet.put("title", "MFF :: Acceso denegado");
			}
		}else{
			toRet.put("address", "View_Error.jsp");
			toRet.put("title", "MFF :: Acceso denegado");
		}
		return toRet;
	}
}
