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
import java.io.IOException;

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


public class GuiMain extends JFrame {
	
	
//	����ϵͳ���а�����[����Ϊ�ı�]
	public static void setSystemClipboard(String refContent){   
		//����Ϊstatic��Ϊ��ֱ��ʹ�ã�����newһ�������ʵ������ֱ��ʹ��,�������: ����.������  
		String vc = refContent.trim();  
		StringSelection ss = new StringSelection(vc);  

		Clipboard sysClb=null;  
		sysClb = Toolkit.getDefaultToolkit().getSystemClipboard();  
		sysClb.setContents(ss,null);  

		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);  //���������д���Ч����ͬ  
	}  
	
	//	��ȡϵͳ���а�����[���а�������Ϊ�ı���]
	//			[java] view plain copy
	public static String getSystemClipboard(){//��ȡϵͳ���а���ı�����[���ϵͳ���а帴�Ƶ��������ı�]  
		Clipboard sysClb=null;  
		sysClb = Toolkit.getDefaultToolkit().getSystemClipboard();  
		Transferable t = sysClb.getContents(null);  
		//Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);  //���������д���һ��  
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
	
	
	
//	����ϵͳ���а�����[����ΪͼƬ��]
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
	
	

	//	��ȡϵͳ���а�����[���а�������ΪͼƬ��]
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

	
//	6,ʹ�÷�ʽ
//	[java] view plain copy
//	����.setSystemClipboard("�����������õļ��а������");  //�����а������ı�������   
//	  
//	String clbContent = ����.getSystemClipboard();  //��ȡ���а���ı�������  
//	  
//	Image img = new Image("xpic.jpg")  
//	����.setImageClipboard(img);  //�����а�����ͼƬ������   
//	Image img2 = ����.getImageClipboard(); //��ȡ���а��ͼƬ������  
//	
	
	
	
	
	
	
	
	
	public class aboutBtnClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
//			JButton jButton1=new JButton("OK");
//			jButton1.addActionListener(this);
//			JTextArea info = new JTextArea();
			String verstr = "�Զ����ɴ��� \n "
					+ "by Сκ�� \n" 
					+ version; 
			
			JLabel info;
			

//			info.setText(verstr);
			
			
			
			
			//����һ����ť����,�ö�����ӵ��Ի�����
			if(ison){
				System.out.print("equals ok");
				// �������ȼ���jDialog1.setVisible(false);

				/* public void dispose()

				 * �ͷ��ɴ� Window�������������ӵ�е������������ʹ�õ����б�����Ļ��Դ��

				 * ����Щ Component ����Դ�����ƻ�������ʹ�õ������ڴ涼�����ص�����ϵͳ��

				 * �������Ǳ��Ϊ������ʾ�� */
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
				
				about.setTitle("�汾");
				about.setAlwaysOnTop(true);
//				about.setDefaultCloseOperation(EXIT_ON_CLOSE);
				about.setVisible(true);
//				about.setPreferredSize(getPreferredSize());
				about.setSize(200, 100);
//				about.getContentPane().add(jButton1);
				about.getContentPane().add(info);
				
				about.setLocationRelativeTo(null);                //�ô��������ʾ	
				
				ison = true;
			}


		}

	}
	//��հ�ť
	public class cleanBtnListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			lineEdit_Search.setText("");
		}
		
	}
	public class CloseBtnClickedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("��Ҫ����");
			System.exit(0);
		}

	}
	public class ColorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// ����3��ͨ����������������()  
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
	//ѡ�����ݿ�
	public class dbselectComboxListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			currentdb = combox_dbsel.getSelectedItem().toString();
			System.out.println("select db:" + currentdb);
		}
		
	}
	public class LabelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// ����3��ͨ����������������()  
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
	//����������
	public class lineEdit_Search_Listener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
//			lineEdit_Search.setText("");
//			System.out.println("�����ؼ���:" + lineEdit_Search.getText());
			System.out.println("�����ؼ���:" + lineEdit_Search.getText());
			rview.setText(lineEdit_Search.getText());
			
		}
		
	}
	
	//����������
	public class rightcleanButton_Listener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
//			lineEdit_Search.setText("");
			rview.setText("");
//			System.out.println("�����ؼ���:" + lineEdit_Search.getText());
			
		}
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("==================================");
		System.out.println();
		System.out.println("gui main begin:");
