package gametheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AliceBobGame {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int g=sc.nextInt();
        List<Integer> primes=new ArrayList<Integer>();
        for (int i=2;i<=100000;i++)
             if (isPrime(i))
                 primes.add(i);
            
		while (g>0){
			int n=sc.nextInt();
			int primecnt=0;
            for (int prime:primes){
                 if (prime>n)
                    break;
                 primecnt++;
            }   
            System.out.println(primecnt==0 || primecnt%2==0?"Bob":"Alice");
			g--;
		}
	}
    
	private static boolean isPrime(int k){
		if (k>2 && k%2==0)
			return false;
		
		int sqrt=(int) Math.sqrt(k);
		for (int p=3;p<=sqrt;p+=2)
			if (k%p==0)
				return false;
		
		return true;
	}
}
