package numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class EugeneBigNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numoftcs = Integer.parseInt(br.readLine());


		if (numoftcs < 1 || numoftcs > 200)
			return;
		
		while(numoftcs>0){
			String[] inpVal=br.readLine().split(" ");
			
			long inpA=Long.parseLong(inpVal[0]);
			if (inpA<0 || inpA>1000)
				return;
			
			long inpN=Long.parseLong(inpVal[1]);
			if (inpN<=0 || inpN>=Math.pow(10, 12))
				return;
			
			long inpM=Long.parseLong(inpVal[2]);
			if (inpM<=1 || inpM>=Math.pow(10, 9))
				return;
			
			System.out.println(findModulo(inpA,inpN,inpM));
			
			numoftcs--;
		}

	}

	private static long findModulo(long inpA, long inpN, long inpM) {
		//BigDecimal inpX=BigDecimal.valueOf(inpA);
		long inpX=inpA;
		
		int numOfDigitsA=0;
		
		long tempA=inpA;
		while(tempA>0){			
			tempA=tempA/10;
			numOfDigitsA++;
		}
		
		long multiplicand=(long) Math.pow(10, numOfDigitsA);
		//double multiplicand=Math.pow(10, numOfDigitsA);
		long remainder=0;		
		for(long iter=1;iter<inpN;iter++)
		{			
			inpX=(inpX*multiplicand)+inpA;											
			if (iter%1000==0){
				remainder+=inpX%inpM;
				inpX=inpA;
			}
		}
		return remainder;
		
		//return inpX%inpM;	 
		
	}

}
