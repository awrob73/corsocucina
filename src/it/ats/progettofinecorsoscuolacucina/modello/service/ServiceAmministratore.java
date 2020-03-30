package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOAmministratore;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DataSource;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;

public class ServiceAmministratore {

	private static ServiceAmministratore instance;
	private DAOAmministratore daoA;
	private DataSource dataSource;

	private ServiceAmministratore() {
		super();
		this.daoA = DAOAmministratore.getInstance();
	}

	public void registrazioneAmministratore(Utente a) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			daoA.inserisci(connection, a);
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
	
	public void modificaDatiUtente(Utente a) throws Exception {
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoA.modifica(connection, a);
		connection.commit();
	}

	public void cancellaAmministratore(long idUtente) throws Exception {
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoA.cancella(connection, idUtente);
		connection.commit();

	}
	
	public List<Utente> visualizzaAmministratori() throws Exception {
		Connection connection = null;
		 
		connection = DataSource.getInstance().getConnection();
		List<Utente> list= daoA.cercaTutti(connection);
		connection.commit();
		return list;
	}
	
	public Utente cercaAmministratorePerUsername(String username) throws Exception {

		Connection connection = null;
		Utente a = new Utente();
		try {
			connection = DataSource.getInstance().getConnection();
			a = daoA.cercaPerUsername(connection, username);
			connection.commit();
			return a;

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
		

	}
	
	public Utente cercaAmministratorePerId(long idUtente) throws Exception {

		Connection connection = null;
		Utente a = new Utente();
		try {
			connection = DataSource.getInstance().getConnection();
			daoA.cercaPerId(connection, idUtente);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServiceException(e.getMessage());
			}
		}
		return a;

	}
	
	public Utente checkCredenziali(String username, String password) throws Exception {
		Connection connection = null;
		Utente u = new Utente();
		try {
			connection = DataSource.getInstance().getConnection();
			
			int i = daoA.cercaPerCredenziali(connection, username, password);
			if(i==1) {
			u = daoA.cercaPerUsername(connection, username);
			}
			connection.commit();
		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static ServiceAmministratore getInstance() {
		if (instance == null) {
			instance = new ServiceAmministratore();
		}
		return instance;
	}
	
}
