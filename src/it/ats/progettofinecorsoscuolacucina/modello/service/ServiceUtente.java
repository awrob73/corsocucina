package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOFeedback;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOUtente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DataSource;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;

public class ServiceUtente {

	private static ServiceUtente instance;
	private DAOUtente daoU;
	private DAOFeedback daoF;
	private DataSource dataSource;
	
	// Inizializzare / richiamare qui tutti i DAO di cui si ha bisogno
	private ServiceUtente() {
		super();
		this.daoU = DAOUtente.getInstance();
		this.daoF = DAOFeedback.getInstance();
	}

	/*
	 * Registrazione nel sistema di un nuovo utente. Se l'utente è già presente si
	 * solleva una eccezione
	 */
	public void registrazioneUtente(Utente u) throws Exception {
		Connection connection = null;
			connection = DataSource.getInstance().getConnection();
			daoU.inserisci(connection, u);
			connection.commit();
	}

	/*
	 * Controllo della presenza di un utente in base alla username e alla password.
	 * Se l'utente è presente viene recuperato e ritornato. Se l'utente non è
	 * presente si solleva una eccezione
	 */
	public Utente checkCredenziali(String username, String password) throws Exception {
		Connection connection = null;
		Utente u = new Utente();
		try {
			connection = DataSource.getInstance().getConnection();
			
			int i = daoU.cercaPerCredenziali(connection, username, password);
			if(i==1) {
			u = daoU.cercaPerUsername(connection, username);
			}
			connection.commit();
		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	/*
	 * Cancellazione di un utente dal sistema. L'utente è cancellabile solo se non
	 * vi sono dati correlati. (Ad esempio, non è (o è stato) iscritto a nessuna
	 * edizione), se l'utente non è cancellabile si solleva una eccezione
	 * 
	 */
	public void cancellaRegistrazioneUtente(long idUtente) throws Exception {
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoU.cancella(connection, idUtente);
		connection.commit();

	}

	/*
	 * Modifica tutti i dati di un utente. L'utente viene individuato in base
	 * all'id. Se l'utente non è presente si solleva una eccezione
	 */
	public void modificaDatiUtente(Utente u) throws Exception {
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoU.modifica(connection, u);
		connection.commit();
	}

	/*
	 * Legge tutti gli utenti registrati sul sistema. Se non vi sono utenti il
	 * metodo ritorna una lista vuota
	 */
	public List<Utente> visualizzaUtentiRegistrati() throws Exception {
		Connection connection = null;
		 
		connection = DataSource.getInstance().getConnection();
		List<Utente> list= daoU.cercaTutti(connection);
		connection.commit();
		return list;
	}

	/*
	 * Inserisce un feedback per una certa edizione. Un utente può inserire un
	 * feedback solo per i corsi già frequentati (e terminati) e solo se non lo ha
	 * già fatto in precedenza (un solo feedback ad utente per edizione). Se
	 * l'utente non può insierire un feedback si solleva una eccezione
	 */
	public void inserisciFeedback(Feedback feedback) throws Exception {
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoF.inserisci(connection, feedback);
		connection.commit();
	}

	/*
	 * Modifica della descrizione e/o del voto di un feedback. Il feedback è
	 * modificabile solo da parte dell'utente che lo ha inserito e solo entro un
	 * mese dal termine della edizione del corso. Se l'utente non può modificare un
	 * feedback si solleva una eccezione
	 */
	public void modificaFeedback(Feedback feedback) throws Exception {
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoF.modifica(connection, feedback);
		connection.commit();
	}

	/*
	 * Eliminazione di un feedback. Il feedback è cancellabile solo da parte
	 * dell'utente che lo ha inserito e solo entro un mese dal termine della
	 * edizione del corso. Se l'utente non può cancellare un feedback si solleva una
	 * eccezione
	 */
	public void cancellaFeedback(long idFeedback) throws Exception {
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoF.cancella(connection, idFeedback);
		connection.commit();
	}

	public Utente visualizzaDatiUtente(String username) throws Exception {
		Connection connection = null;
		 
		connection = DataSource.getInstance().getConnection();
		Utente u = daoU.cercaPerUsername(connection, username);
		connection.commit();
		return u;
	}

	public Utente leggiUtente(long idUtente) throws Exception {
		Connection connection = null;
		 
		connection = DataSource.getInstance().getConnection();
		Utente u = daoU.cercaPerId(connection, idUtente);
		connection.commit();
		return u;
	}

	public void modificaUsername(Utente u, String newUsername) throws Exception {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			u.setUsername(newUsername);
			daoU.modifica(connection, u);
			connection.commit();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
				}
			}
		}
	}

	public void modificaPassword(Utente u, String newPass) throws Exception{
		Connection connection = null;

		try {
			connection = DataSource.getInstance().getConnection();
			u.setPassword(newPass);
			daoU.modifica(connection, u);
			connection.commit();

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
				}
			}
		}

	}

	public void modificaNome(Utente u, String newNome) throws Exception{
		Connection connection = null;

		try {
			connection = DataSource.getInstance().getConnection();
			u.setNome(newNome);
			daoU.modifica(connection, u);
			connection.commit();

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
				}
			}
		}
	}

	public void modificaCognome(Utente u, String newCognome) throws Exception {
		Connection connection = null;

		try {
			connection = DataSource.getInstance().getConnection();
			u.setCognome(newCognome);
			daoU.modifica(connection, u);
			connection.commit();

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
				}
			}
		}
	}

	public void modificaData(Utente u, Date newData) throws Exception {
		Connection connection = null;

		try {
			connection = DataSource.getInstance().getConnection();
			u.setDataNascita(newData);
			daoU.modifica(connection, u);
			connection.commit();

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
				}
			}
		}
	}

	public void modificaEmail(Utente u, String newEmail) throws Exception {
		Connection connection = null;

		try {
			connection = DataSource.getInstance().getConnection();
			u.setEmail(newEmail);
			daoU.modifica(connection, u);
			connection.commit();

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
				}
			}
		}
	}

	public void modificaTelefono(Utente u, long telefono) throws Exception {
		Connection connection = null;

		try {
			connection = DataSource.getInstance().getConnection();
			u.setTelefono(telefono);
			daoU.modifica(connection, u);
			connection.commit();

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new ServiceException(e.getMessage());
				}
			}
		}

	}
	
	public static ServiceUtente getInstance() {
		if (instance == null) {
			instance = new ServiceUtente();
		}
		return instance;
	}

}
