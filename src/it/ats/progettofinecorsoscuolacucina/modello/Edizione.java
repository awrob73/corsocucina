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

	public Edizione() {
		// TODO Auto-generated constructor stub
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

	public void setId(long id) {
		this.id = id;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Edizione [corso=" + corso + ", dataInizio=" + dataInizio + ", durata=" + durata + ", aula=" + aula
				+ ", docente=" + docente + ", terminata=" + terminata + "]";
	}

}
