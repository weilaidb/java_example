package String;

public class JoinStrings {

	public static void main(String[] args) {
		String firstString = "Many ";
		String secondString = "hands ";
		String thirdString = "make light work";
		
		String myString;
		
		myString = firstString + secondString + thirdString;
		System.out.println(myString);
		
		//convert an integer to string and join with two other strings
		int numHands = 99;
		myString = numHands + " " + secondString + thirdString;
		System.out.println(myString);
		
		//combine a string and integers
		myString = "fifty-five is "  + 5 + 5;
		System.out.println(myString);
		
		//Combine integers and a string
		myString = 5 + 5 + " is ten";
		System.out.println(myString);
		
		String doubleString = String.valueOf(3.1415926);
		System.out.println(doubleString);
		
	}

}
