package dynamprog;

import java.util.Arrays;
import java.util.Scanner;

public class KnapSack {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 int T=sc.nextInt();
		 
		 while(T>0){
			 int n=sc.nextInt();
			 int k=sc.nextInt();
			 int[] A=new int[n];
			 for(int i=0;i<n;i++)
				 A[i]=sc.nextInt();
			 
			 Arrays.sort(A);
			 System.out.println(getMaxSum(A,k,n-1));
			 T--;
		 }
		

	}

	private static int getMaxSum(int[] a, int K,int idx) {
		int c=0;
		int sum=0;
		if (idx<0||K<0)
			return 0;
		else if (a[idx]==1||K==0){
			return K;
		}
		else if (idx==0 && K%a[idx]==0){
			return K;
        }
		
		while(sum<K)
		{
			int temp=getMaxSum(a, K-a[idx]*c,idx-1);
			sum+=(a[idx]+temp);
			if (sum>K)
				return sum-a[idx];
			
			c++;
		 }
		
		return sum;
	}

}
