package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.sql.Connection;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;

public class DAOFeedback {

	private static DAOFeedback instance;

	/*
	 * Inserimento di un singolo feedbak relativo ad una edizione di un corso da
	 * parte di un utente. Se un utente ha già inserito un feedback per una certa
	 * edizione si solleva una eccezione
	 */
	public void inserisci(Connection connection, Feedback feedback) throws DAOException {
		// TODO Auto-generated method stub

	}

	/*
	 * Modifica di tutti i dati di un singolo feedback. Un feedback viene
	 * individuato attraverso il suo id. Se il feedback non esiste si solleva una
	 * eccezione
	 */
	public void modifica(Connection connection, Feedback feedback) throws DAOException {
		// TODO Auto-generated method stub

	}

	/*
	 * Cancellazione di un feedback. Se il feedback non esiste si solleva una
	 * eccezione
	 */
	public void cancella(Connection connection, long idFeedback) throws DAOException {
		// TODO Auto-generated method stub

	}

	/*
	 * Lettura di un singolo feedback scritto da un utente per una certa edizione.
	 * Se il feedback non esiste si solleva una eccezione
	 */
	public Feedback cercaSingoloFeedback(Connection connection, long idUtente, long idEdizione) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Lettura di tutti i feedback di una certa edizione. Se non ci sono feedback o
	 * l'edizione non esiste si torna una lista vuota
	 */
	public List<Feedback> cercaPerEdizione(Connection connection, long idEdizione) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Lettura di tutti i feedback scritti da un certo utente. Se non ci sono
	 * feedback o l'utente non esiste si torna una lista vuota
	 */
	public List<Feedback> cercaPerUtente(Connection connection, long idUtente) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Lettura di tutti i feedback scritti per un certo corso (nota: non edizione ma
	 * corso). Se non ci sono feedback o il corso non esiste si torna una lista
	 * vuota
	 */
	public List<Feedback> cercaFeedbackPerCorso(Connection connection, long idCorso) throws DAOException {
		// TODO Auto-generated method stub
		return null;
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
