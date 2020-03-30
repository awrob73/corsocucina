package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
 * Servlet implementation class ServletConfermaFeedback
 */
public class ServletConfermaFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceUtente su;
	private ServiceEdizione se;
	private ServiceFeedback sf;

	public ServletConfermaFeedback() throws Exception {
		super();
		this.su = ServiceUtente.getInstance();
		this.se = ServiceEdizione.getInstance();
		this.sf = ServiceFeedback.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String convU = request.getParameter("idUtente");
		Long idUtente = Long.parseLong(convU);

		String convE = request.getParameter("idEdizione");
		Long idEdizione = Long.parseLong(convE);

		String descrizione = request.getParameter("descrizione");

		String convInt = request.getParameter("voto");
		Integer voto = Integer.parseInt(convInt);

		try {

			Utente u = su.leggiUtente(idUtente);
			Edizione ed = se.leggiEdizione(idEdizione);

			Feedback fb = new Feedback(descrizione, voto, ed, u);
			sf.inserisciFeedback(fb);
			
			request.setAttribute("user", u);
			request.setAttribute("edizione", ed);
			request.setAttribute("feedback", fb);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/leggiFeedbackEdU.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

