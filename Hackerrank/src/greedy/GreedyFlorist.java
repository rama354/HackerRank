package greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class GreedyFlorist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		Queue<Integer> flowers=new PriorityQueue<Integer>(Collections.reverseOrder());
		int[] friends=new int[K];
		for (int i=0;i<N;i++)
			flowers.add(sc.nextInt());
	
		int idx=0;
		long mincost=0;
		
		while(N>0)
		{
			if (idx==K)
				idx=0;
            
			if (friends[idx]==0)
                mincost+=flowers.remove();
            else
                mincost+=(friends[idx]+1)*flowers.remove();
            
			friends[idx++]++;
			N--;
		}
        System.out.println(mincost);
		
	}

}
