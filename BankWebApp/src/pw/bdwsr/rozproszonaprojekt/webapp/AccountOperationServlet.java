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

import pw.bdwsr.bazarozproszona.webapp.util.CommunicationsHelper;
import pw.bdwsr.bazarozproszona.webapp.util.ErrorCommunications;
import pw.bdwsr.bazarozproszona.webapp.util.SuccessCommunications;
import pw.bdwsr.rozproszonaprojekt.db.dao.MongoKlientDAO;
import pw.bdwsr.rozproszonaprojekt.db.dao.OracleKontoDAO;
import pw.bdwsr.rozproszonaprojekt.db.validation.KlientValidator;
import pw.bdwsr.rozproszonaprojekt.db.validation.KontoValidator;
import pw.bdwsr.rozproszonaprojekt.domain.Klient;

/**
 * Servlet implementation class AccountOperationServlet
 */
public class AccountOperationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6522692608314035083L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/AccountOperationsForm.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Double srodki = Double.parseDouble(request.getParameter("srodki"));
		
		OracleKontoDAO okd = new OracleKontoDAO();
		MongoKlientDAO mkd = new MongoKlientDAO();

		Klient klientKryterium = new Klient();
		klientKryterium.setImie("Anna");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		if (klientKryterium != null && KlientValidator.validateImie(klientKryterium.getImie()) 
				&& KontoValidator.validateSrodki(srodki)){
			if(mkd != null && okd != null) {
				List<Klient> listaKlientow = mkd.pobierzKlientowNaPodstawieKryterium(klientKryterium);
				if(listaKlientow != null){
					Iterator<Klient> it = listaKlientow.iterator();
					while (it.hasNext()) {
						Klient klient = (Klient) it.next();
						if (klient != null) {
							String pesel = klient.getPesel();
							if(KlientValidator.validatePesel(pesel)){
								if(okd.wplacPieniedze(pesel, srodki))
									CommunicationsHelper.writeSuccessCommunicate(writer, 
										SuccessCommunications.POWODZENIE_DODANIA_PIENIEDZY_KLIENTOM);
								else
									CommunicationsHelper.writeErrorCommunicate(writer, 
										ErrorCommunications.NIEPOPRAWNE_DODAWANIE_PIENIEDZY_NA_KONTA_KLIENTOW);
							}else{
								CommunicationsHelper.writeErrorCommunicate(writer, 
									ErrorCommunications.BLAD_WALIDACJI_PESEL);
							}
						}else{
							CommunicationsHelper.writeErrorCommunicate(writer, "Instancja klient nie może być null!");
						}
					}
				}else{
					CommunicationsHelper.writeErrorCommunicate(writer, 
							"Instancja listaKlientow nie może być null!");
				}
			}else{
				CommunicationsHelper.writeErrorCommunicate(writer, 
						ErrorCommunications.BLAD_TWORZENIE_OBIEKTKOW_DAO);
			}
		}
	
	}
	
}