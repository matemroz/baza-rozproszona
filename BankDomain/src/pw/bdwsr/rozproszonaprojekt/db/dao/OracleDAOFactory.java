package pw.bdwsr.rozproszonaprojekt.db.dao;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

import pw.bdwsr.rozproszonaprojekt.db.DBConnectionStatus;
import pw.bdwsr.rozproszonaprojekt.domain.Konto;
import pw.bdwsr.rozproszonaprojekt.domain.RodzajKonta;

public class OracleDAOFactory extends DAOFactory {

	public static final String DBURL = "jdbc:oracle:thin:student/student@localhost:1521:XE";

	public Connection createConnection() {
		
		DBConnectionStatus dbc = new DBConnectionStatus();
		dbc.setConnectionStatus(DBConnectionStatus.INIT_CONNECTION_ORACLE_DB);
		dbc.printConnectionStatus();
		Connection conn = null;
		
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(DBURL);
			ods.setLoginTimeout(1);
			conn = ods.getConnection();
			dbc.setConnectionStatus(DBConnectionStatus.CONNECTED_TO_ORACLE_DB);
			dbc.printConnectionStatus();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public KontoDAO getKontoDAO() {
		return new OracleKontoDAO();
	}

	/*public static void main(String[] args){
		OracleKontoDAO okd = new OracleKontoDAO();
		OracleRodzajKontaDAO orkd = new OracleRodzajKontaDAO();
		Konto k = new Konto();
		k.setNrKonta("1111-2121-1232-1231-1231-1231");
		k.setRodzajKonta(new RodzajKonta(1));
		k.setSrodki(4.0);
		k.setPesel("89120500517");
		okd.addKonto(k);
		okd.wplacPieniedze("1111-2121-1232-1231-1231-1231", 3000.00);
		okd.getKontoInfo(111);
		RodzajKonta rkTst = orkd.getDaneRodzajuKonta(1);
		System.out.println(rkTst.getIdRodzajuKonta() + ":" + rkTst.getKapitalizacja() + ":"
				+ rkTst.getNazwa() + ":" + rkTst.getOprocentowanie() + ":" + rkTst.getWaluta());
	}
	*/
}
