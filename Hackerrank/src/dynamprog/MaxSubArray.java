package dynamprog;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MaxSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T>0){
			int N=sc.nextInt();
			int[] inparr=new int[N];
			long sum=0,sum1=0,maxsum=0;
			int ai=Integer.MIN_VALUE;
			for (int i=0;i<N;i++){
				inparr[i]=sc.nextInt();
				sum=Math.max(0,sum+inparr[i]);
				maxsum=Math.max(sum,maxsum);
				if (inparr[i]>0)
					sum1+=inparr[i];
                else
                    ai=Math.max(inparr[i],ai);
			}
			
            if (sum1==0)
                sum1=ai;
            
            if (maxsum==0)
            	maxsum=ai;
				
			System.out.println(maxsum+" "+sum1);
			T--;
		}
	}

}