//		genGui();
//		genJGui();
		GuiMain gui = new GuiMain();
		gui.genJGui();
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

	
//	//����������
//	public class lineEdit_Search_KeyListener implements ActionListener {
//		
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			// TODO Auto-generated method stub
////			lineEdit_Search.setText("");
//			System.out.println("�����ؼ���:" + lineEdit_Search.getText());
//			
//		}
//		
//	}
	
	JDialog about = null;
	
	boolean ison = false;
	final String version = "v1.0";
	
	//===========inter use begin===============
	String currentdb;
	

	void genJGui()
	{
		// ����3��ͨ����������������()  
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
        Container con=frame.getContentPane();//����һ���м�����
        
        Container content = new Container(); 
		content.setBackground(Color.black); 
		content.setLayout(new GridLayout(1,10,1,1));
		
		//���ô�������ʾ��������ʽ
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
//		selDbButton     = new JButton("ѡ������");



		JScrollPane pane3 = new JScrollPane (test_data());	
		
        Box hbox1=Box.createHorizontalBox();//����һ��ˮƽ����
        hbox1.add(label); //��ˮƽ���������һ����ǩ��������Ҵ���һ�����ɼ��ġ�20����λ�����������֮�������һ���ı������
        hbox1.add(Box.createHorizontalStrut(5));
        hbox1.add(lineEdit_Search);
        hbox1.add(Box.createHorizontalStrut(5));
        hbox1.add(cleanButton);
        hbox1.add(getClipdButton);
        hbox1.add(checkbox_ag);
        hbox1.add(combox_dbsel);
//        hbox1.add(selDbButton);
        
        
        //���listener
        combox_dbsel.addActionListener(new dbselectComboxListener());
        cleanButton.addActionListener(new cleanBtnListener());
        lineEdit_Search.addActionListener(new lineEdit_Search_Listener());
//        lineEdit_Search.addKeyListener();
        
        Box lvbox=Box.createVerticalBox();
        lvbox.add(hbox1);
        lvbox.add(pane3);
        
		InDbButton      = new JButton("���");
		rightcleanButton   = new JButton("�����");
		rightselindbButton = new JButton("��ѡ���");
		pasteButton        = new JButton("ճ��");
		autoindbButton     = new JButton("�Զ����");
		modifyButton       = new JButton("�޸�");
		deleteButton       = new JButton("ɾ��");
		setupButton        = new JButton("����");
		toolButton         = new JButton("����");
		aboutButton        = new JButton("����");
		aboutButton.addActionListener(new aboutBtnClickListener());
		closeButton        = new JButton("close");
		closeButton.addActionListener(new CloseBtnClickedListener());
		rightcleanButton.addActionListener(new rightcleanButton_Listener());
		getClipdButton.addActionListener(new getClipdButtonListener());
		
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
        
		
		saveButton         = new JButton("save");
		gencodeButton      = new JButton("���ɴ����");
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

        Box hbox2=Box.createHorizontalBox();//����һ��ˮƽ����
        hbox2.add(saveButton); //��ˮƽ���������һ����ǩ��������Ҵ���һ�����ɼ��ġ�20����λ�����������֮�������һ���ı������
        hbox2.add(Box.createHorizontalStrut(20));
        hbox2.add(gencodeButton);  
        
        Box rvbox = Box.createVerticalBox();
        rvbox.add(hbox2);
        rvbox.add(Box.createVerticalGlue());
        rvbox.add(scrollPane);
//        rvbox.add(rview);
	
        
        Box hbox=Box.createHorizontalBox();//����һ����ֱ���ӣ�������ӽ�����ˮƽ������ӵ����У�����һ������ glue �����
        hbox.add(lvbox);
        hbox.add(Box.createHorizontalGlue());
        hbox.add(vbox1);
        hbox.add(Box.createHorizontalGlue());        
        hbox.add(rvbox);
        hbox.add(Box.createHorizontalGlue());

        
        con.add(hbox,BorderLayout.CENTER); // ����ֱ������ӵ�BorderLayout���ֹ������е��м�λ��
        
		
		//load logo
		loadlogo(frame);
		
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;  //�����
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;  //�����
		width/=2;
		height/=2;

		frame.setSize(width , height);
		frame.setVisible(true);
		
		setLocationRelativeTo(null);               //�ô��������ʾ
		
	}

	
	
	
	JComboBox<Object> JComboBoxKeyList()
	{
		String dbstrlist[] = { "Android", 
	               "C", 
	               "C++", 
	               "Debug", 
	               "Erlang", 
	               "Hadoop",
	               "Java", 
	               "JavaScript", 
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
		return new JComboBox<Object>(dbstrlist);
	}
	

	void loadlogo(Frame f)
	{
		try {
			String src = "/img/logo.png";     //ͼƬ·��,��֧��ICO�ļ�     
			Image image=ImageIO.read(f.getClass().getResource(src));
			//����ͼƬ����
			f.setIconImage(image);          //����ͼ��
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	
	JTable test_data()
	{

		final Object[] columnNames = {"�����ֶ�", "�����ֶ�",//���������final����
				};
		Object[][] rowData = {
				{"ddd", "��"},
				{"eee", "Ů"},
				{"eee", "Ů"},
				{"eee", "Ů"},
				{"eee", "Ů"},
				{"fff", "��"},
		};
		

		JTable friends = new JTable (rowData, columnNames);
		friends.setPreferredScrollableViewportSize(new Dimension(1000, 10000));//���ñ��Ĵ�С
		friends.setRowHeight (30);//����ÿ�еĸ߶�Ϊ20
		friends.setRowHeight (0, 20);//���õ�1�еĸ߶�Ϊ15
		friends.setRowMargin (5);//�����������е�Ԫ��ľ���
		friends.setRowSelectionAllowed (true);//���ÿɷ�ѡ��.Ĭ��Ϊfalse
		friends.setSelectionBackground (Color.white);//������ѡ���еı���ɫ
		friends.setSelectionForeground (Color.red);//������ѡ���е�ǰ��ɫ
		friends.setGridColor (Color.black);//���������ߵ���ɫ
		friends.selectAll ();//ѡ��������
		friends.setRowSelectionInterval (0,2);//���ó�ʼ��ѡ����,������1��3�ж�����ѡ��״̬
		friends.clearSelection ();//ȡ��ѡ��
		friends.setDragEnabled (true);//�������
		friends.setShowGrid (false);//�Ƿ���ʾ������
		friends.setShowHorizontalLines (false);//�Ƿ���ʾˮƽ��������
		friends.setShowVerticalLines (true);//�Ƿ���ʾ��ֱ��������
//		friends.setValueAt ("tt", 0, 0);//����ĳ����Ԫ���ֵ,���ֵ��һ������
		friends.doLayout ();
		friends.setBackground (Color.lightGray);
		
		
//		friends.addColumnSelectionInterval(2, 2);
//		friends.addComponentListener(l);
		
		
		return friends;
	}

	//���а�����
	public class getClipdButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String clbContent = getSystemClipboard();
			lineEdit_Search.setText(clbContent);
		}
		
	}

	
}
