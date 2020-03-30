package it.ats.progettofinecorsoscuolacucina.controllo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.service.ServiceUtente;

/**
 * Servlet implementation class ServletListaFeedback
 */
public class ServletListaFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServiceUtente su;
	private ServiceEdizione se;

	public ServletListaFeedback() throws Exception {
		super();
		this.su = ServiceUtente.getInstance();
		this.se = ServiceEdizione.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String convC = request.getParameter("idCorso");
		Long idCorso = Long.parseLong(convC);

		List<EdizioneDTO> listaEdizioniDTO = null;
		List<Feedback> feedbacks = null;

		List<Feedback> listaFeedbacks = new ArrayList<>();

		try {

			listaEdizioniDTO = se.visualizzaEdizioniPerCorso(idCorso);

			for (EdizioneDTO eDTO : listaEdizioniDTO) {

				feedbacks = eDTO.getFeedbacks();
				for (Feedback f : feedbacks) {
					listaFeedbacks.add(f);
				}

			}

			PrintWriter pw = response.getWriter();
			for (Feedback f : listaFeedbacks) {
				pw.println("Voto: " + f.getVoto() + "\n");
				pw.println(f.getDescrizione());
				pw.println("----------");
			}

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
