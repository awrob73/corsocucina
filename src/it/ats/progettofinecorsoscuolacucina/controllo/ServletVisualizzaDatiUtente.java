package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

@WebServlet("/visualizzaDati")
	public class ServletVisualizzaDatiUtente extends HttpServlet {
		private static final long serialVersionUID = 1L;
	
	private ServiceUtente su ;
	

	public ServletVisualizzaDatiUtente() throws Exception {
		super();
		this.su = ServiceUtente.getInstance();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String username = request.getParameter("username");
			
			Utente u = su.visualizzaDatiUtente(username);
			
			request.setAttribute("user", u);
			getServletContext().
			getRequestDispatcher("/WEB-INF/datiUtente.jsp").
			forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
			
			getServletContext().
			getRequestDispatcher("/WebContent/error.jsp").
			forward(request, response);
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
