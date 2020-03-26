package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.sql.Connection;

import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOCorso;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOFeedback;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOUtente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DataSource;

public class ServiceFeedback {
	private static ServiceUtente instance;
	private DAOUtente daoU;
	private DAOFeedback daoF;
	private DAOCorso daoC;
	private DAOEdizione daoE;
	private DataSource dataSource;
	
	private ServiceFeedback() {
		super();
		this.daoF = DAOFeedback.getInstance();
		this.daoU = DAOUtente.getInstance();
		this.daoC = DAOCorso.getInstance();
		this.daoE = DAOEdizione.getInstance();
	}

	public void inserisciFeedback(Feedback f) throws Exception{
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoF.inserisci(connection, f);
		connection.commit();
	}
	
	public void modificaFeedback(Feedback feedback) throws Exception {
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoF.modifica(connection, feedback);
		connection.commit();
	}
	
	public void cancellaFeedback(long idFeedback) throws Exception {
		Connection connection = null;
		connection = DataSource.getInstance().getConnection();
		daoF.cancella(connection, idFeedback);
		connection.commit();
	}
	
}
