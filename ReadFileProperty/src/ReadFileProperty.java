//
//文件属性的读取 11:12
//
//本课时讲解判断文件是否存在、文件名称、路径、文件大小、是否被隐藏、是否可读可写、是否为文件夹等。
import java.io.File;


public class ReadFileProperty {

	public static void main(String[] args) {
		File file = new File("text.txt");
		//判断文件是否存在
		System.out.println("判断文件是否存在" + file.exists());
		//读取文件的名称
		System.out.println("读取文件的名称" + file.getName());
		//读取文件路径
		System.out.println("读取文件路径 ：" + file.getPath());
		//读取文件绝对路径
		System.out.println("读取文件绝对路径：" + file.getAbsolutePath());
		//获取文件父级路径
		System.out.println("获取文件父级路径 ：" + new File(file.getAbsolutePath()).getParent());
		//读取文件大小
		System.out.println("读取文件大小： " + file.length() + "byte");
		System.out.println("读取文件大小： " + (float)file.length()/1000 + "KB");
		//判断文件是否被隐藏
		System.out.println("判断文件是否被隐藏 :" + file.isHidden());
		//判断文件是否可读
		System.out.println("判断文件是否可读：" + file.canRead());
		//判断文件是否可写
		System.out.println("判断文件是否可写：" + file.canWrite());
		//判断文件是否为文件夹
		System.out.println("判断文件是否为文件夹 :" + file.isDirectory());
		
	}

}
//
//判断文件是否存在true
//读取文件的名称text.txt
//读取文件路径 ：text.txt
//读取文件绝对路径：D:\Java\javagui\ReadFileProperty\text.txt
//获取文件父级路径 ：D:\Java\javagui\ReadFileProperty
//读取文件大小： 30byte
//读取文件大小： 0.03KB
//判断文件是否被隐藏 :false
//判断文件是否可读：true
//判断文件是否可写：false
//判断文件是否为文件夹 :false
