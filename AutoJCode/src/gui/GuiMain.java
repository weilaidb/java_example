package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.IOException;  
import java.awt.Toolkit;  
import java.awt.datatransfer.Clipboard;  
import java.awt.datatransfer.DataFlavor;  
import java.awt.datatransfer.StringSelection;  
import java.awt.datatransfer.Transferable;  
import java.awt.datatransfer.UnsupportedFlavorException;  
import java.awt.Image;  


import com.sleepycat.*;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.Environment;


public class GuiMain extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static String dbName;
	static String fileName;
	static Environment myDbEnvironment;
	static DatabaseConfig dbConfig;
	static Database myDatabase;
	static boolean bDbChanged;
	JTable friends;
	
	
	public static void testdb1()
	{
		dbName = "test2.db";
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
        System.out.println("readFromDatabase nums : " + loopnum + ", 执行耗时:" + (end - begin) + " 毫秒");
		
//		readFromDatabase(test + 100);
//		readFromDatabase(test + 1000);
//		readFromDatabase(test + 2000);
		
        operdb.closeDatabase();	
	}
	
	
	public static void main(String[] args) {

		System.out.println("==================================");
		System.out.println();
		System.out.println("gui main begin:");
		GuiMain gui = new GuiMain();
		gui.genJGui();
	}
	
//	设置系统剪切板内容[内容为文本]
	public static void setSystemClipboard(String refContent){   
		//设置为static是为了直接使用，不用new一个该类的实例即可直接使用,即定义的: 类名.方法名  
		String vc = refContent.trim();  
		StringSelection ss = new StringSelection(vc);  

		Clipboard sysClb=null;  
		sysClb = Toolkit.getDefaultToolkit().getSystemClipboard();  
		sysClb.setContents(ss,null);  

		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);  //跟上面三行代码效果相同  
	}  
	
	//	获取系统剪切板内容[剪切板中内容为文本型]
	//			[java] view plain copy
	public static String getSystemClipboard(){//获取系统剪切板的文本内容[如果系统剪切板复制的内容是文本]  
		Clipboard sysClb=null;  
		sysClb = Toolkit.getDefaultToolkit().getSystemClipboard();  
//		Transferable t = sysClb.getContents(null);  
		Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);  //跟上面三行代码一样  
		try {   
			if (null != t && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {   
				String text = (String)t.getTransferData(DataFlavor.stringFlavor);   
				return text;   
			}   
		} catch (UnsupportedFlavorException e) {  
			//System.out.println("Error tip: "+e.getMessage());  
		} catch (IOException e) {   
		}   //System.out.println("Error tip: "+e.getMessage());  
		return null;   
	}  
	
	
	
//	设置系统剪切板内容[内容为图片型]
//			[java] view plain copy
	public static void setImageClipboard(Image image) {   
		ImageSelection imgSel = new ImageSelection(image);   
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgSel, null);   
	}   

	public static class ImageSelection implements Transferable {   
		private Image image;   
		public ImageSelection(Image image) {this.image = image;}   

		public DataFlavor[] getTransferDataFlavors() {   
			return new DataFlavor[]{DataFlavor.imageFlavor};   
		}   

		public boolean isDataFlavorSupported(DataFlavor flavor) {   
			return DataFlavor.imageFlavor.equals(flavor);   
		}  

		public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {   
			if (!DataFlavor.imageFlavor.equals(flavor)) {throw new UnsupportedFlavorException(flavor);}   
			return image;   
		}  
	}  
	
	

	//	获取系统剪切板内容[剪切板中内容为图片型]
	//			[java] view plain copy
	public static Image getImageClipboard() {   
		Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);   
		try {   
			if (null  != t && t.isDataFlavorSupported(DataFlavor.imageFlavor)) {   
				Image image = (Image)t.getTransferData(DataFlavor.imageFlavor);   
				return image;   
			}   
		} catch (UnsupportedFlavorException e) {   
			//System.out.println("Error tip: "+e.getMessage());  
		} catch (IOException e) {   
			//System.out.println("Error tip: "+e.getMessage());  
		}   
		return null;   
	}  

	
