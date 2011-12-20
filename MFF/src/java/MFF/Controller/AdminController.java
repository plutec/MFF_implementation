package MFF.Controller;

import MFF.Model.RSManagement;
import java.util.HashMap;

public class AdminController implements ControllerInterface {

    RSManagement model;

    public AdminController() {
	model = new RSManagement();
    }

    @Override
    public HashMap<String, Object> call(String action, HashMap<String, Object> parameters) {

	if (action.equals("adminPanel")) {
	    return this.showAdminPanel(parameters);
	}
	return null;

    }

    private HashMap<String, Object> showAdminPanel(HashMap<String, Object> parameters) {
	HashMap<String, Object> toRet = new HashMap<String, Object>();
	toRet.put("address", "View_Admin.jsp");
	toRet.put("title", "MFF :: Administración");
	return toRet;
    }
}
