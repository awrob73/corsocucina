package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceAmministratore;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

/**
 * Servlet implementation class ServletModificaAmministratore
 */
public class ServletModificaAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceAmministratore sa;

	public ServletModificaAmministratore() {
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
			String convId = request.getParameter("id");
			Long idAmministratore = Long.parseLong(convId);
			String newUsername = request.getParameter("username");
			String newPass = request.getParameter("password");
			String newNome = request.getParameter("nome");
			String newCognome = request.getParameter("cognome");
			String giorno = request.getParameter("giorno");
			String mese = request.getParameter("mese");
			String anno = request.getParameter("anno");
			LocalDate l = LocalDate.of(Integer.parseInt(anno), Integer.parseInt(mese), Integer.parseInt(giorno));
			Date newData = java.util.Date.from(l.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			String convTel = request.getParameter("telefono");
			Long telefono = Long.parseLong(convTel);
			String newEmail = request.getParameter("email");

			Utente a = sa.cercaAmministratorePerId(idAmministratore);

			if (newUsername != null && newUsername != a.getUsername()) {
				sa.modificaUsername(a, newUsername);
			}

			if (newPass != null && newPass != a.getPassword()) {
				sa.modificaPassword(a, newPass);
			}

			if (newNome != null && newNome != a.getNome()) {
				sa.modificaNome(a, newNome);
			}

			if (newCognome != null && newCognome != a.getCognome()) {
				sa.modificaCognome(a, newCognome);
			}

			if (newData != null && newData != a.getDataNascita()) {
				sa.modificaData(a, newData);
			}

			if (newEmail != null && newEmail != a.getEmail()) {
				sa.modificaEmail(a, newEmail);
			}

			if (telefono != null && telefono != a.getTelefono()) {
				sa.modificaTelefono(a, telefono);
			}

			a = sa.cercaAmministratorePerId(idAmministratore);
			request.setAttribute("utente", a);

			getServletContext().getRequestDispatcher("/WEB-INF/datiAmministratore.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}

	}
}
