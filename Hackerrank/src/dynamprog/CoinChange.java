package dynamprog;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		if (N<1|| N>250)
			return;
		
		if (M<1|| M>50)
			return;
		
		int[] cointype=new int[M];
		int C=0;
		
	    while(C<M)
	    {
	        cointype[C] = sc.nextInt();
	        ++C;
	    }
	    
	    Arrays.sort(cointype);
	    System.out.println(countCombo(cointype,0,N,0,M));
	    //System.out.println(countChangeCombo(cointype,N));
	    
	}

	
	
	private static int countCombo(int[] cointype,int idx,int N,int sum,int M)
	{
	    int count=0;
		while(idx<M)
		{
			for (int i=1;i<=N;i++)
			{
				if (cointype[idx]*i>N)
					count=countCombo(cointype,idx+1,N,0,M);
				
				else if(cointype[idx]*i==N)
					count=1+countCombo(cointype,idx+1,N,0,M);

				else
				{
					if (sum > N)
						 count=countCombo(cointype,idx+1,N,0,M);
				    else if (sum==N)
						count=1+countCombo(cointype,idx+1,N,0,M);
					else
					{
						sum+=cointype[idx]*i;
						countCombo(cointype,idx+1,N,sum,M);
					}		
						
				}
					
			}
		}
		
		return count;
	}

}
