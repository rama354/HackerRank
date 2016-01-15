package euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NthPowerSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner sc=new Scanner(System.in);
		 int N=sc.nextInt();
		 
		findNthPowerSum(N);
    }
    
    private static void findNthPowerSum(int n) {
		 
		 List<Integer> currdigits=null;
		 List<Integer> prevdigits=new ArrayList<Integer>();
		 
		 prevdigits.add(0);
		
		 for (int i=100;i<10000;i++)
		 {
			 currdigits=new ArrayList<Integer>();
			 int powersum=0;
			 int tempnum=i;
			 while(tempnum>0){
				 powersum+=Math.pow(tempnum%10,n);
				 tempnum/=10;
			 }
			 
			 if (powersum==i)
			 {
				 while(powersum>0){
					 currdigits.add((int) (powersum%10));
					 powersum/=10;
				 }
				 
				 prevdigits=addOperation(prevdigits,currdigits);   
		
			 }
			 
		 }
		 
		 for (int j=prevdigits.size()-1;j>=0;j--)
			 System.out.print(prevdigits.get(j));
		 
	}
    
    private static List<Integer> addOperation(List<Integer> prevdigits,List<Integer> currdigits)
											 
	{
		 int carry=0;	 
		 int prevlen=prevdigits.size();
		 int currlen=currdigits.size();
		 int minlen=Math.min(prevlen,currlen);
		 //List<Integer> temp= new ArrayList<>(currdigits);
		 for (int i=0;i<minlen;i++){
			 int sum=currdigits.get(i)+prevdigits.get(i)+carry;
			 currdigits.set(i, sum%10);
			 carry=sum/10;		 
		 }
		 
		 while(carry>0)
		 {
			 int overflow=carry;
             
			 if (currlen<prevlen){
				overflow=prevdigits.get(minlen)+overflow;
			 	currdigits.add(overflow%10);	
			 }
             if (currlen>prevlen){
                 overflow=currdigits.get(minlen)+overflow;
			 	 currdigits.set(minlen,overflow%10);	
             }
			 
             if (currlen==prevlen)
				 currdigits.add(overflow);
			 
             minlen++;
			 carry=overflow/10;
		 }
		 
		 return new ArrayList<Integer>(currdigits);
	}

}
