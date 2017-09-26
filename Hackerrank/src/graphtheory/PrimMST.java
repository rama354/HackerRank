package graphtheory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class PrimMST {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
	    Map<Integer,PriorityQueue<Edge>> adjlist=new HashMap<Integer,PriorityQueue<Edge>>();
		while (M>0){
			int x=sc.nextInt();
			int y=sc.nextInt();
			int w=sc.nextInt();
			Edge edge=new Edge(x,y,w);
			PriorityQueue<Edge> x_edges=adjlist.get(x);
			PriorityQueue<Edge> y_edges=adjlist.get(y);
			if (x_edges==null)
				x_edges=new PriorityQueue<Edge>();
			x_edges.add(edge);	
			adjlist.put(x, x_edges);
			
			if (y_edges==null)
				y_edges=new PriorityQueue<Edge>();
			y_edges.add(edge);	
			adjlist.put(y, y_edges);
			
			M--;
		}
		Set<Integer> primNodeSet=new HashSet<Integer>();
		primNodeSet.add(sc.nextInt());
		
		int mst_wt=0;
		while(primNodeSet.size()<N)
		{
			int min_wt=Integer.MAX_VALUE;
			Edge mst_edge=null;
			for (int node:primNodeSet)
			{
				PriorityQueue<Edge> edges=adjlist.get(node);
				while(!edges.isEmpty()){
					Edge min_edge=edges.peek();
					if (min_edge!=null)
					{
						if (!primNodeSet.contains(min_edge.from_node) || !primNodeSet.contains(min_edge.to_node))
						{
							   min_wt=Math.min(min_wt,min_edge.weight);
							   mst_edge=min_wt==min_edge.weight?min_edge:mst_edge;
							   break;
						}
						else
						{
							adjlist.get(min_edge.from_node).remove(min_edge);
							adjlist.get(min_edge.to_node).remove(min_edge);
							
						}		
					}	
				}
			}
			mst_wt+=min_wt;
			primNodeSet.add(mst_edge.to_node);
			primNodeSet.add(mst_edge.from_node);
            adjlist.get(mst_edge.from_node).remove(mst_edge);
            adjlist.get(mst_edge.to_node).remove(mst_edge);
		}
		
		System.out.println(mst_wt);
	}

	static class Edge implements Comparable<Edge>{
		int from_node;
		int to_node;
		int weight;
		Edge(int from_node,int to_node,int weight){
			this.from_node=from_node;
			this.to_node=to_node;
			this.weight=weight;
		}
		@Override
		public int compareTo(Edge e) {
			return Integer.valueOf(weight).compareTo(e.weight);
		}	
		
	}
}
