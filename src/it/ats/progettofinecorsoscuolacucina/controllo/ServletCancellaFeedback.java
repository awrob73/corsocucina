package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceFeedback;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;


/**
 * Servlet implementation class ServletCancellaFeedback
 */

public class ServletCancellaFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceFeedback feedbackServiceImpl;
	private ServiceUtente su;
	private ServiceEdizione se;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			String convIdUtente = request.getParameter("idUtente");
			long idUtente = Long.parseLong(convIdUtente);
			Utente u = su.leggiUtente(idUtente);
	
			String convIdEdizione = request.getParameter("idEdizione");
			long idEdizione = Long.parseLong(convIdEdizione);
			Edizione ed = se.leggiEdizione(idEdizione);
			
			Feedback f = feedbackServiceImpl.cercaFeedback(idUtente, idEdizione);
			
			long idFeedback = f.getId();
		     feedbackServiceImpl.cancellaFeedback(idFeedback);
		     request.setAttribute("user", u);
		     request.setAttribute("edizione", ed);
		
		     getServletContext().
				getRequestDispatcher("/WEB-INF/cancellaFeedback.jsp").
				forward(request, response);
		     
		  } catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}

	}
	
	public ServletCancellaFeedback() {
		super();
		this.feedbackServiceImpl = ServiceFeedback.getInstance();
		this.su = ServiceUtente.getInstance();
		this.se = ServiceEdizione.getInstance();
	}
	
}
