package mine.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.OOP.*;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IPostDAO postDao = PostDAO.getInstance();
		List<Post> posts;
		try {
			posts = postDao.getAllPosts();
		} catch (ClassNotFoundException e) {
			request.getSession().setAttribute("Error", "Something went wrong,please try again later");
			response.sendRedirect("./ErrorServlet");
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			request.getSession().setAttribute("Error",
					"We are encountering problems with our database,please try again later");
			response.sendRedirect("./ErrorServlet");
			e.printStackTrace();
			return;
		}
		response.setContentType("text/html");
		String title = posts.get(1).getTitle();
		String image = posts.get(1).getImage();

		response.getWriter().println("<h1>" + title + "</h1>");
		response.getWriter().println("<img src'" + image + "'/>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
