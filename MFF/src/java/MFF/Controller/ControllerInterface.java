package MFF.Controller;

import java.util.HashMap;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public interface ControllerInterface {
	public HashMap<String, Object> call(String action, HashMap parameters);
}
