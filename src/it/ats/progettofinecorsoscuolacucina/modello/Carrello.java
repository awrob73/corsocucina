package it.ats.progettofinecorsoscuolacucina.modello;

import java.util.ArrayList;

/*
 * Rappresenta il carrello di acquisto da parte di un utente. 
 * L'utente può acquistare una o più partecipazioni ad una edizione di un corso
 */
public class Carrello {

	private ArrayList<Edizione> edizioniAcquistate = new ArrayList<Edizione>();

	/*
	 * Aggiunge una edizione nel carrello. Se l'edizione già è presente nel carrello
	 * questa non va aggiunta
	 */
	public void aggiungiEdizione(Edizione e) {
		// TODO Auto-generated method stub
	}

	/*
	 * Elimina una edizione nel carrello. Se l'edizione non è presente nel carrello
	 * non si sollava una eccezione
	 */
	public void rimuoviEdizione(Edizione e) {
		// TODO Auto-generated method stub
	}

	/*
	 * Legge una edizione presente nel carrello in base all'id. Se l'edizione non
	 * esiste il metodo torna null
	 */
	public Edizione getEdizione(int idEdizione) {
		// TODO Auto-generated method stub

		return null;
	}

	/*
	 * Recupera tutte le edizioni presenti nel carrello
	 */
	public ArrayList<Edizione> getEdizioniAcquistate() {
		// TODO Auto-generated method stub

		return null;
	}

	/*
	 * Il metodo ritorna il costo totale delle edizioni presenti nel carrello
	 */
	public double getCostoTotale() {
		// TODO Auto-generated method stub

		return 0.0;
	}

	@Override
	public String toString() {
		return "Carrello [edizioniAcquistate=" + edizioniAcquistate + "]";
	}

}
