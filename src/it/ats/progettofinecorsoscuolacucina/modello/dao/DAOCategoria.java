package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Categoria;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;

public class DAOCategoria {

	private static DAOCategoria instance;

	/*
	 * Inserimento di una nuova categoria
	 * 
	 */
	public void inserisci(Connection connection, String descrizione) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
				Categoria c = new Categoria();
				connection.prepareStatement("insert into categoria values(?,?)");
				preparedStatement.setLong(1, c.getId());
				preparedStatement.setString(2, descrizione);
				preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
	}

	/*
	 * Modifica del nome di una categoria. La categoria viene individuata in base al
	 * suo id. Se la categoria non esiste si solleva una eccezione
	 */
	public void modifica(Connection connection, Categoria c) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
				connection.prepareStatement("update categoria set categoria = ? where id = ?");
				preparedStatement.setLong(2, c.getId());
				preparedStatement.setString(1, c.getDescrizione());
				preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
	}

	/*
	 * Cancellazione di una singola categoria. Una categoria si può cancellare solo
	 * se non ci sono dati correlati. Se la categoria non esiste o non è
	 * cancellabile si solleva una eccezione
	 */
	public void cancella(Connection connection, long idCategoria) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			connection.prepareStatement("delete from categoria where id = ?");
			preparedStatement.setLong(1, idCategoria);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
	}

	/*
	 * Lettura di una singola categoria in base al suo id. Se la categoria non
	 * esiste si solleva una eccezione
	 */
	public Categoria cercaPerId(Connection connection, long idCategoria) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			connection.prepareStatement("select * from categoria where id = ?");
			preparedStatement.setLong(1, idCategoria);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
		return null;
	}

	/*
	 * Lettura di tutte le categorie. Se non vi sono categoria il metodo ritorna una
	 * lista vuota
	 */
	public List<Categoria> cercaTutte(Connection connection) throws DAOException {
		PreparedStatement preparedStatement = null;
		try {
			connection.prepareStatement("select * from categoria");
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
		return null;
	}

	private DAOCategoria() {
		super();
	}

	public static DAOCategoria getInstance() {
		if (instance == null) {
			instance = new DAOCategoria();
		}
		return instance;
	}

}
