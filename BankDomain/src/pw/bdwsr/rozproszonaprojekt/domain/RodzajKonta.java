package pw.bdwsr.rozproszonaprojekt.domain;

public class RodzajKonta {
	protected int idRodzajuKonta;
	protected double oprocentowanie;
	protected double kapitalizacja;
	protected String waluta;
	protected String nazwa;

	public RodzajKonta(int idRodzajuKonta){
		this.idRodzajuKonta = idRodzajuKonta;
	}
	
	public int getIdRodzajuKonta(){
		return idRodzajuKonta;
	}
	
	public double getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(double oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public double getKapitalizacja() {
		return kapitalizacja;
	}

	public void setKapitalizacja(double kapitalizacja) {
		this.kapitalizacja = kapitalizacja;
	}

	public String getWaluta() {
		return waluta;
	}

	public void setWaluta(String waluta) {
		this.waluta = waluta;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}
