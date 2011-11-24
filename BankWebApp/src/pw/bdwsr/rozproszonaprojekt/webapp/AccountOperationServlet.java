package pw.bdwsr.rozproszonaprojekt.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pw.bdwsr.rozproszonaprojekt.db.dao.MongoKlientDAO;
import pw.bdwsr.rozproszonaprojekt.db.dao.OracleKontoDAO;
import pw.bdwsr.rozproszonaprojekt.domain.Klient;

/**
 * Servlet implementation class AccountOperationServlet
 */
public class AccountOperationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6522692608314035083L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/AccountOperationsForm.jsp");
		rd.forward(req, resp);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imie = request.getParameter("imie");
		String srodki = request.getParameter("srodki");
		
		OracleKontoDAO okd = new OracleKontoDAO();
		MongoKlientDAO mkd = new MongoKlientDAO();

		List<Klient> listaKlientow = mkd.pobierzKlientowNaPodstawieKryterium(imie);
		Iterator it = listaKlientow.iterator();
		
		while(it.hasNext()){
			Klient klient = (Klient)it.next();
			
		}
		
		response.setContentType("text/html");
 
		PrintWriter writer = response.getWriter();
	}
}
