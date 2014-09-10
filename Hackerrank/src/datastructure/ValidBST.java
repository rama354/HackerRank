package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Waiting to submit in Java language in HackerRank
 * @author kartik
 *
 */

public class ValidBST {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static TreeMap<Integer,Node> nodelist=null;
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		int numTc=Integer.parseInt(br.readLine());
		if (numTc<1 || numTc>10)
			return;
		 
		int execTc=1;
		while (execTc<=numTc)
		{
			int numOfNodes=Integer.parseInt(br.readLine());
			if(numOfNodes<1 || numOfNodes>100)
				 return;
			
			String[] nodes=br.readLine().split(" ");
			nodelist=new TreeMap<Integer,Node>();
			System.out.println(createPreOrderBST(nodes));
			
			execTc++;
		}
	}
	
	
	
	private static String createPreOrderBST(String[] nodes) 
	{

		int rootnodeval=Integer.parseInt(nodes[0]);
		Node rootnode=new Node(1,rootnodeval,null);
		nodelist.put(1, rootnode);
		
		createSubTree(nodes,1,rootnode);
		if (nodelist.size()==nodes.length)
			return "YES";
		
		return "NO";	
	}



    private static void createSubTree(String[] nodes,int nodeindx,Node rootnode) 
    {
    
    	for (int i=0;i<nodes.length;i++)
		{
			if (nodelist.get(i+1)!=null)
				continue;
			
			int	nodevalue=Integer.parseInt(nodes[i]);
			
			if (nodevalue<rootnode.nodevalue)
			{
				    Node parentnode=getSubTreePos(rootnode,nodevalue);
				    if (parentnode==null)
				    	break;
				    
			    	++nodeindx;
					Node node=new Node(nodeindx,nodevalue,parentnode);
					parentnode.left=node;
					nodelist.put(nodeindx, node);
				  
					
				
			}
		
	    	if (nodevalue>rootnode.nodevalue)
	    	{
	    		Node parentnode=getSubTreePos(rootnode,nodevalue);
	    		if (parentnode==null)
			    	break;
			    
		    		++nodeindx;
					Node node=new Node(nodeindx,nodevalue,parentnode);
					parentnode.right=node;
					nodelist.put(nodeindx, node);
			    
	    	}
	    
		}
				
     	
	}



   private static Node getSubTreePos(Node parentnode, int nodevalue) 
   {	
	   if (nodevalue < parentnode.nodevalue)
	   {
		   if (parentnode.left==null)
			   	return parentnode;
		
		   return getSubTreePos(parentnode.left,nodevalue);
	   }
		
	   if (nodevalue > parentnode.nodevalue)
	   {
		   if (parentnode.right==null)
			   	return null;
		   
		   return getSubTreePos(parentnode.right,nodevalue);
	   }
    	
	   return null;
	}



private static class Node implements Comparable<Node>{
		
		int index=-1;
		int nodevalue;
		public Node parentnode=null;	
		public Node left=null;
		public Node right=null;
		//boolean istraversed=false;
		
		public Node(int index,int nodevalue,Node parentnode){
			this.index=index;
			this.nodevalue=nodevalue;
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
