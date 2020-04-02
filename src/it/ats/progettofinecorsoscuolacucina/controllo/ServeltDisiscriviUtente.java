package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

/**
 * Servlet implementation class ServeltDisiscriviUtente
 */
@WebServlet("/disiscriviUtente")
public class ServeltDisiscriviUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private ServiceEdizione se;
	private ServiceUtente su;

	public ServeltDisiscriviUtente() {
		super();
		this.se = ServiceEdizione.getInstance();
		this.su = ServiceUtente.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String conv = request.getParameter("idUtente");
		Long idUtente = Long.parseLong(conv);
		String convE = request.getParameter("idEdizione");
		Long idEdizione = Long.parseLong(convE);
		
		try {
			
			se.cancellaIscrizioneUtente(idEdizione, idUtente);
			Utente u = su.leggiUtente(idUtente);
			Edizione ed = se.leggiEdizione(idEdizione);
			
			request.setAttribute("edizione", ed);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/disiscrizione.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}


