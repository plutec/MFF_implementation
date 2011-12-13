/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MFF.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author antonio
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
        try {
	    //Extraemos el nombre del controlador
	    String controllerS=request.getParameter("c");
	    if (controllerS==null || controllerS.equals("")) { controllerS="Index"; }
	    //Y el nombre de la acción
	    String action=request.getParameter("a");
	    if (action==null || action.equals("")) { action="index"; }
	    //Creamos el controlador
	    ControllerInterface controllerO = null;
	    if (controllerS.equals("Index")) { controllerO=(IndexController)new IndexController(); }


	    //Ahora las acciones
	    //if (action.equals("index")) { controllerO.index(); }
	    HashMap<String, Object> returned;
	    returned=controllerO.call(action, null);
	    String address;
	    if (returned.containsKey("address")) {
		address=(String) returned.remove("address");
	    } else {
		address="error.jsp";
	    }

	    Iterator itr=returned.keySet().iterator();
	    while(itr.hasNext()) {
		String key=(String) itr.next();
		request.setAttribute(key, returned.get(key));
	    }
	    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.forward(request, response);
    //TODO output your page here
    /*out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet FrontController</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Servlet FrontController at " + request.getContextPath () + "</h1>");
    out.println("</body>");
    out.println("</html>");*/
    //Cargamos el nombre del controlador

            
        } finally { 
            //out.close();
        }
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
