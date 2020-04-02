
package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;


public class ServletModificaIntermedia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceUtente su;

	public ServletModificaIntermedia() throws Exception {
		super();
		this.su = ServiceUtente.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String conv = request.getParameter("id");
			Long idUtente = Long.parseLong(conv);
			
			Utente u = su.leggiUtente(idUtente);
			
			request.setAttribute("user", u);
			
			getServletContext().
			getRequestDispatcher("/WEB-INF/modificaDatiUtente.jsp").
			forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().
			getRequestDispatcher("/WEB-INF/error.jsp").
			forward(request, response);
		}
		
		
	}
}