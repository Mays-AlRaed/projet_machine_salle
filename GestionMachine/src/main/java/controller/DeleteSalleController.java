package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Salle;
import service.SalleService;


@WebServlet(urlPatterns = "/delete_salle")
public class DeleteSalleController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private SalleService salleService;
	public DeleteSalleController() {
		super();
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
		int id = Integer.parseInt(request.getParameter("id"));
        try {
        	Salle salle = this.salleService.findById(id);
            this.salleService.delete(salle);
            String destPage = "salle";
            response.sendRedirect(destPage);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
