package clairvoyant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class LetterCount {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		 String word=br.readLine();
		 
		 char[] chararray=word.toCharArray();
		 
		 LinkedHashSet<Character> charset=new LinkedHashSet<Character>();
		 
		 for (char c:chararray)
		 {
			 charset.add(new Character(c));
		 }

		 StringBuilder sb=new StringBuilder();
		 for (Character c:charset)
		 {
			 int charcount=0;
			 for(char ch:chararray){
				 if(ch==c.charValue())
					 charcount++;
			 }
			 sb.append(c).append(charcount);
		 }
		 
		 System.out.println(sb.toString());
	}

}
