package dynamprog;

import java.util.Scanner;

public class Candies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] rating=new int[N];
		int[] lsweep=new int[N];
		int[] rsweep=new int[N];
		int C=0;
		
		while(C<N){
			rating[C]=sc.nextInt();
			lsweep[C]=1;
			rsweep[C++]=1;
		}
		
		System.out.println(findOptimalCandies(rating,lsweep,rsweep));

	}

	private static long findOptimalCandies(int[] rating, int[] lsweep, int[] rsweep) {
		int len=rating.length;
		 for(int i=0;i<len-1;i++)
			 if (rating[i]<rating[i+1])
				 lsweep[i+1]=lsweep[i]+1;		 
		 
		 for(int i=len-1;i>0;i--)
			 if (rating[i]<rating[i-1])
				 rsweep[i-1]=rsweep[i]+1;

		
		 long totcandycnt=0;
		 for (int i=0;i<len;i++)
			 totcandycnt+=Math.max(lsweep[i],rsweep[i]);
		 
		 return totcandycnt;
	}
}
