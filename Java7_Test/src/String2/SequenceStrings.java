package String2;

public class SequenceStrings {

	public static void main(String[] args) {
		// Strings to be compared
		String string1 = "A";
		String string2 = "To";
		String string3 = "Z";
		
		//Strings for use in output
		String string1Out = "\"" + string1 + "\"" ; // string1 with quotes
		String string2Out = "\"" + string2 + "\"" ; // string2 with quotes
		String string3Out = "\"" + string3 + "\"" ; // string3 with quotes
		
		//Compare string1 with string3
		int result = string1.compareTo(string3);
		if(result < 0){
			System.out.println(string1Out + " is less than " + string3Out);
		}else if(result > 0){
			System.out.println(string1Out + " is greater than " + string3Out);			
		} else {
			System.out.println(string1Out + " is equal to s" + string3Out);			
		}
		
		//Compare string2 with string1
		result = string2.compareTo(string1);
		if(result < 0){
			System.out.println(string2Out + " is less than " + string1Out);
		}else if(result > 0){
			System.out.println(string2Out + " is greater than " + string1Out);			
		} else {
			System.out.println(string2Out + " is equal to s" + string1Out);			
		}	
		
		
		
		
		
	}

}
