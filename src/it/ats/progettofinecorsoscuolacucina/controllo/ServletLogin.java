package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;



@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceUtente su;

	public ServletLogin() throws Exception {
		super();
		this.su = ServiceUtente.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Utente u = su.checkCredenziali(username, password);
			
			if (u != null) {
				HttpSession oldSession = request.getSession(false);
				if (oldSession != null) {
					oldSession.invalidate();
				}
				HttpSession currentSession = request.getSession();
				currentSession.setAttribute("user", u);
				currentSession.setMaxInactiveInterval(10 * 60);
				
				request.setAttribute("user", u);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/paginaPrivataUtente.jsp");
				requestDispatcher.forward(request, response);

			} else {
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
