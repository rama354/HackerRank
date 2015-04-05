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
		BigDecimal inpX=BigDecimal.valueOf(inpA);
		//long inpX=inpA;
		
		int numOfDigitsA=0;
		
		long tempA=inpA;
		while(tempA>0){			
			tempA=tempA/10;
			numOfDigitsA++;
		}
		
		BigDecimal multiplicand=BigDecimal.valueOf(Math.pow(10, numOfDigitsA));
		//double multiplicand=Math.pow(10, numOfDigitsA);
		
		for(long i=1;i<inpN;i++){
			inpX=inpX.multiply(multiplicand).add(BigDecimal.valueOf(inpA));
											//.divideAndRemainder(BigDecimal.valueOf(1000000007L))[1];
			//inpX=(long) ((inpX*multiplicand+inpA)%1000000007L);
		
		}
		
		return inpX.divideAndRemainder(BigDecimal.valueOf(inpM))[1].longValue();
		//return inpX%inpM;
		 
		
	}

}
