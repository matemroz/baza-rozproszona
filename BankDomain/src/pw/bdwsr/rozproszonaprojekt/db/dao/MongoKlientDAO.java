package pw.bdwsr.rozproszonaprojekt.db.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import pw.bdwsr.rozproszonaprojekt.db.utils.MongoDBUtils;
import pw.bdwsr.rozproszonaprojekt.domain.Klient;
/*TODO sprawdzenie czy pesel jest juz w bazie*/	
public class MongoKlientDAO implements KlientDAO{
	
	public final static String KOLEKCJAKLIENTA = "clients";

	@Override
	public Klient pobierzKlienta(String pesel) {
		if (pesel.isEmpty() || pesel == null) {
			System.err.println("Podano niewalsciwy argument funkcji pobierzKlienta");
			return null;
		}
		
		Klient klient = new Klient();
		List<String> conditionColumns = new ArrayList<String>();
		List<String> conditionValues = new ArrayList<String>();
		
		conditionColumns.add("PESEL");
		conditionValues.add(pesel);
		
		DBCursor cursor = MongoDBUtils.queryCommand(KOLEKCJAKLIENTA, conditionColumns, conditionValues);
		
		if (!cursor.hasNext()){
			System.err.println("Funkcja pobierzKlienta nie zwrocila wyniku");
			return null;
		}
		
		BasicDBObject obj = (BasicDBObject) (cursor.next());
		
		String imie = obj.getString("imie");
		String nazwisko = obj.getString("nazwisko");
		String ulicaZamieszkania = obj.getString("ulicaZamieszkania");
		String numerDomu = obj.getString("numerDomu");
		String numerMieszkania = obj.getString("numerMieszkania");
		String numerTelefonu = obj.getString("numerTelefonu");
		String numerDowoduOs = obj.getString("numerDowoduOs");
		String numerPaszportu = obj.getString("numerPaszportu");
		
		klient.setPesel(pesel);
		klient.setImie(imie);
		klient.setNazwisko(nazwisko);
		klient.setUlicaZamiekszania(ulicaZamieszkania);
		klient.setNumerDomu(numerDomu);
		klient.setNumerMieszkania(numerMieszkania);
		klient.setNumerTelefonu(numerTelefonu);
		klient.setNumerDowoduOsobistego(numerDowoduOs);
		klient.setNumerPaszportu(numerPaszportu);
		
		return klient;
	}

	@Override
	public boolean zmienDaneKlienta(Klient klient) {
		if (klient == null) {
			System.err.println("Podano niewalsciwy argument funkcji zmienDaneKlienta");
			return false;
		}
		
		List<String> conditionColumns = new ArrayList<String>();
		List<String> conditionValues = new ArrayList<String>();
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		
		//update where pesel=...
		conditionColumns.add("PESEL");
		conditionValues.add(klient.getPesel());
		
		columns.add("PESEL");
		values.add(klient.getPesel());
		columns.add("imie");
		values.add(klient.getImie());
		columns.add("nazwisko");
		values.add(klient.getNazwisko());
		columns.add("ulicaZamieszkania");
		values.add(klient.getUlicaZamieszkania());
		columns.add("numerDomu");
		values.add(klient.getNumerDomu());
		columns.add("numerMieszkania");
		values.add(klient.getNumerMieszkania());
		columns.add("numerTelefonu");
		values.add(klient.getNumerTelefonu());
		columns.add("numerDowoduOs");
		values.add(klient.getNumerDowoduOsobistego());
		columns.add("numerPaszportu");
		values.add(klient.getNumerPaszportu());
		
		return MongoDBUtils.updateCommand(KOLEKCJAKLIENTA, columns, values, conditionColumns, conditionValues);
	}

	@Override
	public boolean usunKlienta(String pesel) {
		if (pesel.isEmpty() || pesel == null) {
			System.err.println("Podano niewalsciwy argument funkcji usunKlienta");
			return false;
		}
		
		List<String> conditionColumns = new ArrayList<String>();
		List<String> conditionValues = new ArrayList<String>();
		
		conditionColumns.add("PESEL");
		conditionValues.add(pesel);
		
		return MongoDBUtils.deleteCommand(KOLEKCJAKLIENTA, conditionColumns, conditionValues);
	}

	@Override
	public boolean dodajKlienta(Klient klient) {
		if (klient == null) {
			System.err.println("Podano niewalsciwy argument funkcji dodajKlienta");
			return false;
		}
		
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		
		columns.add("PESEL");
		values.add(klient.getPesel());
		columns.add("imie");
		values.add(klient.getImie());
		columns.add("nazwisko");
		values.add(klient.getNazwisko());
		columns.add("ulicaZamieszkania");
		values.add(klient.getUlicaZamieszkania());
		columns.add("numerDomu");
		values.add(klient.getNumerDomu());
		columns.add("numerMieszkania");
		values.add(klient.getNumerMieszkania());
		columns.add("numerTelefonu");
		values.add(klient.getNumerTelefonu());
		columns.add("numerDowoduOs");
		values.add(klient.getNumerDowoduOsobistego());
		columns.add("numerPaszportu");
		values.add(klient.getNumerPaszportu());
		
		return MongoDBUtils.insertCommand(KOLEKCJAKLIENTA, columns, values);
	}

//	public static void main(String[] args){
//		MongoKlientDAO mkdao = new MongoKlientDAO();
//		
//		//stworzenie klienta testowego
//		Klient k = new Klient();
//		k.setPesel("51021163551");
//		k.setImie("Zenon");
//		k.setNazwisko("Spawacz");
//		k.setNumerDomu("1");
//		k.setNumerMieszkania("2");
//		k.setNumerTelefonu("0801100200300");
//		k.setNumerDowoduOsobistego("AIA678531");
//		k.setNumerPaszportu("47fdafasfsfsfs");
//		k.setUlicaZamiekszania("Konwiktorska");
//		
//		//test dodajKlienta
//		System.out.println(mkdao.dodajKlienta(k));
//		
//		//test zmienDaneKlienta
//		k.setUlicaZamiekszania("Lazienkowska");
//		System.out.println(mkdao.zmienDaneKlienta(k));
//		
//		//test pobierzKlienta
//		Klient k2 = mkdao.pobierzKlienta(k.getPesel());
//		System.out.println(k2.toString());
//
//		//test usunKlienta
//		System.out.println(mkdao.usunKlienta(k.getPesel()));
//		
//	}
}