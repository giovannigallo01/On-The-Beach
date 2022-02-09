package it.unical.ingsw.onthebeach;

import it.unical.ingsw.onthebeach.persistenza.dao.*;
import it.unical.ingsw.onthebeach.persistenza.dao.jdbc.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static Database instance = null;
	Connection conn;

	public static Database getInstance() {
		if(instance == null)
			instance = new Database();
		return instance;
	}
	private Database() {
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GestoreLido2", "postgres", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public LidoDao getLidoDao() throws SQLException {
		return new LidoDaoJDBC(conn);
	}
	
	public PrenotazioneDao getPrenotazioneDao() throws SQLException {
		return new PrenotazioneDaoJDBC(conn);
	}
	
	public UtenteDao getUtenteDao() throws SQLException{
		return new UtenteDaoJDBC(conn);
	}

	public RecensioneDao getRecensioneDao() throws SQLException{
		return new RecensioneDaoJDBC(conn);
	}
	public OmbrelloneDao getOmbrelloneDao() throws SQLException{
		return new OmbrelloneDaoJDBC(conn);
	}
}
