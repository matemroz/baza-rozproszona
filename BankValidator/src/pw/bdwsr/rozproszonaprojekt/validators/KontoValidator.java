package pw.bdwsr.rozproszonaprojekt.validators;

//import pw.bdwsr.rozproszonaprojekt.domain.RodzajKonta;

public class KontoValidator {

	public static boolean validateNrKonta(String nrKonta) {
		if (nrKonta.length() != 26)
			return false;

		if (!nrKonta.matches("[0-9]{26}"))
			return false;
		return true;
	}

	public static boolean validateSrodki(String srodki) {
		if (srodki.isEmpty() || srodki == null) {
			return false;
		}
		Double dSrodki = Double.parseDouble(srodki);
		if (dSrodki >= 0)
			return true;
		return false;
	}

	public static boolean validateIdRodzajuKonta(String rodzajKonta) {
		
		return true;
	}

}
