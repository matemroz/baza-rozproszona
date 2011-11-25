package pw.bdwsr.rozproszonaprojekt.db.dao;

import java.util.ArrayList;
import java.util.List;

import pw.bdwsr.rozproszonaprojekt.db.utils.MongoDBUtils;
import pw.bdwsr.rozproszonaprojekt.domain.Klient;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/*TODO sprawdzenie czy pesel jest juz w bazie*/
public class MongoKlientDAO implements KlientDAO {

	public final static String KOLEKCJAKLIENTA = "clients";

	@Override
	public Klient pobierzKlienta(String pesel) {
		if (pesel.isEmpty() || pesel == null) {
			System.err
					.println("Podano niewalsciwy argument funkcji pobierzKlienta");
			return null;
		}

		Klient klient = new Klient();
		List<String> conditionColumns = new ArrayList<String>();
		List<String> conditionValues = new ArrayList<String>();

		conditionColumns.add("PESEL");
		conditionValues.add(pesel);

		DBCursor cursor = MongoDBUtils.queryCommand(KOLEKCJAKLIENTA,
				conditionColumns, conditionValues);

		if (!cursor.hasNext()) {
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
			System.err
					.println("Podano niewalsciwy argument funkcji zmienDaneKlienta");
			return false;
		}

		List<String> conditionColumns = new ArrayList<String>();
		List<String> conditionValues = new ArrayList<String>();
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();

		// update where pesel=...
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

		return MongoDBUtils.updateCommand(KOLEKCJAKLIENTA, columns, values,
				conditionColumns, conditionValues);
	}

	@Override
	public boolean usunKlienta(String pesel) {
		if (pesel.isEmpty() || pesel == null) {
			System.err
					.println("Podano niewalsciwy argument funkcji usunKlienta");
			return false;
		}

		List<String> conditionColumns = new ArrayList<String>();
		List<String> conditionValues = new ArrayList<String>();

		conditionColumns.add("PESEL");
		conditionValues.add(pesel);

		return MongoDBUtils.deleteCommand(KOLEKCJAKLIENTA, conditionColumns,
				conditionValues);
	}

	@Override
	public boolean dodajKlienta(Klient klient) {
		if (klient == null) {
			System.err
					.println("Podano niewalsciwy argument funkcji dodajKlienta");
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

	@Override
	public List<Klient> pobierzKlientowNaPodstawieKryterium(
			Klient klientKryterium) {
		List<Klient> clientsList = new ArrayList<Klient>();

		List<String> conditionColumns = new ArrayList<String>();
		List<String> conditionValues = new ArrayList<String>();

		String pesel = klientKryterium.getPesel();
		String imie = klientKryterium.getImie();
		String nazwisko = klientKryterium.getNazwisko();
		String ulicaZamieszkania = klientKryterium.getUlicaZamieszkania();
		String numerDomu = klientKryterium.getNumerDomu();
		String numerMieszkania = klientKryterium.getNumerMieszkania();
		String numerTelefonu = klientKryterium.getNumerTelefonu();
		String numerDowoduOs = klientKryterium.getNumerDowoduOsobistego();
		String numerPaszportu = klientKryterium.getNumerPaszportu();

		if (!pesel.isEmpty()) {
			conditionColumns.add("PESEL");
			conditionValues.add(pesel);
		}
		if (!imie.isEmpty()) {
			conditionColumns.add("imie");
			conditionValues.add(imie);
		}
		if (!nazwisko.isEmpty()) {
			conditionColumns.add("nazwisko");
			conditionValues.add(nazwisko);
		}
		if (!ulicaZamieszkania.isEmpty()) {
			conditionColumns.add("ulicaZamieszkania");
			conditionValues.add(ulicaZamieszkania);
		}
		if (!numerDomu.isEmpty()) {
			conditionColumns.add("numerDomu");
			conditionValues.add(numerDomu);
		}
		if (!numerMieszkania.isEmpty()) {
			conditionColumns.add("numerMieszkania");
			conditionValues.add(numerMieszkania);
		}
		if (!numerTelefonu.isEmpty()) {
			conditionColumns.add("numerTelefonu");
			conditionValues.add(numerTelefonu);
		}
		if (!numerDowoduOs.isEmpty()) {
			conditionColumns.add("numerDowoduOs");
			conditionValues.add(numerDowoduOs);
		}
		if (!numerPaszportu.isEmpty()) {
			conditionColumns.add("numerPaszportu");
			conditionValues.add(numerPaszportu);
		}

		DBCursor cursor = MongoDBUtils.queryCommand(KOLEKCJAKLIENTA,
				conditionColumns, conditionValues);

		if (!cursor.hasNext()) {
			System.err.println("Funkcja pobierzKlienta nie zwrocila wyniku");
			return null;
		}

		while (cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) (cursor.next());
			Klient klient = new Klient();

			pesel = obj.getString("PESEL");
			imie = obj.getString("imie");
			nazwisko = obj.getString("nazwisko");
			ulicaZamieszkania = obj.getString("ulicaZamieszkania");
			numerDomu = obj.getString("numerDomu");
			numerMieszkania = obj.getString("numerMieszkania");
			numerTelefonu = obj.getString("numerTelefonu");
			numerDowoduOs = obj.getString("numerDowoduOs");
			numerPaszportu = obj.getString("numerPaszportu");

			klient.setPesel(pesel);
			klient.setImie(imie);
			klient.setNazwisko(nazwisko);
			klient.setUlicaZamiekszania(ulicaZamieszkania);
			klient.setNumerDomu(numerDomu);
			klient.setNumerMieszkania(numerMieszkania);
			klient.setNumerTelefonu(numerTelefonu);
			klient.setNumerDowoduOsobistego(numerDowoduOs);
			klient.setNumerPaszportu(numerPaszportu);
			
			clientsList.add(klient);
		}
		return clientsList;
	}

 public static void main(String[] args){
 MongoKlientDAO mkdao = new MongoKlientDAO();
	
	 Klient k = new Klient();
	 k.setPesel("51021163551");
	 k.setImie("Anna");
	 k.setNazwisko("Mazurek");
	 k.setNumerDomu("1");
	 k.setNumerMieszkania("2");
	 k.setNumerTelefonu("0801100200300");
	 k.setNumerDowoduOsobistego("AIA678531");
	 k.setNumerPaszportu("47fdafasfsfsfs");
	 k.setUlicaZamiekszania("Konwiktorska");

	 //test dodajKlienta
	 System.out.println(mkdao.dodajKlienta(k));
 }	
//	 //test zmienDaneKlienta
//	 k.setUlicaZamiekszania("Lazienkowska");
//	 System.out.println(mkdao.zmienDaneKlienta(k));
//	
//	 //test pobierzKlienta
//	 Klient k2 = mkdao.pobierzKlienta(k.getPesel());
//	 System.out.println(k2.toString());
//	
//	 //test pobierzKlientaNaPodstawieKryterium - należy uzupełnić tylko kilka pol w klasie Klient, aby wyszukac podobnych do niego klientow
//	 System.out.println(mkdao.pobierzKlientowNaPodstawieKryterium(k));
//	 
//	 //test usunKlienta
//	 System.out.println(mkdao.usunKlienta(k.getPesel()));
//	
//	 }
}