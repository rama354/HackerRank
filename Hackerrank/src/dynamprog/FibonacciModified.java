package dynamprog;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		int N=sc.nextInt();
		
		if (A<0|| A>2)
			return;
		
		if (B<0|| B>2)
			return;

		if (N<3||N>20)
			return;
		
			System.out.println(computeFibonnaci(BigInteger.valueOf(A),BigInteger.valueOf(B),N,3));
		
	}

	private static BigInteger computeFibonnaci(BigInteger a, BigInteger b,int N,int C) {
		while(C<=N){
			BigInteger temp=a;
			a=b;
			b=b.multiply(b).add(temp);
			return computeFibonnaci(a,b,N,C+1);
		}
			
		return b; 
	}

}
