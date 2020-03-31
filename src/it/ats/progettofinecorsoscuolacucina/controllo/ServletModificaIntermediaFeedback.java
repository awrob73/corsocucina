package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceFeedback;




public class ServletModificaIntermediaFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceFeedback sf;
	
	public ServletModificaIntermediaFeedback() {
		super();
		this.sf = ServiceFeedback.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			String convId = request.getParameter("id");
//			Long idFeedback = Long.parseLong(convId);
			
			String convIdEdizione = request.getParameter("idEdizione");
			Long idEdizione = Long.parseLong(convIdEdizione);
			String convIdUtente = request.getParameter("idUtente");
			Long idUtente = Long.parseLong(convIdUtente);
			
			
			Feedback f = sf.cercaFeedback(idUtente, idEdizione);
			request.setAttribute("feedback", f);
			
			
			
			getServletContext().
			getRequestDispatcher("/WEB-INF/modificaFeedback.jsp").
			forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().
			getRequestDispatcher("/WEB-INF/error.jsp").
			forward(request, response);
		}
		
		
	}
}