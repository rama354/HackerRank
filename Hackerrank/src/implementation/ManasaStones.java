package implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ManasaStones {

	/**
	 * @param args
	 */
	static Set<Integer> stonevals=null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		if (T<1||T>10)
			return;
		
		while(T>0){
			int n=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			if (n<1||n>1000)
				return;
			if (a<1||a>1000)
				return;
			
			if (b<1||b>1000)
				return;
				
			stonevals=new TreeSet<Integer>();
			stonevals.add(0);
			addNextStone(a,b,n-1);
			
			for(int val: stonevals)
				System.out.print(val+" ");
			
			T--;
			
			System.out.println();
		}

	}

	private static void addNextStone(int a,int b,int n) {
		if (n==0)
			return;
		
		Integer[] tempvals=stonevals.toArray(new Integer[stonevals.size()]);
		
		stonevals=new TreeSet<Integer>();
		for(int val:tempvals){
			stonevals.add(val+a);
			stonevals.add(val+b);
		}
		
		addNextStone(a,b,n-1);
		
	}

}
