package pw.bdwsr.rozproszonaprojekt.db;

public class DBConnectionStatus {
	public static final String INIT_CONNECTION_ORACLE_DB= "Inicjalizacja połączenia z bazą danych Oracle...";
	public static final String INIT_CONNECTION_MONGO_DB= "Inicjalizacja połączenia z bazą danych MongoDB...";
	public static final String CONNECTED_TO_ORACLE_DB = "Połączono z bazą danych Oracle";
	public static final String CONNECTED_TO_MONGO_DB = "Połączono z bazą danych Mongo";
	public static final String CONNECTED_TO_BOTH_DB = "Połączono z dwiema bazami danych";
	
	private String connectionStatus;
	
	public DBConnectionStatus(){
		this.connectionStatus = DBConnectionCurrentStatus.connectionCurrentStatus;
	}
	
	public void setConnectionStatus(String connectionStatus){
		if(this.connectionStatus.equals(CONNECTED_TO_MONGO_DB)
				|| this.connectionStatus.equals(CONNECTED_TO_MONGO_DB))
			this.connectionStatus = CONNECTED_TO_BOTH_DB;
		else
			this.connectionStatus = connectionStatus;
		
		DBConnectionCurrentStatus.connectionCurrentStatus = this.connectionStatus;
	}
	
	public void printConnectionStatus(){
		System.out.println(connectionStatus);
	}
}
