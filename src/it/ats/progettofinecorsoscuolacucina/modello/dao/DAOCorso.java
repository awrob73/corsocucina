package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;

public class DAOCorso {

	private static DAOCorso instance;

	/*
	 * Registrazione di un nuovo corso nel catalogo dei corsi
	 */
	public void inserisci(Connection connection, Corso corso) throws DAOException {
		// TODO Auto-generated method stub
	}

	/*
	 * Modifica di tutti i dati di un corso nel catalogo dei corsi. Il corso viene
	 * individuato in base al suo id. Se il corso non esiste si solleva una
	 * eccezione
	 */
	public void modifica(Connection connection, Corso corso) throws DAOException {
		// TODO Auto-generated method stub
	}

	/*
	 * Cancellazione di un nuovo corso nel catalogo dei corsi, questo potrà essere
	 * cancellato solo se non vi sono edizioni di quel corso o qualsiasi altro
	 * legame con gli altri dati. Se il corso non esiste si solleva una eccezione.
	 * Se non è cancellabile si solleva una eccezione
	 */
	public void cancella(Connection connection, long id) throws DAOException {
		// TODO Auto-generated method stub
	}

	/*
	 * Lettura di tutti i corsi dal catalogo. Se non ci sono corsi nel catalogo il
	 * metodo torna una lista vuota
	 */
	public List<Corso> cercaTutti(Connection connection) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Lettura di un singolo corso dal catalogo dei corsi. Se il corso non è
	 * presente si solleva una eccezione
	 */
	public Corso cercaPerId(Connection connection, long idCorso) throws DAOException{
		// TODO Auto-generated method stub
		return null;
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