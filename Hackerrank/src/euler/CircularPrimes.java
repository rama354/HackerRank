package euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CircularPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		sc.close();
		Set<Integer> circularPrimes=new HashSet<Integer>();
		long sum=0;
		for (int i=2;i<N;i++){
			System.out.println(i);
			if (!isCircularPrime(i))
				circularPrimes.add(i);
		}
					
		for (int prime:circularPrimes)
			sum+=prime;
		
		System.out.println(sum);
    }
    
    
    private static boolean isCircularPrime(int i) {
		int temp=i;
		List<Integer> digits=new ArrayList<Integer>();
		 while(i>0)
		 {
			 digits.add(i%10);
			 i/=10;
		 }
		
		 boolean isNotCPrime=false;
		 int numlen=digits.size();
		 if (isPrime(temp))
		 {
			 int k=rotateLeft(temp, numlen);
			 while(k!=temp)
			 {
				// System.out.println(k);
				 if (!isPrime(k)){
					 isNotCPrime=true;
					 break;
				 }
				 k=rotateLeft(k, numlen);	 
			 }
		 }
		 else
			 isNotCPrime=true;
		 
		 
        return isNotCPrime;
		 	
	}
    
    private static int rotateLeft(int k, int len) {
		 List<Integer> digits=new ArrayList<Integer>();
		 while(k>0){
			 digits.add(k%10);
			 k/=10;
		 }
		 
		 int trimlen=digits.size();
		 for (int j=0;j<len-trimlen;j++)
			 digits.add(0);
		 
		 int num=0,i=0;
		
		 while(i<len)
		 {
			 int idx=(i-1)<0?(len-i)-1:i-1;
			 num+=digits.get(idx)*Math.pow(10, i++);
			 
		 }
		 return num;
		
	}
    
    
    private static boolean isPrime(int i){
		if (i>2 && i%2==0)
			return false;
		
		int sqrt=(int) Math.sqrt(i);
		
		for(int j=3;j<=sqrt;j+=2)
			if (i%j==0)
				return false;
		
		return true;	
		
	}

}
