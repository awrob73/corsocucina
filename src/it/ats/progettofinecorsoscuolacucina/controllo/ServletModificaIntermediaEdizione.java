package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;

/**
 * Servlet implementation class ServletModificaIntermediaEdizione
 */

public class ServletModificaIntermediaEdizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceEdizione sed;
	private ServiceCorso sc;
	
	public ServletModificaIntermediaEdizione() {
        super();
        this.sed = ServiceEdizione.getInstance();
        this.sc= ServiceCorso.getInstance();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String conv = request.getParameter("idEdizione");
			long idEdizione = Long.parseLong(conv);
			
			String convIdCorso = request.getParameter("idCorso");
			long idCorso = Long.parseLong(convIdCorso);
			Corso corso = sc.visualizzaCorso(idCorso);
			Edizione ed = sed.leggiEdizione(idEdizione);
			ed.setCorso(corso);
			request.setAttribute("edizione", ed);

			getServletContext().getRequestDispatcher("/WEB-INF/modificaEdizione.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}
	}

}