package graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EvenTree {

	static Map<Integer,List<Integer>> adjclist=null;
static Map<Integer,Boolean> visited=null;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		if (N<2||N>100)
			return;
		
		String[] edges=new String[M];
		int C=0;
		while(C<M){
			edges[C]=sc.nextLine();
			C++;
		}
		
		adjclist=new HashMap<Integer,List<Integer>>(N);

		for(String edge:edges){
			String[] nodes=edge.split(" ");
			int node0=Integer.parseInt(nodes[0]);
			int node1=Integer.parseInt(nodes[1]);
			
			List<Integer> adjvertices=adjclist.get(node0);
			if (adjvertices==null){
				adjvertices=new ArrayList<Integer>();
				adjvertices.add(node1);
				adjclist.put(node0, adjvertices);
			}
			else
				adjvertices.add(node1);
			
			
			adjvertices=adjclist.get(node1);
			if (adjvertices==null){
				adjvertices=new ArrayList<Integer>();
				adjvertices.add(node0);
				adjclist.put(node1, adjvertices);
			}
			else
				adjvertices.add(node0);
			
		}
		
		visited=new HashMap<Integer,Boolean>(N);
		initialize();
		int connectedComponents=0;
		
		for(int i = 1;i <=N;++i) 
		{
		     if(visited.get(i) == false){
		         dfs(i);
		         connectedComponents++;
		     }
		 }
		
	}

	private static void dfs(int node) {
		visited.put(node,true);
		
	    for(int i = 0;i<adjclist.get(node).size();++i)
	    	if(visited.get(adjclist.get(node).get(i)) == false)
	        		dfs(adjclist.get(node).get(i));
	   
		
	}

	private static void initialize() {
		for(int i = 1;i <= 10;++i)
		    visited.put(i, false);
	}
}
