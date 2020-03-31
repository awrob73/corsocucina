package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceAmministratore;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

/**
 * Servlet implementation class ServletModificaIntermediaA
 */
public class ServletModificaIntermediaA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceAmministratore sa;

	public ServletModificaIntermediaA() throws Exception {
		super();
		this.sa = ServiceAmministratore.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String conv = request.getParameter("id");
			Long idAmministratore = Long.parseLong(conv);

			Utente a = sa.cercaAmministratorePerId(idAmministratore);
			System.out.println(a);

			request.setAttribute("amministratore", a);

			getServletContext().getRequestDispatcher("/WEB-INF/modificaDatiAmministratore.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}

	}
}
