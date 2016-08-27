package datastructure;

import java.util.Scanner;
import java.util.Stack;

public class Waiter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int Q=sc.nextInt();
		
		Stack<Integer> plates=new Stack<Integer>();
		for (int i=0;i<N;i++)
			plates.add(sc.nextInt());
		
		int p=2;
		for (int i=0;i<Q;i++){
			Stack<Integer> temp1=new Stack<Integer>();
			Stack<Integer> temp2=new Stack<Integer>();
			while (!plates.empty()){
				int plate=plates.pop();
				if (plate%p!=0)
					temp1.add(plate);
				else
					temp2.add(plate);
			}
			plates=temp1;
			while(!temp2.empty())
				System.out.println(temp2.pop());
			
			p=nextPrime(p);
		}
		
		while (!plates.empty())
			System.out.println(plates.pop());
	}

	private static int nextPrime(int k) {
		while(true){
			boolean isPrime=true;
			k++;
			if (k%2==0)
				continue;
			
			for (int i=3;i<=Math.sqrt(k);i+=2)
				if (k%i==0){
					isPrime=false;
					break;
				}
		
			if (isPrime)
				return k;
		}
	}

}
