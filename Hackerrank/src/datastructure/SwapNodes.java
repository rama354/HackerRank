package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class SwapNodes {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static TreeMap<Integer,Node> nodelist=null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 int numOfNodes=Integer.parseInt(br.readLine());
		 if(numOfNodes<1 || numOfNodes>1024)
			 return;
		 
		 nodelist=new TreeMap<Integer,Node>();
		 Node node=new Node(1,-1,-1);//root nod
		 node.depth=1;
		 nodelist.put(1, node);
	
		 int inplines=1;//int nodesread=1;
		 
		 while(inplines<=numOfNodes)
		 {
			   String[] inp=br.readLine().split(" ");
			   if (!inp[0].equalsIgnoreCase("-1")){
				   Node leftnode=new Node(Integer.parseInt(inp[0]),inplines,0);
				   nodelist.put(Integer.parseInt(inp[0]),leftnode);
				   //nodesread++;
				   Node parentnode=nodelist.get(inplines);
				   parentnode.leftchildidx=Integer.parseInt(inp[0]);
			   }
			   if (!inp[1].equalsIgnoreCase("-1")){
				   Node rightnode=new Node(Integer.parseInt(inp[1]),inplines,1);
				   nodelist.put(Integer.parseInt(inp[1]),rightnode);
				   //nodesread++;
				   Node parentnode=nodelist.get(inplines);
				   parentnode.rightchildidx=Integer.parseInt(inp[1]);
			   }
			   inplines++;
		 }
		 
		 setNodeDepths(numOfNodes);
		 int numOfSwapOpr=Integer.parseInt(br.readLine());
		 for(int i=0;i<numOfSwapOpr;i++){
			 doSwapAndTraversal(numOfNodes,Integer.parseInt(br.readLine()),nodelist);
			 //for(Node n:nodelist.values())
			//	 n.istraversed=false;
		 }
		 

	}
	
	
	private static void doSwapAndTraversal(int lastnode,int depth, TreeMap<Integer, Node> primlist) 
	{
		List<Node> templist=new ArrayList<Node>();
		int lastNodeDepth=primlist.get(lastnode).depth;
		int weight=1;
		while(depth*weight<=lastNodeDepth)
		{
			for (Node n: primlist.values())
			{
				if (n.depth==depth*weight)
					templist.add(n);
			}
			weight++;
		}	
			for (Node n:templist)
			{
				int tempidx=n.leftchildidx;
				n.leftchildidx=n.rightchildidx;
				n.rightchildidx=tempidx;
				
			}
			
		int refnode=1,traversecount=0,subtree=0;
		
		while(traversecount<=lastnode)
		{		
			Node n1=getSubtree(primlist.get(refnode),subtree);
			//if(n1==null)n1=primlist.get(refnode);
			System.out.print(n1.index+" ");
			traversecount++;
			if (n1.rightchildidx!=-1){
				subtree=1;
				refnode=n1.index;
			}
			else
				refnode=n1.parentnode;
						 			
			if (refnode==-1)
				break;
		}
		
		System.out.println();
	}


	private static Node getSubtree(Node n,int subtree) 
	{
		Node tempnode;
		if(subtree==0)
			tempnode=nodelist.get(n.leftchildidx);
		else
			tempnode=nodelist.get(n.rightchildidx);
		
		if (tempnode!=null && !tempnode.istraversed)
		{
			if (tempnode.leftchildidx != -1)
				subtree=0;
			
			n=getSubtree(tempnode,subtree);		
		}
		return n;
	}



	private static void setNodeDepths(int numOfNodes) 
	{
	   int parentnode=1;int depth=2;
	   while(parentnode!=numOfNodes)
	   {
		   for(Node n:nodelist.values())
		   {
			   if(n.parentnode==parentnode)
				   n.depth=nodelist.get(parentnode).depth+1;

		   }
		   parentnode++;
	   }
	   
		
	}


	private static class Node implements Comparable<Node>{
		
		int index=-1;
		int parentnode=-1;
		int depth;
		int leftchildidx=-1;
		int rightchildidx=-1;
		int subtree;
		boolean istraversed=false;
		
		public Node(int index,int parentnode,int subtree){
			this.index=index;
			this.subtree=subtree;
			this.parentnode=parentnode;
		}

		@Override
		public int compareTo(Node o) {
			 if(index>o.index)
				 return 1;
			 if(index<o.index)
				 return -1;
			return 0;
		}
	}

}
