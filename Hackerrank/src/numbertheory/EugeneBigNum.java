package numbertheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EugeneBigNum {

    private static long defM=(long) (Math.pow(10, 9)+7);
    
    	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);

		int numoftcs = sc.nextInt();

		// System.out.println("numoftcs "+numoftcs);

		if (numoftcs < 1 || numoftcs > 200)
			return;
		
		while(numoftcs>0){
			//String[] inpVal=sc.next().split(" ");
			
			String A=sc.next();
			
			long N=sc.nextLong();
			long M=sc.nextLong();
			
			System.out.println(findModulo(A,N,M));
			
			numoftcs--;
		}

	}

	private static long findModulo(String A, long N, long M) {
		//List<String> XList=new ArrayList<String>();
		
		long segment=1000000;
		int count=0;
		long carry=0,temp=0;
		while(N-count*segment>0)
		{	
			StringBuilder X=new StringBuilder();
			long remain=N-count*segment;
			if (remain<segment)
				segment=remain;
			
			for (int i=0;i<segment;i++){
				 X.append(A);
			}
						
			int startidx=0;
			for (int i=1;i<=X.length();i++){
				temp=Long.parseLong(carry+X.substring(startidx, i));
				if (temp>=M){
					carry=temp%M;
					startidx=i;
				}
				
			}
			 
			count++;
		}
			
		if (temp<M)
			return temp;
		else
			return carry;
	}

	
}