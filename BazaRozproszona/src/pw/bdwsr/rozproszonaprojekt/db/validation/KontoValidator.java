package pw.bdwsr.rozproszonaprojekt.db.validation;

import pw.bdwsr.rozproszonaprojekt.domain.RodzajKonta;

public class KontoValidator {

	public static boolean validateNrKonta(String nrKonta) {
		if (nrKonta.length() != 26)
			return false;

		if (!nrKonta.matches("[0-9]{26}"))
			return false;
		return true;
	}

	public static boolean validateSrodki(double srodki) {
		if (srodki >= 0)
			return true;
		return false;
	}

	public static boolean validateIdRodzajuKonta(String rodzajKonta) {
		
		return true;
	}

}
