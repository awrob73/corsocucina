package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;


public class ServletDettagliEdizione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceEdizione se;

	public ServletDettagliEdizione() throws Exception {
		super();
		this.se = ServiceEdizione.getInstance();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			String idEdizione = request.getParameter("id");
			long id = Long.parseLong(idEdizione);
			Edizione e = se.leggiEdizione(id);

			request.setAttribute("infoEdizione", e);
			getServletContext().getRequestDispatcher("/WEB-INF/dettagliEdizione.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
