package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

	/**
	 * @param args
	 */
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		 int numTc=Integer.parseInt(br.readLine());
		 
		 if(numTc<1||numTc>100)
			 return;
		 
		 int actualTc=1;
		 
		 while(actualTc<=numTc){
			 //String[] str=getInputStrings(br.readLine());
			 String inputstr=br.readLine();
			 if(inputstr.length()<1 || inputstr.length()>10000)
				 return;
			 System.out.println(anagram(inputstr));
			 actualTc++;
		 }
		 

	}
	private static int anagram(String str) 
	{
		int anagchng=0;
		
		if (str.length()%2!=0)
			return -1;
		else
		{
			StringBuilder firststr=new StringBuilder(str.substring(0, (str.length()/2)));
			StringBuilder secondstr=new StringBuilder(str.substring((str.length()/2)));
			
			for(int i=0;i<firststr.length();i++)
			{
				int idx=secondstr.indexOf(firststr.substring(i, i+1));
				if (idx!=-1)
				{
					secondstr.deleteCharAt(idx);
					continue;
				
				}
				anagchng++;
			}
		}
		
		return anagchng;
		
	}
	
}
