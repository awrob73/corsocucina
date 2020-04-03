package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCategoria;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceCorso;

/**
 * Servlet implementation class ServletModificaIntermediaCorso
 */
public class ServletModificaIntermediaCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServiceCorso sc;
	private ServiceCategoria scat;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificaIntermediaCorso() {
        super();
        this.sc = ServiceCorso.getInstance();
        this.scat= ServiceCategoria.getInstance();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String conv = request.getParameter("id");
			Long idCorso = Long.parseLong(conv);
			
			Corso c = sc.visualizzaCorso(idCorso);
			c.setCategoria(scat.cercaCategoriaId(c.getCategoria().getId()));
			request.setAttribute("corso", c);

			getServletContext().getRequestDispatcher("/WEB-INF/modificaCorso.jsp").forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}
	}

}
