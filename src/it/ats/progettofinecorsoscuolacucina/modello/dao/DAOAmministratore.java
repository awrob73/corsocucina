package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;

public class DAOAmministratore {

	private static DAOAmministratore instance;

	/*
	 * Registrazione di un nuovo amministratore. Se già presente si solleva una
	 * eccezione
	 */
	public void inserisci(Connection connection, Utente amministratore) throws DAOException {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(
					"INSERT INTO amministratore(username, password, nome, cognome, data_nascita, email, telefono) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, amministratore.getUsername());
			ps.setString(2, amministratore.getPassword());
			ps.setString(3, amministratore.getNome());
			ps.setString(4, amministratore.getCognome());
			ps.setDate(5, new java.sql.Date(amministratore.getDataNascita().getTime()));
			ps.setString(6, amministratore.getEmail());
			ps.setLong(7, amministratore.getTelefono());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
	}

	/*
	 * Modifica di tutti i dati di un amministratore. L'amministratore viene
	 * individuato in base all'id. Se non esiste viene sollevata una eccezione
	 */
	public void modifica(Connection connection, Utente amministratore) throws DAOException {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(
					"UPDATE amministratore SET username=?, password=?, nome=?, cognome=?, data_nascita=?, email=?, telefono=? WHERE id=?");
			ps.setString(1, amministratore.getUsername());
			ps.setString(2, amministratore.getPassword());
			ps.setString(3, amministratore.getNome());
			ps.setString(4, amministratore.getCognome());
			ps.setDate(5, new java.sql.Date(amministratore.getDataNascita().getTime()));
			ps.setString(6, amministratore.getEmail());
			ps.setLong(7, amministratore.getTelefono());
			ps.setLong(8, amministratore.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore modifica");
		}
	}

	/*
	 * Cancellazione di un amministratore individuato attraverso il suo id.
	 * L'amministratore potrà essere cancellato solo se non legato a nessun altro
	 * dato presente sul DB. Se non esiste viene sollevata una eccezione. Se non è
	 * cancellabile si solleva una eccezione
	 */
	public void cancella(Connection connection, long id) throws DAOException {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM amministratore WHERE id=?");
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore cancellazione");
		}
	}

	/*
	 * Lettura di tutti gli amministratori registrati
	 */
	public List<Utente> cercaTutti(Connection connection) throws DAOException {
		List<Utente> amministratori = new ArrayList<Utente>();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM amministratore");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				Date dataNascita = rs.getDate("data_nascita");
				String email = rs.getString("email");
				long telefono = rs.getLong("telefono");
				Utente amministratore = new Utente(id, username, password, nome, cognome, dataNascita, email, telefono,
						true);
				amministratori.add(amministratore);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}

		return amministratori;
	}

	/*
	 * Lettura dei dati di un singolo amministratore in base al suo id. Se non
	 * presente si solleva una eccezione
	 */
	public Utente cercaPerId(Connection connection, long id) throws DAOException {
		Utente amministratore = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM amministratore WHERE id =?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				Date dataNascita = rs.getDate("data_nascita");
				String email = rs.getString("email");
				long telefono = rs.getLong("telefono");
				amministratore = new Utente(id, username, password, nome, cognome, dataNascita, email, telefono, true);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return amministratore;
	}
	
	public Utente cercaPerUsername(Connection connection, String username) throws DAOException {
		PreparedStatement preparedStatement = null;
		Utente u = new Utente();
		try {
			preparedStatement = connection.prepareStatement("select * from amministratore where username=?");
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				u.setId(rs.getLong("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setDataNascita(rs.getDate("data_nascita"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getLong("telefono"));
				u.setAdmin(true);

			}
			
			return u;

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Utente non trovato");
		}
	}
	
	public int cercaPerCredenziali(Connection connection, String username, String password) throws DAOException {
		PreparedStatement preparedStatement = null;
		int verifica = 0;
		String verificaPassword = null;
		try {
			preparedStatement = connection.prepareStatement("select * from amministratore where username=?");
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				verificaPassword = rs.getString("password");
				if (verificaPassword.equals(password)) {
					verifica = 1;
				}

			}
			return verifica;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("password non corretta");
		}

	}

	private DAOAmministratore() {
		super();
	}

	public static DAOAmministratore getInstance() {
		if (instance == null) {
			instance = new DAOAmministratore();
		}
		return instance;
	}

}