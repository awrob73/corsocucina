
package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceFeedback;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

@WebServlet("/corsiPersonali")
public class ServletCorsiPersonali extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceUtente su;
	private ServiceCorso sc;
	private ServiceEdizione se;
	private ServiceFeedback sf;

	public ServletCorsiPersonali() throws Exception {
		super();
		this.su = ServiceUtente.getInstance();
		this.sc = ServiceCorso.getInstance();
		this.se = ServiceEdizione.getInstance();
		this.sf = ServiceFeedback.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");

		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		List<Edizione> listaEdizioniAttive = new ArrayList<Edizione>();
		List<Edizione> listaEdizioniConcluseNoFeedback = new ArrayList<Edizione>();
		List<Edizione> listaEdizioniConcluseSiFeedback = new ArrayList<Edizione>();
		
		try {
			Utente u = su.visualizzaDatiUtente(username);

			listaEdizioni = se.visualizzaEdizioniPerUtente(u.getId());

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
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/corsiPersonali.jsp");
			requestDispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}