package MFF.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

	static private Connection connection = null;

	static public void createConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/grupo4","grupo4","467");
			//connection = DriverManager.getConnection("jdbc:mysql://localhost/mff", "root", "passii");
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	static public Connection getConnection() {
	    if (connection==null) {
		createConnection();
	    }
	    return connection;
	}

	static public void closeConnection() {

		try {
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}

