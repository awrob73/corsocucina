package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

public class ServletDettagliEdizione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceEdizione se;
	private ServiceUtente su;

	public ServletDettagliEdizione() throws Exception {
		super();
		this.se = ServiceEdizione.getInstance();
		this.su = ServiceUtente.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");

		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		List<Edizione> listaEdizioniAttive = new ArrayList<Edizione>();
		try {
			Utente u = su.visualizzaDatiUtente(username);
			String idEdizione = request.getParameter("id");
			long id = Long.parseLong(idEdizione);
			Edizione ed = se.leggiEdizione(id);
			listaEdizioni = se.visualizzaEdizioniPerUtente(u.getId());

			for (Edizione edi : listaEdizioni) {
				if (edi.isTerminata() == false) {
					listaEdizioniAttive.add(edi);

				}
			}
			request.setAttribute("listaEdizioni", listaEdizioni);
			request.setAttribute("listaEdizioniAttive", listaEdizioniAttive);
			request.setAttribute("infoEdizione", ed);
			request.setAttribute("user", u);

			request.setAttribute("infoEdizione", ed);
			getServletContext().getRequestDispatcher("/WEB-INF/dettagliEdizione.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
