package pw.bdwsr.rozproszonaprojekt.db.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import pw.bdwsr.rozproszonaprojekt.db.utils.OracleDBUtils;
import pw.bdwsr.rozproszonaprojekt.domain.RodzajKonta;

public class OracleRodzajKontaDAO implements RodzajKontaDAO {

	/**
	 * Pobiera dane o rodzaju konta
	 * 
	 * @param idRodzajuKonta
	 *            numer identyfikacyjny danego rodzaju konta
	 * @return obiekt RodzajKonta
	 */
	@Override
	public RodzajKonta getDaneRodzajuKonta(int idRodzajuKonta) {
		RodzajKonta rk = new RodzajKonta(idRodzajuKonta);
		String columnNames = "OPROCENTOWANIE, KAPITALIZACJA, WALUTA, NAZWA";
		String condition = "IDRODZAJUKONTA = '" + idRodzajuKonta + "'";
		String tableName = "RODZAJKONTA";
		ResultSet rs = OracleDBUtils.queryCommand(tableName, columnNames,
				condition);

		if (rs.equals(null))
			return null;

		try {
			while (rs.next()) {
				rk.setOprocentowanie(Double.parseDouble(rs
						.getString("OPROCENTOWANIE")));
				rk.setKapitalizacja(Double.parseDouble(rs
						.getString("KAPITALIZACJA")));
				rk.setWaluta(rs.getString("WALUTA"));
				rk.setNazwa(rs.getString("NAZWA"));
			}
		} catch (SQLException ex) {
			System.err.println("Error while getting RodzajKonta info \n"
					+ ex.getSQLState() + "\n" + ex.getErrorCode() + "\n"
					+ ex.getMessage());
		}

		return rk;
	}

}
