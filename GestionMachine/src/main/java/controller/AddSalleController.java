package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Salle;
import beans.user;
import service.SalleService;
import service.UserService;

@WebServlet(urlPatterns = "/add_marque")
public class AddSalleController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private SalleService salleService;
	public AddSalleController() {
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
        try {
            Salle salle  = new Salle(code, type);
            this.salleService.create(salle);
            String destPage = "salle";
            String message = "Salle a ?t? ajout?e avec succ?s";  
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
			 		destPage = "add_salle_jsp";
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
}
