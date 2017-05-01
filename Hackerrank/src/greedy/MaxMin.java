package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int[] nums=new int[N];
		for (int i=0;i<N;i++)
			nums[i]=sc.nextInt();
		
		Arrays.sort(nums);
		int max=Integer.MAX_VALUE;
		for(int p=0;p<N-K;p++){
			if (nums[p+K-1]-nums[p]<max)
				max=nums[p+K-1]-nums[p];
					
		}
		
		System.out.println(max);
	}
}
