package pw.bdwsr.rozproszonaprojekt.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchClientProfileServlet
 */
public class SearchClientProfileServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1622685832956294323L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/SearchClientProfileForm.jsp");
		rd.forward(req, resp);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nrKonta = request.getParameter("nrKonta");
 
		response.setContentType("text/html");
 
		PrintWriter writer = response.getWriter();		
		writer.write(nrKonta);
	}
}
