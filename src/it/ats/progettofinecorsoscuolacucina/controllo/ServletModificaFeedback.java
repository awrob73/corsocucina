package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceFeedback;



@WebServlet("/modificaFeedback")
public class ServletModificaFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceFeedback sf;


	public ServletModificaFeedback() {
		super();
		this.sf = ServiceFeedback.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		String convId = request.getParameter("id");
		Long idFeedback = Long.parseLong(convId);
		String newDescrizione = request.getParameter("descrizione");	
		String convNewVoto = request.getParameter("voto");
		int newVoto = Integer.parseInt(convNewVoto);
		String convIdEdizione = request.getParameter("id_edizione");
		Long idEdizione = Long.parseLong(convIdEdizione);
		String convIdUtente = request.getParameter("id_utente");
		Long idUtente = Long.parseLong(convIdUtente);
		
			Feedback f = sf.cercaFeedback(idUtente, idEdizione);
			
			if (newDescrizione != null && newDescrizione != f.getDescrizione()) {
				sf.modificaDescrizione(f, newDescrizione);
			}
			
			Integer value= new Integer(newVoto);
			
			if (value != null && newVoto >=1 && newVoto <=10 && newVoto != f.getVoto()) {
				sf.modificaVoto(f, newVoto);
			}
			
			f = sf.cercaFeedback(idUtente, idEdizione);
			request.setAttribute("feedback", f);
			
			getServletContext().
			getRequestDispatcher("/WEB-INF/*****.jsp").
			forward(request, response);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
	}
}
