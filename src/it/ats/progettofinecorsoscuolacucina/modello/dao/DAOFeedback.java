package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;

public class DAOFeedback {

	private static DAOFeedback instance;

	/*
	 * Inserimento di un singolo feedbak relativo ad una edizione di un corso da
	 * parte di un utente. Se un utente ha già inserito un feedback per una certa
	 * edizione si solleva una eccezione
	 */
	public void inserisci(Connection connection, Feedback feedback) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO feedback (id, descrizione, voto, id_edizione, id_utente) VALUES(?,?,?,?,?)");
			preparedStatement.setLong(1, feedback.getId());
			preparedStatement.setString(2, feedback.getDescrizione());
			preparedStatement.setInt(3, feedback.getVoto());
			preparedStatement.setLong(4, feedback.getEdizione().getId());
			preparedStatement.setLong(5, feedback.getUtente().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
	}

	/*
	 * Modifica di tutti i dati di un singolo feedback. Un feedback viene
	 * individuato attraverso il suo id. Se il feedback non esiste si solleva una
	 * eccezione
	 */
	public void modifica(Connection connection, Feedback feedback) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"update feedback set  descrizione = ?, voto = ?, id_edizione = ?, id_utente = ?  where id = ?");
			preparedStatement.setString(1, feedback.getDescrizione());
			preparedStatement.setInt(2, feedback.getVoto());
			preparedStatement.setLong(3, feedback.getEdizione().getId());
			preparedStatement.setLong(4, feedback.getUtente().getId());
			preparedStatement.setLong(5, feedback.getId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Impossibile modificare");
		}
	}

	/*
	 * Cancellazione di un feedback. Se il feedback non esiste si solleva una
	 * eccezione
	 */
	public void cancella(Connection connection, long idFeedback) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from feedback where id = ?");
			preparedStatement.setLong(1, idFeedback);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Impossibile cancellare");
		}
	}
	
	public Feedback cercaFeedback(Connection connection, long id) throws DAOException {
		PreparedStatement preparedStatement = null;
		Feedback feedback = new Feedback();
		try {
			preparedStatement = connection.prepareStatement("select * from feedback where id?;");
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Utente u = new Utente();
				Edizione ed = new Edizione();
				feedback.setId(rs.getInt("id"));
				feedback.setDescrizione(rs.getString("descrizione"));
				feedback.setVoto(rs.getInt("voto"));
				u.setId(rs.getLong("id_utente"));
				feedback.setUtente(u);
				ed.setId(rs.getLong("id_edizione"));
				feedback.setEdizione(ed);;
			}
			return feedback;
		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Feedback non trovato");
		}
	}
	
	/*
	 * Lettura di un singolo feedback scritto da un utente per una certa edizione.
	 * Se il feedback non esiste si solleva una eccezione
	 */
	public Feedback cercaSingoloFeedback(Connection connection, long idUtente, long idEdizione) throws DAOException {
		PreparedStatement preparedStatement = null;
		Feedback feedback = new Feedback();
		try {
			preparedStatement = connection.prepareStatement("select * from feedback where (id_utente=? AND id_edizione=?);");
			preparedStatement.setLong(1, idUtente);
			preparedStatement.setLong(2, idEdizione);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Utente u = new Utente();
				Edizione ed = new Edizione();
				feedback.setId(rs.getInt("id"));
				feedback.setDescrizione(rs.getString("descrizione"));
				feedback.setVoto(rs.getInt("voto"));
				u.setId(rs.getLong("id_utente"));
				feedback.setUtente(u);
				ed.setId(rs.getLong("id_edizione"));
				feedback.setEdizione(ed);
			}
			return feedback;
		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Feedback non trovato");
		}
	}
	
	/*
	 * Lettura di tutti i feedback di una certa edizione. Se non ci sono feedback o
	 * l'edizione non esiste si torna una lista vuota
	 */
	public List<Feedback> cercaPerEdizione(Connection connection, long idEdizione) throws DAOException {
		PreparedStatement preparedStatement = null;
		List<Feedback> list = new ArrayList<Feedback>();
		try {
			preparedStatement = connection.prepareStatement("select * from feedback where id_edizione=?;");
			preparedStatement.setLong(1, idEdizione);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Feedback feedback = new Feedback();
				Utente u = new Utente();
				Edizione ed = new Edizione();
				feedback.setId(rs.getInt("id"));
				feedback.setDescrizione(rs.getString("descrizione"));
				feedback.setVoto(rs.getInt("voto"));
				u.setId(rs.getLong("id_utente"));
				feedback.setUtente(u);
				ed.setId(rs.getLong("id_edizione"));
				feedback.setEdizione(ed);
				list.add(feedback);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Errore lettura feedback");
		}
	}
	
	/*
	 * Lettura di tutti i feedback scritti da un certo utente. Se non ci sono
	 * feedback o l'utente non esiste si torna una lista vuota
	 */
	public List<Feedback> cercaPerUtente(Connection connection, long idUtente) throws DAOException {
		PreparedStatement preparedStatement = null;
		List<Feedback> list = new ArrayList<Feedback>();
		try {
			preparedStatement = connection.prepareStatement("select * from feedback where id_utente=?;");
			preparedStatement.setLong(1, idUtente);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Feedback feedback = new Feedback();
				Utente u = new Utente();
				Edizione ed = new Edizione();
				feedback.setId(rs.getInt("id"));
				feedback.setDescrizione(rs.getString("descrizione"));
				feedback.setVoto(rs.getInt("voto"));
				u.setId(rs.getLong("id_utente"));
				feedback.setUtente(u);
				ed.setId(rs.getLong("id_edizione"));
				feedback.setEdizione(ed);
				list.add(feedback);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Errore lettura feedback");
		}
	}

	/*
	 * Lettura di tutti i feedback scritti per un certo corso (nota: non edizione ma
	 * corso). Se non ci sono feedback o il corso non esiste si torna una lista
	 * vuota
	 */
	public List<Feedback> cercaFeedbackPerCorso(Connection connection, long idCorso) throws DAOException {
		PreparedStatement preparedStatement = null;
		List<Feedback> list = new ArrayList<Feedback>();
		try {
			preparedStatement = connection.prepareStatement
					("SELECT f.id,f.descrizione AS f_descrizione,f.voto,"
							+ "e.data_inizio, e.durata, e.aula, e.docente, e.terminata,"
							+ "c.id AS id_corso, c.codice, c.titolo, c.max_partecipanti, c.costo, c.descrizione AS c_descrizione"
							+ "FROM feedback AS f "
							+ "JOIN edizione AS e ON f.id_edizione =e.id"
							+ "JOIN corso AS c ON e.id_corso = c.id "
							+ "WHERE e.id_corso = ?;");
			
			preparedStatement.setLong(1, idCorso);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Corso corso = new Corso(rs.getLong("id_corso"),rs.getInt("c.codice"),rs.getString("c.titolo"), 
				              rs.getInt("c.max_partecipanti"), rs.getDouble("c.costo"), rs.getString("c_descrizione"));
				
				Edizione edizione = new Edizione(corso,rs.getDate("data_inizio"), rs.getInt("durata"),
						rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));
				
				Feedback feedback = new Feedback(rs.getInt("id"),rs.getString("f_descrizione"), rs.getInt("voto"),edizione);
				
				list.add(feedback);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return list;
	}

	
	private DAOFeedback() {
		super();
	}

	public static DAOFeedback getInstance() {
		if (instance == null) {
			instance = new DAOFeedback();
		}
		return instance;
	}

}