//	6,使用方式
//	[java] view plain copy
//	类名.setSystemClipboard("这里是新设置的剪切板的内容");  //给剪切板设置文本型内容   
//	  
//	String clbContent = 类名.getSystemClipboard();  //获取剪切板的文本型内容  
//	  
//	Image img = new Image("xpic.jpg")  
//	类名.setImageClipboard(img);  //给剪切板设置图片型内容   
//	Image img2 = 类名.getImageClipboard(); //获取剪切板的图片型内容  
//		
	public class aboutBtnClickListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String verstr = "自动生成代码 \n "
					+ "by 小魏莱 \n" 
					+ version; 
			
			JLabel info;			
			//创建一个按钮对象,该对象被添加到对话框中
			if(ison){
				System.out.print("equals ok");
				// 以下语句等价于jDialog1.setVisible(false);

				/* public void dispose()

				 * 释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源。

				 * 即这些 Component 的资源将被破坏，它们使用的所有内存都将返回到操作系统，

				 * 并将它们标记为不可显示。 */
//				about.setAlwaysOnTop(false);
				about.dispose();
				about.setVisible(false);
				ison = false;
				//				about.setVisible(false);
			}
			else
			{
				System.out.print("else switch");

				info = new JLabel();
				info.setText(verstr);
				about = new JDialog();
				
				about.setTitle("版本");
				about.setAlwaysOnTop(true);
//				about.setDefaultCloseOperation(EXIT_ON_CLOSE);
				about.setVisible(true);
//				about.setPreferredSize(getPreferredSize());
				about.setSize(200, 100);
//				about.getContentPane().add(jButton1);
				about.getContentPane().add(info);
				
				about.setLocationRelativeTo(null);                //让窗体居中显示	
				
				ison = true;
			}


		}

	}
	//清空按钮
	public class cleanBtnListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			lineEdit_Search.setText("");
			pane3.setViewportView(test_data());
		}
		
	}
	public class CloseBtnClickedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("我要关了");
			System.exit(0);
		}

	}
	public class ColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// 方法3：通过分析匿名类名称()  
			String clazzName3 = new Object() {  
				public String getClassName() {  
					String clazzName = this.getClass().getName();  
					return clazzName.substring(0, clazzName.lastIndexOf('$'));  
				}  
			}.getClassName();  
			System.out.println(clazzName3);  
//			lableButton.setText("color clicked!!");
			label.setText("color clicked!!");
		}

	}
	
	
	
	//选择数据库
	public class dbselectComboxListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			bDbChanged = true;
			currentdb = combox_dbsel.getSelectedItem().toString();
			System.out.println("select db:" + currentdb);
			if(lineEdit_Search.getText().isEmpty())
				pane3.setViewportView(test_data());
			else
				pane3.setViewportView(test_data_search());
		}
		
	}
	public class LabelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// 方法3：通过分析匿名类名称()  
			String clazzName3 = new Object() {  
				public String getClassName() {  
					String clazzName = this.getClass().getName();  
					return clazzName.substring(0, clazzName.lastIndexOf('$'));  
				}  
			}.getClassName();  
			System.out.println(clazzName3);  
			
//			lableButton.setText("lable clicked!!");
			label.setText("lable clicked!!");

		}

	}
	//搜索行内容
	public class lineEdit_Search_Listener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			// TODO Auto-generated method stub
