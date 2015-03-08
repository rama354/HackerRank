package numbertheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManasaMaths {

	/**
	 * @param args
	 * @throws  
	 * @throws Exception 
	 */
	private static Set<Integer> permSet=null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int numoftcs=Integer.parseInt(br.readLine());
	      
         //System.out.println("numoftcs "+numoftcs);    
               
         if (numoftcs<1 || numoftcs>45)
                return;
        
         while(numoftcs>0){
        	 
        	 int integer=Integer.parseInt(br.readLine());
        	 
        	 if (integer<0 || integer>Math.pow(10, 110))
        		 return;
        	 
        	 List<Integer> digits=new ArrayList<Integer>();
        		
     		while(integer>0){		 
     			digits.add(integer%10);
     			integer/=10;
     		}
     		
     		permSet=new HashSet<Integer>();
     		for (int i=0;i<digits.size();i++)
     			 genPermutation(digits.get(i),digits,digits.get(i),1);
        	
        	boolean isdivBy8=false;	 
        	 
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
        		 System.out.println("NO");
        	 
        	 numoftcs--;
         }
	}

	private static void genPermutation(Integer prevdigit,
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

	
}
