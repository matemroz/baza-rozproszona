package pw.bdwsr.rozproszonaprojekt.db.dao;

import java.net.UnknownHostException;
import java.sql.Connection;

import pw.bdwsr.rozproszonaprojekt.db.DBConnectionStatus;
import pw.bdwsr.rozproszonaprojekt.domain.Konto;
import pw.bdwsr.rozproszonaprojekt.domain.RodzajKonta;

import com.mongodb.*;

public class MongoDAOFactory extends DAOFactory{

	public static final String DBURL = "localhost";
	public static final int DBPORT = 27017;
	public static final String DBNAME = "mydb";
	
	public DB createConnection(){
		DBConnectionStatus dbc = new DBConnectionStatus();
		Mongo conn = null;
		DB db = null;
		dbc.setConnectionStatus(DBConnectionStatus.INIT_CONNECTION_MONGO_DB);
		dbc.printConnectionStatus();
		try {
			conn = new Mongo(DBURL,DBPORT);
			db = conn.getDB(DBNAME);
			dbc.setConnectionStatus(DBConnectionStatus.CONNECTED_TO_MONGO_DB);
			dbc.printConnectionStatus();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		return db;
	}
	
	public static void main(String[] args){
		DB db = new MongoDAOFactory().createConnection();
		System.out.println(db.getCollectionNames().toString());
	}

}
