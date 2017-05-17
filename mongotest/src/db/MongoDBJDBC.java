package db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

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



//
//import org.bson.Document;
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//public class MongoDBJDBC{
//   public static void main( String args[] ){
//      try{   
//       // ���ӵ� mongodb ����
//         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//       
//         // ���ӵ����ݿ�
//         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//       System.out.println("Connect to database successfully");
//      
//       MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//       System.out.println("���� test ѡ��ɹ�");
//      }catch(Exception e){
//        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//     }
//   }
//}




//
//
//import java.util.ArrayList;
//import java.util.List;
//import org.bson.Document;
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//public class MongoDBJDBC{
//   public static void main( String args[] ){
//      try{   
//         // ���ӵ� mongodb ����
//         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//         
//         // ���ӵ����ݿ�
//         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//         System.out.println("Connect to database successfully");
//         
//         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//         System.out.println("���� test ѡ��ɹ�");
//         //�����ĵ�  
//         /** 
//         * 1. �����ĵ� org.bson.Document ����Ϊkey-value�ĸ�ʽ 
//         * 2. �����ĵ�����List<Document> 
//         * 3. ���ĵ����ϲ������ݿ⼯���� mongoCollection.insertMany(List<Document>) ���뵥���ĵ������� mongoCollection.insertOne(Document) 
//         * */
//         Document document = new Document("title", "MongoDB").  
//         append("description", "database").  
//         append("likes", 100).  
//         append("by", "Fly");  
//         List<Document> documents = new ArrayList<Document>();  
//         documents.add(document);  
//         collection.insertMany(documents);  
//         System.out.println("�ĵ�����ɹ�");  
//      }catch(Exception e){
//         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//      }
//   }
//}
//
//





//
//
//
////���������ĵ�
//
//import org.bson.Document;
//import com.mongodb.MongoClient;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoCursor;
//import com.mongodb.client.MongoDatabase;
//
//public class MongoDBJDBC{
//   public static void main( String args[] ){
//      try{   
//         // ���ӵ� mongodb ����
//         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//         
//         // ���ӵ����ݿ�
//         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//         System.out.println("Connect to database successfully");
//         
//         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//         System.out.println("���� test ѡ��ɹ�");
//         
//         //���������ĵ�  
//         /** 
//         * 1. ��ȡ������FindIterable<Document> 
//         * 2. ��ȡ�α�MongoCursor<Document> 
//         * 3. ͨ���α�������������ĵ����� 
//         * */  
//         FindIterable<Document> findIterable = collection.find();  
//         MongoCursor<Document> mongoCursor = findIterable.iterator();  
//         while(mongoCursor.hasNext()){  
//            System.out.println(mongoCursor.next());  
//         }  
//      
//      }catch(Exception e){
//         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//      }
//   }
//}
//
//
//

//
////�����ĵ�
//
//import org.bson.Document;
//import com.mongodb.MongoClient;
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoCursor;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.model.Filters;
//
//public class MongoDBJDBC{
//   public static void main( String args[] ){
//      try{   
//         // ���ӵ� mongodb ����
//         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//         
//         // ���ӵ����ݿ�
//         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//         System.out.println("Connect to database successfully");
//         
//         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//         System.out.println("���� test ѡ��ɹ�");
//         
//         //�����ĵ�   ���ĵ���likes=100���ĵ��޸�Ϊlikes=200   
//         collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));  
//         //�����鿴���  
//         FindIterable<Document> findIterable = collection.find();  
//         MongoCursor<Document> mongoCursor = findIterable.iterator();  
//         while(mongoCursor.hasNext()){  
//            System.out.println(mongoCursor.next());  
//         }  
//      
//      }catch(Exception e){
//         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//      }
//      
//      
//   }
//}
//




//ɾ����һ���ĵ�
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBC{
   public static void main( String args[] ){
      try{   
         // ���ӵ� mongodb ����
         @SuppressWarnings("resource")
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

         // ���ӵ����ݿ�
         String dbname = "mycols2";
         MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);  
         System.out.println("Connect to database [" + dbname + "] successfully");

//         mongoDatabase.drop(); //ɾ�����ݿ�
         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//         collection.drop(); //ɾ�����ݱ�
         System.out.println("���� test ѡ��ɹ�");

         //��ʱͳ��
         long begin = System.currentTimeMillis();   
         //����һ������ 
         int insertnums = 10000;
         for (int i = 0; i < insertnums; i++) {
        	 test_insertDb(collection, i + begin);			
		}
         long end = System.currentTimeMillis();   
         long result = end - begin;
         System.out.println("����[" + insertnums + "]������ִ�к�ʱ:" + (end - begin) + "����");
         
         //ɾ�����������ĵ�һ���ĵ�  
         collection.deleteOne(Filters.eq("likes", 200));  
         //ɾ�����з����������ĵ�  
         collection.deleteMany (Filters.eq("likes", 200));  
         //�����鿴���  
         FindIterable<Document> findIterable = collection.find();  
         MongoCursor<Document> mongoCursor = findIterable.iterator();  
         if(!mongoCursor.hasNext())
         {
        	 System.out.println("nodata!!");          	 
         }
         else
         {
        	 System.out.println("has data!!");          	         	 
         }
         while(mongoCursor.hasNext()){  
           System.out.println("havedata-->>:" + mongoCursor.next());  
         }  
           
      }catch(Exception e){
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     }
   }
   
   
   public static void test_insertDb(MongoCollection<Document> collection)
   {
       //�����ĵ�  
         /** 
         * 1. �����ĵ� org.bson.Document ����Ϊkey-value�ĸ�ʽ 
         * 2. �����ĵ�����List<Document> 
         * 3. ���ĵ����ϲ������ݿ⼯���� mongoCollection.insertMany(List<Document>) ���뵥���ĵ������� mongoCollection.insertOne(Document) 
         * */
         Document document = new Document("title", "MongoDB").  
         append("description", "database").  
         append("likes", 100).  
         append("by", "Fly");  
         List<Document> documents = new ArrayList<Document>();  
         documents.add(document);  
         collection.insertMany(documents);  
//         System.out.println("�ĵ�����ɹ�");  
   }
   
   public static void test_insertDb(MongoCollection<Document> collection, long num)
   {
       //�����ĵ�  
         /** 
         * 1. �����ĵ� org.bson.Document ����Ϊkey-value�ĸ�ʽ 
         * 2. �����ĵ�����List<Document> 
         * 3. ���ĵ����ϲ������ݿ⼯���� mongoCollection.insertMany(List<Document>) ���뵥���ĵ������� mongoCollection.insertOne(Document) 
         * */
         Document document = new Document("title", "MongoDB").  
         append("description", "database").  
         append("likes", num).  
         append("by", "Fly" + num);  
         List<Document> documents = new ArrayList<Document>();  
         documents.add(document);  
         collection.insertMany(documents);  
//         System.out.println("�ĵ�����ɹ�");  
   }
      
   
}

