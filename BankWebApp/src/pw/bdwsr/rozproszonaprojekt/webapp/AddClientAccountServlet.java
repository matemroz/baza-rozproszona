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
 * Servlet implementation class AddClientAccount
 */
public class AddClientAccountServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3069725355821798452L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/AddClientAccountForm.jsp");
		rd.forward(req, resp);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imie = request.getParameter("imie");
		String nazwisko = request.getParameter("nazwisko");
		String ulicaZamieszkania = request.getParameter("ulicaZamieszkania");
		String nrDomu = request.getParameter("nrDomu");
		String nrMieszkania = request.getParameter("nrMieszkania");
		String nrTelefonu = request.getParameter("nrTelefonu");
		String nrDowoduOsobistego = request.getParameter("nrDowoduOsobistego");
		String nrPaszportu = request.getParameter("nrPaszportu");
		String miasto = request.getParameter("miasto");
		String srodkiInicjalne = request.getParameter("srodkiInicjalne");
		String rodzajKonta = request.getParameter("rodzajKonta");
		
		response.setContentType("text/html");
 
		PrintWriter writer = response.getWriter();		
	}

}
