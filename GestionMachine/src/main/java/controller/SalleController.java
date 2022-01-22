package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Salle;
import service.SalleService;
import service.UserService;


@WebServlet(urlPatterns = "/salle")
public class SalleController extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	private SalleService salleService;
	private UserService userService;
	public SalleController() {
		super();
		this.salleService = new SalleService();
		this.userService = new UserService();
	}
	

    /**
     * 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		 try {	
			 	String destPage = "login_jsp";
			 	boolean isLogged = this.userService.checkIfLogged(request);
			 	if(isLogged) {
			 		destPage = "salle_jsp";
			 		List<Salle> marques = this.salleService.findAll();
				 	request.setAttribute("marques", marques);
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
	

}
