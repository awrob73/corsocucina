package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceFeedback;


/**
 * Servlet implementation class ServletCancellaFeedback
 */
@WebServlet("/cancellaFeedback")
public class ServletCancellaFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceFeedback feedbackServiceImpl;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			String convIdUtente = request.getParameter("id_utente");
			Long idUtente = Long.parseLong(convIdUtente);
	
			String convIdEdizione = request.getParameter("id_edizione");
			Long idEdizione = Long.parseLong(convIdEdizione);
			
			Feedback f = feedbackServiceImpl.cercaFeedback(idUtente, idEdizione);
			
			long idFeedback = f.getId();
		     feedbackServiceImpl.cancellaFeedback(idFeedback);
		     String m = "il feedback è stato cancellato";
		     request.setAttribute("messaggio", m);
		
		     getServletContext().
				getRequestDispatcher("/WEB-INF/****.jsp").
				forward(request, response);
		     
		  } catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}

	}
	
	public ServletCancellaFeedback() {
		super();
		this.feedbackServiceImpl = ServiceFeedback.getInstance();
	}
	
}
