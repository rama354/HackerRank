package graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PrimMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
	    int [][] wt_tree=new int[N+1][N+1];
	    Map<Integer,ArrayList<Integer>> adjlist=new HashMap<Integer,ArrayList<Integer>>();
		while (M>0){
			int x=sc.nextInt();
			int y=sc.nextInt();
			int w=sc.nextInt();
			wt_tree[x][y]=w;
			wt_tree[y][x]=w;
			ArrayList<Integer> x_nodes=adjlist.get(x);
			ArrayList<Integer> y_nodes=adjlist.get(y);
			if (x_nodes==null)
				x_nodes=new ArrayList<Integer>();
			x_nodes.add(y);	
			adjlist.put(x, x_nodes);
			
			if (y_nodes==null)
				y_nodes=new ArrayList<Integer>();
			y_nodes.add(x);	
			adjlist.put(y, y_nodes);
			
			M--;
		}
		List<Integer> primNodeList=new ArrayList<Integer>();
		primNodeList.add(sc.nextInt());
		
		int mst_wt=0;
		while(primNodeList.size()<N)
		{
			int min_wt=Integer.MAX_VALUE;
			int mst_node=0;
			for (int node:primNodeList)
			{
				List<Integer> s_nodes=adjlist.get(node);
				for( int s_node:s_nodes)
				{
					if (!primNodeList.contains(s_node) && wt_tree[node][s_node]>0)
					{	
						min_wt=Math.min(min_wt,wt_tree[node][s_node]);
						mst_node=min_wt==wt_tree[node][s_node]?s_node:mst_node;
					}
				}	
			}
			mst_wt+=min_wt;
			primNodeList.add(mst_node);
		}
		
		System.out.println(mst_wt);
	}

}
