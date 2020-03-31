package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

/**
 * Servlet implementation class ServletCancellaEdizione
 */
public class ServletCancellaEdizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceEdizione se;
	
	public ServletCancellaEdizione() {
		
		this.se = ServiceEdizione.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String convIdE = request.getParameter("idEdizione");
			Long idEdizione = Long.parseLong(convIdE);
			
			Edizione ed = se.leggiEdizione(idEdizione);
			se.cancellaEdizione(idEdizione);
		    
			String m = "L'edizione " + ed.getDataInizio() + " è stata correttamente cancellata";
		    request.setAttribute("messaggio", m);
		
		    getServletContext().
			getRequestDispatcher("/WEB-INF/listaEdizione.jsp").
			forward(request, response);
		     
//		    <%String m =(String) request.getAttribute("messaggio") %>
//		    <%=m %>
		     
		  } catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
	}

}