
public class MatchStrings {

	public static void main(String[] args) {
		String string1 = "Too many";
		String string2 = "cooks";
		String string3 = "Too many cooks";
		
		//Make string1 and string3 refer to seperate strings that are  identical 
		string1 += string2;
		
		//Display the contents of the strings
		System.out.println("Test 1");
		System.out.println("string3 is now:" + string3);
		System.out.println("string1 is now:" + string1);
		
		if(string1 == string3){
			System.out.println("string1 == string3 is false." 
					+ " string1 and string3 point to the same string.");
			
		} else{
			System.out.println("string1 == string3 is true."
					+ " string1 and string3 do not point to the same string.");
		}
		
		//Now make string1 and string3  refer to the  same string.
		string3 = string1;
		//Display the contents of the strings.
		System.out.println("\n\nTest 2");
		System.out.println("string3 is now:" + string3);
		System.out.println("string1 is now:" + string1);
		
		if(string1 == string3) {
			System.out.println("string1 == string3 is true."
					+ " string1 and string3 point to the same things");
		} else {
			System.out.println("string1 == string3 is false."
					+ " string1 and string3 do not point to the same things");
		}
		
		//比较字符串是否相等
		if(string1.equals(string3)){
			System.out.println("string1.equals(string3) is true."
					+ " so strings are equal.");
		}
		if(string3.equals(string1)){
			System.out.println("string3.equals(string1) is true."
					+ " so strings are equal.");
		}
		
		
		
	}

}
