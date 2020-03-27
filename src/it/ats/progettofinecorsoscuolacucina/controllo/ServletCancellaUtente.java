package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;


@WebServlet("/cancella")
public class ServletCancellaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private ServiceUtente utenteServiceImpl;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String username = request.getParameter("username");
			Utente u = utenteServiceImpl.visualizzaDatiUtente(username);
			long idUtente = u.getId();
		     utenteServiceImpl.cancellaRegistrazioneUtente(idUtente);
		     request.setAttribute("idUtente", idUtente);
		
		  } catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
		getServletContext().
		getRequestDispatcher("/WEB-INF/cancellaDatiUtente.jsp").
		forward(request, response);

	}
	
	public ServletCancellaUtente() {
		super();
		this.utenteServiceImpl = ServiceUtente.getInstance();
	}
	
  }	
