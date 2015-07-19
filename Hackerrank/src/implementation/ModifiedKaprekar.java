package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifiedKaprekar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int P=sc.nextInt();
		int Q=sc.nextInt();
		
		if (P<0||P>Q||Q>100000)
			return;
		
		System.out.println(findModKapNum(P,Q));
		

	}

	private static String findModKapNum(long p, long q) {
		String modKapRange=new String();
		
		for(long i=p;i<=q;i++){
			
			long modKap=i;
			long modkapsquare=modKap*modKap;
			
			List<Integer> digitsSquare=new ArrayList<Integer>();
			
			while(modkapsquare>0){
				digitsSquare.add((int) (modkapsquare%10));
				modkapsquare/=10;
			}
			
			long rightNum=0,leftNum=0;
			int d=(digitsSquare.size()%2==0)?digitsSquare.size()/2:(digitsSquare.size()+1)/2;
			
			for(int j=0;j<digitsSquare.size();j++){
				if(j<d)
					rightNum+=digitsSquare.get(j)*Math.pow(10,j);
				else
					leftNum+=digitsSquare.get(j)*Math.pow(10,j-d);
			}
			
			if(rightNum+leftNum==i)
				modKapRange+=Long.toString(i)+" ";
		}
			
		if(modKapRange.length()==0)
			return "INVALID RANGE";
		else
			return modKapRange;
	}

}
