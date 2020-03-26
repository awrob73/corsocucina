package it.ats.progettofinecorsoscuolacucina.modello.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import it.ats.progettofinecorsoscuolacucina.modello.dao.eccezioni.DAOException;

public class DataSource {

	private static Properties dbProperties;
	private static String url;
	private static Driver dbDriver;
	private static DataSource instance;

	private DataSource() {
		super();
		this.load();
		// TODO Auto-generated constructor stub
	}

	private void load() {
		try {
			dbProperties = new Properties();
			InputStream inputStream = DataSource.class.getClassLoader().getResourceAsStream("jdbc.properties");
			dbProperties.load(inputStream);
			dbDriver = (Driver) Class.forName(dbProperties.getProperty("DriverClassName")).newInstance();
			url = dbProperties.getProperty("url");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws DAOException {
		Connection connection;
		try {
			connection = dbDriver.connect(url, dbProperties);
			if(connection == null) {
				instance.getConnection();
			}
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return connection;
	}

	public void close(Connection connection) throws DAOException {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException sqle) {
			// sqle.printStackTrace();
			throw new DAOException("Errore database");
		}
	}

	public void close(Statement statement) throws DAOException {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException sqle) {
			// sqle.printStackTrace();
			throw new DAOException("Errore database");
		}
	}

	public void close(ResultSet resultSet) throws DAOException {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException sqle) {
			// sqle.printStackTrace();
			throw new DAOException("Errore database");
		}
	}

	public static DataSource getInstance() {
		if (instance == null) {
			instance = new DataSource();
		}
		return instance;
	}
}
