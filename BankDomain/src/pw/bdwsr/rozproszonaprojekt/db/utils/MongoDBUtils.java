package pw.bdwsr.rozproszonaprojekt.db.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pw.bdwsr.rozproszonaprojekt.db.dao.DAOFactory;
import pw.bdwsr.rozproszonaprojekt.db.dao.MongoDAOFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class MongoDBUtils {
	
	public static boolean insertCommand(String collectionName, List<String> columns, List<String> values){
		BasicDBObject query = new BasicDBObject();
		
		if (columns.isEmpty() || values.isEmpty()) {
			System.err.println("1");//TODO komunikat
			return false;
		}
		if (columns.size() != values.size()) {
			System.err.println("2");//TODO komunikat
			return false;
		}
		if (collectionName.isEmpty()) {
			System.err.println("3");//TODO komunikat
			return false;
		}
		
		Iterator<String> itColNames = columns.iterator();
		Iterator<String> itValues = values.iterator();

		DB db = getConnectionToDB();
		
		if (!isInDB(collectionName,db)){
			System.err.println("4");
			return false;
		}
		
		DBCollection col = db.getCollection(collectionName);
		
		while (itColNames.hasNext() && itValues.hasNext()) {
			query.put(itColNames.next(), itValues.next());
		}
		System.out.println(query.toString());
		WriteResult result = col.insert(query);
		System.out.println(result.toString());
		return true;
	}
	
	public static boolean updateCommand(String collectionName, List<String> columns, List<String> newValues, List<String> conditionColumns, List<String> conditionValues){
		BasicDBObject query = new BasicDBObject();
		BasicDBObject update = new BasicDBObject();
		BasicDBObject condition = new BasicDBObject();
		
		if (columns.isEmpty() || newValues.isEmpty()) {//condition moze byc puste
			System.err.println("1");//TODO komunikat
			return false;
		}
		if ((columns.size() != newValues.size()) || (conditionColumns.size() != conditionValues.size())) {
			System.err.println("2");//TODO komunikat
			return false;
		}
		if (collectionName.isEmpty()) {
			System.err.println("3");//TODO komunikat
			return false;
		}
		
		Iterator<String> itColNames = columns.iterator();
		Iterator<String> itNewValues = newValues.iterator();
		Iterator<String> itConColNames = conditionColumns.iterator();
		Iterator<String> itConValues = conditionValues.iterator();

		DB db = getConnectionToDB();
		
		if (!isInDB(collectionName,db)){
			System.err.println("4");//TODO komunikat
			return false;
		}
		
		DBCollection coll = db.getCollection(collectionName);
		
		while (itConColNames.hasNext() && itConValues.hasNext()) {
			condition.put(itConColNames.next(), itConValues.next());
		}
		
		while (itColNames.hasNext() && itNewValues.hasNext()) {
			query.put(itColNames.next(), itNewValues.next());
		}
		update.put("$set",query);//zlaczenie slowa kluczowego SET z kolumnami+wartosci
		
		System.out.println(condition);
		System.out.println(update);
		WriteResult result = coll.updateMulti(condition, update);
		System.out.println(result.getError());
		return true;
	}

	public static boolean deleteCommand(String collectionName, List<String> conditionColumns, List<String> conditionValues){
		BasicDBObject condition = new BasicDBObject();
		
		if (conditionColumns.isEmpty() || conditionValues.isEmpty()) {
			//TODO komunikat
			return false;
		}
		if (conditionColumns.size() != conditionValues.size()) {
			//TODO komunikat
			return false;
		}
		if (collectionName.isEmpty()) {
			//TODO komunikat
			return false;
		}
		
		Iterator<String> itConColNames = conditionColumns.iterator();
		Iterator<String> itConValues = conditionValues.iterator();

		DB db = getConnectionToDB();
		
		if (!isInDB(collectionName,db)){
			return false;
		}
		
		DBCollection coll = db.getCollection(collectionName);
		
		while (itConColNames.hasNext() && itConValues.hasNext()) {
			condition.put(itConColNames.next(), itConValues.next());
		}
		
		WriteResult result = coll.remove(condition);
		System.out.println(result.getError());
		return true;
	}
	
	public static DBCursor queryCommand(String collectionName, List<String> conditionColumns, List<String> conditionValues){
		BasicDBObject condition = new BasicDBObject();
		DBCursor result = null;
		
		if (conditionColumns.isEmpty() || conditionValues.isEmpty()) {//condition moze byc puste
			//TODO komunikat
			return null;
		}
		if (conditionColumns.size() != conditionValues.size()) {
			//TODO komunikat
			return null;
		}
		if (collectionName.isEmpty()) {
			//TODO komunikat
			return null;
		}
		
		Iterator<String> itConColNames = conditionColumns.iterator();
		Iterator<String> itConValues = conditionValues.iterator();
		

		DB db = getConnectionToDB();
		
		if (!isInDB(collectionName,db)){
			return null;
		}
		
		DBCollection coll = db.getCollection(collectionName);
		
		while (itConColNames.hasNext() && itConValues.hasNext()) {
			condition.put(itConColNames.next(), itConValues.next());
		}
		
		result = coll.find(condition);

		return result;
	}
	
	private static DB getConnectionToDB(){

		MongoDAOFactory mDAO =  (MongoDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MONGO);
		
		DB db = mDAO.createConnection();

		return db;
	}
	
	private static boolean isInDB(String collectionName, DB db){
		Set<String> collectionsInDB = db.getCollectionNames();
		
		if (!collectionsInDB.contains(collectionName)){
			System.out.println("Kolekcja '"+ collectionName +"' nie istnieje w bazie MongoDB. Najpierw użyj polecenia tworzącego kolekcję.");
			return false;
		}
		
		return true;
	}
	
	
//	public static void main(String[] args){
//		List<String> columnNames = new ArrayList<String>();
//		List<String> values = new ArrayList<String>();
//		MongoDBUtils.insertCommand("clients", columnNames, values);
//		columnNames.add("x");
//		values.add("1");
//		columnNames.add("y");
//		values.add("4");
//		MongoDBUtils.insertCommand("clients", columnNames, values);
//		MongoDBUtils.insertCommand("d", columnNames, values);
//		MongoDBUtils.insertCommand("", columnNames, values);
//		
//		
//		List<String> columnNames2 = new ArrayList<String>();
//		List<String> values2 = new ArrayList<String>();
//		columnNames2.add("imie");
//		values2.add("Grzegorz");
//		MongoDBUtils.updateCommand("clients", columnNames2, values2, columnNames, values);
//		
//		MongoDBUtils.deleteCommand("clients", columnNames2, values2);
//		
//		MongoDBUtils.queryCommand("clients", columnNames2, values2);
//	}
}
