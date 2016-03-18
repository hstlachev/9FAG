package mine.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = (String) request.getSession().getAttribute("Error");
		response.setContentType("text/html");
		response.getWriter().append("<!DOCTYPE html><html>");
		response.getWriter().append(
				"<body background='https://cdn.elegantthemes.com/blog/wp-content/uploads/2014/02/error_thumb.jpg'>");
		response.getWriter().append("<h1>");
		response.getWriter().append(error);
		response.getWriter().append("</h1></body></html>");
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
