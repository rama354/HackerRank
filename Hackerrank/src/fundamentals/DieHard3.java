package fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DieHard3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 final BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	      int numtc= Integer.parseInt(br.readLine());  
	      
	      if (numtc<1||numtc>100)
	    	  return;
	      
	      while(numtc--!=0){
	    	  String[] capacities=br.readLine().split(" ");
	    	  int a=Integer.parseInt(capacities[0]);
	    	  if(a<1||a>1000)
	    		  return;
	    	  
	    	  int b=Integer.parseInt(capacities[1]);
	    	  if(a<1||a>1000)
	    		  return;
	    	  
	    	  int c=Integer.parseInt(capacities[2]);
	    	  if(a<1||a>1000)
	    		  return;
	    	  
	    	  System.out.println(yippiKayYay(a,b,c));
	    	  
	      }
	      

	}

	private static String yippiKayYay(int a, int b, int c) {
	   
			/*if (c%a==0 || c%b==0 || a%c==0 || b%c==0)
				return "YES";
			
			if (c>a && c>b)
				return "NO";
			
			int maxcap=Math.max(a, b);
			int mincap=Math.min(a, b);
	 
			int modulo=0;
			modulo=maxcap%mincap;
			
			int counter=0;
			
			while(modulo>0 && counter<)
			{
				if (c%modulo==0 || modulo%c==0)
				  return "YES";
				else{
				 
					if (modulo<mincap)
						modulo=(maxcap-(mincap-modulo))%mincap;
				}
				counter++;
			}
		 
			return "NO";
		*/
		/*if (c%a==0 || c%b==0 || a%c==0 || b%c==0)
			return "YES";*/
		
		int maxcap=Math.max(a, b);
		int mincap=Math.min(a, b);
		
		if (c%gcd(maxcap,mincap)==0 && c<=maxcap){
			 return "YES";
		}
			
		return "NO";
		
	}

	 private static int gcd(int K, int M) {
	      int k = K;   // In order to state a simple, elegant loop invariant,
	      int m = M;   // we keep the formal arguments constant and use 
	                   // local variables to do the calculations.
	      // loop invariant: GCD(K,M) = GCD(k,m)
	      while (k != m) {
	         if (k > m) 
	            { k = k-m; }
	         else 
	            { m = m-k; }
	      }
	      // At this point, GCD(K,M) = GCD(k,m) = GCD(k,k) = k
	      return k;
	   }
}
