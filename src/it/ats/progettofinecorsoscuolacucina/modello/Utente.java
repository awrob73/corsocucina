package it.ats.progettofinecorsoscuolacucina.modello;

import java.util.Date;

public class Utente {

	private long id;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String email;
	private long telefono;
	private boolean admin = false;
	
	public Utente() {
		super();
	}

	//

	public Utente(String username, String password, String nome, String cognome, Date dataNascita, String email,
			long telefono, boolean admin) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.telefono = telefono;
		this.admin = admin;
	}

	public Utente(long id, String username, String password, String nome, String cognome, Date dataNascita,
			String email, long telefono, boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.email = email;
		this.telefono = telefono;
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public String getEmail() {
		return email;
	}

	public long getTelefono() {
		return telefono;
	}

	public boolean isAdmin() {
		return admin;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Utente [username=" + username + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita="
				+ dataNascita + ", email=" + email + ", telefono=" + telefono + ", admin=" + admin + "]";
	}

}
