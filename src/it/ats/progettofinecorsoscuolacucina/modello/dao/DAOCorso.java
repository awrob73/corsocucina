package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Categoria;
import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;

public class DAOCorso {

	private static DAOCorso instance;

	/*
	 * Registrazione di un nuovo corso nel catalogo dei corsi
	 */
	public void inserisci(Connection connection, Corso corso) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"INSERT INTO corso(id, codice, titolo, id_categoria, max_partecipanti, costo, descrizione) VALUES(?,?,?,?,?,?,?)");
			preparedStatement.setLong(1, corso.getId());
			preparedStatement.setInt(2, corso.getCodice());
			preparedStatement.setString(3, corso.getTitolo());
			preparedStatement.setLong(4, corso.getCategoria().getId());
			preparedStatement.setInt(5, corso.getMaxPartecipanti());
			preparedStatement.setDouble(6, corso.getCosto());
			preparedStatement.setString(7, corso.getDescrizione());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
	}

	/*
	 * Modifica di tutti i dati di un corso nel catalogo dei corsi. Il corso viene
	 * individuato in base al suo id. Se il corso non esiste si solleva una
	 * eccezione
	 */
	public void modifica(Connection connection, Corso corso) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"update corso set  codice = ?, titolo = ?, id_categoria = ?, max_partecipanti = ?, costo = ?, descrizione = ?) where id = ?");
			preparedStatement.setInt(1, corso.getCodice());
			preparedStatement.setLong(7, corso.getId());
			preparedStatement.setString(2, corso.getTitolo());
			preparedStatement.setLong(3, corso.getCategoria().getId());
			preparedStatement.setInt(4, corso.getMaxPartecipanti());
			preparedStatement.setDouble(5, corso.getCosto());
			preparedStatement.setString(6, corso.getDescrizione());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Impossibile modificare");
		}
	}

	/*
	 * Cancellazione di un nuovo corso nel catalogo dei corsi, questo potrà essere
	 * cancellato solo se non vi sono edizioni di quel corso o qualsiasi altro
	 * legame con gli altri dati. Se il corso non esiste si solleva una eccezione.
	 * Se non è cancellabile si solleva una eccezione
	 */
	public void cancella(Connection connection, long id) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("delete from corso where id = ?");
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Impossibile cancellare");
		}
	}

	/*
	 * Lettura di tutti i corsi dal catalogo. Se non ci sono corsi nel catalogo il
	 * metodo torna una lista vuota
	 */
	public List<Corso> cercaTutti(Connection connection) throws DAOException {
		PreparedStatement preparedStatement = null;
		List<Corso> list = new ArrayList<Corso>();
		try {
			preparedStatement = connection.prepareStatement("select * from corso");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Corso corso = new Corso();
				corso.setId(rs.getLong("id"));
				corso.setCodice(rs.getInt("codice"));
				corso.setTitolo(rs.getString("titolo"));
				corso.getCategoria().setId(rs.getLong("id_categoria"));
				corso.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				corso.setCosto(rs.getDouble("costo"));
     			corso.setDescrizione(rs.getString("descrizione"));
				list.add(corso);

			}

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Impossibile trovare corsi");
		}

		return list;
	}
	
	/*
	 * Lettura di un singolo corso dal catalogo dei corsi. Se il corso non è
	 * presente si solleva una eccezione
	 */
	public Corso cercaPerId(Connection connection, long idCorso) throws DAOException{
		PreparedStatement preparedStatement = null;
		Corso corso = new Corso();
		try {
			preparedStatement = connection.prepareStatement("select * from corso where id=?");
			preparedStatement.setLong(1, idCorso);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				
				corso.setId(rs.getLong("id"));
				corso.setCodice(rs.getInt("codice"));
				corso.setTitolo(rs.getString("titolo"));
				corso.getCategoria().setId(rs.getLong("id_categoria"));
				corso.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				corso.setCosto(rs.getDouble("costo"));
     			corso.setDescrizione(rs.getString("descrizione"));

			}
			return corso;

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Corso non trovato");
		}
	}
	
	public List<Corso> cercaPerIdCategoria(Connection connection, long idCategoria) throws DAOException{
		PreparedStatement preparedStatement = null;
		List<Corso> list = new ArrayList<Corso>();
		
		try {
			preparedStatement = connection.prepareStatement("select * from corso where id_categoria=?");
			preparedStatement.setLong(1, idCategoria);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Corso corso = new Corso();
				corso.setId(rs.getLong("id"));
				corso.setCodice(rs.getInt("codice"));
				corso.setTitolo(rs.getString("titolo"));
				corso.getCategoria().setId(rs.getLong("id_categoria"));
				corso.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				corso.setCosto(rs.getDouble("costo"));
     			corso.setDescrizione(rs.getString("descrizione"));
     			list.add(corso);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Corsi della categoria non trovati");
		}
	}
	
	public List<Corso> corsiUtente(Connection connection, long idUtente) throws DAOException{
		PreparedStatement preparedStatement = null;
		List<Corso> list = new ArrayList<Corso>();
		
		try {
			preparedStatement = connection.prepareStatement("select c.* from corso as c inner join edizione as e on e.id_corso=c.id inner join iscritto as i on i.id_edizione= e.id where i.id_utente=?;");
			preparedStatement.setLong(1, idUtente);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Corso corso = new Corso();
				Categoria cat = new Categoria();
				corso.setId(rs.getLong("id"));
				corso.setCodice(rs.getInt("codice"));
				corso.setTitolo(rs.getString("titolo"));
				cat.setId(rs.getLong("id_categoria"));
				corso.setCategoria(cat);
				corso.setMaxPartecipanti(rs.getInt("max_partecipanti"));
				corso.setCosto(rs.getDouble("costo"));
     			corso.setDescrizione(rs.getString("descrizione"));
     			list.add(corso);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();//
			throw new DAOException("Utente non ha corsi attivati");
		}
	}
	
	private DAOCorso() {
		super();
	}

	public static DAOCorso getInstance() {
		if (instance == null) {
			instance = new DAOCorso();
		}
		return instance;
	}

}