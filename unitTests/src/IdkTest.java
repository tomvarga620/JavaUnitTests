import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdkTest {

    @org.junit.Test
    public void triangle() {
        Idk test = new Idk();

        String result = test.formatText("dadada");
        assertEquals("Dadada", result);
    }

    @org.junit.Test
    public void formatText() {
    }

    @BeforeClass
    public static void setUp() throws Exception {

        //pripojenie do mongoDB
        MongoClient mongoClient = new MongoClient("localhost",27017);
        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("root","JavaUser",
                "password".toCharArray());
        MongoDatabase database = mongoClient.getDatabase("JavaUser");

        MongoCollection<Document> col = database.getCollection("userpid");

        Document user1 = new Document();
        Document user2 = new Document();
        Document user3 = new Document();

        //14.5.2019
        user1.append("name","test1").append("surname","test1").append("pid","1905140017");
        //6.8.2019
        user2.append("name","test2").append("surname","test2").append("pid","1908060011");
        //2.9.2019
        user3.append("name","test3").append("surname","test3").append("pid","1909020014");

        col.insertOne(user1);
        col.insertOne(user2);
        col.insertOne(user3);
        System.out.println("user inserted");

        /*col.insertOne(user2);
        col.insertOne(user3);*/

    }

    @AfterClass
    public static void tearDown() throws Exception {
        /*//pripojenie do mongoDB
        MongoClient mongoClient = new MongoClient("localhost",27017);
        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("root","JavaUser",
                "password".toCharArray());
        MongoDatabase database = mongoClient.getDatabase("JavaUser");

        MongoCollection<Document> col = database.getCollection("userpid");

        BasicDBObject document = new BasicDBObject();

        col.deleteMany(document);

        System.out.println("deleted");*/

    }

    @Test
    public void mongoFormat() {
        System.out.println("mongoFormat test");
    }
}