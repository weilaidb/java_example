package WeatherFan;
//
//��java ���п�ݼ���
//��java�����г���Ŀ�ݼ�_�ٶ�֪��
//Ctrl + F11
//���԰ٶ�֪��|2���ش�|2012-03-13
//java��eclipse�����г���Ŀ�ݼ���ʲô?_�ٶ�֪��
//CTRL+F11,����Ŷ
//���԰ٶ�֪��|2���ش�|2015-02-02
//
//
//
////Eclipse��ݼ�
//package control;
//
//public class Utils {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//�������ݼ���ƻ���¶�ӦCmd������Windows�¶�ӦCtrl��
//		//Ctrl + 1 ����޸�
//		//Ctrl +D���ɾ��
//		//Shift +Enter,ֱ�ӻس�
//		//Ctrl +F11����������Ŀ
//		//Alt+��/�� �����ƶ���
//		//Ctrl+Alt +��/�� ���ٸ�����
//		//Ctrl+M ����ǰ�����Ŵ�
//		//Alt+/ ��ȫ����
//		//Ctrl+/ ����ע��
//		

//test for ��ά����
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
