package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;
@WebServlet("/infoCorso")
public class ServletInfoCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceCorso sc;

	public ServletInfoCorso() throws Exception {
		super();
		this.sc = ServiceCorso.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String idCorso = request.getParameter("id");
			long id = Long.parseLong(idCorso);
			Corso c = sc.visualizzaCorso(id);

			request.setAttribute("corso", c);
			getServletContext().getRequestDispatcher("/WEB-INF/dettagliCorso.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}