////			lineEdit_Search.setText("");
////			System.out.println("搜索关键字:" + lineEdit_Search.getText());
//			System.out.println("搜索关键字:" + lineEdit_Search.getText());
////			rview.setText(lineEdit_Search.getText());
////			dbName = "test2.db";
//			dbName = getCurrentDbName();
//			fileName = "savefile.txt";
//			
//			BerkeleyOper readdb = new BerkeleyOper(dbName, fileName);
//			readdb.openDatabase();
////			readdb.readFromDatabase(lineEdit_Search.getText());
//			
//			String searchkey = lineEdit_Search.getText();
//		
//			long begin = System.currentTimeMillis(); 
//			boolean findedflag = false;
//			ArrayList<String> dblst = readdb.getEveryItem();
//			for (String inkey : dblst) {
//				
////				System.out.println("====items : " + inkey);
//				String inresult = readdb.readFromDatabase(inkey);
//				if(inresult.contains(searchkey))
//				{
//					findedflag = true;
//					rview.setText(inresult);
//					System.out.println("==========find result of [" + searchkey + "]");
//				}
//			}
//			
//			if(!findedflag)
//			{
//				System.out.println("==========!!!no find result of [" + searchkey + "]");				
//			}
//			readdb.closeDatabase();
//			
//			long end = System.currentTimeMillis();   
////	        long result = end - begin;
//	        System.out.println("readFromDatabase nums : " + dblst.size() + ", 执行耗时:" + (end - begin) + " 毫秒");
//			
	        pane3.setViewportView(test_data_search());
			
		}
		
	}
	
	//搜索行内容
	public class rightcleanButton_Listener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
//			lineEdit_Search.setText("");
			rview.setText("");
//			System.out.println("搜索关键字:" + lineEdit_Search.getText());
			
		}
		
	}
	
	public class DeleteButton_Listener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
//			lineEdit_Search.setText("");
//			rview.setText("");
//			System.out.println("搜索关键字:" + lineEdit_Search.getText());
			
		}
	}
	
    /**
     * 获取当前的日期yyyyMMdd
     */
    public String getCurrentDate(){
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
    
    
    /**
     * 获取当前的时间yyyyMMddHHmmss
     */
    public String getCurrentTime(){
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }
    
    public void DoInsertDb()
    {

		String keys = getCurrentTime();
		System.out.println("入库, key:" + keys + ", currentdb:" + getCurrentDbName());
//		dbName = "test2.db";
		dbName = getCurrentDbName();
		fileName = "savefile.txt";
//		getCurrentDbName();
		
		String clipdata = getSystemClipboard();
		if(clipdata.trim().isEmpty())
			return;
		
		if(null == olddata)
		{
			olddata = "";
		}
		
		if(olddata.equals(clipdata) && !bDbChanged)
		{
			return;
		}
		BerkeleyOper writedb = new BerkeleyOper(dbName, fileName);
		writedb.openDatabase();
		writedb.writeToDatabase(keys, getSystemClipboard(), true);
		writedb.closeDatabase();
		
		pane3.setViewportView(test_data());
		
		olddata = clipdata;
		bDbChanged = false;
//		test_data();	
    }
    
	public class InDbBtnClickedLitener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			DoInsertDb();
			
		}
		
	}
	

	JFrame frame;
	JLabel label;
	JButton lableButton;
	JButton cleanButton;
	JButton getClipdButton;
	JButton selDbButton;
	JButton InDbButton;
	JButton saveButton;
	JButton gencodeButton;
	JButton rightcleanButton;
	JButton rightselindbButton;
	JButton pasteButton;
	JButton autoindbButton;
	JButton modifyButton;
	JButton deleteButton;
	JButton setupButton;
	JButton toolButton;
	JButton aboutButton;
	JButton closeButton;
	JTextField  lineEdit_Search;
	JCheckBox  checkbox_ag;
	JComboBox<Object>  combox_dbsel;
	//===========inter use end  ===============

	JTextArea  rview;
	JEditorPane left1edit;
	JEditorPane left2edit;
	JEditorPane rightedit;

	
