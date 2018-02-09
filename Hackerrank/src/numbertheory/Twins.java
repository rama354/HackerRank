package numbertheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Twins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		
		List<Integer> primes=new ArrayList<Integer>();
		
		IntStream.rangeClosed(n, m).forEach(i -> {
			if (isPrime(i))
				primes.add(i);
		});
		
		int count=0;
		for (int p=0;p<primes.size()-1;p++){
			count=primes.get(p+1)-primes.get(p)==2?++count:count;
		}
		System.out.println(count);
	}

	private static boolean isPrime(int i) {
		if (i==1)
			return false;
			
		if ( i>2 && i%2==0)
			return false;
		 
		int sqrt=(int) Math.sqrt(i);
		
		for (int k=3;k<=sqrt;k+=2)
			if (i%k==0)
				return false;
		
		return true;
		
	}

}
