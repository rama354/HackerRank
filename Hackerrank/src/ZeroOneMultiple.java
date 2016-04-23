import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


/*find the smallest positive 'zero-one' multiple for a random integer.
 * 'zero-one' number is a number that has only digits 1 & 0(base10 representation)
 * e.g. 4 -->100 3-->111 24 --> 111000 112 -->10010000
 */

public class ZeroOneMultiple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		System.out.println(getBase10Multiple(N));

	}

	private static String getBase10Multiple(int num) {
		long S=1;
		HashSet<Long> prevS=new HashSet<Long>();
        
		while(true)
        {
			if (S%num==0)
				 return  Long.toString(S);
			 else
				 prevS.add(S);
			
			 S*=10; 
			 
			 ArrayList<Long> temp = new ArrayList<Long>();;
			 for (Long pS:prevS)
			 {
				 
				 if ((S+pS)%num==0)
					 return  Long.toString(S+pS);
	            else
					 temp.add(S+pS);
			 }	 
			 prevS.addAll(temp);
		
            
		}
		
	}

	

}
