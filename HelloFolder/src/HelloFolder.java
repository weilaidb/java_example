//
//�ļ��еĴ�������������ɾ�� 11:53
//
//����ʱ����ͨ��ʹ��mkdir������mkdirs�������������ļ��У�ʹ��delete��������ɾ���ļ��У�ʹ��renameTo���������������ļ���
import java.io.File;


public class HelloFolder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File folder = new File("my new folder");
//		if (folder.mkdir()) {
//			System.out.println("�ļ��д������");
//		}else{
//			System.out.println("�ļ��д���ʧ��");
//		}
//		
//		File folder2 = new File("my new folder/one/two/three/four/main");
//		if (folder2.mkdirs()) {
//			System.out.println("�ļ��д������");
//		}else{
//			System.out.println("�ļ��д���ʧ��");
//		}
		
//		//����ͬһ������
//		File folderFile = new File("my new folder-new/one/two");
//		File newfolderFile = new File("my new folder-new/two");
//		if(folder.renameTo(newfolderFile)) {
//			System.out.println("done");
//		} else {
//			System.out.println("fail");
//		}
		
		File folderFile = new File("my new folder-new/one");
		if (folderFile.delete()) {
			System.out.println("done");
		} else {
			System.out.println("fail");
		}
	}

}
