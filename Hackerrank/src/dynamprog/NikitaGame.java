package dynamprog;

import java.util.Arrays;
import java.util.Scanner;

public class NikitaGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T>0){			
			int N=sc.nextInt();
			long[] A=new long[N];
			long sum=0;
			for (int i=0;i<N;i++){
				A[i]=sc.nextInt();
				sum+=A[i];
			}
			System.out.println(dividAndConquer(A,sum));
			T--;
		}
	}

	private static int dividAndConquer(long[] a,long rsum){
		long lsum=0;
		int len=a.length;
		int maxpts=0;
		
		for (int i=0;i<len;i++){
			lsum+=a[i];
			rsum-=a[i];
			if (lsum==rsum)
			{
				if (len==2)
					return 1;
				
				if (i+1<len/2.0){
					long[] rarr=Arrays.copyOfRange(a, i+1, len);
					maxpts=1+dividAndConquer(rarr,rsum);
				}
				else{
					long[] larr=Arrays.copyOfRange(a, 0,i+1);
					maxpts=1+dividAndConquer(larr,lsum);
				}
				break;
			}
		}
		
		return maxpts;
	}

}
