package mine.OOP;

import java.sql.SQLException;
import java.util.List;

public interface IPostDAO {
	public List<Post> getAllPosts() throws ClassNotFoundException, SQLException;
}
