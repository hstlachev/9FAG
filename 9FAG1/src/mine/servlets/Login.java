package mine.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mine.OOP.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setContentType("text/html");
		response.getWriter().append("<html><head><title>Login page</title></head><body>");
		response.getWriter().append("<form action='./Login' method='post'>");
		response.getWriter().append("<label Username :></label> ");
		response.getWriter().append("<h2>Username</h2> ");
		response.getWriter().append("<input type='text' name='username'>");
		response.getWriter().append("<br></br>");
		response.getWriter().append("<h2>Password</h2> ");
		response.getWriter().append("<label Password :></label> ");
		response.getWriter().append("<input type='password' name='password'>");
		response.getWriter().append("<br></br>");
		response.getWriter().append("<input type='submit' value='Login'></form></body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account acc = null;
		try {
			acc = AccDAO.getAcc(username, password);
		} catch (InvalidUserNameOrPasswordExeption e) {
			request.getSession().setAttribute("Error", "Invalid username or password");
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
		request.getSession().setAttribute("Account", acc);
		response.sendRedirect("./home");
		return;

	}

}
