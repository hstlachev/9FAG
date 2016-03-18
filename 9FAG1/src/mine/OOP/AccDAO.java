package mine.OOP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccDAO {

	private static Connection getConnection() {
		DBConnection connection = DBConnection.getDB();
		Connection con = DBConnection.getCon();
		return con;
	}

	public static Account getAcc(String username, String password)
			throws InvalidUserNameOrPasswordExeption, SQLException {
		// if(1==1)
		// throw new InvalidUserNameOrPasswordExeption();
		Connection con = getConnection();
		PreparedStatement ps;
		int returned = -1;
		String email;

		ps = con.prepareStatement("SELECT name,password FROM account WHERE name=? AND password=?;");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		if (rs.next() == false) {
			throw new InvalidUserNameOrPasswordExeption();
		} else {
			returned = rs.getInt(1);
			email = rs.getString(3);
		}

		return new Account(returned, email, username, password);

	}

	public static boolean register(String username, String password, String email) throws SQLException, EmailTakenExeption, NameTakenExeption {
		PreparedStatement psName = getConnection().prepareStatement("SELECT name FROM account where name=?");
		psName.setString(1, username);
		ResultSet rsName=psName.executeQuery();
		if(rsName.next()==false){
			PreparedStatement psEmail = getConnection().prepareStatement("SELECT name FROM account where name=?");
			psEmail.setString(1, username);
			ResultSet rsEmail=psEmail.executeQuery();
			if(rsEmail.next()==false){
				PreparedStatement psInsert=getConnection().prepareStatement("INSERT INTO account VALUES(null,?,?,?)");
				psInsert.setString(1, username);
				psInsert.setString(2, email);
				psInsert.setString(3, password);
				psInsert.executeUpdate();	
				return true;
			}
			else{
				throw new EmailTakenExeption();
			}
		}
		else{
			throw new NameTakenExeption();
		}

	}

}
