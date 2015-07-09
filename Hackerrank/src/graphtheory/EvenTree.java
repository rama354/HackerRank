package graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EvenTree {

    static Map<Integer,List<Integer>> adjclist=null;
    static Map<Integer,Boolean> visited=null;
	static Map<Integer,Integer> disconnect=new HashMap<Integer,Integer>();
    static int rootNode;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		if (N<2||N>100)
			return;
		
		String[] edges=new String[M];
		int C=0;
		while(C<M){
			edges[C]=sc.next()+" "+sc.next();
			C++;
		}
		
		adjclist=new LinkedHashMap<Integer,List<Integer>>(N);

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
		
		rootNode=Integer.parseInt(edges[0].split(" ")[1]);
		
		visited=new HashMap<Integer,Boolean>(N);
		initialize(N);
		
		
		/*for(int i = 1;i <=N;++i) 
		{
		     if(visited.get(i) == false){
		         dfs(i);
		         connectedComponents++;
		     }
		 }*/
		dfs(rootNode,0);
        if (disconnect.containsKey(rootNode))
			System.out.println(disconnect.size()-1);
		else
			System.out.println(disconnect.size());

    }
    
    private static void dfs(int node,int parentNode) {
		visited.put(node,true);
		
	    /*for(int i = 0;i<adjclist.get(node).size();++i)
	    	if(visited.get(adjclist.get(node).get(i)) == false)
	        		dfs(adjclist.get(node).get(i));*/
	   
		if (node!=rootNode && (adjclist.get(node).size()+1)%2==0){
			disconnect.put(parentNode, node);
			return;
		}
		for(int i=0;i<adjclist.get(node).size();++i)
			if(visited.get(adjclist.get(node).get(i)) == false && adjclist.get(node).get(i)!=parentNode)
					dfs(adjclist.get(node).get(i),node);
		
	}
    
    private static void initialize(int vertices) {
		for(int i = 1;i <=vertices;++i)
		    visited.put(i, false);
	}

}