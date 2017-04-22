package gui;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;

public class BerkeleyOper {
	String dbName;
	String fileName;
	Environment myDbEnvironment;
	DatabaseConfig dbConfig;
	Database myDatabase;
	
	public BerkeleyOper(String dbname, String file)
	{
		dbName   = dbname;
		fileName = file;
	}
	
	
	/*
     * �򿪵�ǰ���ݿ�
     */
    public void openDatabase() {
        // TODO Auto-generated method stub
        try{
            
			CheckMethods.PrintDebugMessage("�����ݿ�: "+dbName);
            EnvironmentConfig envConfig = new EnvironmentConfig();
            envConfig.setAllowCreate(true);
            envConfig.setTransactional(true);
            envConfig.setReadOnly(false);
            envConfig.setTxnTimeout(10000, TimeUnit.MILLISECONDS);
            envConfig.setLockTimeout(10000, TimeUnit.MILLISECONDS);
            
			/*
             *   �������� ���Խ��и���
                EnvironmentMutableConfig envMutableConfig = new EnvironmentMutableConfig();
                envMutableConfig.setCachePercent(50);//����je��cacheռ��jvm �ڴ�İٷֱȡ�
                envMutableConfig.setCacheSize(123456);//�趨����Ĵ�СΪ123456Bytes
                envMutableConfig.setTxnNoSync(true);//�趨�����ύʱ�Ƿ�д���ĵ����ݵ����̣�true��д���̡�
                //envMutableConfig.setTxnWriteNoSync(false);//�趨�������ύʱ���Ƿ�д�����log�����̡����д���̻�Ӱ�����ܣ���д��Ӱ������İ�ȫ�����Ӧ�䡣
             *
             */
            File file = new File(fileName);
            if(!file.exists())
                file.mkdirs();
            myDbEnvironment = new Environment(file,envConfig);
            
            dbConfig = new DatabaseConfig();
            dbConfig.setAllowCreate(true);
            dbConfig.setTransactional(true);
            dbConfig.setReadOnly(false);
            
			//dbConfig.setSortedDuplicates(false);
            /*
                setBtreeComparator ��������B tree�ȽϵıȽ�����ͨ������������
                setDuplicateComparator ���������Ƚ�һ��key��������ֵͬ��ʱ��Ĵ�С�Ƚ�����
                setSortedDuplicates ����һ��key�Ƿ�����洢���ֵ��true��������Ĭ��false.
                setExclusiveCreate �Զ�ռ�ķ�ʽ�򿪣�Ҳ����˵ͬһ��ʱ��ֻ����һʵ�������database��
                setReadOnly ��ֻ����ʽ��database,Ĭ����false.
                setTransactional �������Ϊtrue,��֧��������Ĭ����false����֧������
            */
            if(myDatabase == null)
                myDatabase = myDbEnvironment.openDatabase(null, dbName, dbConfig);
            
            CheckMethods.PrintDebugMessage(dbName+"���ݿ��е����ݸ���: "+myDatabase.count());
            /*
             *  Database.getDatabaseName()
                ȡ�����ݿ������
                �磺String dbName = myDatabase.getDatabaseName();
                
                Database.getEnvironment()
                ȡ�ð������database�Ļ�����Ϣ
                �磺Environment theEnv = myDatabase.getEnvironment();
                
                Database.preload()
                Ԥ�ȼ���ָ��bytes�����ݵ�RAM�С�
                �磺myDatabase.preload(1048576l); // 1024*1024
                
                Environment.getDatabaseNames()
                ���ص�ǰ�����µ����ݿ��б�
                Environment.removeDatabase()
                ɾ����ǰ������ָ�������ݿ⡣
                �磺
                String dbName = myDatabase.getDatabaseName();
                myDatabase.close();
                myDbEnv.removeDatabase(null, dbName);
                
                Environment.renameDatabase()
                ����ǰ�����µ����ݿ����
                �磺
                String oldName = myDatabase.getDatabaseName();  
                String newName = new String(oldName + ".new", "UTF-8");
                myDatabase.close();
                myDbEnv.renameDatabase(null, oldName, newName);
                
                Environment.truncateDatabase()
                ���database�ڵ��������ݣ���������˶�������¼��
                �磺
                Int numDiscarded= myEnv.truncate(null,
                myDatabase.getDatabaseName(),true);
                CheckMethods.PrintDebugMessage("һ��ɾ���� " + numDiscarded +" ����¼ �����ݿ� " + myDatabase.getDatabaseName());
             */
        }
        catch(DatabaseException e){
            CheckMethods.PrintInfoMessage(e.getMessage());

        }
    }
    
