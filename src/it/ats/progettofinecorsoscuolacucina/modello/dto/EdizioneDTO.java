package it.ats.progettofinecorsoscuolacucina.modello.dto;

import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;

public class EdizioneDTO {

	private Edizione edizione;
	private List<Feedback> feedbacks;
	private List<Utente> utentiIscritti;

	public EdizioneDTO(Edizione edizione, List<Feedback> feedbacks, List<Utente> utenti) {
		this.edizione = edizione;
		this.feedbacks = feedbacks;
		this.utentiIscritti = utenti;
	}

	public EdizioneDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<Utente> getUtentiIscritti() {
		return utentiIscritti;
	}

	public void setUtentiIscritti(List<Utente> utentiIscritti) {
		this.utentiIscritti = utentiIscritti;
	}

	public Edizione getEdizione() {
		return edizione;
	}

	public void setEdizione(Edizione edizione) {
		this.edizione = edizione;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		return "EdizioneDTO [edizione=" + edizione + ", feedbacks=" + feedbacks + ", utentiIscritti=" + utentiIscritti
				+ "]";
	}
}
