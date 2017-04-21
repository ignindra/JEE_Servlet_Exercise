package servletPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Sample servlet", urlPatterns = { "/Servlet" })
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	private List<String> names = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("inputs", names);
		if (request.getParameter("deleteval") != null) {
			names.remove(Integer.parseInt(request.getParameter("deleteval")));
		}
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		names.add(getInput(request.getParameterValues("nama")));
		request.getSession().setAttribute("inputs", names);
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
	}
	
	private String getInput(String[] values) {
		String result = "";
		return result.join(" ", values);
	}
}