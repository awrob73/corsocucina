package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sun.corba.se.pept.transport.ConnectionCache;

import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOFeedback;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOUtente;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DataSource;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.Utente;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;

public class ServiceEdizione {

	private static ServiceEdizione instance;
	// Dichiarare qui tutti i DAO di cui si ha bisogno
	private DAOEdizione daoE;
	private DAOUtente daoU;
	private DAOFeedback daoF;
	

	// Inizializzare / richiamare qui tutti i DAO di cui si ha bisogno
	private ServiceEdizione() {
		this.daoE = DAOEdizione.getInstance();
		this.daoU = DAOUtente.getInstance();
		this.daoF = DAOFeedback.getInstance();
	}

	/*
	 * Inserisce una nuova edizione
	 */
	public void inserisciEdizione(Edizione ed) throws ServiceException, SQLException {
		Connection connection = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			daoE.inserisci(connection, ed);
			connection.commit();
		} catch (DAOException e) {
			
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
	}

	/*
	 * Modifica tutti i dati di una edizione esistente
	 */
	public void modificaEdizione(Edizione ed) throws ServiceException, SQLException {
		Connection connection = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			daoE.modifica(connection, ed);
			connection.commit();
			
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

	}

	/*
	 * Cancella una edizione esistente. E' possibile cancellare una edizione
	 * soltanto se la data di inizio è antecedente a quella odierna. Nel caso in cui
	 * l'edizione sia cancellabile, è necessario cancellare l'iscrizione a tutti gli
	 * utenti iscritti
	 */
	public void cancellaEdizione(long idEdizione) throws ServiceException, SQLException {
		
		Connection connection = null;
		List<Utente> listaUtenti = new ArrayList<>();
		
		try {
			connection = DataSource.getInstance().getConnection();
			listaUtenti = daoU.cercaUtentiPerEdizione(connection, idEdizione);
			
			for (Utente u : listaUtenti) {
				long idUtente = u.getId();
				daoU.cancellaIscrizioneUtente(connection, idEdizione, idUtente);
			}
			
			daoE.cancella(connection, idEdizione);
			connection.commit();
			
			
		} catch (DAOException e) {
			
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

	}

	/*
	 * Iscrive un utente ad una edizione un utente. Si può iscrivere solo se ci sono
	 * ancora posti disponibili considerato che ogni corso ha un numero massimo di
	 * partecipanti
	 */
	public void iscriviUtente(long idEdizione, long idUtente) throws ServiceException, SQLException {
		
		Connection connection = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			daoU.iscriviUtente(connection, idEdizione, idUtente);
			connection.commit();
		} catch (DAOException e) {
			
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

	}

	/*
	 * Cancella l'iscrizione ad un utente
	 */
	public void cancellaIscrizioneUtente(long idEdizione, long idUtente) throws ServiceException, SQLException {
		
		Connection connection = null;
		
		
		try {
			connection = DataSource.getInstance().getConnection();
			daoU.cancellaIscrizioneUtente(connection, idEdizione, idUtente);
			
			connection.commit();
			
			
		} catch (DAOException e) {
			
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


	}

	/*
	 * Il metodo ritorna tutte le edizioni con relativi utenti e feedback dei corsi
	 * in calendario nel mese indicato dell'anno corrente. Se il metodo / i metodi
	 * del / dei DAO invocati sollevano una eccezione, il metodo deve tornare una
	 * eccezione
	 */
	public List<EdizioneDTO> visualizzaEdizioniPerMese(int mese) throws ServiceException, SQLException {
		Connection connection = null;
		
		Date da = new Date(Calendar.getInstance().get(Calendar.YEAR),mese,1);
		Date a = new Date(Calendar.getInstance().get(Calendar.YEAR),mese,31);
		
		
		List<EdizioneDTO> listaEdizioneDTO = new ArrayList<>();
		List<Edizione> listaEdizione = new ArrayList<>();
		List<Feedback> listaFeedback = new ArrayList<>();
		List<Utente> listaUtentiIscritti = new ArrayList<>();
		
		try {
			connection = DataSource.getInstance().getConnection();
			
			listaEdizione = daoE.cercaPerPeriodo(connection, da, a);
			
			for (Edizione ed : listaEdizione) {
				
				long idEdizione = ed.getId();
				listaFeedback = daoF.cercaPerEdizione(connection, idEdizione);
				listaUtentiIscritti = daoU.cercaUtentiPerEdizione(connection, idEdizione);
				EdizioneDTO edDTO = new EdizioneDTO(ed,listaFeedback,listaUtentiIscritti);
				listaEdizioneDTO.add(edDTO);
			}
			
			connection.commit();
			
			
		} catch (DAOException e) {
			
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

		return listaEdizioneDTO;
	}

	/*
	 * Il metodo ritorna tutte le edizioni con relativi utenti e feedback dei corsi
	 * in calendario nel mese indicato dell'anno corrente. Se il metodo / i metodi
	 * del / dei DAO invocati sollevano una eccezione, il metodo deve tornare una
	 * eccezione
	 */
	public List<EdizioneDTO> visualizzaEdizioniPerAnno(int anno) throws ServiceException, SQLException {
		Connection connection = null;
		
		Date da = new Date(anno,1,1);
		Date a = new Date(anno,12,31);
		
		
		List<EdizioneDTO> listaEdizioneDTO = new ArrayList<>();
		List<Edizione> listaEdizione = new ArrayList<>();
		List<Feedback> listaFeedback = new ArrayList<>();
		List<Utente> listaUtentiIscritti = new ArrayList<>();
		
		try {
			connection = DataSource.getInstance().getConnection();
			
			listaEdizione = daoE.cercaPerPeriodo(connection, da, a);
			
			for (Edizione ed : listaEdizione) {
				
				long idEdizione = ed.getId();
				listaFeedback = daoF.cercaPerEdizione(connection, idEdizione);
				listaUtentiIscritti = daoU.cercaUtentiPerEdizione(connection, idEdizione);
				EdizioneDTO edDTO = new EdizioneDTO(ed,listaFeedback,listaUtentiIscritti);
				listaEdizioneDTO.add(edDTO);
			}
			
			connection.commit();
			
			
		} catch (DAOException e) {
			
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

		return listaEdizioneDTO;
	}

	/*
	 * Il metodo ritorna tutte le edizioni con relativi utenti e feedback del corso
	 * specificato presenti in calendario nell'anno corrente a partire dalla data
	 * odierna. Se il metodo / i metodi del / dei DAO invocati sollevano una
	 * eccezione, il metodo deve tornare una eccezione
	 */
	public List<EdizioneDTO> visualizzaEdizioniPerCorso(long idCorso) throws ServiceException, SQLException {
		Connection connection = null;
				
		List<EdizioneDTO> listaEdizioneDTO = new ArrayList<>();
		List<Edizione> listaEdizione = new ArrayList<>();
		List<Feedback> listaFeedback = new ArrayList<>();
		List<Utente> listaUtentiIscritti = new ArrayList<>();
		
		try {
			connection = DataSource.getInstance().getConnection();
			
			listaEdizione = daoE.cercaPerIdCorso(connection, idCorso);
			
			for (Edizione ed : listaEdizione) {
				
				long idEdizione = ed.getId();
				listaFeedback = daoF.cercaPerEdizione(connection, idEdizione);
				listaUtentiIscritti = daoU.cercaUtentiPerEdizione(connection, idEdizione);
				EdizioneDTO edDTO = new EdizioneDTO(ed,listaFeedback,listaUtentiIscritti);
				listaEdizioneDTO.add(edDTO);
			}
			
			connection.commit();
			
			
		} catch (DAOException e) {
			
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

		return listaEdizioneDTO;
	}

	/*
	 * Il metodo ritorna tutte le edizioni dei corsi, relativi utenti e feedbacks in
	 * calendario dell'anno corrente a partire dalla data odierna. Se il metodo / i
	 * metodi del / dei DAO invocati sollevano una eccezione, il metodo deve tornare
	 * una eccezione
	 */
	public EdizioneDTO visualizzaEdizione(long idEdizione) throws ServiceException, SQLException {
		Connection connection = null;
		
		Edizione ed = null;
		EdizioneDTO edDTO = null;
		List<Feedback> listaFeedback = new ArrayList<>();
		List<Utente> listaUtentiIscritti = new ArrayList<>();
		
		try {
			connection = DataSource.getInstance().getConnection();
			
			ed = daoE.cercaPerId(connection, idEdizione);
			
			listaFeedback = daoF.cercaPerEdizione(connection, idEdizione);
			listaUtentiIscritti = daoU.cercaUtentiPerEdizione(connection, idEdizione);
			edDTO = new EdizioneDTO(ed,listaFeedback,listaUtentiIscritti);
			
			connection.commit();
						
		} catch (DAOException e) {
			
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

		return edDTO;
	}
	
	public List<Edizione> visualizzaEdizioniPerUtente(long idUtente) throws ServiceException, SQLException {
		Connection connection = null;
		
		Edizione ed = null;
		List<Edizione> listaEdizioniUtente = new ArrayList<>();
		
		try {
			connection = DataSource.getInstance().getConnection();
			
			listaEdizioniUtente = daoU.cercaIscrizioniUtente(connection, idUtente);
			
			connection.commit();
						
		} catch (DAOException e) {
			
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

		return listaEdizioniUtente;
	}
	
	public Edizione leggiEdizione(long idEdizione) throws Exception {
		Connection connection = null;
		 
		connection = DataSource.getInstance().getConnection();
		Edizione ed = daoE.cercaPerId(connection, idEdizione);
		connection.commit();
		return ed;
	}


	public static ServiceEdizione getInstance() {
		if (instance == null) {
			instance = new ServiceEdizione();
		}
		return instance;
	}

}
