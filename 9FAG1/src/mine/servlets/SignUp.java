package mine.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.OOP.AccDAO;
import mine.OOP.EmailTakenExeption;
import mine.OOP.NameTakenExeption;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<html><head><title>Login page</title></head><body>");
		response.getWriter().append("<form action='./SignUp' method='post'>");
		response.getWriter().append("<label Username :></label> ");
		response.getWriter().append("<h2>Username</h2> ");
		response.getWriter().append("<input type='text' name='username'>");
		response.getWriter().append("<br></br>");
		response.getWriter().append("<h2>Password</h2> ");
		response.getWriter().append("<label Password :></label> ");
		response.getWriter().append("<input type='password' name='password'>");
		response.getWriter().append("<br></br>");
		response.getWriter().append("<h2>Repeat password</h2> ");
		response.getWriter().append("<label Repeat password:></label> ");
		response.getWriter().append("<input type='password' name='repeatPassword'>");
		response.getWriter().append("<br></br>");
		response.getWriter().append("<h2>Email</h2> ");
		response.getWriter().append("<label Email:></label> ");
		response.getWriter().append("<input type='text' name='email'>");
		response.getWriter().append("<br></br>");
		response.getWriter().append("<input type='submit' value='Sign up'></form></body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatPass = request.getParameter("repeatPassword");
		String email = request.getParameter("email");


		if (password.equals(repeatPass)) {
			try {
				boolean register = AccDAO.register(username, password, email);
			} catch (SQLException e) {
				request.getSession().setAttribute("Error",
						"We are encountering problems with our database,please try again later");
				response.sendRedirect("./ErrorServlet");
				e.printStackTrace();
				return;
			} catch (EmailTakenExeption e) {
				request.getSession().setAttribute("Error", "Email is taken,try again ");
				response.sendRedirect("./ErrorServlet");
				e.printStackTrace();
				return;
			} catch (NameTakenExeption e) {
				request.getSession().setAttribute("Error", "Name is taken,try again ");
				response.sendRedirect("./ErrorServlet");
				e.printStackTrace();
				return;
			}
		} else {
			request.getSession().setAttribute("Error", "You must repeat password correctly");
		}

	}

}
