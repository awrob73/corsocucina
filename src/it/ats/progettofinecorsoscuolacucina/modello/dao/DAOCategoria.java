package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			preparedStatement=connection.prepareStatement("insert into categoria values(?,?)");
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
			preparedStatement =connection.prepareStatement("update categoria set categoria = ? where id = ?");
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
			preparedStatement = connection.prepareStatement("delete from categoria where id = ?");
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
		Categoria c = new Categoria();
		try {
			preparedStatement = connection.prepareStatement("select * from categoria where id=?");
			preparedStatement.setLong(1, idCategoria);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				c.setId(rs.getLong("id"));
				c.setDescrizione(rs.getString("descrizione"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
		return c;
	}

	/*
	 * Lettura di tutte le categorie. Se non vi sono categoria il metodo ritorna una
	 * lista vuota
	 */
	public List<Categoria> cercaTutte(Connection connection) throws DAOException {
		PreparedStatement preparedStatement = null;
		List<Categoria> list = new ArrayList<Categoria>();
		try {
			preparedStatement =connection.prepareStatement("select * from categoria");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt("id"));
				c.setDescrizione(rs.getString("descrizione"));
				list.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Errore registrazione");
		}
		return list;
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
