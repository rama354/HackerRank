package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BiggerGreater {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numoftcs = Integer.parseInt(br.readLine());
		
		if (numoftcs < 1 || numoftcs > 100000)
			return;
		
		while(numoftcs>0){
			
			String word=br.readLine();
			if (word.length()>100||word.length()<1)
				return;
			
			System.out.println(reArrangeWord(word));
			numoftcs--;
		}
	}

	private static String reArrangeWord(String word) {
		 String newWord=new String();
		 char oldchar=0;
		 
		 for (int j=0;j<word.length();j++){
			 for (int i=j+1;i<word.length();i++){
				 
				if (word.charAt(i)-word.charAt(j)>=1)
					 oldchar=word.charAt(j);
					 newWord=word.replace(word.charAt(j), word.charAt(i));
					 newWord=newWord.replace(newWord.charAt(i),oldchar);
					 
			 }		 
		 }
		 
		 if (newWord.equalsIgnoreCase(word))
			 return "no answer";
		 else
			 return newWord;
	}

}
