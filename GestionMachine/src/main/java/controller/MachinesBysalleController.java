package controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import beans.Machine;
import beans.Salle;
import service.MachineService;
import service.SalleService;
import service.UserService;
@WebServlet(urlPatterns = "/machine_by_marque")
public class MachinesBysalleController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private MachineService machineService;
	
	public MachinesBysalleController() {
		super();
		this.userService = new UserService();
		this.machineService = new MachineService();
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
			 		destPage = "machines_by_salle_jsp";
			 		String salleIdParameter = request.getParameter("salleId");
			 		if(salleIdParameter != null) {
			 			List<Machine> machines = this.machineService.findMachineBySalleId(Integer.parseInt(salleIdParameter));
			 			request.setAttribute("machines", machines);
			 		}
			 		else {
			 			destPage = "machines_jsp";
			 		}
			 	}
	            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
	            dispatcher.forward(request, response);
	        } catch (Exception ex) {
	            throw new ServletException(ex);
	        }
    }
}