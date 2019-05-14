import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class Idk {

    public Float triangle(float num1,float num2,float num3){
        if((num1>0 && num2>0 && num3>0) && (num1+num2>num3 && num2+num3>num1 && num3+num1>num2)){
            return num1+num2+num3;
        }
        else
        {
            float numError = -1;
            return numError;
        }
    }

    public String formatText(String text){

        if(text=="" || text==null){
            return null;
        }
        else
        {
            String rslt = text.substring(0, 1).toUpperCase() + text.substring(1);
            return rslt;
        }

    }

    public void mongoFormat(){
        MongoClient mongoClient = new MongoClient("localhost",27017);
        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("root","JavaUser",
                "password".toCharArray());
        MongoDatabase database = mongoClient.getDatabase("JavaUser");

        MongoCollection<org.bson.Document> col = database.getCollection("userpid");

        //list for new collection
        List listDob = new ArrayList();

        try (MongoCursor<org.bson.Document> cur = col.find().iterator()) {
            while (cur.hasNext()) {

                org.bson.Document doc = cur.next();

                List listPid = new ArrayList(doc.values());
                System.out.print(listDob.get(1));
                System.out.print(": ");
                System.out.println(listDob.get(2));
                System.out.print(": ");
                System.out.println(listDob.get(3));

            }
        }

        mongoClient.close();

    }

}
