package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;

import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;

@WebServlet("/cercaNuoviCorsi")
public class ServletCercaNuoviCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceCorso co;

	public ServletCercaNuoviCorsi() throws Exception {
		super();
		this.co = ServiceCorso.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			List<Corso> listCorsi = co.visualizzaCatalogoCorsi();
			request.setAttribute("corso", listCorsi);
			getServletContext().getRequestDispatcher("/WEB-INF/listaCorsi.jsp").forward(request, response);

		} catch (Exception e) {

			e.printStackTrace();

		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
