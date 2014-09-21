import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ANC {

	/**
	 * @param args
	 */
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//byte b=127;
		//System.out.println(b);
		Integer num=Integer.parseInt(br.readLine());
		System.out.println(testMethod(num));
		
		
	}
		
		static Integer testMethod(Integer input)
	    {

			int digitsum=0;
			while(Math.abs(input)>0)
			{
				digitsum+=input%10;
				input=input/10;
				
			}
			
	      return Math.abs(digitsum);

		}
	

}
