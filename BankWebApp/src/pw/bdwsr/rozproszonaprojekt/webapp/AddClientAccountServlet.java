package pw.bdwsr.rozproszonaprojekt.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pw.bdwsr.rozproszonaprojekt.db.dao.MongoKlientDAO;
import pw.bdwsr.rozproszonaprojekt.db.dao.OracleKontoDAO;
import pw.bdwsr.rozproszonaprojekt.db.validation.KlientValidator;
import pw.bdwsr.rozproszonaprojekt.db.validation.KontoValidator;
import pw.bdwsr.rozproszonaprojekt.domain.Klient;
import pw.bdwsr.rozproszonaprojekt.domain.Konto;

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
		String srodkiInicjalne = request.getParameter("srodkiInicjalne");
		String idRodzajuKonta = request.getParameter("rodzajKonta");
		
		Konto konto = new Konto();
		Klient klient = new Klient();
		
		if(KlientValidator.validateImie(imie))
			klient.setImie(imie);
		
		if(KlientValidator.validateNazwisko(nazwisko))
			klient.setNazwisko(nazwisko);
		
		if(KlientValidator.validateNumerDomu(nrDomu))
			klient.setNumerDomu(nrDomu);
		
		if(KlientValidator.validateUlicaZamieszkania(ulicaZamieszkania))
			klient.setUlicaZamiekszania(ulicaZamieszkania);
		
		if(KlientValidator.validateNumerMieszkania(nrMieszkania))
			klient.setNumerMieszkania(nrMieszkania);
		
		if(KlientValidator.validateNumerTelefonu(nrTelefonu))
			klient.setNumerTelefonu(nrTelefonu);
		
		if(KlientValidator.validateNumerDowoduOsobistego(nrDowoduOsobistego))
			klient.setNumerDowoduOsobistego(nrDowoduOsobistego);
		
		if(KlientValidator.validateNumerPaszportu(nrPaszportu))
			klient.setNumerPaszportu(nrPaszportu);
		
		if(KontoValidator.validateSrodki(Double.parseDouble(srodkiInicjalne)))
			konto.setSrodki(Double.parseDouble(srodkiInicjalne));
		
		if(KontoValidator.validateIdRodzajuKonta(idRodzajuKonta))
			konto.setIdRodzajuKonta(Integer.parseInt(idRodzajuKonta));
		
		MongoKlientDAO mkd = new MongoKlientDAO();
		OracleKontoDAO okd = new OracleKontoDAO();
		
		if(mkd != null && okd != null){
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			if(mkd.dodajKlienta(klient) && okd.addKonto(konto))
				printSuccessAddProfilKlienta(response, writer);
			else
				printFailureAddProfilKlienta(response, writer);
		}
	}

	private void printSuccessAddProfilKlienta(HttpServletResponse response, 
			PrintWriter writer) throws IOException{
		writer.write("Dodanie nowego profilu klienta przebieg�o pomy�lnie!");
	}
	
	private void printFailureAddProfilKlienta(HttpServletResponse response, 
			PrintWriter writer) throws IOException{
		writer.write("Dodanie nowego proflilu klienta przebieg�o niepoprawnie.");
	}
	
}
