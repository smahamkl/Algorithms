package examples.strings;

public class LongestWord {
	
	  public static String LongestWord(String sen) { 
		  
		       String longStr = "";
		       String[] Res = sen.split("[\\p{Punct}\\s]+");
		       
		       for (String s : Res) {
					if (s.length() > longStr.length())
						longStr = s;

					// System.out.println(s);
				}
		       
		    return longStr;
		    
		  } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(LongestWord("testing the code"));
	}

}
