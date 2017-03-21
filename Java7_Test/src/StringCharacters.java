
public class StringCharacters {

	public static void main(String[] args) {
		//Text string to be analyzed
		String text = "To be or not to be, that is the question;"
				+ "Whether 'this nobler' in the mind to suffer."
				+ " the slings and arrows of outraneous forune."
				+ " or to take arms against a sea of troubles, "
				+ " and by opposing end them?";
		int spaces = 0,
				vowels  = 0,
				letters = 0;
		
		//Analyze all the characters int the string
		int textLength = text.length();
		
		for (int i = 0; i < textLength; i++) {
			//Check for vowels
			char ch = Character.toLowerCase(text.charAt(i));
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			{
				vowels++;
			}
			
			//Check for letters
			if(Character.isLetter(ch)){
				letters++;
			}
			
			//Check for spaces
			if(Character.isWhitespace(ch)){
				spaces++;
			}
			
		}
		
		System.out.println("The text contained vowels:  " + vowels + "\n"
				           +"               consonants:  " + (letters - vowels) + "\n"
				           +"                   spaces:  " + spaces);
		
		
		
		
	}

}
