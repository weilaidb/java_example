package comdb;

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

public class BerkeleyDemo {
	
	static String dbName;
	static String fileName;
	static Environment myDbEnvironment;
	static DatabaseConfig dbConfig;
	static Database myDatabase;
	
	
	
	public static void test1()
	{
		dbName = "test.db";
		fileName = "savefile.txt";
		BerkeleyOper operdb = new BerkeleyOper(dbName, fileName);
		operdb.openDatabase();
		
		int loopnum = 10000;
		String test = "abc";
		String value = "value";
		String strresult;
//		for (int i = 0; i < loopnum; i++) {
//			writeToDatabase(test + i, value + 1000 + i ,true);			
//		}
		long begin = System.currentTimeMillis(); 
		for (int i = 0; i < loopnum; i++) {
			strresult = operdb.readFromDatabase(test + i);
			if(strresult.contains("2"))
			{
				System.out.println(strresult + " contain 2");
			}
		}
		long end = System.currentTimeMillis();   
        long result = end - begin;
        System.out.println("readFromDatabase nums : " + loopnum + ", Ö´ÐÐºÄÊ±:" + (end - begin) + " ºÁÃë");
		
//		readFromDatabase(test + 100);
//		readFromDatabase(test + 1000);
//		readFromDatabase(test + 2000);
		
        operdb.closeDatabase();	
	}
	
	public static void test2()
	{
		dbName = "test2.db";
		fileName = "savefile2.txt";
		BerkeleyOper operdb = new BerkeleyOper(dbName, fileName);
		operdb.openDatabase();
		
		int loopnum = 10000;
		String test = "abc";
		String value = "value";
		String strresult;
//		for (int i = 0; i < loopnum; i++) {
//			writeToDatabase(test + i, value + 1000 + i ,true);			
//		}
		long begin = System.currentTimeMillis(); 
		for (int i = 0; i < loopnum; i++) {
			strresult = operdb.readFromDatabase(test + i);
			if(strresult.contains("2"))
			{
				System.out.println(strresult + " contain 2");
			}
		}
		long end = System.currentTimeMillis();   
		long result = end - begin;
		System.out.println("readFromDatabase nums : " + loopnum + ", Ö´ÐÐºÄÊ±:" + (end - begin) + " ºÁÃë");
		
//		readFromDatabase(test + 100);
//		readFromDatabase(test + 1000);
//		readFromDatabase(test + 2000);
		
		operdb.closeDatabase();	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("app begining...");
		test1();
		test2();
		
		System.out.println("app end...");
	}
    

}
