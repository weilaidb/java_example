//文件的创建、删除、重命名 09:05
//本课时讲解通过文件类的creatNewFile（）方法创建文件，通过delete（）方法删除文件，使用renameTo（）方法重命名文件。
import java.io.File;
import java.io.IOException;

public class HelloFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("new Hello.txt");
		
		//是否存在
		if ( file.exists())
		{
			//文件夹结构必须处于同一分区
			//文件处于不同的分区，需要使用文件的拷贝，而不是重命名
			File nametoFile = new File("src/new Hello.txt");
			file.renameTo(nametoFile);
			
			
			//文件
			file.isFile();
			//文件夹
			file.isDirectory();
//			file.delete();
			System.out.println(file.isFile());
			System.out.println(file.isDirectory());
					
		}
		else
		{
			System.out.println("文件不存在");
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("文件无法创建");
			}
		}

	}

}

/*
 * result 
 * 文件不存在

 */
