package pw.bdwsr.rozproszonaprojekt.db.dao;

import java.util.List;

import pw.bdwsr.rozproszonaprojekt.domain.Klient;

public interface KlientDAO {
	public Klient pobierzKlienta(String pesel);
	public List<Klient> pobierzKlientowNaPodstawieKryterium(Klient klientKryterium);//wypelnione tylko pola, ktore maja stanowic kryterium wyszukiwania
	public boolean zmienDaneKlienta(Klient klient);
	public boolean usunKlienta(String pesel);
	public boolean dodajKlienta(Klient klient);
}
