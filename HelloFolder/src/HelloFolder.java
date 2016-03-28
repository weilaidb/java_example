//
//文件夹的创建、重命名、删除 11:53
//
//本课时讲解通过使用mkdir（）与mkdirs（）方法创建文件夹，使用delete（）方法删除文件夹，使用renameTo（）方法重命名文件夹
import java.io.File;


public class HelloFolder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File folder = new File("my new folder");
//		if (folder.mkdir()) {
//			System.out.println("文件夹创建完成");
//		}else{
//			System.out.println("文件夹创建失败");
//		}
//		
//		File folder2 = new File("my new folder/one/two/three/four/main");
//		if (folder2.mkdirs()) {
//			System.out.println("文件夹创建完成");
//		}else{
//			System.out.println("文件夹创建失败");
//		}
		
//		//处于同一分区中
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
