package resources;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoDBParser {
	static MongoClient mongoClient = new MongoClient("35.231.82.144",27017);
	static DB db = mongoClient.getDB("micros");
	static DBCollection collection = db.getCollection("products");
	static BasicDBObject document = new BasicDBObject();
	public static void main(String[] args) {
		//MongoClient client = new MongoClient("35.231.82.144:27017", 27017);
		
		System.out.println("-------------------------------------"+collection.count());
		countDocuments();
	//	createCollection("{'prodName':'ssssssssssssssss','prodDesc':'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'}");
		selectDocument("prodName", "java");
		mongoClient.close();
	}
	public static int countDocuments() {
		System.out.println("-------------------------------------"+collection.count());
		return (int) collection.count();

	}
public static String createCollection(String collectionName) {
	db.createCollection(collectionName, null);
	return collectionName + " has been created successfully";
}

public static String insertDocument(String doc) {
	collection.insert((BasicDBObject)JSON.parse(doc));
	return doc + "inserted ===============================================================";
}
public static String selectDocument(String key, String value) {
	document.put(key, value);
	DBCursor cursor = collection.find(document);
	DBObject doc = null;
	while (cursor.hasNext()) {
		 doc = cursor.next();
	    System.out.println(doc.toString()+ "===========================================");
	}
    return doc.toString();

}
}
