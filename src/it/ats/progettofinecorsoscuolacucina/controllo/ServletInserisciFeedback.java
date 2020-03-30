package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

/**
 * Servlet implementation class ServletInserisciFeedback
 */
public class ServletInserisciFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceUtente su;
	private ServiceEdizione se;

	public ServletInserisciFeedback() throws Exception {
		super();
		this.su = ServiceUtente.getInstance();
		this.se = ServiceEdizione.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String convU = request.getParameter("idUtente");
		Long idUtente = Long.parseLong(convU);
		
		String convE = request.getParameter("idEdizione");
		Long idEdizione = Long.parseLong(convE); 
		
		try {
			
			Utente u = su.leggiUtente(idUtente); 
			Edizione ed = se.leggiEdizione(idEdizione);
			
			
			request.setAttribute("user", u);
			request.setAttribute("edizione", ed);
				
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/inserisciFeedback.jsp");
			requestDispatcher.forward(request, response);
			
		} 
		catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}