package dynamprog;

import java.util.Scanner;

public class StockMaximize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		while(T>0){
			int N=sc.nextInt();
			int[] shareprice=new int[N];
			long[] profit=new long[N];
			
			for(int i=0;i<N;i++){
				shareprice[i]=sc.nextInt();
				profit[i]=0;
			}
			
			long sum=maxProfit(shareprice,0);
			System.out.println(sum>0?sum:0);
			T--;
		}

	}

	private static long maxProfit(int[] shareprice,long sum) {
		 		
		int maxPrice=0;
		for (int i=shareprice.length-1;i>-1;i--){
			if (shareprice[i]>maxPrice){
				maxPrice=shareprice[i];
				continue;
			}
			sum=sum+maxPrice-shareprice[i];
		}
			
	    return sum;
		
	}

}
