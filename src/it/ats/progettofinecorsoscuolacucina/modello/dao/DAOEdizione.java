package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;
import it.ats.progettofinecorsoscuolacucina.modello.Categoria;
import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;

public class DAOEdizione {

	private static DAOEdizione instance;

	/*
	 * Registrazione di una nuova edizione nel calendario dei corsi
	 */
	public void inserisci(Connection connection, Edizione ed) throws DAOException {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(
					"INSERT INTO edizione(id_corso,data_inizio,durata,aula,docente,terminata) VALUES (?,?,?,?,?,?)");
			ps.setLong(1, ed.getId());
			ps.setDate(2, new java.sql.Date(ed.getDataInizio().getTime()));
			ps.setInt(3, ed.getDurata());
			ps.setString(4, ed.getAula());
			ps.setString(5, ed.getDocente());
			ps.setBoolean(6, false);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Cancellazione di una edizione presente nel calendario dei corsi. Per
	 * cancellare una edizione è necessario prima cancellare le eventuali iscrizioni
	 * degli utenti e i feedbacks. L'edizione viene individuata in base al suo id.
	 * Se l'edizione non è presente si solleva una eccezione
	 */
	public void cancella(Connection connection, long idEdizione) throws DAOException {

		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = connection.prepareStatement("delete from edizione where id = ?");
			preparedStatement.setLong(1, idEdizione);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Impossibile cancellare");
		}

	}

	/*
	 * Modifica di tutti i dati di una edizione presente nel calendario dei corsi.
	 * L'edizione viene individuata in base al suo id. Se l'edizione non è presente
	 * si solleva una eccezione
	 */
	public void modifica(Connection connection, Edizione ed) throws DAOException {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("UPDATE edizione SET data_inizio=?, durata=?, aula=?, docente=? WHERE id= ?");
			ps.setDate(1, new java.sql.Date(ed.getDataInizio().getTime()));
			ps.setInt(2, ed.getDurata());
			ps.setString(3, ed.getAula());
			ps.setString(4, ed.getDocente());
			ps.setLong(5, ed.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore modifica");
		}
	}

