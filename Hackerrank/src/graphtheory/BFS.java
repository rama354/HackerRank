package graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		while(T>0){
			int N=sc.nextInt();
			int M=sc.nextInt();
			Map<Integer,List<Integer>> adjclist=new HashMap<Integer,List<Integer>>();
			while(M>0){
				int x=sc.nextInt();
				int y=sc.nextInt();
				
				List<Integer> adjnodes=adjclist.get(x);
				if (adjnodes==null){
					adjnodes=new ArrayList<Integer>();
				}
				adjnodes.add(y);
				adjclist.put(x, adjnodes);
				
				adjnodes=adjclist.get(y);
				if (adjnodes==null){
					adjnodes=new ArrayList<Integer>();
				}
				adjnodes.add(x);
				adjclist.put(y, adjnodes);
	
				M--;
			}
			
			int S=sc.nextInt();
			calcShortestDist(N,S,adjclist);
			System.out.println();
			T--;
		}
		

	}

	private static void calcShortestDist(int N,int s,Map<Integer, List<Integer>> adjclist)
	{
		long[] shortestDist=new long[N];
		boolean[] visitedNodes=new boolean[N];
		for (int i=0;i<N;i++){
			shortestDist[i]=-1;
			//visitedNodes[i]=false;
		}
        
		shortestDist[s-1]=0;
		visitedNodes[s-1]=true;
		int dist=0;

		while(true)
		{
            boolean endOfGraph=true;
			for(int i=0;i<N;i++)
				if (shortestDist[i]==dist)
				{
					List<Integer> adjnodes=adjclist.get(i+1);
					if (adjnodes!=null)
						for (int node:adjnodes)
							if (visitedNodes[node-1]==false){
								shortestDist[node-1]=dist+6;
								visitedNodes[node-1]=true;
								endOfGraph=false;
						}
				}
			
			if (!endOfGraph)
                dist+=6;
            else
                break;
		}
		
		
		for (long i:shortestDist)
			if (i!=0)
				System.out.print(i+" ");
			
	}

}
