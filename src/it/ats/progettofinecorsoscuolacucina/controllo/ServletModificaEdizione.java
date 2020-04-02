package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;

/**
 * Servlet implementation class ServletModificaCorso
 */
public class ServletModificaEdizione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceEdizione sed;
	private ServiceCorso sc;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModificaEdizione() {
		super();
		this.sed = ServiceEdizione.getInstance();
		this.sc = ServiceCorso.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String convId = request.getParameter("idEdizione");
			long idEdizione = Long.parseLong(convId);
			String convIdCorso = request.getParameter("idCorso");
			long idCorso = Long.parseLong(convIdCorso);
			String newGiorno = request.getParameter("giorno");
			String newMese = request.getParameter("mese");
			String newAnno = request.getParameter("anno");
			LocalDate l = LocalDate.of(Integer.parseInt(newAnno), Integer.parseInt(newMese), Integer.parseInt(newGiorno));
			Date newData = java.util.Date.from(l.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			String convDurata = request.getParameter("durata");
			int newDurata = Integer.parseInt(convDurata);
			String newAula = request.getParameter("aula");
			String newDocente = request.getParameter("docente");
			String convTerminata = request.getParameter("terminata");
			
			
			
			Edizione ed = sed.leggiEdizione(idEdizione);
			Corso corso = sc.visualizzaCorso(idCorso);
			ed.setCorso(corso);	
			if(!convTerminata.isEmpty()) {
			if (convTerminata.equals("si")) {
				ed.setTerminata(true);
			}else {
				ed.setTerminata(false);
			}sed.modificaTerminata(ed);
			}
			
			if (newData != null && newData != ed.getDataInizio()) {
				sed.modificaData(ed, newData);
			}

			if (newDurata > -1 && newDurata != ed.getDurata()) {
				sed.modificaDurata(ed, newDurata);
			}

			if (newAula != null && newAula != ed.getAula()) {
				sed.modificaAula(ed, newAula);
			}

			if (newDocente != null && newDocente != ed.getDocente()) {
				sed.modificaDocente(ed, newDocente);
			}
			
			request.setAttribute("edizione", ed);
			getServletContext().
			getRequestDispatcher("/WEB-INF/confermaModificaEdizione.jsp").
			forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
	}

}