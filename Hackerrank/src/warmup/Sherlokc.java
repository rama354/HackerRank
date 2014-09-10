package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sherlokc {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		// TODO Auto-generated method stub
		int numTc = Integer.parseInt(br.readLine());
		if (numTc<1 || numTc>20)
			return;
		
		for(int i=1;i<=numTc;i++)
		{
			int decentNumDigits =Integer.parseInt(br.readLine());
			if (decentNumDigits<1 || decentNumDigits>100000)
				return;
			
			System.out.println(getLargestDecentNum(decentNumDigits));
			
		}
	}

	private static Integer getLargestDecentNum(int decentNumDigits) 
	{
		StringBuilder sb=new StringBuilder();
		//long largedDecentNum=0;
		int numOf5=decentNumDigits,numOf3=0;
		boolean gotDecentNum=false;
		
		if (decentNumDigits<3)
			return Integer.parseInt(sb.append("-1").toString());
		
		if (decentNumDigits%3==0 || decentNumDigits%15==0)
		{		
			for(int i=decentNumDigits-1;i>=0;i--)
			{
				//largedDecentNum+=5*Math.pow(10,i);
				sb.append("5");
			}
			//return largedDecentNum;
			return Integer.parseInt(sb.toString());
		}
		
		/*if (decentNumDigits%5==0)
		{
			
			for(int i=decentNumDigits-1;i>=0;i--)
			{
				//largedDecentNum+=3*Math.pow(10,i);
				sb.append("3");
			}
			//return largedDecentNum;
			return Integer.parseInt(sb.toString());
		}*/
		
		while(numOf3<=decentNumDigits)
		{
			if(numOf5%3!=0)
			{
				//largedDecentNum+=5*Math.pow(10,--numOf5);
				//largedDecentNum+=3*Math.pow(10,numOf3++);
				numOf3++;numOf5--;
			}
			else if(numOf3%5!=0)
			{ 
				//largedDecentNum+=5*Math.pow(10,--numOf5);
				//largedDecentNum+=3*Math.pow(10,numOf3++);
				numOf3++;numOf5--;
			}
			else{
				gotDecentNum=true;
				break;
			}
				
				
		}
		//return numOf3;
		if (gotDecentNum)
		{
			for(int i=1;i<=numOf5;i++)
			{
				//largedDecentNum+=5*Math.pow(10,decentNumDigits-i);
				sb.append("5");
			}
			for(int i=0;i<numOf3;i++)
			{
				//largedDecentNum+=3*Math.pow(10,i);
				sb.append("3");
			}
			//return largedDecentNum;
			return Integer.parseInt(sb.toString());
		}	
		else
			return Integer.parseInt(sb.append("-1").toString());
	}

}
