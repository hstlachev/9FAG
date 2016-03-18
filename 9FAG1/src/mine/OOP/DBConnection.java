package mine.OOP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBConnection {
	private static final String DB_USER = "root";
	private static final String DB_PASS = "52659093";
	private static final String DB_NAME = "mydb";
	private static final String DB_PORT = "3306";
	private static final String DB_HOST = "localhost";


	private static DBConnection instance = null;
	private static Connection con;

	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME+"?autoReconnect=true&useSSL=false", DB_USER,
					DB_PASS);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static synchronized DBConnection getDB() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	public static Connection getCon() {
		return con;

	}

}
