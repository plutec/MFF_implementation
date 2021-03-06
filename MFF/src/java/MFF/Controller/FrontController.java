package MFF.Controller;

import MFF.Model.User;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antonio Sánchez Perea
 * @date 13-dic-2011
 */
public class FrontController extends HttpServlet {
	
	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		//PrintWriter out = response.getWriter();
		//Extraemos todos los parámetros
		HashMap<String, String> parameters = this.extractParameters(request);//new HashMap<String, Object>();
		//Extraemos el nombre del controlador
		String controllerS = request.getParameter("c");
		if (controllerS == null || controllerS.equals("")) {
			controllerS = "Index";
		}
		//Y el nombre de la acción
		String action = request.getParameter("a");
		if (action == null || action.equals("")) {
			action = "index";
		}
		//Creamos el controlador
		ControllerInterface controllerO = null;
		if (controllerS.equals("Index")) {
			controllerO = new IndexController();
		} else if (controllerS.equals("Film")) {
			
			controllerO = new FilmController();
			
			/*String searchString = request.getParameter("search");
			 * if (searchString != null) {
			 * parameters.put("search", searchString);
			 * }
			 * 
			 * String filmID = request.getParameter("id");
			 * if (filmID != null) {
			 * //parameters.put("id", Integer.valueOf(filmID));
			 * }*/
			
		} else if (controllerS.equals("Rating")) {
			controllerO = new RatingController();
		} else if (controllerS.equals("User")) {
			
			controllerO = new UserController();
			/*String searchString = request.getParameter("search");
			 * if (searchString != null) parameters.put("search", searchString);
			 * String userId = request.getParameter("nick");
			 * if (userId != null) parameters.put("nick", userId);
			 * String userPass = request.getParameter("pass");
			 * if (userPass != null) parameters.put("pass", userPass);*/
			
		} else if (controllerS.equals("Similarity")) {
			controllerO = new SimilarityController();
		} else if (controllerS.contains("Admin")) {
			controllerO = new AdminController();
		} else { //Manda a página de error
			String address = "View_Error.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
		//Extraemos datos de la sesión
		HttpSession session = request.getSession(true);
		if (session!=null && session.getAttribute("user") != null) {
		    User u=(User) session.getAttribute("user");
		    parameters.put("sessionUserID", u.getId());
		}

		//Llamamos al método call con el nombre de la acción
		HashMap<String, Object> returned = controllerO.call(action, parameters);
		
		//Mandamos a la vista que nos diga el controlador
		String address = null;
		if (returned.containsKey("address")) {
			address = (String) returned.remove("address");
		}
		
		Iterator itr = returned.keySet().iterator();
		while (itr.hasNext()) {
			String key = (String) itr.next();
			request.setAttribute(key, returned.get(key));
		}
		
		if (address != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
		//FIN!
	}
	
	protected HashMap<String, String> extractParameters(HttpServletRequest request) {
		HashMap<String, String> toRet = new HashMap<String, String>();
		Enumeration<String> names=request.getParameterNames();
		while (names.hasMoreElements()) {
			String key = names.nextElement();
			toRet.put((String) key,(String)request.getParameter(key));
		}
		return toRet;
	}
	
	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * Handles the HTTP <code>POST</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	
	/**
	 * Returns a short description of the servlet.
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
}
