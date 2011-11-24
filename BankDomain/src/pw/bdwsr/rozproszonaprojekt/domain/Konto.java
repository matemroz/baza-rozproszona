package pw.bdwsr.rozproszonaprojekt.domain;

public class Konto {
	protected String nrKonta;
	protected double srodki;
	protected int idRodzajuKonta;
	protected String pesel;

	public String getNrKonta() {
		return nrKonta;
	}

	public void setNrKonta(String nrKonta) {
		this.nrKonta = nrKonta;
	}

	public double getSrodki() {
		return srodki;
	}

	public void setSrodki(double srodki) {
		this.srodki = srodki;
	}

	public int getIdRodzajuKonta() {
		return idRodzajuKonta;
	}

	public void setIdRodzajuKonta(int idRodzajuKonta) {
		this.idRodzajuKonta = idRodzajuKonta;
	}
	
	public String getPesel(){
		return this.pesel;
	}
	
	public void setPesel(String pesel){
		this.pesel = pesel;
	}
}
