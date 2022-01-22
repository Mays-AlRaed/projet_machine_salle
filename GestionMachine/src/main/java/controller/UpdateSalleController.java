package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Salle;
import service.SalleService;
import service.UserService;

@WebServlet(urlPatterns = "/update_marque")
public class UpdateSalleController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private SalleService salleService;
	
	public UpdateSalleController() {
		super();
		this.userService = new UserService();
		this.salleService = new SalleService();
	}

    /**
     * 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String code = request.getParameter("code");
        String type = request.getParameter("type");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Salle salle  = new Salle(id, code, type);
            this.salleService.update(salle);
            String destPage = "salle";
            response.sendRedirect(destPage);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		 try {	
			 	String destPage = "login_jsp";
			 	boolean isLogged = this.userService.checkIfLogged(request);
			 	if(isLogged) {
			 		destPage = "update_salle_jsp";
			 		String idParameter = request.getParameter("id");
			 		if(idParameter != null) {
			 			int id = Integer.parseInt(idParameter);
			 			Salle salle = this.salleService.findById(id);
			 			request.setAttribute("salle", salle);
			 		}
			 		else {
			 			destPage = "add_salle_jsp";
			 		}
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
}
