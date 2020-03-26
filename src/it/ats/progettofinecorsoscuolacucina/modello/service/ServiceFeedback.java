package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.sql.Connection;
import java.util.List;

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
	
	public Feedback cercaFeedbackId(long id) throws Exception{
		Connection conn = null;
		conn = DataSource.getInstance().getConnection();
		Feedback f = daoF.cercaFeedback(conn, id);
		conn.commit();
		return f;
	}
	
	public Feedback cercaFeedback(long idUtente, long idEdizione) throws Exception{
		Connection conn = null;
		conn = DataSource.getInstance().getConnection();
		Feedback f = daoF.cercaSingoloFeedback(conn, idUtente, idEdizione);
		conn.commit();
		return f;
	}
	
	public List<Feedback> cercaFeedbackEdizione(long idEdizione) throws Exception{
		Connection conn = null;
		conn = DataSource.getInstance().getConnection();
		List<Feedback> list = daoF.cercaPerEdizione(conn, idEdizione);
		conn.commit();
		return list;
	}
	
	public List<Feedback> cercaFeedbackUtente(long idUtente) throws Exception{
		Connection conn = null;
		conn = DataSource.getInstance().getConnection();
		List<Feedback> list = daoF.cercaPerUtente(conn, idUtente);
		conn.commit();
		return list;
	}
	
	public List<Feedback> cercaFeedbackCorso(long idCorso) throws Exception{
		Connection conn = null;
		conn = DataSource.getInstance().getConnection();
		List<Feedback> list = daoF.cercaFeedbackPerCorso(conn, idCorso);
		conn.commit();
		return list;
	}
	
}
