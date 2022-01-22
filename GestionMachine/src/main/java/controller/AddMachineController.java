package controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Machine;
import beans.Salle;
import service.MachineService;
import service.SalleService;
import service.UserService;

@WebServlet(urlPatterns = "/add_machine")
public class AddMachineController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private MachineService machineService;
	private SalleService salleService;
	public AddMachineController() {
		super();
		this.userService = new UserService();
		this.machineService = new MachineService();
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
		String reference = request.getParameter("reference");
		String stringDateAchat = request.getParameter("dateAchat");
		Date dateAchat = new Date();
		try {
			dateAchat = new SimpleDateFormat("yyyy-MM-dd").parse(stringDateAchat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        Double prix = Double.parseDouble(request.getParameter("prix"));
        int salleId = Integer.parseInt(request.getParameter("salleId"));
        try {
            Machine machine  = new Machine(reference, dateAchat, prix, salleId );
            this.machineService.create(machine);
            String destPage = "machines";
            String message = "Machine a �t� ajout�e avec succ�s";  
            response.sendRedirect(destPage);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		 try {	
			 	List<Salle> salle = this.salleService.findAll();
			 	request.setAttribute("salle", salle);
			 	String destPage = "login_jsp";
			 	boolean isLogged = this.userService.checkIfLogged(request);
			 	if(isLogged) {
			 		destPage = "add_machine_jsp";
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
}