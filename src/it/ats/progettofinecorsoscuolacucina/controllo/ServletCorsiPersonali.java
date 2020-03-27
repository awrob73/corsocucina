package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

@WebServlet("/corsiPersonali")
public class ServletCorsiPersonali extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServiceUtente su ;
	private ServiceCorso sc;
	private ServiceEdizione se;
	

	public ServletCorsiPersonali() throws Exception {
		super();
		this.su = ServiceUtente.getInstance();
		this.sc = ServiceCorso.getInstance();
		this.se = ServiceEdizione.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		List<EdizioneDTO> listEdizione = new ArrayList<EdizioneDTO>();
		List<Corso> listCorso = new ArrayList<Corso>();
		try {
			Utente u = su.visualizzaDatiUtente(username);
			listCorso = sc.visualizzaCorsiUtente(u.getId());
			for(Corso c: listCorso) {
				for(int i=0; i<se.visualizzaEdizioniPerCorso(c.getId()).size();i++) {
					listEdizione.add(se.visualizzaEdizioniPerCorso(c.getId()).get(i));
//					System.out.println(se.visualizzaEdizioniPerCorso(c.getId()).get(i));
				}
				
			}
			request.setAttribute("listaCorsi", listCorso);
			request.setAttribute("listaEdizione", listEdizione);
			request.setAttribute("user", u);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/corsiPersonali.jsp");
			requestDispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
