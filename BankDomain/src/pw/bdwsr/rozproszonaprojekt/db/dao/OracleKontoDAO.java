package pw.bdwsr.rozproszonaprojekt.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pw.bdwsr.rozproszonaprojekt.db.utils.OracleDBUtils;
import pw.bdwsr.rozproszonaprojekt.domain.Konto;
import pw.bdwsr.rozproszonaprojekt.domain.RodzajKonta;

;

public class OracleKontoDAO implements KontoDAO {

	/**
	 * Pobiera dane konta o podanym numerze
	 * 
	 * @param nrKonta
	 *            numer konta
	 * @return obiekt Konto lub null jeśli konto o podanym numerze nie występuje
	 */
	@Override
	public Konto getKontoInfo(String nrKonta) {
		Konto k = new Konto();
		String columnNames = "NRKONTA, IDRODZAJUKONTA, SRODKI, PESEL";
		String condition = "NRKONTA = '" + nrKonta + "'";
		String tableName = "KONTO";
		ResultSet rs = OracleDBUtils.queryCommand(tableName, columnNames,
				condition);

		if (rs.equals(null))
			return null;

		try {
			while (rs.next()) {
				k.setNrKonta(rs.getString("NRKONTA"));
				k.setIdRodzajuKonta(Integer.parseInt(rs.getString("IDRODZAJUKONTA")));
				k.setSrodki(Double.parseDouble(rs.getString("SRODKI")));
				k.setPesel(rs.getString("PESEL"));
			}
		} catch (SQLException ex) {
			System.err.println("Problem z pobraniem danych konta");
		}

		return k;
	}

	/**
	 * Dodaje nowe konto do bazy danych
	 * 
	 * @param konto
	 *            obiekt konto
	 * @return true jeśli operacja się powiedzie lub w przeciwnym wypadku false
	 */
	@Override
	public boolean addKonto(Konto konto) {
		String tableName = "KONTO";
		List<String> columnNames = new ArrayList<String>();
		List<String> values = new ArrayList<String>();

		columnNames.add("NRKONTA");
		columnNames.add("IDRODZAJUKONTA");
		columnNames.add("SRODKI");
		columnNames.add("PESEL");

		values.add("'" + konto.getNrKonta() + "'");
		values.add("'" + konto.getIdRodzajuKonta() + "'");
		values.add("'" + konto.getSrodki() + "'");
		values.add("'" + konto.getPesel() + "'");

		return OracleDBUtils.insertCommand(tableName, columnNames, values);
	}

	/**
	 * Dodaje sumę pieniędzy do konta
	 * 
	 * @param nrKonta
	 *            numer konta
	 * @param srodki 
	 * 			  wysokość dodawanej kwoty
	 * @return true jeśli operacja się powiedzie lub w przeciwnym wypadku false
	 */
	@Override
	public boolean wplacPieniedze(String pesel, double srodki) {
		String tableName = "KONTO";
		String columnName = "SRODKI";
		String value = "'" + Double.toString(srodki) + "'";
		String condition = "PESEL = '" + pesel + "'";

		return OracleDBUtils.updateCommand(tableName, columnName, value,
				condition);
	}

}
