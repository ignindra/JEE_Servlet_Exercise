package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Sample servlet", urlPatterns = { "/Servlet" })
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Test");
		String searchTerm = request.getParameter("searchTerm");
		PrintWriter write = response.getWriter();
		write.println("You searched for..."+searchTerm);
	}
}