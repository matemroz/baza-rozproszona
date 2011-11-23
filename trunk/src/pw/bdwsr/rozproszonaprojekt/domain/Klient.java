package pw.bdwsr.rozproszonaprojekt.domain;

public class Klient {
	
	private String pesel;
	private String imie;
	private String nazwisko;
	private String ulicaZamieszkania;
	private String numerDomu;
	private String numerMieszkania;
	private String numerTelefonu;
	private String numerDowoduOsobistego;
	private String numerPaszportu;

	
	/*---SETTERY---*/
	
	public boolean setPesel( String s){
		if (s.isEmpty() || s == null){
			System.err.println("Nie podano argumentu funkcji");
			return false;
		}
		
		this.pesel = s;
		return true;
	}
	
	public boolean setImie( String s){
		if (s.isEmpty() || s == null){
			System.err.println("Nie podano argumentu funkcji");
			return false;
		}
		
		this.imie = s;
		return true;
	}
	
	public boolean setNazwisko( String s){
		if (s.isEmpty() || s == null){
			System.err.println("Nie podano argumentu funkcji");
			return false;
		}
		
		this.nazwisko = s;
		return true;
	}
	
	public boolean setUlicaZamiekszania( String s){
		if (s.isEmpty() || s == null){
			System.err.println("Nie podano argumentu funkcji");
			return false;
		}
		
		this.ulicaZamieszkania = s;
		return true;
	}
	
	public boolean setNumerDomu( String s){
		if (s.isEmpty() || s == null){
			System.err.println("Nie podano argumentu funkcji");
			return false;
		}
		
		this.numerDomu = s;
		return true;
	}
	
	public boolean setNumerMieszkania( String s){
		if (s.isEmpty() || s == null){
			System.err.println("Nie podano argumentu funkcji");
			return false;
		}
		
		this.numerMieszkania = s;
		return true;
	}
	
	public boolean setNumerTelefonu( String s){
		if (s.isEmpty() || s == null){
			System.err.println("Nie podano argumentu funkcji");
			return false;
		}
		
		this.numerTelefonu = s;
		return true;
	}
	
	public boolean setNumerDowoduOsobistego( String s){
		if (s.isEmpty() || s == null){
			System.err.println("Nie podano argumentu funkcji");
			return false;
		}
		
		this.numerDowoduOsobistego = s;
		return true;
	}
	
	public boolean setNumerPaszportu( String s){
		if (s.isEmpty() || s == null){
			System.err.println("Nie podano argumentu funkcji");
			return false;
		}
		
		this.numerPaszportu = s;
		return true;
	}
	
	/*---GETTERY---*/
	
	public String getPesel(){
		return this.pesel;
	}
	
	public String getImie(){
		return this.imie;
	}
	
	public String getNazwisko(){
		return this.nazwisko;
	}
	
	public String getUlicaZamieszkania(){
		return this.ulicaZamieszkania;
	}
	
	public String getNumerDomu(){
		return this.numerDomu;
	}
	
	public String getNumerMieszkania(){
		return this.numerMieszkania;
	}
	
	public String getNumerTelefonu(){
		return this.numerTelefonu;
	}
	
	public String getNumerDowoduOsobistego(){
		return this.numerDowoduOsobistego;
	}
	
	public String getNumerPaszportu(){
		return this.numerPaszportu;
	}
	
	public String toString(){
		return "{\n" +
			"PESEL : \"" + this.pesel + "\",\n" +
			"imie : \"" + this.imie + "\",\n" +
			"nazwisko : \"" + this.nazwisko + "\",\n" +
			"ulicaZamieszkania : \"" + this.ulicaZamieszkania + "\",\n" +
			"numerDomu : \"" + this.numerDomu + "\"\n" +
			"numerMieszkania : \"" + this.numerMieszkania + "\",\n" +
			"numerTelefonu : \"" + this.numerTelefonu + "\",\n" +
			"numerDowoduOs : \"" + this.numerDowoduOsobistego + "\",\n" +
			"numerPaszportu : \"" + this.numerPaszportu + "\"\n" +
			"}";

	}
	
}