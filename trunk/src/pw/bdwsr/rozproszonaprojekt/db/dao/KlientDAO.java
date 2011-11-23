package pw.bdwsr.rozproszonaprojekt.db.dao;

import pw.bdwsr.rozproszonaprojekt.domain.Klient;

public interface KlientDAO {
	public Klient pobierzKlienta(String pesel);
	public boolean zmienDaneKlienta(Klient klient);
	public boolean usunKlienta(String pesel);
	public boolean dodajKlienta(Klient klient);
}
