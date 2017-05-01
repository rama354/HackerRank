package graphtheory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MoonJourney {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int P=sc.nextInt();
		int[] anauts=new int[N];
		for (int i=0;i<N;i++)
			anauts[i]=i;
		
		//int country=0;
		while(P>0){
			int A=sc.nextInt();
			int B=sc.nextInt();
			int tmp=anauts[B];
			for (int i=0;i<N;i++)
				if (anauts[i]==tmp)
					anauts[i]=anauts[A];
							
			P--;
		}
		System.out.println(select(anauts));
	}

	private static long select(int[] astronauts) {
		Map<Integer,Integer> groups=new HashMap<Integer,Integer>();
		for (int i=0;i<astronauts.length;i++){
			Integer count=groups.get(astronauts[i]);
			if (count==null)
				groups.put(astronauts[i],1);
			else
				groups.put(astronauts[i],count+1);
		}
		
		long p = 0,q=0;
		for (int key:groups.keySet()){
			int val=groups.get(key);
			p+=val;
			q+=(val*val);
		}
		return (p*p-q)/2;
	}

}
