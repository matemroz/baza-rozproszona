package pw.bdwsr.rozproszonaprojekt.db.dao;

import pw.bdwsr.rozproszonaprojekt.domain.Konto;

public interface KontoDAO {
	public Konto getKontoInfo(String nrKonta);
	public boolean addKonto(Konto konto);
	public boolean wplacPieniedze(String nrKonta, double srodki);
}
