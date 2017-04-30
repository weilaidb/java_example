package db;
import java.util.ArrayList;  
import java.util.List;  
import com.mongodb.MongoClient;  
import com.mongodb.MongoCredential;  
import com.mongodb.ServerAddress;  
import com.mongodb.client.MongoDatabase;  
  
public class MongoDBJDBC {  
    public static void main(String[] args){  
        try {  
            //���ӵ�MongoDB���� �����Զ�����ӿ����滻��localhost��Ϊ����������IP��ַ  
            //ServerAddress()���������ֱ�Ϊ ��������ַ �� �˿�  
            ServerAddress serverAddress = new ServerAddress("localhost",27017);  
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
            addrs.add(serverAddress);  
              
            //MongoCredential.createScramSha1Credential()���������ֱ�Ϊ �û��� ���ݿ����� ����  
            MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());  
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
            credentials.add(credential);  
              
            //ͨ��������֤��ȡMongoDB����  
            MongoClient mongoClient = new MongoClient(addrs,credentials);  
              
            //���ӵ����ݿ�  
            MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");  
            System.out.println("Connect to database successfully");  
        } catch (Exception e) {  
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );  
        }  
    }  
} 