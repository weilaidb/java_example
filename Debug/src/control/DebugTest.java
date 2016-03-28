package control;

import javax.swing.JFrame;


public class DebugTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ints = new int[20];
		try {
			for ( int i = 0; i < 21; i++){
				ints[i] = i + 1;
				System.out.println(i + 1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("数组越界");
		}
	
	}

}

