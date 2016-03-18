package mine.OOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PostDAO implements IPostDAO {
	private static IPostDAO instance;

	private PostDAO() {

	}

	public synchronized static IPostDAO getInstance() {
		if (instance == null) {
			instance = new PostDAO();
		}
		return instance;
	}

	@Override
	public List<Post> getAllPosts() throws ClassNotFoundException, SQLException {
		List<Post> posts = new ArrayList<Post>();
			Connection con = getConnection();
			PreparedStatement ps;
			ps = con.prepareStatement("SELECT * from posts");
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				posts.add(new Post(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4),result.getString(6)));
			}

			return posts;
		
		
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		DBConnection connection = DBConnection.getDB();
		Connection con = DBConnection.getCon();
		return con;
	}
}
