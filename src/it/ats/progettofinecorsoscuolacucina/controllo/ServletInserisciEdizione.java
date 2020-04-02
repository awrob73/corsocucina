package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

/**
 * Servlet implementation class ServletInserisciEdizione
 */
public class ServletInserisciEdizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceEdizione se;
	private ServiceCorso sc;
	
	public ServletInserisciEdizione() {
		
		this.se = ServiceEdizione.getInstance();
		this.sc = ServiceCorso.getInstance();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String convIdCorso = request.getParameter("idCorso");
		long idCorso = Long.parseLong(convIdCorso);
		String giorno = request.getParameter("giorno");
		String mese = request.getParameter("mese");
		String anno = request.getParameter("anno");
		LocalDate l = LocalDate.of(Integer.parseInt(anno), Integer.parseInt(mese), Integer.parseInt(giorno)+1);
		Date dataInizio = java.util.Date.from(l.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		String convDurata = request.getParameter("durata");
		int durata = Integer.parseInt(convDurata);
		String aula = request.getParameter("aula");
		String docente = request.getParameter("docente");
		
				
		Edizione ed = null;
		
		try {
			
			Corso corso = sc.visualizzaCorso(idCorso);
			
			ed = new Edizione(corso, dataInizio, durata, aula, docente, false);

			se.inserisciEdizione(ed);
			List<EdizioneDTO> listEdizioni = se.visualizzaEdizioniPerCorso(idCorso);
			request.setAttribute("edizioni", listEdizioni);
			request.setAttribute("corso", corso);
			
			String m = "L'edizione del " + ed.getDataInizio() + " è stata correttamente inserita";
		    request.setAttribute("messaggio", m);
					
			getServletContext().getRequestDispatcher("/WEB-INF/listaEdizioniAMessage.jsp").
			forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}

	}

}