	/*
	 * Lettura dei dati di una edizione presente nel calendario dei corsi.
	 * L'edizione viene individuata in base al suo id. Se l'edizione non è presente
	 * si solleva una eccezione
	 */
	public Edizione cercaPerId(Connection connection, long idEdizione) throws DAOException {
		Edizione ed = null;
		PreparedStatement ps;
		try {

			ps = connection.prepareStatement(
					"SELECT edizione.id as id_edizione, edizione.*, corso.codice, corso.titolo, corso.descrizione as descrizione_corso, corso.costo, corso.max_partecipanti, categoria.descrizione as descrizione_categoria FROM edizione JOIN corso ON edizione.id_corso = corso.id JOIN categoria ON corso.id_categoria = categoria.id where edizione.id=?");
			ps.setLong(1, idEdizione);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
				Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
						rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
				ed = new Edizione(idEdizione, corso, rs.getDate("data_inizio"), rs.getInt("durata"),
						rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return ed;
	}

	/*
	 * Lettura di tutte le edizioni presenti nel calendario dei corsi. Se non vi
	 * sono edizioni registrate viene ritornata una lista vuota
	 */
	public List<Edizione> cercaTutte(Connection connection) throws DAOException {
		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		Edizione ed = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(
					"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
				Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
						rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
				ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
						rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

				listaEdizioni.add(ed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return listaEdizioni;
	}

	/*
	 * Lettura di tutte le edizioni a cui un certo utente è iscritto o è stato
	 * iscritto in passato (vale a dire tutte), presenti nel calendario dei corsi.
	 * Le edizioni vengono individuate in base all'id dell'utente. Se non vi sono
	 * edizioni per quell'utente o l'utente non esiste viene ritornata una lista
	 * vuota
	 */
	public List<Edizione> cercaPerIdUtente(Connection connection, long idUtente) throws DAOException {

		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		Edizione ed = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(
					"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id JOIN iscritto ON iscritto.id_utente=utente.id where utente.id=?");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
				Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
						rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
				ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
						rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

				listaEdizioni.add(ed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return listaEdizioni;

	}

	/*
	 * Lettura di tutte le edizioni presenti nel calendario nel range delle date da,
	 * a (inclusi). Se non vi sono edizioni in quel range di date viene ritornata
	 * una lista vuota
	 */
	public List<Edizione> cercaPerPeriodo(Connection connection, Date da, Date a) throws DAOException {

		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		Edizione ed = null;
		PreparedStatement ps;

		try {
			ps = connection.prepareStatement(
					"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id WHERE data_inizio BETWEEN ? and ?");
			ps.setDate(1, da);
			ps.setDate(2, a);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
				Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
						rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
				ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
						rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

				listaEdizioni.add(ed);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return listaEdizioni;

	}

	/*
	 * Lettura di tutte le edizioni di una certa categoria, presenti nel calendario
	 * dei corsi se future = true. Le edizioni lette devono essere solo quelle a
	 * partire dalla data odierna e dell'anno corrente. Se future = false devono
	 * essere lette tutte le edizioni. Le edizioni vengono individuate in base
	 * all'id della categoria. Se non vi sono edizioni per quella categoria o la
	 * categoria non esiste viene ritornata una lista vuota
	 */
	public List<Edizione> cercaPerCategoria(Connection connection, long idCategoria, boolean future)
			throws DAOException {

		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		Edizione ed = null;
		PreparedStatement ps;

		try {

			if (future == true) {
				ps = connection.prepareStatement(
						"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id WHERE id_categoria = ? AND data_inizio>=CURRENT_DATE()");
				ps.setLong(1, idCategoria);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
					Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
							rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
					ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
							rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

					listaEdizioni.add(ed);
				}
			} else {
				ps = connection.prepareStatement(
						"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id WHERE id_categoria = ?");
				ps.setLong(1, idCategoria);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
					Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
							rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
					ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
							rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

					listaEdizioni.add(ed);

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return listaEdizioni;

	}

	/*
	 * Lettura di tutte le edizioni presenti nel calendario dei corsi. Se future =
	 * true, le edizioni lette devono essere solo quelle a partire dalla data
	 * odierna e dell'anno corrente, se future = false devono essere lette tutte le
	 * edizioni. Se non vi sono edizioni viene ritornata una lista vuota
	 */
	public List<Edizione> cercaTutte(Connection connection, boolean future) throws DAOException {

		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		Edizione ed = null;
		PreparedStatement ps;

		try {

			if (future == true) {
				ps = connection.prepareStatement(
						"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id WHERE data_inizio>=CURRENT_DATE()");

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
					Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
							rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
					ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
							rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

					listaEdizioni.add(ed);
				}
			} else {
				ps = connection.prepareStatement(
						"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id");

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
					Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
							rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
					ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
							rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

					listaEdizioni.add(ed);

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return listaEdizioni;
	}

	/*
	 * Lettura di tutte le edizioni a cui è iscritto una certo utente, presenti nel
	 * calendario dei corsi. Se future = true, le edizioni lette devono essere solo
	 * quelle a partire dalla data odierna e dell'anno corrente, se future = false
	 * devono essere lette tutte le edizioni. Le edizioni vengono individuate in
	 * base all'id dell'utente. Se non vi sono edizioni per quell'id viene ritornata
	 * una lista vuota
	 */
	public List<Edizione> cercaPerIdUtente(Connection connection, long idUtente, boolean future) throws DAOException {

		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		Edizione ed = null;
		PreparedStatement ps;

		try {

			if (future == true) {
				ps = connection.prepareStatement(
						"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id JOIN iscritto ON iscritto.id_utente=utente.id where utente.id=? and data_inizio>=CURRENT_DATE()");
				ps.setLong(1, idUtente);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
					Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
							rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
					ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
							rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

					listaEdizioni.add(ed);
				}
			} else {
				ps = connection.prepareStatement(
						"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id JOIN iscritto ON iscritto.id_utente=utente.id where utente.id=?");
				ps.setLong(1, idUtente);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {

					Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
					Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
							rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
					ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
							rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

					listaEdizioni.add(ed);

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return listaEdizioni;
	}

	/*
	 * Lettura di tutte le edizioni di una certa categoria, presenti nel calendario
	 * dei corsi. Le edizioni vengono individuate in base all'id della categoria. Se
	 * non vi sono edizioni per quella categoria o la categoria non esiste viene
	 * ritornata una lista vuota
	 */
	public List<Edizione> cercaPerIdCategoria(Connection connection, long idCategoria) throws DAOException {

		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		Edizione ed = null;
		PreparedStatement ps;

		try {
			ps = connection.prepareStatement(
					"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id WHERE id_categoria = ?");
			ps.setLong(1, idCategoria);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
				Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
						rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
				ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
						rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

				listaEdizioni.add(ed);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return listaEdizioni;
	}
	
	public List<Edizione> cercaPerIdCorso(Connection connection, long idCorso) throws DAOException {

		List<Edizione> listaEdizioni = new ArrayList<Edizione>();
		Edizione ed = null;
		PreparedStatement ps;

		try {
			ps = connection.prepareStatement(
					"SELECT e.id as id_edizione, e.data_inizio, e.aula, e.docente, e.durata, e.terminata, c.codice, c.titolo, c.descrizione as descrizione_corso, c.costo, c.max_partecipanti, cc.descrizione as descrizione_categoria FROM edizione AS e JOIN corso AS c ON e.id_corso = c.id JOIN categoria AS cc ON c.id_categoria = cc.id WHERE id_corso = ?");
			ps.setLong(1, idCorso);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Categoria categoria = new Categoria(rs.getString("descrizione_categoria"));
				Corso corso = new Corso(rs.getInt("codice"), rs.getString("titolo"), categoria,
						rs.getInt("max_partecipanti"), rs.getDouble("costo"), rs.getString("descrizione_corso"));
				ed = new Edizione(rs.getLong("id"), corso, rs.getDate("data_inizio"), rs.getInt("durata"),
						rs.getString("aula"), rs.getString("docente"), rs.getBoolean("terminata"));

				listaEdizioni.add(ed);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Errore ricerca");
		}
		return listaEdizioni;
	}

	private DAOEdizione() {
		super();
	}

	public static DAOEdizione getInstance() {
		if (instance == null) {
			instance = new DAOEdizione();
		}
		return instance;
	}

}
