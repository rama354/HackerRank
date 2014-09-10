package cryptography;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class PRNGuessing {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		int numtc=Integer.parseInt(br.readLine());
		if (numtc>10)
			return;
		
		while (numtc!=0)
		{
			String[] timestamps=new String(br.readLine()).split(" ");
			int starttime=Integer.parseInt(timestamps[0]);
			int endtime=Integer.parseInt(timestamps[1]);
			
			if (endtime-starttime>1000000)
				return;	
			
			int[] randvalues=new int[10];
			for(int j=0;j<10;j++)
			{
				randvalues[j]=Integer.parseInt(br.readLine());
			}
			Random rand=null;
			
			for(int seed=starttime;seed<=endtime;seed++)
			{
				rand=new Random(seed);
				boolean isSeedUsed=true;
				for(int j=0;j<10;j++)
				{
					if (randvalues[j]==rand.nextInt(1000))
						continue;
					else
						isSeedUsed=false;
				}
				
				if(isSeedUsed)				
					genOutput(seed,rand);
					
			}
			numtc--;
		}
	}

	private static void genOutput(int seed, Random rand) 
	{
		System.out.print(seed+" ");
		for(int j=0;j<10;j++)
			System.out.print(rand.nextInt(1000)+" ");
		
		System.out.println();
		
	}

}
