package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Categoria;
import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceAmministratore;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCategoria;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;

public class ServletInserisciCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceCorso sc;
	private ServiceAmministratore sa;
	private ServiceCategoria scat;

	public ServletInserisciCorso() {
		super();
		this.sc = ServiceCorso.getInstance();
		this.sa = ServiceAmministratore.getInstance();
		this.scat = ServiceCategoria.getInstance();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String convC = request.getParameter("codice");
		int codice = Integer.parseInt(convC);
		String titolo = request.getParameter("titolo");
		String convCa = request.getParameter("idCategoria");
		long idCategoria = Long.parseLong(convCa);
		String convM = request.getParameter("maxPartecipanti");
		int maxPartecipanti = Integer.parseInt(convM);
		String convCo = request.getParameter("costo");
		double costo = Double.parseDouble(convCo);
		String descrizione = request.getParameter("descrizione");
		
		String username = request.getParameter("username");
		
		try {

			Utente a = sa.cercaAmministratorePerUsername(username);
			Categoria cat = scat.cercaCategoriaId(idCategoria);
			
			Corso c = new Corso(codice, titolo, cat, maxPartecipanti, costo, descrizione);
	
			sc.inserisciCorso(c);
			
			request.setAttribute("corso", c);

			getServletContext().getRequestDispatcher("/WEB-INF/confermaNuovoCorso.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}

	}

}