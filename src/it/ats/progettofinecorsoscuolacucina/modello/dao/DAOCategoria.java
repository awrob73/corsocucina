package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
	}

	/*
	 * Modifica del nome di una categoria. La categoria viene individuata in base al
	 * suo id. Se la categoria non esiste si solleva una eccezione
	 */
	public void modifica(Connection connection, Categoria c) throws DAOException {
		// TODO Auto-generated method stub
	}

	/*
	 * Cancellazione di una singola categoria. Una categoria si può cancellare solo
	 * se non ci sono dati correlati. Se la categoria non esiste o non è
	 * cancellabile si solleva una eccezione
	 */
	public void cancella(Connection connection, long idCategoria) throws DAOException {
		// TODO Auto-generated method stub
	}

	/*
	 * Lettura di una singola categoria in base al suo id. Se la categoria non
	 * esiste si solleva una eccezione
	 */
	public Categoria cercaPerId(Connection connection, long idCategoria) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Lettura di tutte le categorie. Se non vi sono categoria il metodo ritorna una
	 * lista vuota
	 */
	public List<Categoria> cercaTutte(Connection connection) throws DAOException {
		// TODO Auto-generated method stub
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
