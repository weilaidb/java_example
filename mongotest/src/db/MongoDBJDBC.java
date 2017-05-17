package db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

//public class MongoDBJDBC{
//   public static void main( String args[] ){
//      try{   
//      // 连接到 mongodb 服务
//      MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//         
//       
//      // 连接到数据库
//      MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//      System.out.println("Connect to database successfully");
//      mongoDatabase.createCollection("test");
//      System.out.println("集合创建成功");
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
//       // 连接到 mongodb 服务
//         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//       
//         // 连接到数据库
//         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//       System.out.println("Connect to database successfully");
//      
//       MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//       System.out.println("集合 test 选择成功");
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
//         // 连接到 mongodb 服务
//         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//         
//         // 连接到数据库
//         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//         System.out.println("Connect to database successfully");
//         
//         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//         System.out.println("集合 test 选择成功");
//         //插入文档  
//         /** 
//         * 1. 创建文档 org.bson.Document 参数为key-value的格式 
//         * 2. 创建文档集合List<Document> 
//         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
//         * */
//         Document document = new Document("title", "MongoDB").  
//         append("description", "database").  
//         append("likes", 100).  
//         append("by", "Fly");  
//         List<Document> documents = new ArrayList<Document>();  
//         documents.add(document);  
//         collection.insertMany(documents);  
//         System.out.println("文档插入成功");  
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
////检索所有文档
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
//         // 连接到 mongodb 服务
//         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//         
//         // 连接到数据库
//         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//         System.out.println("Connect to database successfully");
//         
//         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//         System.out.println("集合 test 选择成功");
//         
//         //检索所有文档  
//         /** 
//         * 1. 获取迭代器FindIterable<Document> 
//         * 2. 获取游标MongoCursor<Document> 
//         * 3. 通过游标遍历检索出的文档集合 
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
////更新文档
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
//         // 连接到 mongodb 服务
//         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//         
//         // 连接到数据库
//         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
//         System.out.println("Connect to database successfully");
//         
//         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//         System.out.println("集合 test 选择成功");
//         
//         //更新文档   将文档中likes=100的文档修改为likes=200   
//         collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));  
//         //检索查看结果  
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




//删除第一个文档
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
         // 连接到 mongodb 服务
         @SuppressWarnings("resource")
		 MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

         // 连接到数据库
         String dbname = "mycols2";
         MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);  
         System.out.println("Connect to database [" + dbname + "] successfully");

//         mongoDatabase.drop(); //删除数据库
         MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//         collection.drop(); //删除数据表
         System.out.println("集合 test 选择成功");

         //耗时统计
         long begin = System.currentTimeMillis();   
         //插入一条数据 
         int insertnums = 10000;
         for (int i = 0; i < insertnums; i++) {
        	 test_insertDb(collection, i + begin);			
		}
         long end = System.currentTimeMillis();   
         long result = end - begin;
         System.out.println("插入[" + insertnums + "]条数据执行耗时:" + (end - begin) + "毫秒");
         
         //删除符合条件的第一个文档  
         collection.deleteOne(Filters.eq("likes", 200));  
         //删除所有符合条件的文档  
         collection.deleteMany (Filters.eq("likes", 200));  
         //检索查看结果  
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
       //插入文档  
         /** 
         * 1. 创建文档 org.bson.Document 参数为key-value的格式 
         * 2. 创建文档集合List<Document> 
         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
         * */
         Document document = new Document("title", "MongoDB").  
         append("description", "database").  
         append("likes", 100).  
         append("by", "Fly");  
         List<Document> documents = new ArrayList<Document>();  
         documents.add(document);  
         collection.insertMany(documents);  
//         System.out.println("文档插入成功");  
   }
   
   public static void test_insertDb(MongoCollection<Document> collection, long num)
   {
       //插入文档  
         /** 
         * 1. 创建文档 org.bson.Document 参数为key-value的格式 
         * 2. 创建文档集合List<Document> 
         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
         * */
         Document document = new Document("title", "MongoDB").  
         append("description", "database").  
         append("likes", num).  
         append("by", "Fly" + num);  
         List<Document> documents = new ArrayList<Document>();  
         documents.add(document);  
         collection.insertMany(documents);  
//         System.out.println("文档插入成功");  
   }
      
   
}

