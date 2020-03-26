package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Categoria;
import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;

public class DAOUtente {

	private static DAOUtente instance;

	/*
	 * Registrazione di un nuovo utente alla scuola di formazione. Se l'utente già
	 * esiste si solleva una eccezione
	 */
	public void inserisci(Connection connection, Utente u) throws DAOException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO utente(username, password, nome, cognome, data_nascita, email, telefono) VALUES(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, u.getUsername());
			preparedStatement.setString(2, u.getPassword());
			preparedStatement.setString(3, u.getNome());
			preparedStatement.setString(4, u.getCognome());
			preparedStatement.setDate(5, new Date(u.getDataNascita().getTime()));
			preparedStatement.setString(6, u.getEmail());
			preparedStatement.setLong(7, u.getTelefono());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
	}

	/*
	 * Modifica di tutti i dati di un utente l'utente viene individuato dal suo id.
	 * Se l'utente non esiste si solleva una eccezione
	 */
	public void modifica(Connection connection, Utente u) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"update utente set  password = ?, nome = ?, cognome = ?, data_nascita = ?, email = ?, telefono = ?) where username = ?");
			preparedStatement.setString(7, u.getUsername());
			preparedStatement.setString(1, u.getPassword());
			preparedStatement.setString(2, u.getNome());
			preparedStatement.setString(3, u.getCognome());
			preparedStatement.setDate(4, new Date(u.getDataNascita().getTime()));
			preparedStatement.setString(5, u.getEmail());
			preparedStatement.setLong(6, u.getTelefono());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Impossibile modificare");
		}

	}

	/*
	 * Cancellazione di un singolo utente. L'utente si può cancellare solo se non è
	 * correlato ad altri dati. Se l'utente non esiste o non è cancellabile si
	 * solleva una eccezione
	 */
	public void cancella(Connection connection, long id) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from utente where id = ?");
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Impossibile cancellare");
		}

	}

	/*
	 * Lettura di tutti gli utenti registrati. Se non ci sono utenti registrati il
	 * metodo ritorna una lista vuota
	 */
	public List<Utente> cercaTutti(Connection connection) throws DAOException {

		PreparedStatement preparedStatement = null;
		List<Utente> list = new ArrayList<Utente>();
		try {
			preparedStatement = connection.prepareStatement("select * from utente");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Utente u = new Utente();
				u.setId(rs.getLong("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setDataNascita(rs.getDate("data_nascita"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getLong("telefono"));
				list.add(u);

			}

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Impossibile trovare utenti");
		}

		return list;
	}

	/*
	 * Lettura dei dati di un singolo utente. Se l'utente non esiste si solleva una
	 * eccezione
	 */
	public Utente cercaPerId(Connection connection, long id) throws DAOException {
		PreparedStatement preparedStatement = null;
		Utente u = new Utente();
		try {
			preparedStatement = connection.prepareStatement("select * from utente where id=?");
			preparedStatement.setLong(1, id);
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

			}
			return u;

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Utente non trovato");
		}
	}
	
	public Utente cercaPerUsername(Connection connection, String username) throws DAOException {
		PreparedStatement preparedStatement = null;
		Utente u = new Utente();
		try {
			preparedStatement = connection.prepareStatement("select * from utente where username=?");
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

			}
			return u;

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Utente non trovato");
		}
	}

	/*
	 * Iscrizione di un certo utente ad una certa edizione di un corso. Sia l'utente
	 * che l'edizione devono già essere stati registrati in precedenza. Se l'utente
	 * e/o l'edizione non esistono o l'utente è già iscritto a quella edizione si
	 * solleva una eccezione
	 */
	public void iscriviUtente(Connection connection, long idEdizione, long idUtente) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("insert into iscritto(id_edizione,id_utente) values(?,?);");
			preparedStatement.setLong(1, idEdizione);
			preparedStatement.setLong(2, idUtente);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Errore iscrizione corso");
		}
	}

	/*
	 * Cancellazione di una iscrizione ad una edizione, nota: quando si cancella
	 * l'iscrizione, sia l'utente che l'edizione non devono essere cancellati. Se
	 * l'utente e/o l'edizione non esistono si solleva una eccezione
	 */
	public void cancellaIscrizioneUtente(Connection connection, long idEdizione, long idUtente) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection
					.prepareStatement("delete from iscritto where (id_edizione=? and id_utente=?);");
			preparedStatement.setLong(1, idEdizione);
			preparedStatement.setLong(2, idUtente);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Errore cancellazione iscrizione corso");
		}
	}

	/*
	 * Lettura di tutte le edizioni a cui è iscritto un utente. Se l'utente non
	 * esiste o non è iscritto a nessuna edizione ritorna una lista vuota
	 */
	public List<Edizione> cercaIscrizioniUtente(Connection connection, long idUtente) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
		preparedStatement = connection.prepareStatement(
				"select corso.codice,corso.titolo,categoria.descrizione,edizione.data_inizio,edizione.durata,edizione.aula,edizione.docente,edizione.terminata,corso.costo"
						+ "from iscritto join edizione on edizione.id=iscritto.id_edizione"
						+ "join corso on edizione.id_corso=corso.id "
						+ "join categoria on categoria.id=corso.id_categoria" + "where id_utente=?");

		preparedStatement.setLong(1, idUtente);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<Edizione> lista = new ArrayList<>();
		
		while (resultSet.next()) {

			Categoria categoria = new Categoria(resultSet.getString("categoria.descrizione"));
			Corso corso = new Corso(resultSet.getInt("codice"), resultSet.getString("titolo"), categoria,
					resultSet.getDouble("costo"));

			Edizione e = new Edizione(corso, resultSet.getDate("data_inizio"), resultSet.getInt("durata"),
					resultSet.getString("aula"), resultSet.getString("docente"), resultSet.getBoolean("terminata"));

			lista.add(e);
		}
		return lista;

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Errore cancellazione iscrizione corso");
		}
	}

	/*
	 * Lettura di tutti gli utenti iscritti ad una certa edizione. Se l'edizione non
	 * esiste o non vi sono utenti iscritti ritorna una lista vuota
	 */
	public List<Utente> cercaUtentiPerEdizione(Connection connection, long idEdizione) throws DAOException {
		PreparedStatement preparedStatement = null;
		List<Utente> lista = new ArrayList<Utente>();
		try {
			preparedStatement = connection.prepareStatement(
					"select * from utente inner join iscritto on iscritto.id_utente = utente.id inner join edizione on edizione.id=iscritto.id_edizione where edizione.id=?;");
			preparedStatement.setLong(1, idEdizione);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Utente u = new Utente();
				u.setId(rs.getLong("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
				u.setDataNascita(rs.getDate("data_nascita"));
				u.setEmail(rs.getString("email"));
				u.setTelefono(rs.getLong("telefono"));
				lista.add(u);

			}
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Errore cancellazione iscrizione corso");
		}
	}

	/*
	 * Ritorna il numero di utenti iscritti ad una certa edizione
	 */
	public int getNumeroIscritti(Connection connection, long idEdizione) throws DAOException {
		PreparedStatement preparedStatement = null;
		int numeroIscritti = 0;
		try {
			preparedStatement = connection.prepareStatement(
					"select count(id_utente) as numero from iscritto inner join edizione on edizione.id=iscritto.id_edizione where id_edizione=?;");
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				numeroIscritti = rs.getInt("numero");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore numero iscritti");
		}
		return numeroIscritti;
	}

	/*
	 * Ritorna un utente sulla base delle sue credenziali
	 */
	public int cercaPerCredenziali(Connection connection, String username, String password) throws DAOException {
		PreparedStatement preparedStatement = null;
		int verifica = 0;
		String verificaPassword = null;
		try {
			preparedStatement = connection.prepareStatement("select * from utente where username=?");
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				verificaPassword = rs.getString("password");
				if(verificaPassword.equals(password)) {
					verifica =1;
				}

			}
			return verifica;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("password non corretta");
		}
		
	}

	private DAOUtente() {
		super();
	}

	public static DAOUtente getInstance() {
		if (instance == null) {
			instance = new DAOUtente();
		}
		return instance;
	}

}
