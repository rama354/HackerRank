package datastructure;

import java.util.Scanner;

public class TruckTour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		//long[] pumpval=new long[N];
		//long[] pumpdist=new long[N];
		
		int startidx=0;
		int idx=startidx;
		long offset=0;
		while(startidx<N)
		{
			offset+=sc.nextLong()-sc.nextLong();
			if (offset<0){
				offset=0;
				idx=startidx+1;
			}
			
			startidx++;
		}
		
		System.out.println(idx);
	}

}
