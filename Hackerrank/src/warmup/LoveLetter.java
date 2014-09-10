package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LoveLetter {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		int numTc = Integer.parseInt(br.readLine());
		if (numTc<1 || numTc>10)
			return;
		
		for(int i=1;i<=numTc;i++)
		{
			String word=br.readLine();
			int len=word.length();
			char[] wordArray=word.toCharArray();
			int p=0,q=len-1;
			int numofopr=0;
			while(q>=p)
			{
				numofopr+=doPalDromeOpr(p,q,wordArray);
				p++;q--;
			}
			System.out.println(numofopr);
		}
	}

	private static int doPalDromeOpr(int i,int j,char[] wordArray) 
	{	
		 int opr=0;
		 while(wordArray[i] != wordArray[j])
		 {
			 if (wordArray[i] < wordArray[j]){
				 wordArray[j]-=1;
				 opr++;
				 if (wordArray[j]=='a')
					 break;
			 }
			 else{
				 wordArray[i]-=1;
				 opr++;
				 if (wordArray[i]=='a')
					 break;
			 }
			 
		 }
		 
		 return opr;
		
	}

}
