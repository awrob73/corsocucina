package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceAmministratore;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;


public class ServletEdizioniCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceEdizione se;
	private ServiceAmministratore sa;
	private ServiceUtente su;
	private ServiceCorso sc;

	public ServletEdizioniCorso() throws Exception {
		super();
		this.se = ServiceEdizione.getInstance();
		this.sa = ServiceAmministratore.getInstance();
		this.su = ServiceUtente.getInstance();
		this.sc = ServiceCorso.getInstance();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Utente a = sa.checkCredenziali(username, password);
			Utente u = su.checkCredenziali(username, password);
			
			String convId = request.getParameter("idCorso");
			Long idCorso = Long.parseLong(convId);
		
			Corso co = sc.visualizzaCorso(idCorso);
			
			List<EdizioneDTO> listEdizioni = se.visualizzaEdizioniPerCorso(idCorso);
			
			if(a.getNome() != null) {
				HttpSession currentSession = request.getSession();
				currentSession.setAttribute("user", a);
				currentSession.setMaxInactiveInterval(10 * 60);
				
				request.setAttribute("user", a);
				request.setAttribute("edizioni", listEdizioni);
				request.setAttribute("corso", co);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/listaEdizioniA.jsp");
				requestDispatcher.forward(request, response);
			}
			else if (u.getNome() != null) {
				
				HttpSession currentSession = request.getSession();
				currentSession.setAttribute("user", u);
				currentSession.setMaxInactiveInterval(10 * 60);
				
				request.setAttribute("user", u);
				request.setAttribute("edizioni", listEdizioni);
				request.setAttribute("corso", co);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/listaEdizioni.jsp");
				requestDispatcher.forward(request, response);
			} 

			
			

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}