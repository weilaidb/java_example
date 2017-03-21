package String2;
import static java.util.Arrays.sort;

public class MatchString2 {

	public static void main(String[] args) {
		String string1 = "Too many ";
		String string2 = "cooks";
		String string3 = "Too many cooks";
		
		string1 += string2;
		//Display the contents of the strings
		System.out.println("Test 1");
		System.out.println("string3 is now:" + string3);
		System.out.println("string1 is now:" + string1);
		
		if(string1.equals(string3)) {
			System.out.println("string1.equal(string3) is true."
					+ " so strings are equals.");
		} else {
			System.out.println("string1.equals(string3) is false."
					+  " so things are not equal.");
		}
		
		string3 = "TOO many cooks";
		System.out.println("\n\nTest 2");
		System.out.println("string3 is now:" + string3);
		System.out.println("string1 is now:" + string1);
		
		if(string1.equals(string3)) {
			System.out.println("string1.equal(string3) is true."
					+ " so strings are equals.");
		} else {
			System.out.println("string1.equals(string3) is false."
					+  " so things are not equal.");
		}
		
		if(string1.equalsIgnoreCase(string3)) {
			System.out.println("string1.equalsIgnoreCase(string3) is true."
					+ " so strings are equals ignoring case.");
		} else {
			System.out.println("string1.equals(string3) is false."
					+  " so things are not different.");
		}
		
		
		if(string1.startsWith("Too")){
			System.out.println("The string does start with \"Too\" too!");
		}
		
//		if(string1.compareTo(string3)){
			
//		}
//		if(string1.compareTo(string3)) {
//			
//		}
		
		
		
		
		
		
		
	}

}
