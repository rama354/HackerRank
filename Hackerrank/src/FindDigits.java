import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FindDigits {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int numoftcs=Integer.parseInt(br.readLine());
		 
              
        if (numoftcs<1 || numoftcs>15)
               return;
       
        while(numoftcs-->0){
        	
        	long integer=Long.parseLong(br.readLine());
        	if (integer<0||integer>=Math.pow(10,10))
        		return;
        	
        	System.out.println(findDigits(integer));
        }

	}

	private static int findDigits(long integer) {
		// TODO Auto-generated method stub
		long n=integer;
		int count=0;
		while(integer>0){
			if((integer%10)!=0 && n%(integer%10)==0)
				count++;
			
			 integer/=10;
		}
		
		return count++;
	}

}
