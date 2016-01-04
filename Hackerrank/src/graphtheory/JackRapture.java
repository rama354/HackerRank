package graphtheory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JackRapture {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		 
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int E=sc.nextInt();
		int C=0;
		
		Map<Integer,Map<Integer,Integer>> adjclist=new LinkedHashMap<Integer,Map<Integer,Integer>>(N);
		Map<Integer,Integer> minFare=new LinkedHashMap<Integer,Integer>();
		Map<Integer,Boolean> sptSet=new LinkedHashMap<Integer,Boolean>();
		
		for (int i = 1; i <= N; i++)
        {
			minFare.put(i, Integer.MAX_VALUE);
            sptSet.put(i, Boolean.FALSE);
        }
		
		while(C<E){
			int node0=sc.nextInt();
			int node1=sc.nextInt();
			int fare=sc.nextInt();
            
			Map<Integer,Integer> routefares0=adjclist.get(node0);
			if (routefares0==null){
				routefares0=new HashMap<Integer,Integer>();
				routefares0.put(node1,fare);
				adjclist.put(node0, routefares0);
			}
			else
				routefares0.put(node1,fare);
			
			Map<Integer,Integer> routefares1=adjclist.get(node1);
			if (routefares1==null){
				routefares1=new HashMap<Integer,Integer>();
				routefares1.put(node0,fare);
				adjclist.put(node1, routefares1);
			}
			else
				routefares1.put(node0,fare);
			
			C++;
		}
		
		findShortestPath(adjclist,minFare,sptSet,N);
		
		if(minFare.get(N)==Integer.MAX_VALUE)
			System.out.println("NO PATH EXISTS");
		else
			System.out.println(minFare.get(N));
	}

	
	private static void findShortestPath(Map<Integer, Map<Integer, Integer>> adjclist,
										 Map<Integer, Integer> minFare, 
										 Map<Integer, Boolean> sptSet, int n) 
	{
		minFare.put(1, 0);		
		for (int count = 0; count < n-1; count++)
		{
			int u = minDistance(minFare, sptSet,n);
			sptSet.put(u, Boolean.TRUE);
			
			Map<Integer, Integer> routefares=adjclist.get(u);
			
			if (routefares!=null)
				for(int adjvtx:routefares.keySet())
				{
					if (!sptSet.get(adjvtx) && minFare.get(u)!=Integer.MAX_VALUE
						&& minFare.get(u)+ (routefares.get(adjvtx)-minFare.get(u))< minFare.get(adjvtx))
					{
						int deltafare=(routefares.get(adjvtx)-minFare.get(u));
						deltafare=deltafare>0?deltafare:0;
						minFare.put(adjvtx, deltafare+minFare.get(u));
					}
						
				}
			
		}
	}


	private static int minDistance(Map<Integer, Integer> disTo,
								   Map<Integer, Boolean> sptSet, int n) {
		int min = Integer.MAX_VALUE, min_index=-1;
		 
        for (int v = 1; v <= n; v++)
            if (sptSet.get(v) == false && disTo.get(v) <= min)
            {
                min = disTo.get(v);
                min_index = v;
            }
 
        return min_index;
	}

	
}
