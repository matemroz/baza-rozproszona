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
import pw.bdwsr.bazarozproszona.webapp.util.WebAppUtil;
import pw.bdwsr.rozproszonaprojekt.db.dao.MongoKlientDAO;
import pw.bdwsr.rozproszonaprojekt.db.dao.OracleKontoDAO;
import pw.bdwsr.rozproszonaprojekt.db.dao.OracleRodzajKontaDAO;
import pw.bdwsr.rozproszonaprojekt.validators.KlientValidator;
import pw.bdwsr.rozproszonaprojekt.validators.KontoValidator;
import pw.bdwsr.rozproszonaprojekt.domain.Klient;
import pw.bdwsr.rozproszonaprojekt.domain.Konto;
import pw.bdwsr.rozproszonaprojekt.domain.RodzajKonta;

/**
 * Servlet implementation class SearchClientProfileServlet
 */
public class SearchClientProfileServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1622685832956294323L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/SearchClientProfileForm.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nrKonta = request.getParameter("nrKonta");

		Konto konto = new Konto();
		Klient klient = new Klient();
		RodzajKonta rk = new RodzajKonta();

		MongoKlientDAO mkd = new MongoKlientDAO();
		OracleKontoDAO okd = new OracleKontoDAO();
		OracleRodzajKontaDAO rkd = new OracleRodzajKontaDAO();

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		if (okd != null && KontoValidator.validateNrKonta(nrKonta)) {
			konto = okd.getKontoInfo(nrKonta);
			if (mkd != null && konto != null) {
				String pesel = konto.getPesel();
				if (KlientValidator.validatePesel(pesel)) {
					klient = mkd.pobierzKlienta(pesel);
					int idRodzajuKonta = konto.getIdRodzajuKonta();
					if (KontoValidator.validateIdRodzajuKonta(Integer.toString(idRodzajuKonta))) {
						rk = rkd.getDaneRodzajuKonta(idRodzajuKonta);
						if (konto != null && klient != null && rk != null)
							printClientPersonalAndAccountData(response, writer,
									konto, klient, rk);
						else
							CommunicationsHelper.writeErrorCommunicate( writer,
											ErrorCommunications.PROBLEM_POBRANIE_DANYCH_KLIENTA);
					} else {
						CommunicationsHelper.writeErrorCommunicate(writer,
										ErrorCommunications.BLAD_WALIDACJI_IDRODZAJUKONTA);
					}
				} else {
					CommunicationsHelper.writeErrorCommunicate(writer,
							ErrorCommunications.BLAD_WALIDACJI_PESEL);
				}
			} else {
				CommunicationsHelper.writeErrorCommunicate(writer,
						ErrorCommunications.BLAD_TWORZENIE_OBIEKTKOW_DAO);
			}
		} else
			CommunicationsHelper.writeErrorCommunicate(writer,
					ErrorCommunications.PROBLEM_POBRANIE_DANYCH_KONTA);

	}

	private void printClientPersonalAndAccountData(
			HttpServletResponse response, PrintWriter writer, Konto konto,
			Klient klient, RodzajKonta rk) throws IOException {
		writer.write("<h1>Dane profilu klienta</h1>");
		writer.write("<br><br><h3>Dane personalne:</h3>");
		writer.write("<table>");
		WebAppUtil.printSimpleTableRow(writer, "Imię", klient.getImie());
		WebAppUtil.printSimpleTableRow(writer, "Nazwisko", klient.getNazwisko());
		WebAppUtil.printSimpleTableRow(writer, "Pesel", klient.getPesel());
		WebAppUtil.printSimpleTableRow(writer, "Ulica zamieszkania", klient.getUlicaZamieszkania());
		WebAppUtil.printSimpleTableRow(writer, "Numer domu", klient.getNumerDomu());
		WebAppUtil.printSimpleTableRow(writer, "Numer mieszkania", klient.getNumerMieszkania());
		WebAppUtil.printSimpleTableRow(writer, "Numer telefonu", klient.getNumerTelefonu());
		WebAppUtil.printSimpleTableRow(writer, "Numer dowodu osobistego", klient.getNumerDowoduOsobistego());
		WebAppUtil.printSimpleTableRow(writer, "Numer paszportu", klient.getNumerPaszportu());
		writer.write("</table>");
		writer.write("<br><br><h3>Dane konta bankowego</h3>");
		writer.write("<table>");
		WebAppUtil.printSimpleTableRow(writer, "Numer konta", konto.getNrKonta());
		WebAppUtil.printSimpleTableRow(writer, "Dostępne środki", Double.toString(konto.getSrodki()));
		WebAppUtil.printSimpleTableRow(writer, "Oprocentowanie", Double.toString(rk.getIdRodzajuKonta()));
		WebAppUtil.printSimpleTableRow(writer, "Kapitalizacja", Integer.toString(rk.getKapitalizacja()));
		WebAppUtil.printSimpleTableRow(writer, "Waluta", rk.getWaluta());
		WebAppUtil.printSimpleTableRow(writer, "Nazwa", rk.getNazwa());
		writer.write("</table>");
	}
}
