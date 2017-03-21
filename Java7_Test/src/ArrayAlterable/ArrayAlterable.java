package ArrayAlterable;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.lang.Math.random;


public class ArrayAlterable {
	public static void main(String[] args) {
		float [][]samples;
		samples = new float[6][];
		for (int i = 0; i < samples.length; i++) {
			samples[i] = new float[i + 1];
		}
		
		for (int i = 0; i < samples.length; i++) {
			for (int j = 0; j < samples[i].length; j++) {
				samples[i][j] = 99.0f;
			}
		}
		
		for (int i = 0; i < samples.length; i++) {
			java.util.Arrays.fill(samples[i], 99.0f);
		}
		
		System.out.println("done");
		System.out.println("multi array");
		long[][][] beans = new long[5][][];
		beans[0] = new long[4][];
		beans[1] = new long[2][];
		beans[2] = new long[7][];
		beans[3] = new long[7][];
		beans[4] = new long[7][];
		
		for (int i = 0; i < beans.length; i++) {
			for (int j = 0; j < beans[i].length; j++) {
				beans[i][j] = new long[(int)(1.0 + 6.0 *Math.random())];
			}
		}
		
	}
}
