package search;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GridCell {

	/**
	 * @param args
	 */
	static Map<Integer, Integer> connectedcells=null;
	static Map<Integer,Boolean> visited=null;
	//static List<Integer> connectCount=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
		
		int m=sc.nextInt();
		int n=sc.nextInt();
		
		//int[][] matrix=new int[m][n];
		
		connectedcells=new LinkedHashMap<Integer,Integer>();
		
		int C = 0;
		while(C<(m*n)){
			int val = sc.nextInt();
			if (val == 1)
				connectedcells.put(C, val);
			
			C++;
		}
		
		visited=new LinkedHashMap<Integer, Boolean>();
        for (int key:connectedcells.keySet())
				visited.put(key,Boolean.FALSE);
        
		int maxconnect=0;
		
		for (int key:connectedcells.keySet()){
			int row=key/n;
			int col=key%n;
			if (!visited.get(key))
				visited.put(key, true);
			else
				continue;
			
			int connectCount=dfs(row,col,n);
			maxconnect=maxconnect>connectCount?maxconnect:connectCount;
		}
		
		System.out.println(maxconnect);
	}

	private static int dfs(int row, int col, int n) {
		int connectCount = 1;

		int connectKey = row * n + (col + 1);
		if (col + 1 != n) {
			if (connectedcells.containsKey(connectKey)
					&& !visited.get(connectKey)) {
				visited.put(connectKey, true);
				connectCount += dfs(row, col + 1, n);
			}
		}

		connectKey = row * n + (col - 1);
		if (col - 1 >= 0) {
			if (connectedcells.containsKey(connectKey)
					&& !visited.get(connectKey)) {
				visited.put(connectKey, true);
				connectCount += dfs(row, col - 1, n);
			}
		}

		connectKey = (row - 1) * n + (col + 1);
		if (col + 1 != n) {
			if (connectedcells.containsKey(connectKey)
					&& !visited.get(connectKey)) {
				visited.put(connectKey, true);
				connectCount += dfs(row - 1, col + 1, n);

			}
		}

		connectKey = (row - 1) * n + (col - 1);
		if (col - 1 >= 0) {
			if (connectedcells.containsKey(connectKey)
					&& !visited.get(connectKey)) {
				visited.put(connectKey, true);
				connectCount += dfs(row - 1, col - 1, n);
			}
		}

		connectKey = (row + 1) * n + (col + 1);
		if (col + 1 != n) {
			if (connectedcells.containsKey(connectKey)
					&& !visited.get(connectKey)) {
				visited.put(connectKey, true);
				connectCount += dfs(row + 1, col + 1, n);
			}
		}

        connectKey = (row + 1) * n + (col - 1);
		if (col - 1 >= 0) {	
			if (connectedcells.containsKey(connectKey)
					&& !visited.get(connectKey)) {
				visited.put(connectKey, true);
				connectCount += dfs(row+1, col-1, n);
			}
		}

		connectKey = (row + 1) * n + col;
		if (connectedcells.containsKey(connectKey) && !visited.get(connectKey)) {
			visited.put(connectKey, true);
			connectCount += dfs(row+1, col, n);
		}

		connectKey = (row + 1) * n + col;
		if (connectedcells.containsKey(connectKey) && !visited.get(connectKey)) {
			visited.put(connectKey, true);
			connectCount += dfs(row+1, col, n);
		}

		return connectCount;
	}

}
