package graphtheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EvenTree {

	/**
	 * @param args
	 */
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
		
		HashMap<Integer,Integer> subtrees=new HashMap<Integer,Integer>();

		for(String edge:edges){
			String[] nodes=edge.split(" ");
			int node0=Integer.parseInt(nodes[0]);
			if(subtrees.containsKey(node0)){
				int nodecount=subtrees.get(node0);
				subtrees.put(node0, nodecount++);
			}
			else{
				subtrees.put(node0, 1);
			}
	
		}
		
		
		//List<Integer> targetNodes=getEvenNodesSubTrees(subtrees);
		
	}

	private static List<Integer> getEvenNodesSubTrees(HashMap<Integer, Integer> subtrees) {
		List<Integer> tempNodes=new ArrayList<Integer>();
		
		for(Integer node:subtrees.keySet()){
			if(subtrees.get(node)%2==0)
				
				
		}
		
	}

}
