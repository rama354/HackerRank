package graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EvenTree {

	/**
	 * @param args
	 */
	static boolean[] visited=null;
	
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
		
		Map<Integer,List<Integer>> adjclist=new HashMap<Integer,List<Integer>>(N);

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
		
		visited=new boolean[N];
		initialize();
		int connectedComponents=0;
		
		for(int i = 1;i <=N;++i) 
		{
		     if(visited[i] == false){
		         dfs(i);
		         connectedComponents++;
		     }
		 }
		
	}

	private static void dfs(int node) {
		visited[node] = true;
	    for(int i = 0;i < adj[s].size();++i)    {
	     if(visited[adj[s][i]] == false)
	         dfs(adj[s][i]);
	    }
		
	}

	private static void initialize() {
		for(int i = 0;i < 10;++i)
		     visited[i] = false;
	}

	

}
