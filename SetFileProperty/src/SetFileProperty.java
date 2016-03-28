//
//文件属性的设置 04:38
//
//本课时讲解将文件设定为可读、可写或只读。
import java.io.File;


public class SetFileProperty {

	public static void main(String[] args) {
		File file = new File("test.file");
		//将文件设定为可写
		file.setWritable(false);
		file.setWritable(true);
		//将文件设定为可读
		file.setReadable(false);
		file.setReadable(true);
		//将文件设定为只读
		file.setReadOnly();
		
	}

}
