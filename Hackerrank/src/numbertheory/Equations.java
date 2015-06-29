package numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Equations {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long inpVal = Long.parseLong(br.readLine());

		// System.out.println("numoftcs "+numoftcs);

		if (inpVal < 1 || inpVal > 1000000)
			return;
		
		System.out.println(getSolutions(getFactorial(inpVal)));

	}

	private static BigInteger getFactorial(long inpVal) {
		 BigInteger factorial=BigInteger.ONE;
		 for (long i=1;i<=inpVal;i++)
			 factorial=factorial.multiply(BigInteger.valueOf(i));
		 
		 return factorial;
	}

	private static long getSolutions(BigInteger factorial) 
	{
		long numSoln=0;
		BigDecimal rhs=BigDecimal.ONE.divide(new BigDecimal(factorial,));
		
		for (BigInteger i=1;i<factorial;i++){
			 for (double j=1;j<factorial;j++){
				 
				 double lhs=1/i + 1/j;
				 
				 if (lhs==rhs)
					 numSoln++;
			 }			
		}
		
		return numSoln;
		
	}

}
