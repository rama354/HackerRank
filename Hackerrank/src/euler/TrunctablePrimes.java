package euler;

import java.util.Scanner;

public class TrunctablePrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long sum=0;
		for (int i=11;i<N;i++){
			String s=Integer.toString(i);
			if (isRightPrime(s) && isLeftPrime(s))
				sum+=i;
		}
		System.out.println(sum);
	}

	private static boolean isRightPrime(String s) {
		for (int i=s.length();i>0;i--)
		{
			 if(!isPrime(Integer.valueOf(s.substring(0,i))))
				 return false;
		}
		return true;
	}

	private static boolean isLeftPrime(String s) {
		for (int i=0;i<s.length();i++){
			 if(!isPrime(Integer.valueOf(s.substring(i))))
				 return false;
		}
		return true;
	}

	private static boolean isPrime(Integer i) {
		if (i==1)
			return false;
		
		if ( i > 2 && i%2 == 0 ) 
	        return false;
	    
	    long top = (long)Math.sqrt(i) + 1;
	    
	    for(int j = 3; j < top; j+=2)
	        if(i % j == 0)
	        	return false;
	        
		return true;
		
		
	}

}
