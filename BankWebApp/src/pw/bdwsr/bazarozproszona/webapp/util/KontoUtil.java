package pw.bdwsr.bazarozproszona.webapp.util;

public class KontoUtil {
	public static String generateAccountNumber(String pesel){
		char[] peselArray = pesel.toCharArray();
		String nrKonta = "";
		for(int i = 0; i < peselArray.length; i++){
			nrKonta += peselArray[i];
			if(i % 4  == 0)
				nrKonta += '-';
		}
		return nrKonta;
	}
}
