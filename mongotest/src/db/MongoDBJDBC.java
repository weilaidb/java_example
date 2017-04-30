package db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

//public class MongoDBJDBC{
//   public static void main( String args[] ){
//      try{   
//      // ���ӵ� mongodb ����
//      MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//         
//       
//      // ���ӵ����ݿ�
//      MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//      System.out.println("Connect to database successfully");
//      mongoDatabase.createCollection("test");
//      System.out.println("���ϴ����ɹ�");
//        
//      }catch(Exception e){
//        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//     }
//   }
//}

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBC{
   public static void main( String args[] ){
      try{   
       // ���ӵ� mongodb ����
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
       
         // ���ӵ����ݿ�
         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
       System.out.println("Connect to database successfully");
      
       MongoCollection<Document> collection = mongoDatabase.getCollection("test");
       System.out.println("���� test ѡ��ɹ�");
      }catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     }
   }
}

