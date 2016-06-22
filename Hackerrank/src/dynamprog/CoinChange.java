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
		String[] inp1=sc.nextLine().trim().split(" ");
		int N=Integer.parseInt(inp1[0]);
		int M=Integer.parseInt(inp1[1]);
		
		if (N<1|| N>250)
			return;
		
		if (M<1|| M>50)
			return;
		
		String[] inp2=sc.nextLine().trim().split(" ");
		
		int[] cointype=new int[M];
		int C=0;
		
	    while(C<M)
	    	cointype[C]=Integer.parseInt(inp2[C++]);
	       
	    
	    Arrays.sort(cointype);
	    long finalcount=0;
	    for(int coinval:cointype)
	    	if(N%coinval==0)
	    		finalcount++;
	    
	    System.out.println(finalcount+countCombo(cointype,N,0,0));
	    
	    
	}

	
	
	private static long countCombo(int[] cointype,int N,int M)
	{
		long count=0;
		
		
	}

}