//	//搜索行内容
//	public class lineEdit_Search_KeyListener implements ActionListener {
//		
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			// TODO Auto-generated method stub
////			lineEdit_Search.setText("");
//			System.out.println("搜索关键字:" + lineEdit_Search.getText());
//			
//		}
//		
//	}
	
	JDialog about = null;
	
	boolean ison = false;
	final String version = "v1.9";
	
	//===========inter use begin===============
	String currentdb;
	//获取当前数据库的名称
	String getCurrentDbName()
	{
		String dbName = null;
		currentdb = combox_dbsel.getSelectedItem().toString();
		for (String string : dbstrlist) {
			if(currentdb == string)
			{
				dbName = string.replace("+", "D").toUpperCase() + "db";
				break;
			}
		}

		return dbName;
		
	}
	
	Box lvbox;
	JScrollPane pane3;
	static String olddata = null;
	
	void genJGui()
	{
		// 方法3：通过分析匿名类名称()  
		String clazzName3 = new Object() {  
			public String getClassName() {  
				String clazzName = this.getClass().getName();  
				return clazzName.substring(0, clazzName.lastIndexOf('$'));  
			}  
		}.getClassName();  
		System.out.println(clazzName3);  

		
		String title = "JutoCCode";
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con=frame.getContentPane();//创建一个中间容器
        
        Container content = new Container(); 
		content.setBackground(Color.black); 
		content.setLayout(new GridLayout(1,10,1,1));
		
		//设置窗体中显示的字体样式
		frame.setFont(new Font("Times",Font.PLAIN, 20));
	    
		
		lableButton = new JButton("Change Lable");
		lableButton.addActionListener(new LabelListener());
		
		JButton colorButton = new JButton("Change Color");
		colorButton.addActionListener(new ColorListener());
		
		
		label           = new JLabel("GetList");
		lineEdit_Search = new JTextField(15);
		cleanButton     = new JButton("clean");
		getClipdButton  = new JButton("getClipd");
		checkbox_ag     = new JCheckBox("AG",true);  
		combox_dbsel    = JComboBoxKeyList();
//		selDbButton     = new JButton("选择代码库");



		pane3 = new JScrollPane (test_data());
		
        Box hbox1=Box.createHorizontalBox();//创建一个水平箱子
        hbox1.add(label); //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
        hbox1.add(Box.createHorizontalStrut(5));
        hbox1.add(lineEdit_Search);
        hbox1.add(Box.createHorizontalStrut(5));
        hbox1.add(cleanButton);
        hbox1.add(getClipdButton);
        hbox1.add(checkbox_ag);
        hbox1.add(combox_dbsel);
//        hbox1.add(selDbButton);
        lvbox=Box.createVerticalBox();
        lvbox.add(hbox1);
        lvbox.add(pane3); 
        
        //添加listener
        combox_dbsel.addActionListener(new dbselectComboxListener());
        cleanButton.addActionListener(new cleanBtnListener());
        lineEdit_Search.addActionListener(new lineEdit_Search_Listener());
//        lineEdit_Search.addKeyListener();
        
        
		InDbButton      = new JButton("入库");
		rightcleanButton   = new JButton("右清空");
		rightselindbButton = new JButton("右选入库");
		pasteButton        = new JButton("粘上");
		autoindbButton     = new JButton("自动入库");
		modifyButton       = new JButton("修改");
		deleteButton       = new JButton("删除");
		setupButton        = new JButton("设置");
		toolButton         = new JButton("工具");
		aboutButton        = new JButton("关于");
		aboutButton.addActionListener(new aboutBtnClickListener());
		closeButton        = new JButton("close");
		closeButton.addActionListener(new CloseBtnClickedListener());
		rightcleanButton.addActionListener(new rightcleanButton_Listener());
		getClipdButton.addActionListener(new getClipdButtonListener());
		InDbButton.addActionListener(new InDbBtnClickedLitener());
		deleteButton.addActionListener(new DeleteButton_Listener());
		
        Box vbox1=Box.createVerticalBox();
        vbox1.add(InDbButton);
        vbox1.add(rightcleanButton);
        vbox1.add(rightselindbButton);
        vbox1.add(pasteButton);
        vbox1.add(autoindbButton);
        vbox1.add(modifyButton);
        vbox1.add(deleteButton);
        vbox1.add(setupButton);
        vbox1.add(toolButton);
        vbox1.add(aboutButton);
        vbox1.add(closeButton);
        
        Timer timer_clipboard = new Timer();
        timer_clipboard.schedule(new TimerClipBoardTask(), 1000, 2000); 
        
		
		saveButton         = new JButton("save");
		gencodeButton      = new JButton("生成代码库");
		rview              = new JTextArea(100, 150);
		rview.setLineWrap(true); 
		  
//		rview.setContentType("text/html"); 
		rview.setLineWrap(true);
		
		JScrollPane scrollPane = new JScrollPane(rview);  
//		scrollPane.setPreferredSize(new Dimension(rview.getWidth(), rview.getHeight()));
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
        scrollPane.revalidate();
        scrollPane.repaint();

        Box hbox2=Box.createHorizontalBox();//创建一个水平箱子
        hbox2.add(saveButton); //在水平箱子上添加一个标签组件，并且创建一个不可见的、20个单位的组件。在这之后再添加一个文本框组件
        hbox2.add(Box.createHorizontalStrut(20));
        hbox2.add(gencodeButton);  
        
        Box rvbox = Box.createVerticalBox();
        rvbox.add(hbox2);
        rvbox.add(Box.createVerticalGlue());
        rvbox.add(scrollPane);
        JScrollBar sBar = scrollPane.getVerticalScrollBar();
        sBar.setValue(0); 
//        rvbox.add(rview);
	
        
        Box hbox=Box.createHorizontalBox();//创建一个垂直箱子，这个箱子将两个水平箱子添加到其中，创建一个横向 glue 组件。
        hbox.add(lvbox);
        hbox.add(Box.createHorizontalGlue());
        hbox.add(vbox1);
        hbox.add(Box.createHorizontalGlue());        
        hbox.add(rvbox);
        hbox.add(Box.createHorizontalGlue());

        
        con.add(hbox,BorderLayout.CENTER); // 将垂直箱子添加到BorderLayout布局管理器中的中间位置
        
		
		//load logo
		loadlogo(frame);
		
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;  //桌面宽
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;  //桌面高
		width/=2;
		height/=2;

		frame.setSize(width , height);
		frame.setVisible(true);
		
		setLocationRelativeTo(null);               //让窗体居中显示
		
	}

	
	
	String dbstrlist[] = { "Android", 
            "C", 
            "C++", 
            "C#", 
            "Debug", 
            "Erlang",
            "Go",
            "Hadoop",
            "Java", 
            "JavaScript", 
            "MongoDB", 
            "MySql", 
            "Oracle", 
            "Patchs", 
            "Perl", 
            "Postgresql",
            "Rust", 
            "shell", 
            "Sqlite3", 
            "Swift", 
            "Php", 
            "Python", 
            "Qt", 
            "Qtquick", "Unittest"}; 	
	JComboBox<Object> JComboBoxKeyList()
	{
  
		return new JComboBox<Object>(dbstrlist);
	}
	

	void loadlogo(Frame f)
	{
		try {
			String src = "/img/logo.png";     //图片路径,不支持ICO文件     
			Image image=ImageIO.read(f.getClass().getResource(src));
			//创建图片对象
			f.setIconImage(image);          //设置图标
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	
	Object[][] getDbContent_Search()
	{
		System.out.println("搜索关键字:" + lineEdit_Search.getText());
		dbName = getCurrentDbName();
		fileName = "savefile.txt";
		
		BerkeleyOper readdb = new BerkeleyOper(dbName, fileName);
		readdb.openDatabase();
		String searchkey = lineEdit_Search.getText();
	
		long begin = System.currentTimeMillis(); 
		boolean findedflag = false;
		ArrayList<String> dblst = readdb.getEveryItem();
		//反序
		Collections.reverse(dblst);
		int rows = dblst.size();
		if(0 == rows)
		{
			rows = 1;
		}
		Object[][] rawdata = new  Object[rows][2];		
		int no = 0;
		
		for (String inkey : dblst) {
			String inresult = readdb.readFromDatabase(inkey);
			if(inresult.toLowerCase().contains(searchkey.toLowerCase()))
			{
				rawdata[no][0] = inkey;
				rawdata[no][1] = inresult;
				no+=1;
				findedflag = true;
				rview.setText(inresult);
				System.out.println("==========find result of [" + searchkey + "]");
			}
		}
		if(!findedflag)
		{
			System.out.println("==========!!!no find result of [" + searchkey + "]");				
		}
		readdb.closeDatabase();
		
		long end = System.currentTimeMillis();   
        System.out.println("readFromDatabase nums : " + dblst.size() + ", 执行耗时:" + (end - begin) + " 毫秒");
		
		if(!findedflag)
		{
			System.out.println("==========!!!no find result of [" + searchkey + "]");
			rawdata[0][0] = "nokey";
			rawdata[0][1] = "nodata";
		}
		else
		{
			return rawdata;
		}
		
		return rawdata;
	}
	
	Object[][] getDbContent()
	{
		dbName = getCurrentDbName();
		fileName = "savefile.txt";
		
		BerkeleyOper readdb = new BerkeleyOper(dbName, fileName);
		readdb.openDatabase();
		
		long begin = System.currentTimeMillis(); 
		boolean findedflag = false;
		ArrayList<String> dblst = readdb.getEveryItem();
		//反序
		Collections.reverse(dblst);
		int rows = dblst.size();
		if(0 == rows)
		{
			rows = 1;
		}
		Object[][] rawdata = new  Object[rows][2];
		int no = 0;
		for (String inkey : dblst) {
			rawdata[no][0] = inkey;
			String inresult = readdb.readFromDatabase(inkey);
			rawdata[no][1] = inresult;
			System.out.println("==========find result of [getDbContent]");
			no += 1;
			findedflag = true;
		}
		readdb.closeDatabase();
		long end = System.currentTimeMillis();   
		System.out.println("readFromDatabase nums : " + dblst.size() + ", 执行耗时:" + (end - begin) + " 毫秒");
		
		if(!findedflag)
		{
			System.out.println("==========!!!no find result of [getDbContent ]");
			rawdata[0][0] = "nokey";
			rawdata[0][1] = "nodata";
		}
		else
		{
			return rawdata;
		}
		
		return rawdata;
	}
	
	
	JTable test_data()
	{

		final Object[] columnNames = {"索引字段", "内容字段",//列名最好用final修饰
				};
//		Object[][] rowData = {
//				{"ddd", "男"},
//				{"eee", "女"},
//				{"eee", "女"},
//				{"eee", "女"},
//				{"eee", "女"},
//				{"fff", "男"},
//		};
		
		Object[][] rowData = getDbContent();
		

		friends = new JTable (rowData, columnNames);
		friends.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = friends.getSelectedRow();
		        int col = friends.getSelectedColumn();
		        String value = (String) friends.getValueAt(row, col);
//		        System.out.println("row:" + row + ", col:"  + col + ", value:" + value);
		        rview.setText(value);
//		        JScrollBar   sbar=rview.scrollRectToVisible(getMaximizedBounds());   
//		        sbar.setValue(sbar.getMaximum()); 
//		        JOptionPane.showMessageDialog(null, value);
			}
		});
		friends.setPreferredScrollableViewportSize(new Dimension(1000, 10000));//设置表格的大小
		friends.setRowHeight (30);//设置每行的高度为20
		friends.setRowHeight (0, 20);//设置第1行的高度为15
		friends.setRowMargin (5);//设置相邻两行单元格的距离
		friends.setRowSelectionAllowed (true);//设置可否被选择.默认为false
		friends.setSelectionBackground (Color.white);//设置所选择行的背景色
		friends.setSelectionForeground (Color.red);//设置所选择行的前景色
		friends.setGridColor (Color.black);//设置网格线的颜色
		friends.selectAll ();//选择所有行
