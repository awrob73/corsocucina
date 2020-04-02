package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

public class ServletIscriviUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceEdizione se;
	private ServiceUtente su;

	public ServletIscriviUtente() {
		super();
		this.se = ServiceEdizione.getInstance();
		this.su = ServiceUtente.getInstance();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String utid = request.getParameter("idUtente");
		long idUtente = Long.parseLong(utid);
		String edid = request.getParameter("idEdizione");
		long idEdizione = Long.parseLong(edid);
		
		try {
			
			Edizione ed = se.leggiEdizione(idEdizione);
			Utente u = su.leggiUtente(idUtente);
			se.iscriviUtente(ed.getId(), u.getId());

			
			request.setAttribute("user", u);
			request.setAttribute("edizione", ed);
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/iscrizione.jsp");
			requestDispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}