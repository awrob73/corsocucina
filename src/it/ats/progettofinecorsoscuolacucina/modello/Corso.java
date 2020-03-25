package it.ats.progettofinecorsoscuolacucina.modello;

public class Corso {

	private long id;
	private int codice;
	private String titolo;
	private Categoria categoria;
	private int maxPartecipanti;
	private double costo;
	private String descrizione;

	public Corso(int codice, String titolo, Categoria categoria, int maxPartecipanti, double costo,
			String descrizione) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.categoria = categoria;
		this.maxPartecipanti = maxPartecipanti;
		this.costo = costo;
		this.descrizione = descrizione;
	}

	public Corso(long id, int codice, String titolo, Categoria categoria, int maxPartecipanti, double costo,
			String descrizione) {
		super();
		this.id = id;
		this.codice = codice;
		this.titolo = titolo;
		this.categoria = categoria;
		this.maxPartecipanti = maxPartecipanti;
		this.costo = costo;
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

	public int getCodice() {
		return codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}

	public double getCosto() {
		return costo;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setMaxPartecipanti(int maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Corso [codice=" + codice + ", titolo=" + titolo + ", categoria=" + categoria + ", maxPartecipanti="
				+ maxPartecipanti + ", costo=" + costo + ", descrizione=" + descrizione + "]";
	}

}
