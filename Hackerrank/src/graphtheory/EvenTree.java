package graphtheory;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EvenTree {

    static Map<Integer,List<Integer>> adjclist=null;
    static Map<Integer,Boolean> visited=null;
    static int disconnect=0;
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
		
		dfs(rootNode,0);
        System.out.println(disconnect);
    }
    
     private static int dfs(int node,int parentNode) {
		//visited.put(node,true);
		int nodeCount=0;
	    
		
		for(int i=0;i<adjclist.get(node).size();++i)
			if(adjclist.get(node).get(i)!=parentNode)
					nodeCount+=dfs(adjclist.get(node).get(i),node);
            
        if (node!=rootNode && (nodeCount+1)%2==0){
			disconnect++;
			return 0;
		}
		else
            return nodeCount+1;
	}
    
     /*private static void initialize(int vertices) {
		for(int i = 1;i <=vertices;++i)
		    visited.put(i, false);
	}*/
}