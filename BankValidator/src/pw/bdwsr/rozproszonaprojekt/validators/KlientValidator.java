package pw.bdwsr.rozproszonaprojekt.db.validation;

public class KlientValidator {

	public static boolean validatePesel(String pesel) {
		if (pesel.length() == 11) {
			try {
				Long.parseLong(pesel);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else
			return false;
	}

	public static boolean validateImie(String imie) {
		if (imie.length() <= 0)
			return false;

		if (!imie.matches("^[a-zA-ZąćęłńóśźĄĆĘŁŃÓŚŹ]{2,20}$"))
			return false;

		return true;
	}

	/**
	 * Dwuczłonowe nazwiska nie są przyjmowane
	 * 
	 * @param nazwisko
	 * @return
	 */

	public static boolean validateNazwisko(String nazwisko) {
		if (nazwisko.length() <= 0)
			return false;

		if (!nazwisko.matches("^[a-zA-ZąćęłńóśźĄĆĘŁŃÓŚŹ-]{2,20}$"))
			return false;
		return true;

	}

	public static boolean validateUlicaZamieszkania(String ulicaZamieszkania) {
		if (ulicaZamieszkania.length() <= 0)
			return false;

		if (!ulicaZamieszkania
				.matches("[a-zA-Z0-9ąćęłńóśźĄĆĘŁŃÓŚŹ\\s-]{2,30}$"))
			return false;
		return true;
	}

	public static boolean validateNumerDomu(String numerDomu) {
		if (numerDomu.length() <= 0)
			return false;
		try {
			Integer.parseInt(numerDomu);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean validateNumerMieszkania(String numerMieszkania) {
		if (numerMieszkania.length() <= 0)
			return false;

		if (!numerMieszkania.matches("^[0-9]{1,4}[a-zA-Z]{0,1}$"))
			return false;
		return true;
	}

	/**
	 * Numer telefonu w formacie kierunkowy numer własciwy (np 221234567)
	 * 
	 * @param numerTelefonu
	 * @return
	 */
	public static boolean validateNumerTelefonu(String numerTelefonu) {
		if ((numerTelefonu.length() != 9) && (numerTelefonu.length() != 10))
			return false;

		if (!numerTelefonu.matches("^[0-9]{0,2}[//s]{0,1}[0-9]{0,7}$"))
			return false;
		return true;
	}

	public static boolean validateNumerDowoduOsobistego(
			String numerDowoduOsobistego) {
		if (numerDowoduOsobistego.length() != 9)
			return false;

		if (!numerDowoduOsobistego.matches("^[a-zA-Z]{3}[0-9]{6}$"))
			return false;
		return true;
	}

	public static boolean validateNumerPaszportu(String numerPaszportu) {
		if (numerPaszportu.length() != 9)
			return false;

		if (!numerPaszportu.matches("^[a-zA-Z]{2}[0-9]{7}$"))
			return false;
		return true;
	}

}
