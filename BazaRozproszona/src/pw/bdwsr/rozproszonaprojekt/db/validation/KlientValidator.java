package pw.bdwsr.rozproszonaprojekt.db.validation;

public class KlientValidator {
	public static boolean validatePesel(String pesel){
		if (pesel.length() == 11){
			try{
				Integer.parseInt(pesel);
				return true;
			}
			catch(Exception e){
				return false;
			}
		}
		else return false;
	}
	
	public static boolean validateImie(String imie){
		
		return true;
	}
	
	public static boolean validateNazwisko(String nazwisko){
		return true;
	}
	
	public static boolean validateUlicaZamieszkania(String ulicaZamieszkania){
		return true;
	}
	
	public static boolean validateNumerDomu(String numerDomu){
		return true;
	}
	
	public static boolean validateNumerMieszkania(String numerMieszkania){
		return true;
	}

	public static boolean validateNumerTelefonu(String numerTelefonu){
		return true;
	}
	
	public static boolean validateNumerDowoduOsobistego(String numerDowoduOsobistego){
		return true;
	}
	
	public static boolean validateNumerPaszportu(String numerPaszportu){
		return true;
	}
	
}