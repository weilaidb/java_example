package db;

//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoDatabase;
import com.mongodb.*;
import com.mongodb.client.*;

public class MongoDBJDBC{
   public static void main( String args[] ){
      try{   
       // ���ӵ� mongodb ����
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
       
         // ���ӵ����ݿ�
         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
        System.out.println("Connect to database successfully");
        
      }catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     }
   }
}