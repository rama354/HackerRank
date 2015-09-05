package search;

import java.util.Scanner;

public class MissingNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
           Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		if (n<1||n>1000010)
			return;
		
		int[] A= new int[n];
	 
		for(int i=0;i<n;i++)
			A[i]=sc.nextInt();
		
		//Arrays.sort(A);
        sort(A);
		
		int m=sc.nextInt();
		if (m<1||m>1000010)
			return;
		
		int[] B=new int[m];
		
		for(int i=0;i<m;i++)
			B[i]=sc.nextInt();
		
		//Arrays.sort(B);
        sort(B);
		
		System.out.println(findMissingNum(A,B).trim());
		
    }
    
    		 
	private static void sort(int[] arr) {
		 
		int N = arr.length;
        if (N == 0)
            return;
        /** find max and min values **/
        int max = arr[0], min = arr[0];
        for (int i = 0; i < N; i++)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;
 
        int[] count= new int[range];
    	for(int number : arr){
    		count[number - min]++;
    	}
    	
    	int z= 0;
    	for(int i= min;i <= max;i++){
    		while(count[i - min] > 0){
    			arr[z]= i;
    			z++;
    			count[i - min]--;
    		}
    	}
		
	 }
		
	
    
    private static String findMissingNum(int[] A, int[] B) {
		 
		StringBuilder missnum=new StringBuilder();
		int idx=0;
		for(int i=0;i<A.length;i++)
		{					
			 int currtmp=B[idx];int prevtmp=0;
			 while(A[i]>currtmp)
			 {
				if(currtmp!=prevtmp)
					missnum.append(currtmp).append(" ");
				
				prevtmp=currtmp;
				//idx++;
				currtmp=B[++idx];
				
			}
			idx++;
		}
		
		for (;idx<B.length;idx++){
			int currtmp=B[idx];int prevtmp=0;
			if(currtmp!=prevtmp)
				missnum.append(currtmp).append(" ");
		}
		
		return missnum.toString();
	}
}