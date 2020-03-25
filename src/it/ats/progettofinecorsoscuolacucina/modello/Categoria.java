package it.ats.progettofinecorsoscuolacucina.modello;

public class Categoria {

	private long id;
	private String descrizione;

	public Categoria() {
	}

	public Categoria(String descrizione) {
		this.descrizione = descrizione;
	}

	
	public Categoria(long id, String descrizione) {
		this.id = id;
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Categoria [descrizione=" + descrizione + "]";
	}

}
