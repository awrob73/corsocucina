package it.ats.progettofinecorsoscuolacucina.modello;

public class Feedback {

	private int id;
	private String descrizione;
	private int voto;
	private Edizione edizione;
	private Utente utente;

	public Feedback(String descrizione, int voto, Edizione edizione, Utente utente) {
		super();
		this.descrizione = descrizione;
		this.voto = voto;
		this.edizione = edizione;
		this.utente = utente;
	}

	public Feedback(int id, String descrizione, int voto, Edizione edizione, Utente utente) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.voto = voto;
		this.edizione = edizione;
		this.utente = utente;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public int getId() {
		return id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public Edizione getEdizione() {
		return edizione;
	}

	public Utente getUtente() {
		return utente;
	}

	@Override
	public String toString() {
		return "Feedback [descrizione=" + descrizione + ", voto=" + voto + ", edizione=" + edizione + ", utente="
				+ utente + "]";
	}

}
