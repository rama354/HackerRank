package crossover;

import java.util.Arrays;

public class MergeArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		int[] a={3,5,6,9,12,38,18,20,25,28};
		
		int[] b={30,32,34,36,14,40,42,44,46,48,0,0,0,0,0,0,0,0,0,0};
		
		int M=10;
		
		mergeArray(a, b, M );
		System.out.println(b.length);
		for (int i:b){
			System.out.println(i);
		}

	}

	private static void mergeArray(int[] a, int[] b, int m) {
		
		 for (int i=m;i<2*m;i++){
			 b[i]=a[i-m];
		 }
		 
		 Arrays.sort(b);
		
	}

}
