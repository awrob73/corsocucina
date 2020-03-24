package it.ats.progettofinecorsoscuolacucina.modello;

import java.util.Date;

public class Edizione {

	private long id;
	private Corso corso;
	private Date dataInizio;
	private int durata;
	private String aula;
	private String docente;
	private boolean terminata;

	public Edizione(Corso corso, Date dataInizio, int durata, String aula, String docente, boolean terminata) {
		super();
		this.corso = corso;
		this.dataInizio = dataInizio;
		this.durata = durata;
		this.aula = aula;
		this.docente = docente;
		this.terminata = terminata;
	}

	public Edizione(long id, Corso corso, Date dataInizio, int durata, String aula, String docente, boolean terminata) {
		super();
		this.id = id;
		this.corso = corso;
		this.dataInizio = dataInizio;
		this.durata = durata;
		this.aula = aula;
		this.docente = docente;
		this.terminata = terminata;
	}

	public boolean isTerminata() {
		return terminata;
	}

	public void setTerminata(boolean terminata) {
		this.terminata = terminata;
	}

	public long getId() {
		return id;
	}

	public Corso getCorso() {
		return corso;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public int getDurata() {
		return durata;
	}

	public String getAula() {
		return aula;
	}

	public String getDocente() {
		return docente;
	}

	@Override
	public String toString() {
		return "Edizione [corso=" + corso + ", dataInizio=" + dataInizio + ", durata=" + durata + ", aula=" + aula
				+ ", docente=" + docente + ", terminata=" + terminata + "]";
	}

}
