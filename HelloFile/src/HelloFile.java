//�ļ��Ĵ�����ɾ���������� 09:05
//����ʱ����ͨ���ļ����creatNewFile�������������ļ���ͨ��delete��������ɾ���ļ���ʹ��renameTo���������������ļ���
import java.io.File;
import java.io.IOException;

public class HelloFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("new Hello.txt");
		
		//�Ƿ����
		if ( file.exists())
		{
			//�ļ��нṹ���봦��ͬһ����
			//�ļ����ڲ�ͬ�ķ�������Ҫʹ���ļ��Ŀ�����������������
			File nametoFile = new File("src/new Hello.txt");
			file.renameTo(nametoFile);
			
			
			//�ļ�
			file.isFile();
			//�ļ���
			file.isDirectory();
//			file.delete();
			System.out.println(file.isFile());
			System.out.println(file.isDirectory());
					
		}
		else
		{
			System.out.println("�ļ�������");
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("�ļ��޷�����");
			}
		}

	}

}

/*
 * result 
 * �ļ�������

 */
