package euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem52 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		for (int i=250;i<=N;i++)
		{
			int temp=i;
			
			List<Integer> digits=new ArrayList<Integer>();
			while(temp>0){
				digits.add(temp%10);
				temp/=10;
			}	
			temp=2;
			
			long[] multiples=new long[K];
			multiples[0]=i;
			loop1:
			while(temp<=K)
			{
				long multiple=i*temp;
				List<Integer> tdigits=new ArrayList<Integer>(digits);
				int digitcount=0;
				while(multiple>0)
				{
					if (tdigits.contains(new Integer((int) (multiple%10)))){
						tdigits.remove(new Integer((int) (multiple%10)));
						multiple/=10;
						digitcount++;
					}
					else
						break loop1;
				}
				
				if (digits.size()!=digitcount)
					break;
				else
					multiples[temp-1]=i*temp;
				
				temp++;
			}
			
			if (temp>K){
				for(long value:multiples)
					System.out.print(value+" ");
				
				System.out.println();
			}
			
			
		}
	}

}