//		friends.setRowSelectionInterval (0,2);//设置初始的选择行,这里是1到3行都处于选择状态
		friends.clearSelection ();//取消选择
		friends.setDragEnabled (true);//不懂这个
		friends.setShowGrid (false);//是否显示网格线
		friends.setShowHorizontalLines (false);//是否显示水平的网格线
		friends.setShowVerticalLines (true);//是否显示垂直的网格线
//		friends.setValueAt ("tt", 0, 0);//设置某个单元格的值,这个值是一个对象
		friends.doLayout ();
		friends.setBackground (Color.lightGray);
		
		
//		friends.addColumnSelectionInterval(2, 2);
//		friends.addComponentListener(l);
		
		
		return friends;
	}

	JTable test_data_search()
	{

		final Object[] columnNames = {"索引字段", "内容字段",//列名最好用final修饰
				};
//		Object[][] rowData = {
//				{"ddd", "男"},
//				{"eee", "女"},
//				{"eee", "女"},
//				{"eee", "女"},
//				{"eee", "女"},
//				{"fff", "男"},
//		};
		
		Object[][] rowData = getDbContent_Search();
		

		friends = new JTable (rowData, columnNames);
		friends.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = friends.getSelectedRow();
		        int col = friends.getSelectedColumn();
		        String value = (String) friends.getValueAt(row, col);
//		        System.out.println("row:" + row + ", col:"  + col + ", value:" + value);
		        rview.setText(value);
//		        JOptionPane.showMessageDialog(null, value);
			}
		});
