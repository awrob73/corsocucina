package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Edizione;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOEdizione;
import it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;

public class ServiceEdizione {

	private static ServiceEdizione instance;
	// Dichiarare qui tutti i DAO di cui si ha bisogno
	private DAOEdizione daoC;
	// ... dichiarazione di altri DAO

	// Inizializzare / richiamare qui tutti i DAO di cui si ha bisogno
	private ServiceEdizione() {
		this.daoC = DAOEdizione.getInstance();
		// ... costruzione di altri DAO
	}

	/*
	 * Inserisce una nuova edizione
	 */
	public void inserisciEdizione(Edizione e) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Modifica tutti i dati di una edizione esistente
	 */
	public void modificaEdizione(Edizione e) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Cancella una edizione esistente. E' possibile cancellare una edizione
	 * soltanto se la data di inizio è antecedente a quella odierna. Nel caso in cui
	 * l'edizione sia cancellabile, è necessario cancellare l'iscrizione a tutti gli
	 * utenti iscritti
	 */
	public void cancellaEdizione(long idEdizione) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Iscrive un utente ad una edizione un utente. Si può iscrivere solo se ci sono
	 * ancora posti disponibili considerato che ogni corso ha un numero massimo di
	 * partecipanti
	 */
	public void iscriviUtente(long idEdizione, long idUtente) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Cancella l'iscrizione ad un utente
	 */
	public void cancellaIscrizioneUtente(long idEdizione, long idUtente) throws ServiceException {
		// TODO Auto-generated method stub

	}

	/*
	 * Il metodo ritorna tutte le edizioni con relativi utenti e feedback dei corsi
	 * in calendario nel mese indicato dell'anno corrente. Se il metodo / i metodi
	 * del / dei DAO invocati sollevano una eccezione, il metodo deve tornare una
	 * eccezione
	 */
	public List<EdizioneDTO> visualizzaEdizioniPerMese(int mese) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Il metodo ritorna tutte le edizioni con relativi utenti e feedback dei corsi
	 * in calendario nel mese indicato dell'anno corrente. Se il metodo / i metodi
	 * del / dei DAO invocati sollevano una eccezione, il metodo deve tornare una
	 * eccezione
	 */
	public List<EdizioneDTO> visualizzaEdizioniPerAnno(int anno) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Il metodo ritorna tutte le edizioni con relativi utenti e feedback del corso
	 * specificato presenti in calendario nell'anno corrente a partire dalla data
	 * odierna. Se il metodo / i metodi del / dei DAO invocati sollevano una
	 * eccezione, il metodo deve tornare una eccezione
	 */
	public List<EdizioneDTO> visualizzaEdizioniPerCorso(long idCorso) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Il metodo ritorna tutte le edizioni dei corsi, relativi utenti e feedbacks in
	 * calendario dell'anno corrente a partire dalla data odierna. Se il metodo / i
	 * metodi del / dei DAO invocati sollevano una eccezione, il metodo deve tornare
	 * una eccezione
	 */
	public EdizioneDTO visualizzaEdizione(long idEdizione) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public static ServiceEdizione getInstance() {
		if (instance == null) {
			instance = new ServiceEdizione();
		}
		return instance;
	}

}
