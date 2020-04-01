package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

/**
 * Servlet implementation class ServletCancellaEdizione
 */
public class ServletCancellaEdizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceEdizione se;
	private ServiceCorso sc;
	
	public ServletCancellaEdizione() {
		
		this.se = ServiceEdizione.getInstance();
		this.sc = ServiceCorso.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String convIdE = request.getParameter("idEdizione");
			long idEdizione = Long.parseLong(convIdE);
			
			String convIdC = request.getParameter("idCorso");
			long idCorso = Long.parseLong(convIdC);
			
			Edizione ed = se.leggiEdizione(idEdizione);
			se.cancellaEdizione2(idEdizione);
			
			Corso corso = sc.visualizzaCorso(idCorso);
			List<EdizioneDTO> listEdizioni = se.visualizzaEdizioniPerCorso(idCorso);
			request.setAttribute("edizioni", listEdizioni);
			request.setAttribute("corso", corso);
			String m = "L'edizione del " + ed.getDataInizio() + " è stata correttamente cancellata";
		    request.setAttribute("messaggio", m);
		
		    getServletContext().
			getRequestDispatcher("/WEB-INF/listaEdizioniAMessage.jsp").
			forward(request, response);
		     

		  } catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
	}

}