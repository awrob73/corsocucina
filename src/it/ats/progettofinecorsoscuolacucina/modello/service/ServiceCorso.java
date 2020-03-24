package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Categoria;
import it.ats.progettofinecorsoscuolacucina.modello.Corso;
import it.ats.progettofinecorsoscuolacucina.modello.Feedback;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOCorso;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DataSource;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;
import it.ats.progettofinecorsoscuolacucina.modello.dto.CorsoDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;

public class ServiceCorso {

	private static ServiceCorso instance;
	// Dichiarare qui tutti i DAO di cui si ha bisogno
	private DAOCorso daoC;

	// Inizializzare / richiamare qui tutti i DAO di cui si ha bisogno
	private ServiceCorso() {
		this.daoC = DAOCorso.getInstance();
		// ... costruzione dei altri dao
	}

	/*
	 * Il metodo mostra tutti i corsi offerti dalla scuola. Se il metodo / i metodi
	 * del / dei DAO invocati sollevano una eccezione, il metodo deve tornare una
	 * eccezione
	 */
	public List<Corso> visualizzaCatalogoCorsi() throws ServiceException {
		Connection connection = null;
		List<Corso> listaCorsi = new ArrayList<>();
		try {
			connection = DataSource.getInstance().getConnection();
			listaCorsi = daoC.cercaTutti(connection);
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
		return listaCorsi;
	}

	/*
	 * Il metodo mostra l'elenco dei corsi di una certa categorie. Se il metodo / i
	 * metodi del / dei DAO invocati sollevano una eccezione, il metodo deve tornare
	 * una eccezione
	 */
	public List<Corso> visualizzaCorsiPerCategoria(int idCategoria) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Lettura di tutte le categorie. Se il metodo / i metodi del / dei DAO invocati
	 * sollevano una eccezione, il metodo deve tornare una eccezione
	 */
	public List<Categoria> visualizzaCategorie() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Il metodo (invocabile solo da un amministratore) crea una nuova categoria. Se
	 * il metodo / i metodi del / dei DAO invocati sollevano una eccezione, il
	 * metodo deve tornare una eccezione
	 */
	public void creaNuovaCategoria(String descrizione) throws ServiceException {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Modifica tutti i dati di un corso. Se il metodo / i metodi del / dei DAO
	 * invocati sollevano una eccezione, il metodo deve tornare una eccezione
	 */
	public void modificaDatiCorso(Corso corso) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Inserisce un nuovo corso a catalogo (invocabile solo dall'amministratore). Se
	 * il metodo / i metodi del / dei DAO invocati sollevano una eccezione, il
	 * metodo deve tornare una eccezione
	 */
	public void inserisciCorso(Corso corso) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Cancella un singolo corso dal catalogo dei corsi. Se il metodo / i metodi del
	 * / dei DAO invocati sollevano una eccezione, il metodo deve tornare una
	 * eccezione
	 */
	public void cancellaCorso(long idCorso) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Legge i dati di un singolo corso (senza edizioni). Se il metodo / i metodi
	 * del / dei DAO invocati sollevano una eccezione, il metodo deve tornare una
	 * eccezione
	 */
	public Corso visualizzaCorso(long idCorso) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public static ServiceCorso getInstance() {
		if (instance == null) {
			instance = new ServiceCorso();
		}
		return instance;
	}

}
