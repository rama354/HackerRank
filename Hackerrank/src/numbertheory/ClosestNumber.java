package numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClosestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long numoftcs = Long.parseLong(br.readLine());

		if (numoftcs < 1 || numoftcs > 100000)
			return;

		while (numoftcs > 0) {
			String[] params = br.readLine().split(" ");
			long a = Long.parseLong(params[0]);

			if (a < 1 || a > Math.pow(10, 9))
				return;

			long b = Long.parseLong(params[1]);

			if (b < Math.pow(-10, 9) || b > Math.pow(10, 9))
				return;

			if (Math.pow(a, b) <= 0 || Math.pow(a, b) > Math.pow(10, 9))
				return;

			long x = Long.parseLong(params[2]);

			if (x < 1 || x > Math.pow(10, 9))
				return;

			System.out.println(closestNum(a,b,x));
			
			numoftcs--;
		}

	}

	private static long closestNum(long a, long b, long x) {
		long closestNum=0;
		boolean isClosest=false;
		
		long multiplicand=0;
		
		while(!isClosest)
		{
			if (x*multiplicand==Math.pow(a, b)){
				closestNum=x*multiplicand;
				isClosest=true;
			}
			else if(x*multiplicand>Math.pow(a, b))
			{
				double temp1=x*multiplicand-Math.pow(a, b);
				double temp2=Math.pow(a, b)-x*(multiplicand-1);
				closestNum=(temp1<temp2)?x*multiplicand:x*(multiplicand-1);
				isClosest=true;
			}
			
			multiplicand++;
		}
		
		return closestNum;
	}
}
