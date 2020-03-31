package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceFeedback;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;




public class ServletModificaFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceFeedback sf;
	private ServiceUtente su;
	private ServiceCorso sc;
	private ServiceEdizione se;


	public ServletModificaFeedback() {
		super();
		this.sf = ServiceFeedback.getInstance();
		this.su= ServiceUtente.getInstance();
		this.sc = ServiceCorso.getInstance();
		this.se = ServiceEdizione.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		String convId = request.getParameter("idFeedback");
		long idFeedback = Long.parseLong(convId);
		String newDescrizione = request.getParameter("descrizione");	
		String convNewVoto = request.getParameter("voto");
		int newVoto = Integer.parseInt(convNewVoto);
		String convIdEdizione = request.getParameter("idEdizione");
		long idEdizione = Long.parseLong(convIdEdizione);
		String convIdUtente = request.getParameter("idUtente");
		long idUtente = Long.parseLong(convIdUtente);
		
			Feedback f = sf.cercaFeedback(idUtente, idEdizione);
			Utente u = su.leggiUtente(f.getUtente().getId());
			List<Edizione> listaEdizioni = new ArrayList<Edizione>();
			
			if (newDescrizione != null && !newDescrizione.trim().toLowerCase().equals(f.getDescrizione().trim().toLowerCase())) {
				sf.modificaDescrizione(f, newDescrizione);
			}
			
			Integer value= new Integer(newVoto);
			
			if (value != null && newVoto >=1 && newVoto <=10 && newVoto != f.getVoto()) {
				sf.modificaVoto(f, newVoto);
			}
			
			listaEdizioni = se.visualizzaEdizioniPerUtente(u.getId());
			List<Edizione> listaEdizioniAttive = new ArrayList<Edizione>();
			List<Edizione> listaEdizioniConcluseNoFeedback = new ArrayList<Edizione>();
			List<Edizione> listaEdizioniConcluseSiFeedback = new ArrayList<Edizione>();

			for (Edizione ed : listaEdizioni) {

				if (ed.isTerminata() == true) {
					
					Feedback fb = sf.cercaFeedback(u.getId(),ed.getId());

					if(fb.getVoto()>0 && !fb.getDescrizione().isEmpty()) {
						listaEdizioniConcluseSiFeedback.add(ed);
					} else {
						listaEdizioniConcluseNoFeedback.add(ed);
					}
										
				} else {
					
					listaEdizioniAttive.add(ed);
				}
			}
			request.setAttribute("listaEdizioni", listaEdizioni);
			request.setAttribute("listaEdizioniAttive", listaEdizioniAttive);
			request.setAttribute("listaEdizioniConcluseNoFeedback", listaEdizioniConcluseNoFeedback);

			request.setAttribute("listaEdizioniConcluseSiFeedback", listaEdizioniConcluseSiFeedback);
			
			
			request.setAttribute("user", u);
			
			getServletContext().
			getRequestDispatcher("/WEB-INF/corsiPersonali.jsp").
			forward(request, response);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
	}
}
