package it.ats.progettofinecorsoscuolacucina.controllo;

import java.awt.List;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Categoria;
import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCategoria;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;

public class ServletModificaCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceCategoria scat;
	private ServiceCorso sc;

	
	public ServletModificaCorso() {
		super();
		this.scat = ServiceCategoria.getInstance();
		this.sc = ServiceCorso.getInstance();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String convId = request.getParameter("id");
			long idCorso = Long.parseLong(convId);
			String convCodice = request.getParameter("codice");
			int codiceCorso = Integer.parseInt(convCodice);
			String titolo = request.getParameter("titolo");
			String convIdCategoria = request.getParameter("id_categoria");
			long idCategoria = Long.parseLong(convId);
			String convMaxPartecipanti = request.getParameter("maxPartecipanti");
			int MaxPartecipanti = Integer.parseInt(convMaxPartecipanti);
			String convCosto = request.getParameter("costo");
			Double costo = Double.parseDouble(convCosto);
			String descrizione = request.getParameter("descrizione");
			
			Corso c = sc.visualizzaCorso(idCorso);
			Categoria cat = new Categoria();
			java.util.List<Categoria> listaCat = scat.cercaTutteCategorie();
			for (Categoria ca : listaCat) {
				if(ca.getDescrizione().trim().toLowerCase().equals(request.getParameter("categoria").trim().toLowerCase())) {
					cat.setId(ca.getId());
					cat.setDescrizione(ca.getDescrizione());
					break;
				}
			}
			

			if (codiceCorso > -1 && codiceCorso != c.getCodice()) {
				sc.modificaCodice(c, codiceCorso);
			}

			if (titolo != null && titolo != c.getTitolo()) {
				sc.modificaTitolo(c, titolo);
			}

			if (cat.getId() >= 0 && cat.getId() != c.getCategoria().getId()) {
				sc.modificaCategoria(c, cat);
				c.setCategoria(cat);
			}

			if (MaxPartecipanti > 0 && MaxPartecipanti != c.getMaxPartecipanti()) {
				sc.modificaMaxPartecipanti(c, MaxPartecipanti);
			}

			if (costo > 0 && costo != c.getCosto()) {
				sc.modificaCosto(c, costo);
			}
			
			if(descrizione != null && descrizione != c.getDescrizione()) {
				sc.modificaDescrizione(c, descrizione);
			}

			 
			
			request.setAttribute("corso", c);

			getServletContext().
			getRequestDispatcher("/WEB-INF/confermaModificaCorso.jsp").
			forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
		
	}

}
