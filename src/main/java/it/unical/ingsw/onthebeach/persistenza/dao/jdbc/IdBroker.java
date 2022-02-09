package it.unical.ingsw.onthebeach.persistenza.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdBroker {

	public static long getId(Connection conn) {
		long id = 0;
		String query = "SELECT nextval('sequenza_id') AS id;";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			rs.next();
			id = rs.getLong("id");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
