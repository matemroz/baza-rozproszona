package pw.bdwsr.rozproszonaprojekt.domain;

public class RodzajKonta {
	protected int idRodzajuKonta;
	protected double oprocentowanie;
	protected int kapitalizacja;
	protected String waluta;
	protected String nazwa;

	public RodzajKonta(){ }
	
	public int getIdRodzajuKonta(){
		return idRodzajuKonta;
	}
	
	public double getOprocentowanie() {
		return oprocentowanie;
	}

	public void setOprocentowanie(double oprocentowanie) {
		this.oprocentowanie = oprocentowanie;
	}

	public int getKapitalizacja() {
		return kapitalizacja;
	}

	public void setKapitalizacja(int kapitalizacja) {
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
