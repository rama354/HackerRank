package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class HurdleRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] hurdles=new int[n];
		int max=Integer.MIN_VALUE;
		for (int i=0;i<n;i++){
			hurdles[i]=sc.nextInt();
			max=hurdles[i]>max?hurdles[i]:max;
		}
		
		System.out.println(max-k>0?max-k:0);
		
	}

}
