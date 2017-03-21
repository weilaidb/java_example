package String;

public class StringTest {

	public static void main(java.lang.String[] args) {
		System.out.println("This is \na string constant!!");
		
		String myString = "Strings can be knotty";
		System.out.println(myString);
		String anything;
		anything = null;
		
		if(anything == null)
		{
			System.out.println("anyString does not refer to anythings!");
		}
		
		String message = "Only the mediocre are always at their best";
		
		message = null;
		
		String[] names = new String[5];
		
		String[] colors = {"Red", "Green", "Blue", "yellow", "indigo", "violet"};
		
		
		String[] stars = {
			"Rober", "Wei Lai", "NiNi", "So Good", "Sophia", "Tst"
		};
		
		System.out.println("Your Lucky star for today is "
				+ stars[(int)(stars.length *Math.random())]);
		
		myString  = "The quick brown fox" + "jump over the lazy dog";
		
		String date = "31st ";
		String month = "December";
		String lastDay = date + month;
		
		String phrase = "Too many";
		phrase += " cooks spoil the broth";
		
		
	}

}
