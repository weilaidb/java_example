package WeatherFan;
//
//问java 运行快捷键：
//求java中运行程序的快捷键_百度知道
//Ctrl + F11
//来自百度知道|2个回答|2012-03-13
//java中eclipse中运行程序的快捷键是什么?_百度知道
//CTRL+F11,采纳哦
//来自百度知道|2个回答|2015-02-02
//
//
//
////Eclipse快捷键
//package control;
//
//public class Utils {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//大多数快捷键在苹果下对应Cmd键，在Windows下对应Ctrl键
//		//Ctrl + 1 快捷修复
//		//Ctrl +D快捷删除
//		//Shift +Enter,直接回车
//		//Ctrl +F11快速运行项目
//		//Alt+↑/↓ 快速移动行
//		//Ctrl+Alt +↑/↓ 快速复制行
//		//Ctrl+M 将当前视力放大
//		//Alt+/ 补全代码
//		//Ctrl+/ 快速注释
//		

//test for 二维数组
public class WeatherFan {

	public static void main(String[] args) {
		float[][] temperature = new float[10][365];
		
		for (int i = 0; i < temperature.length; i++) {
			for (int j = 0; j < temperature[i].length; j++) {
				temperature[i][j] = (float)(45.0 *Math.random() - 10.0);
				System.out.println("temperature of  "
						+ (i) + " " + j + "    " + temperature[i][j]);
			}
		}
		
		//
		for (int i = 0; i < temperature.length; i++) {
			float average = 0.0f;
			
			for (int j = 0; j < temperature[i].length; j++) {
				average += temperature[i][j];
			}
			
			//output  the average temperature for the current location
			System.out.println("Average temperature at location "
					+ (i+1) + " = " + average / (float)temperature[i].length);
		}
		
		
		
	}

}
