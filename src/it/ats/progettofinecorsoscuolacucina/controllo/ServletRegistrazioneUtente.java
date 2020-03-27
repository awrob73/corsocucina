package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;

public class ServletRegistrazioneUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceUtente utenteServiceImpl;
	
	public ServletRegistrazioneUtente() {
		super();
		this.utenteServiceImpl = ServiceUtente.getInstance();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String giorno = request.getParameter("giorno");
		String mese = request.getParameter("mese");
		String anno = request.getParameter("anno");
		LocalDate l = LocalDate.of(Integer.parseInt(anno), Integer.parseInt(mese), Integer.parseInt(giorno));
		Date d = java.util.Date.from(l.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		String email = request.getParameter("email");
		long telefono = Long.parseLong(request.getParameter("telefono"));
		boolean adm = false;
		Utente u = new Utente(username, password, nome, cognome, d, email, telefono, adm);
		try {
			utenteServiceImpl.registrazioneUtente(u);
			//apertura sessione
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			HttpSession currentSession = request.getSession(true);
			currentSession.setAttribute("user", u);
			currentSession.setMaxInactiveInterval(10 * 60);
			
			request.setAttribute("user", u);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/paginaPrivataUtente.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}



}
