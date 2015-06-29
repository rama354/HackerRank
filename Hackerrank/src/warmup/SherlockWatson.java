package warmup;

import java.util.Scanner;

public class SherlockWatson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int K = sc.nextInt();
	    int Q = sc.nextInt();
	    int C=0;
	    if (N<1 || N>100000)
	    	return;
	   
	    if (K<1 || K>100000)
	    	return;
	    
	    if (Q<1 || Q>500)
	    	return;
	     
	    int[] arr=new int[N];
	    while(C<N)
	    {
	        arr[C] = sc.nextInt();
	        ++C;
	    }

	    
	    int shift=rightRotation(arr,K);
	    C=0;
	    while(C<Q)
	    {
	        int idx = sc.nextInt();
         	for(int i=0;i<N;i++)
         		if (idx==(i+shift)%N)
                 	System.out.println(arr[i]);
                 
	        ++C;

	    }
	    
    }
	
    private static int rightRotation(int[] arr, int k) {
		 int len=arr.length;
		 int shift=0;
		 
		 if (k!=1 || len!=1)
			 shift=(k<=len)?k:k%len;
		 
		 if (k==1)
			 shift=k;
		 
		 if (len==1)
			 shift=0;
		 
		 return shift;
	}

}
