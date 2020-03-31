package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceAmministratore;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCategoria;

/**
 * Servlet implementation class ServletInserisciCategoria
 */
public class ServletInserisciCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceAmministratore sa;
	private ServiceCategoria sc;

	public ServletInserisciCategoria() {
		super();
		this.sa = ServiceAmministratore.getInstance();
		this.sc = ServiceCategoria.getInstance();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String descrizione = request.getParameter("descrizione");
		
		try {
			if(!descrizione.trim().isEmpty()) {
			sc.aggiungiCategoria(descrizione);}
			Utente a = sa.cercaAmministratorePerUsername(username);
			
			request.setAttribute("descrizione", descrizione);
			request.setAttribute("user", a);
			

			getServletContext().getRequestDispatcher("/WEB-INF/confermaNuovaCategoria.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}

	}

}