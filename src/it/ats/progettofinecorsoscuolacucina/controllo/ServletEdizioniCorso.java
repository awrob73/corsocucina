package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;


public class ServletEdizioniCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceEdizione se;

	public ServletEdizioniCorso() throws Exception {
		super();
		this.se = ServiceEdizione.getInstance();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {

			String idCorso = request.getParameter("id");
			long id = Long.parseLong(idCorso);
			List<EdizioneDTO> listEdizioni = se.visualizzaEdizioniPerCorso(id);
			request.setAttribute("edizione", listEdizioni);
			getServletContext().getRequestDispatcher("/WEB-INF/listaEdizioni.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();

		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}