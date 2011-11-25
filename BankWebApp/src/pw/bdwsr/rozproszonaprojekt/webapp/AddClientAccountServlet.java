package pw.bdwsr.rozproszonaprojekt.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pw.bdwsr.bazarozproszona.webapp.util.CommunicationsHelper;
import pw.bdwsr.bazarozproszona.webapp.util.ErrorCommunications;
import pw.bdwsr.bazarozproszona.webapp.util.KontoUtil;
import pw.bdwsr.bazarozproszona.webapp.util.SuccessCommunications;
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

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/AddClientAccountForm.jsp");
		rd.forward(req, resp);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String imie = request.getParameter("imie");
		String nazwisko = request.getParameter("nazwisko");
		String ulicaZamieszkania = request.getParameter("ulicaZamieszkania");
		String nrDomu = request.getParameter("nrDomu");
		String nrMieszkania = request.getParameter("nrMieszkania");
		String nrTelefonu = request.getParameter("nrTelefonu");
		String nrDowoduOsobistego = request.getParameter("nrDowoduOsobistego");
		String nrPaszportu = request.getParameter("nrPaszportu");
		String pesel = request.getParameter("pesel");
		String srodkiInicjalne = request.getParameter("srodkiInicjalne");
		String idRodzajuKonta = request.getParameter("rodzajKonta");
		
		Konto konto = new Konto();
		Klient klient = new Klient();
		
		MongoKlientDAO mkd = new MongoKlientDAO();
		OracleKontoDAO okd = new OracleKontoDAO();
		
		response.setContentType("text/html");
		
		PrintWriter writer = response.getWriter();
		
		if(KlientValidator.validateImie(imie) 
				&& KlientValidator.validateNazwisko(nazwisko)
				&& KlientValidator.validateNumerDomu(nrDomu) 
				&& KlientValidator.validateUlicaZamieszkania(ulicaZamieszkania)
				&& KlientValidator.validateNumerMieszkania(nrMieszkania) 
				&& KlientValidator.validateNumerTelefonu(nrTelefonu)
				&& KlientValidator.validateNumerDowoduOsobistego(nrDowoduOsobistego)
				&& KlientValidator.validateNumerPaszportu(nrPaszportu)
				&& KlientValidator.validatePesel(pesel)
				&& KontoValidator.validateSrodki(Double.parseDouble(srodkiInicjalne))
				&& KontoValidator.validateIdRodzajuKonta(idRodzajuKonta)
				&& mkd != null && okd != null
				&& klient != null && konto != null){
			
			klient.setImie(imie);
			klient.setNazwisko(nazwisko);
			klient.setNumerDomu(nrDomu);
			klient.setUlicaZamiekszania(ulicaZamieszkania);
			klient.setNumerMieszkania(nrMieszkania);
			klient.setNumerTelefonu(nrTelefonu);
			klient.setNumerDowoduOsobistego(nrDowoduOsobistego);
			klient.setNumerPaszportu(nrPaszportu);
			klient.setPesel(pesel);
			konto.setNrKonta(KontoUtil.generateAccountNumber(pesel));
			konto.setSrodki(Double.parseDouble(srodkiInicjalne));
			konto.setIdRodzajuKonta(Integer.parseInt(idRodzajuKonta));
			konto.setPesel(pesel);
			
			if(mkd.dodajKlienta(klient) && okd.addKonto(konto))
				CommunicationsHelper.writeErrorCommunicate(writer,
						SuccessCommunications.POWODZENIE_DODANIE_PROFILU_KLIENTA);
			else
				CommunicationsHelper.writeErrorCommunicate(writer,
						ErrorCommunications.BLAD_DODAWANIA_NOWEGO_PROFILU_KLIENTA);
		}else{
			CommunicationsHelper.writeErrorCommunicate(writer,
					ErrorCommunications.NIEPOPRAWNE_DANE_FORMULARZA_DODAWANIA_KLIENTA);
		}
	}
}
