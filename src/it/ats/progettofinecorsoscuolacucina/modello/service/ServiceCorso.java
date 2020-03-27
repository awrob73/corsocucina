package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Categoria;
import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOCategoria;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOCorso;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOFeedback;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DataSource;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;
import it.ats.progettofinecorsoscuolacucina.modello.dto.CorsoDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;

public class ServiceCorso {

	private static ServiceCorso instance;
	// Dichiarare qui tutti i DAO di cui si ha bisogno
	private DAOCorso daoCo;
	private DAOFeedback daoF;
	private DAOCategoria daoCat;

	// Inizializzare / richiamare qui tutti i DAO di cui si ha bisogno
	private ServiceCorso() {
		this.daoCo = DAOCorso.getInstance();
		this.daoF = DAOFeedback.getInstance();
		this.daoCat = DAOCategoria.getInstance();
	}

	public void inserisciCorso(Corso corso) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			daoCo.inserisci(connection, corso);
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

	public void modificaDatiCorso(Corso corso) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			daoCo.modifica(connection, corso);
			;
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

	public void cancellaCorso(long idCorso) throws ServiceException {
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			daoCo.cancella(connection, idCorso);
			;
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

	public List<Corso> visualizzaCatalogoCorsi() throws ServiceException {
		Connection connection = null;
		List<Corso> listaCorsi = new ArrayList<>();
		try {
			connection = DataSource.getInstance().getConnection();
			listaCorsi = daoCo.cercaTutti(connection);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServiceException(e.getMessage());
			}
		}
		return listaCorsi;
	}
	
	public List<Corso> visualizzaCorsiUtente(long idUtente) throws ServiceException {
		Connection connection = null;
		List<Corso> listaCorsi = new ArrayList<>();
		try {
			connection = DataSource.getInstance().getConnection();
			listaCorsi = daoCo.corsiUtente(connection, idUtente);
			for(Corso c:listaCorsi) {
				c.setCategoria(daoCat.cercaPerId(connection, c.getCategoria().getId()));
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServiceException(e.getMessage());
			}
		}
		return listaCorsi;
	}

	public Corso visualizzaCorso(long idCorso) throws ServiceException {

		Connection connection = null;
		Corso co = new Corso();
		try {
			connection = DataSource.getInstance().getConnection();
			daoCo.cercaPerId(connection, idCorso);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServiceException(e.getMessage());
			}
		}
		return co;
	}

	/*
	 * Il metodo mostra l'elenco dei corsi di una certa categorie. Se il metodo / i
	 * metodi del / dei DAO invocati sollevano una eccezione, il metodo deve tornare
	 * una eccezione
	 */
	public List<Corso> visualizzaCorsiPerCategoria(int idCategoria) throws Exception {
		Connection conn = null;
		conn=DataSource.getInstance().getConnection();
		List<Corso> list = daoCo.cercaPerIdCategoria(conn, idCategoria);
		for(Corso c : list) {
			c.setCategoria(daoCat.cercaPerId(conn, c.getCategoria().getId()));
		}
		return list;
	}

	/*
	 * Ritorna un oggetto CorsoDTO con tutti i dati di un singolo corso, tutte le
	 * edizioni di quel corso con relativi feedbacks (classe EdizioneDTO). Il corso
	 * è individuato tramite il suo id. Se il metodo / i metodi del / dei DAO
	 * invocati sollevano una eccezione, il metodo deve tornare una eccezione
	 */
	
	public CorsoDTO visualizzaSchedaCorso(long idCorso) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Ritorna una lista con tutti i feedbacks relativi ad un corso. Il corso è
	 * individuato tramite il suo id. Se il metodo / i metodi del / dei DAO invocati
	 * sollevano una eccezione, il metodo deve tornare una eccezione
	 */
	public List<Feedback> visualizzaFeedbackCorso(long idCorso) throws ServiceException {
		Connection connection = null;
		List<Feedback> listaCorsiFeedback = new ArrayList<>();
		try {
			connection = DataSource.getInstance().getConnection();
			listaCorsiFeedback = daoF.cercaFeedbackPerCorso(connection, idCorso);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServiceException(e.getMessage());
			}
		}
		return listaCorsiFeedback;

	}

	/*
	 * Legge i dati di un singolo corso (senza edizioni). Se il metodo / i metodi
	 * del / dei DAO invocati sollevano una eccezione, il metodo deve tornare una
	 * eccezione
	 */

	public static ServiceCorso getInstance() {
		if (instance == null) {
			instance = new ServiceCorso();
		}
		return instance;
	}

}
