package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;

@WebServlet("/modificaFinale")
public class ServletModificaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceUtente su;

	public ServletModificaUtente() {
		super();
		this.su = ServiceUtente.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String convId = request.getParameter("id");
			Long idUtente = Long.parseLong(convId);
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

			Utente u = su.leggiUtente(idUtente);

			if (newUsername != null && newUsername != u.getUsername()) {
				su.modificaUsername(u, newUsername);
			}

			if (newPass != null && newPass != u.getPassword()) {
				su.modificaPassword(u, newPass);
			}

			if (newNome != null && newNome != u.getNome()) {
				su.modificaNome(u, newNome);
			}

			if (newCognome != null && newCognome != u.getCognome()) {
				su.modificaCognome(u, newCognome);
			}

			if (newData != null && newData != u.getDataNascita()) {
				su.modificaData(u, newData);
			}

			if (newEmail != null && newEmail != u.getEmail()) {
				su.modificaEmail(u, newEmail);
			}

			if (telefono != null && telefono != u.getTelefono()) {
				su.modificaTelefono(u, telefono);
			}

			u = su.leggiUtente(idUtente);
			request.setAttribute("utente", u);

			getServletContext().
			getRequestDispatcher("/WEB-INF/datiUtente.jsp").
			forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}

	}

}
