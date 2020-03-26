package it.ats.progettofinecorsoscuolacucina.modello.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import it.ats.progettofinecorsoscuolacucina.modello.Categoria;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DAOCategoria;
import it.ats.progettofinecorsoscuolacucina.modello.dao.DataSource;
import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;
import it.ats.progettofinecorsoscuolacucina.modello.service.eccezioni.ServiceException;


public class ServiceCategoria {
	
	private static ServiceCategoria instance;
	// Dichiarare qui tutti i DAO di cui si ha bisogno
	private DAOCategoria daoC;

	// Inizializzare / richiamare qui tutti i DAO di cui si ha bisogno
	private ServiceCategoria() {
		super();
		this.daoC = DAOCategoria.getInstance();
	}
	
	public void aggiungiCategoria(String descrizione)  throws ServiceException {
		
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			daoC.inserisci(connection, descrizione);
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
	
	public void modificaCategoria(Categoria c)  throws ServiceException {
		
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			daoC.modifica(connection, c);;
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

	public void cancellaCategoria(long idCategoria)  throws ServiceException {
		
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			daoC.cancella(connection, idCategoria);;
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
	
	public Categoria cercaCategoriaId(long idCategoria)  throws ServiceException {
		
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			Categoria c = daoC.cercaPerId(connection, idCategoria);
			return c;
			
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
	
	public List<Categoria> cercaTutteCategorie()  throws ServiceException {
		
		Connection connection = null;
		try {
			connection = DataSource.getInstance().getConnection();
			List<Categoria> listCategoria = daoC.cercaTutte(connection);
			return listCategoria;
			
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
}
