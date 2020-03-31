package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;


public class ServletListaCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceAmministratore sa;
	private ServiceUtente su;
	private ServiceCorso sc;

	public ServletListaCorso() {
		super();
		this.sa = ServiceAmministratore.getInstance();
		this.su = ServiceUtente.getInstance();
		this.sc = ServiceCorso.getInstance();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		try {
			Utente a = sa.cercaAmministratorePerUsername(username);
			List<Corso> lista = new ArrayList<Corso>();
			lista = sc.visualizzaCatalogoCorsi();
			
			request.setAttribute("listaCorsi", lista);
			getServletContext().getRequestDispatcher("/WEB-INF/listaCorsiAmministratore.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}