//		friends.addMouseListener();
		friends.setPreferredScrollableViewportSize(new Dimension(1000, 10000));//设置表格的大小
		friends.setRowHeight (30);//设置每行的高度为20
		friends.setRowHeight (0, 20);//设置第1行的高度为15
		friends.setRowMargin (5);//设置相邻两行单元格的距离
		friends.setRowSelectionAllowed (true);//设置可否被选择.默认为false
		friends.setSelectionBackground (Color.white);//设置所选择行的背景色
		friends.setSelectionForeground (Color.red);//设置所选择行的前景色
		friends.setGridColor (Color.black);//设置网格线的颜色
		friends.selectAll ();//选择所有行
//		friends.setRowSelectionInterval (0,2);//设置初始的选择行,这里是1到3行都处于选择状态
		friends.clearSelection ();//取消选择
		friends.setDragEnabled (true);//不懂这个
		friends.setShowGrid (false);//是否显示网格线
		friends.setShowHorizontalLines (false);//是否显示水平的网格线
		friends.setShowVerticalLines (true);//是否显示垂直的网格线
//		friends.setValueAt ("tt", 0, 0);//设置某个单元格的值,这个值是一个对象
		friends.doLayout ();
		friends.setBackground (Color.lightGray);
		
		
//		friends.addColumnSelectionInterval(2, 2);
//		friends.addComponentListener(l);
		
		
		return friends;
	}

	//剪切板内容
	public class getClipdButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String clbContent = getSystemClipboard();
			lineEdit_Search.setText(clbContent);
		}
		
	}
	
	public String uiclipboard; //存储粘贴板中的数据

	class TimerClipBoardTask extends TimerTask {  
		  
	    @Override  
	    public void run() {  	         
	        if(!checkbox_ag.isSelected())
	        {
	        	return;
	        }
	        String curtext = getSystemClipboard1();
//	        System.out.println("clipboardinfo : " + curtext); 
	        if(!curtext.equals(uiclipboard))
	        {
	        	uiclipboard = curtext;
//	        	System.out.println("clipboard diff save file "); 
	        	DoInsertDb();
	        	
	        }
	        
	    }  
	  
	}  
	public String getSystemClipboard1(){//获取系统剪切板的文本内容[如果系统剪切板复制的内容是文本]  
	    Clipboard sysClb=null;  
	    sysClb = Toolkit.getDefaultToolkit().getSystemClipboard();  
	    Transferable t = sysClb.getContents(null);  
	    //Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);  //跟上面三行代码一样  
	    try {   
	        if (null != t && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {   
	        String text = (String)t.getTransferData(DataFlavor.stringFlavor);   
	        return text;   
	        }   
	    } catch (UnsupportedFlavorException e) {  
	        //System.out.println("Error tip: "+e.getMessage());  
	    } catch (IOException e) {   
	    }   //System.out.println("Error tip: "+e.getMessage());  
	    return null;   
	}  
	
}
