package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceAmministratore;

/**
 * Servlet implementation class ServletVisualizzaDatiAmministratore
 */
public class ServletVisualizzaDatiAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceAmministratore sa;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVisualizzaDatiAmministratore() {
		super();
		this.sa = ServiceAmministratore.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String username = request.getParameter("username");

			Utente a = sa.cercaAmministratorePerUsername(username);

			request.setAttribute("utente", a);
			getServletContext().getRequestDispatcher("/WEB-INF/datiAmministratore.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();

			getServletContext().getRequestDispatcher("/WebContent/error.jsp").forward(request, response);
		}
	}

}
