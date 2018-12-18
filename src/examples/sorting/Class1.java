package examples.sorting;

public class Class1 {

	public static void main(String[] args)
	{
		String s = "Practice, practice, practice!";
		System.out.println(s.indexOf("prac"));
		
		String text = "Hurray!!#! It's Friday! finally...";
		String[] words = text.split("!+");
		System.out.println(words[0] + ":" + words[1] + ":" + words[2]);
	}
}
