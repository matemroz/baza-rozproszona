package pw.bdwsr.rozproszonaprojekt.db.dao;

public abstract class DAOFactory {
	public static final int ORACLE = 1;
	public static final int MONGO = 2;
	
	public static DAOFactory getDAOFactory(int whichFactory){
		switch (whichFactory){
			case ORACLE:
				return new OracleDAOFactory();
			case MONGO:
				return new MongoDAOFactory();
			default:
				return null;
		}
	}
}
