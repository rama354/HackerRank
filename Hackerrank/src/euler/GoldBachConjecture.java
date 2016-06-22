package euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoldBachConjecture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner sc=new Scanner(System.in);
		 int T=sc.nextInt();
		 List<Integer> primes=new ArrayList<Integer>();
		 while (T>0){
			 int N=sc.nextInt();
			 System.out.println(goldBachConjecture(N));	 	 
			 T--;
		 }
    }
    
	private static int goldBachConjecture(int n) {
		 int count=0;
		 for(int i=2;i<n-1;i++)
		 { 
			 if (isPrime(i))
			 {
				 int j=n-i;
				 double sqrt=Math.sqrt(j/2);
                 if (j%2==0 && Math.ceil(sqrt)==sqrt)
                	 count=+1;
                 
			 }
			 
		 }
		
		 return count;
	}
   
    
    private static boolean isPrime(int i) 
    {
    	if (i>2 && i%2==0)
    		return false;
    	
    	int sqrt=(int) Math.sqrt(i);
    
    	for (int j=3;j<=sqrt;j+=2)
    		if (i%j==0)
    			return false;
    	
    	return true;
	}


	
}

