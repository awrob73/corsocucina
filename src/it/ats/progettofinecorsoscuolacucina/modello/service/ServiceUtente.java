package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOUtente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DataSource;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;

public class ServiceUtente {

	private static ServiceUtente instance;
	// Dichiarare qui tutti i DAO di cui si ha bisogno
	private DAOUtente daoU;

	// Inizializzare / richiamare qui tutti i DAO di cui si ha bisogno
	private ServiceUtente() {
		super();
		this.daoU = DAOUtente.getInstance();
	}

	/*
	 * Registrazione nel sistema di un nuovo utente. Se l'utente è già presente si
	 * solleva una eccezione
	 */
	public void registrazioneUtente(Utente u) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			daoU.inserisci(connection, u);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
				}
			}
		}

	}

	/*
	 * Controllo della presenza di un utente in base alla username e alla password.
	 * Se l'utente è presente viene recuperato e ritornato. Se l'utente non è
	 * presente si solleva una eccezione
	 */
	public Utente checkCredenziali(String username, String password) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Cancellazione di un utente dal sistema. L'utente è cancellabile solo se non
	 * vi sono dati correlati. (Ad esempio, non è (o è stato) iscritto a nessuna
	 * edizione), se l'utente non è cancellabile si solleva una eccezione
	 * 
	 */
	public void cancellaRegistrazioneUtente(long idUtente) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Modifica tutti i dati di un utente. L'utente viene individuato in base
	 * all'id. Se l'utente non è presente si solleva una eccezione
	 */
	public void modificaDatiUtente(Utente u) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Legge tutti gli utenti registrati sul sistema. Se non vi sono utenti il
	 * metodo ritorna una lista vuota
	 */
	public List<Utente> visualizzaUtentiRegistrati() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Inserisce un feedback per una certa edizione. Un utente può inserire un
	 * feedback solo per i corsi già frequentati (e terminati) e solo se non lo ha
	 * già fatto in precedenza (un solo feedback ad utente per edizione). Se
	 * l'utente non può insierire un feedback si solleva una eccezione
	 */
	public void inserisciFeedback(Feedback feedback) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Modifica della descrizione e/o del voto di un feedback. Il feedback è
	 * modificabile solo da parte dell'utente che lo ha inserito e solo entro un
	 * mese dal termine della edizione del corso. Se l'utente non può modificare un
	 * feedback si solleva una eccezione
	 */
	public void modificaFeedback(Feedback feedback) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Eliminazione di un feedback. Il feedback è cancellabile solo da parte
	 * dell'utente che lo ha inserito e solo entro un mese dal termine della
	 * edizione del corso. Se l'utente non può cancellare un feedback si solleva una
	 * eccezione
	 */
	public void cancellaFeedback(long idFeedback) throws ServiceException {
		// TODO Auto-generated method stub

	}

	public static ServiceUtente getInstance() {
		if (instance == null) {
			instance = new ServiceUtente();
		}
		return instance;
	}

}