    /*
     * �����ݿ���д���¼
     * ����key��value
     */
    public boolean writeToDatabase(String key,String value,boolean isOverwrite) {
        // TODO Auto-generated method stub
        try {
              //����key/value,ע��DatabaseEntry��ʹ�õ���bytes����
              DatabaseEntry theKey=new DatabaseEntry(StringHelper.TrimString(key).getBytes("UTF-8"));
              DatabaseEntry theData=new DatabaseEntry(value.getBytes("UTF-8"));
              OperationStatus res = null;
              Transaction txn = null;
              try
              {
                  TransactionConfig txConfig = new TransactionConfig();
                  txConfig.setSerializableIsolation(true);
                  txn = myDbEnvironment.beginTransaction(null, txConfig);
                  if(isOverwrite)
                  {
                      res = myDatabase.put(txn, theKey, theData);
                  }
                  else
                  {
                      res = myDatabase.putNoOverwrite(txn, theKey, theData);
                  }
                  txn.commit();
                  if(res == OperationStatus.SUCCESS)
                  {
                      CheckMethods.PrintDebugMessage("�����ݿ�" + dbName +"��д��:"+key+","+value);
                      return true;
                  } 
                  else if(res == OperationStatus.KEYEXIST)
                  {
                      CheckMethods.PrintDebugMessage("�����ݿ�" + dbName +"��д��:"+key+","+value+"ʧ��,��ֵ�Ѿ�����");
                      return false;
                  }
                  else 
                  {
                      CheckMethods.PrintDebugMessage("�����ݿ�" + dbName +"��д��:"+key+","+value+"ʧ��");
                      return false;
                  }
              }
              catch(LockConflictException lockConflict)
              {
                  txn.abort();
                  CheckMethods.PrintInfoMessage("�����ݿ�" + dbName +"��д��:"+key+","+value+"����lock�쳣");
                  CheckMethods.PrintInfoMessage(lockConflict.getMessage());
                  CheckMethods.PrintInfoMessage(lockConflict.getCause().toString());
                  CheckMethods.PrintInfoMessage(lockConflict.getStackTrace().toString());
                                return false;
              }
        }
        catch (Exception e) 
        {
            // ������
            CheckMethods.PrintInfoMessage("�����ݿ�" + dbName +"��д��:"+key+","+value+"���ִ���");
            
            return false;
        }
    }
    
    
    /*
     * �رյ�ǰ���ݿ�
     */
    public void closeDatabase() {
        // TODO Auto-generated method stub    
        if(myDatabase != null)
        {
            myDatabase.close();
        }
        if(myDbEnvironment != null)
        {
            CheckMethods.PrintDebugMessage("�ر����ݿ�: " + dbName);
            myDbEnvironment.cleanLog(); 
            myDbEnvironment.close();
        }
    }
    
    
    /*
     * ɾ�����ݿ��е�һ����¼
     */
    public  boolean deleteFromDatabase(String key) {
        boolean success = false;
           long sleepMillis = 0;
        for(int i=0;i<3;i++)
        {
            if (sleepMillis != 0) 
            {
                try 
                {
                    Thread.sleep(sleepMillis);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                sleepMillis = 0;
            }
            Transaction txn = null;
            try
            {
                TransactionConfig txConfig = new TransactionConfig();
                txConfig.setSerializableIsolation(true);
                txn = myDbEnvironment.beginTransaction(null, txConfig);
                DatabaseEntry theKey;
                theKey = new DatabaseEntry(StringHelper.TrimString(key).getBytes("UTF-8"));
                OperationStatus res = myDatabase.delete(txn, theKey);
                txn.commit();
                if(res == OperationStatus.SUCCESS)
                {
                     CheckMethods.PrintDebugMessage("�����ݿ�" + dbName +"��ɾ��:"+key);
                       success = true; 
                       return success;
                }
                else if(res == OperationStatus.KEYEMPTY)
                {
                     CheckMethods.PrintDebugMessage("û�д����ݿ�" + dbName +"���ҵ�:"+key+"���޷�ɾ��");
                }
                else
                {
                     CheckMethods.PrintDebugMessage("ɾ������ʧ�ܣ�����"+res.toString());
                }
                return false;
            }
            catch (UnsupportedEncodingException e) 
            {
                // TODO Auto-generated catch block
                
                e.printStackTrace();
                return false;
            }
            catch(LockConflictException lockConflict)
            {
                CheckMethods.PrintInfoMessage("ɾ������ʧ�ܣ�����lockConflict�쳣");
                CheckMethods.PrintInfoMessage(lockConflict.getMessage());
                CheckMethods.PrintInfoMessage(lockConflict.getCause().toString());
                CheckMethods.PrintInfoMessage(lockConflict.getStackTrace().toString());
                sleepMillis = 1000;
                
                continue;
            }
            finally 
            {
                 if (!success)
                 {
                      if (txn != null) 
                      {
                          txn.abort();
                      }
                 }
            }
        }
        return false;
    }
    
    
    
    /*
     * �����ݿ��ж�������
     * ����key ����value
     */
    public String readFromDatabase(String key) {
        // TODO Auto-generated method stub
        //Database.getSearchBoth()
        try {
             DatabaseEntry theKey = new DatabaseEntry(StringHelper.TrimString(key).getBytes("UTF-8"));
             DatabaseEntry theData = new DatabaseEntry();
             Transaction txn = null;
             try
             {
                 TransactionConfig txConfig = new TransactionConfig();
                 txConfig.setSerializableIsolation(true);
                 txn = myDbEnvironment.beginTransaction(null, txConfig);
                 OperationStatus res = myDatabase.get(txn, theKey, theData, LockMode.DEFAULT);
                 txn.commit();
                 if(res == OperationStatus.SUCCESS)
                 {
                     byte[] retData = theData.getData();
                     String foundData = new String(retData, "UTF-8");
                     CheckMethods.PrintDebugMessage("�����ݿ�" + dbName +"�ж�ȡ:"+key+","+foundData);
                     return foundData;
                 }
                 else
                 {
                     CheckMethods.PrintDebugMessage("No record found for key '" + key + "'.");
                     return "";
                 }
             }
             catch(LockConflictException lockConflict)
             {
                 txn.abort();
                 CheckMethods.PrintInfoMessage("�����ݿ�" + dbName +"�ж�ȡ:"+key+"����lock�쳣");
                 CheckMethods.PrintInfoMessage(lockConflict.getMessage());
                 CheckMethods.PrintInfoMessage(lockConflict.getCause().toString());
                 CheckMethods.PrintInfoMessage(lockConflict.getStackTrace().toString());
                 
                 return "";
             }
            
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
            return "";
        }
    }
    
    
    
    /*
     * �������ݿ��е����м�¼������list
     */
    public  ArrayList<String> getEveryItem() {
        // TODO Auto-generated method stub
        CheckMethods.PrintDebugMessage("===========�������ݿ�"+dbName+"�е���������==========");
         Cursor myCursor = null;
         ArrayList<String> resultList = new ArrayList<String>();
         Transaction txn = null;
         try{
             txn = this.myDbEnvironment.beginTransaction(null, null);
             CursorConfig cc = new CursorConfig();
             cc.setReadCommitted(true);
             if(myCursor==null)
                 myCursor = myDatabase.openCursor(txn, cc);
             DatabaseEntry foundKey = new DatabaseEntry();
             DatabaseEntry foundData = new DatabaseEntry();         
             // ʹ��cursor.getPrev�����������α��ȡ����
             if(myCursor.getFirst(foundKey, foundData, LockMode.DEFAULT)
                     == OperationStatus.SUCCESS)
             {
                 String theKey = new String(foundKey.getData(), "UTF-8");
                 String theData = new String(foundData.getData(), "UTF-8");
                 resultList.add(theKey);
                 CheckMethods.PrintDebugMessage("Key | Data : " + theKey + " | " + theData + "");
                 while (myCursor.getNext(foundKey, foundData, LockMode.DEFAULT) 
                           == OperationStatus.SUCCESS) 
                 {
                        theKey = new String(foundKey.getData(), "UTF-8");
                        theData = new String(foundData.getData(), "UTF-8");
                        resultList.add(theKey);
                        CheckMethods.PrintDebugMessage("Key | Data : " + theKey + " | " + theData + "");
                 }
             }
             myCursor.close();
             txn.commit();
             return resultList;
         } 
         catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();    
            return null;
         }
         catch (Exception e) 
         {
             CheckMethods.PrintInfoMessage("getEveryItem��������쳣");
             CheckMethods.PrintInfoMessage(e.getMessage().toString());
             CheckMethods.PrintInfoMessage(e.getCause().toString());
             
             txn.abort();
             if (myCursor != null) 
             {
                 myCursor.close();
             }
             return null;
         }
    }
    
    	
	
}
