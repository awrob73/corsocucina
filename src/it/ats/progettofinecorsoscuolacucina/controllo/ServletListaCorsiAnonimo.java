package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;

/**
 * Servlet implementation class ServletListaCorsiAnonimo
 */
public class ServletListaCorsiAnonimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ServiceCorso sc;
	
    public ServletListaCorsiAnonimo() {
        super();
        this.sc = ServiceCorso.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Corso> listCorsi = sc.visualizzaCatalogoCorsi();
			request.setAttribute("corso", listCorsi);
			getServletContext().getRequestDispatcher("/WEB-INF/listaCorsiAnonimo.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
