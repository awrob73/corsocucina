package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

@WebServlet("/corsiPersonali")
public class ServletCorsiPersonali extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceUtente su ;
	private ServiceCorso sc;
	

	public ServletCorsiPersonali() throws Exception {
		super();
		this.su = ServiceUtente.getInstance();
		this.sc = ServiceCorso.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		List<Corso> list = new ArrayList<Corso>();
		try {
			Utente u = su.visualizzaDatiUtente(username);
			list = sc.visualizzaCorsiUtente(u.getId());
			request.setAttribute("lista", list);
			request.setAttribute("user", u);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/corsiPersonali.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
