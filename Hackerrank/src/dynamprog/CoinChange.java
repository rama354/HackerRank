package dynamprog;

import java.util.Arrays;
import java.util.HashMap;
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
	    	cointype[C++]=sc.nextInt();
	       
		Arrays.sort(cointype);
		long[][] lookup=new long[N+1][M];
		
		//HashMap<Integer, Integer> s=new HashMap<Integer,Integer>();
		
		System.out.println(countWays(lookup,N,M-1,cointype));
	    
	    
	}

	private static long countWays(long[][] lookup, int N, int coinidx, int[] cointype)
	{
		int k=0;long ways=0;
		if (coinidx<0||N<0)
			return 0;
		else if (cointype[coinidx]==1||N==0){
			lookup[N][coinidx]=1;
			return 1;
		}
		else if (coinidx==0 && N%cointype[coinidx]==0){
            lookup[N][0]=1;
			return 1;
        }
		else if (coinidx==0 && N%cointype[coinidx]!=0){
            lookup[N][0]=0;
			return 0;
        }
		
		 while(cointype[coinidx]*k<=N)
		 {
			if (lookup[N-cointype[coinidx]*k][coinidx-1]!=0)
				ways+=lookup[N-cointype[coinidx]*k][coinidx-1];
			else
				ways+=countWays(lookup, N-cointype[coinidx]*k,coinidx-1,cointype);
			
		    k++;
		 }
		 lookup[N][coinidx]=ways;
		 return ways;
	}

}
