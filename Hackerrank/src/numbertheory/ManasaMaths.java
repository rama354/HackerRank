package numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManasaMaths {

	/**
	 * @param args
	 * @throws  
	 * @throws Exception 
	 */
	private static Set<ArrayList<Long>> permSet=null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int numoftcs=Integer.parseInt(br.readLine());
		 
               
         if (numoftcs<1 || numoftcs>45)
                return;
        
         while(numoftcs>0){
        	 
        	 long integer=Long.parseLong(br.readLine());
        	 
        	 if (integer<0 || integer>Math.pow(10, 110))
        		 return;
        	 
        	 List<Long> digits=new ArrayList<Long>();
        		
     		while(integer>0){		 
     			digits.add(integer%10);
     			integer/=10;
     		}
     		
     		permSet=new HashSet<ArrayList<Long>>();
     		
     		//for (int i=0;i<digits.size();i++)
     			// genPermutation(digits.get(i),digits,digits.get(i),1);
     		
     		Collections.sort(digits);
     		
     		if (digits.size()==2){
     			permSet.add(new ArrayList<Long>(digits));
    			swap(digits, 0, 1);
    			permSet.add(new ArrayList<Long>(digits));
    		}
     		else if (digits.size()==1)
     			permSet.add(new ArrayList<Long>(digits));
     		else
     		{
     			while(genPermutation(digits))
           		 permSet.add(new ArrayList<Long>(digits));
     		}
        	
        	createNumbersAndCheck();
        	/*boolean isdivBy8=false;	 
        	 
        	 for(Integer permute:permSet){        		 
        		 if(permute%8==0)
        		 {
        			 isdivBy8=true;
        			 break;
        		 }		 
        	 }
        	 
        	 if(isdivBy8)
        		 System.out.println("YES");
        	 else
        		 System.out.println("NO");*/
        	 
        	 numoftcs--;
         }
	}

	
	private static void createNumbersAndCheck() {
		 for (ArrayList<Long> list:permSet)
		 {		 
			 long permutation=0;
			 for (int i=0;i<list.size();i++)
				 permutation+=list.get(i)*((int)Math.pow(10, i));
			 
			 if (permutation%8==0){
				 System.out.println("YES");
				 return;
			 }
				 
		 }	
		 
		 System.out.println("NO");
	}


	private static boolean genPermutation(List<Long> digits) 
	{
		 	
		 int k = digits.size() - 2;
		    
		 while (digits.get(k) >= digits.get(k + 1)) {
		        k--;
		        if (k < 0) {
		            return false;
		        }
		    }
		    int l = digits.size() - 1;
		    
		 while (digits.get(k) >= digits.get(l)) {
		        l--;
		    }
		    
		    swap(digits, k, l);
		    int length = digits.size() - (k + 1);
		    
		    for (int i = 0; i < length / 2; i++) {
		        swap(digits, k + 1 + i, digits.size() - i - 1);
		    }
		    
		    return true;
		
	}


	private static void swap(List<Long> digits, int k, int l) {
		 Long temp=digits.get(k);
		 digits.set(k, digits.get(l));
		 digits.set(l, temp);
		
	}


	
	/*private static void genPermutation(Integer prevdigit,
			List<Integer> digits,int permutation,int size) 
	{
		if (size<digits.size())
		{
			for (int i=0;i<digits.size();i++)
			{
			     Integer currplaceval=digits.get(i);
			     if (currplaceval==prevdigit)
			    	 continue;
			         
			        permutation+=currplaceval*((int) Math.pow(10,size));
			     	genPermutation(currplaceval,digits,permutation,size+1);
		   }
		}
		else
		{
			permSet.add(permutation);
		}
		
	}
	*/

	
}
