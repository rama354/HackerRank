package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arrsize = Integer.parseInt(br.readLine());


		if (arrsize < 1 || arrsize > 1000)
			return;
		
		int[] sortedarr=new int[arrsize];
		
		String[] inparr=br.readLine().split(" ");
		
		for(int i=0;i<arrsize-1;i++)
			sortedarr[i]=Integer.parseInt(inparr[i]);
		
		outPutSortStage(sortedarr);

	}

	private static void outPutSortStage(int[] ar) {
		// TODO Auto-generated method stub
		int len=ar.length;
		int insertInt=ar[len-1];
		int idx=len-2;
		while(idx>=0 && insertInt<ar[idx]){
			for(int i=0;i<len;i++){
				if(i==idx+1)
					ar[i]=ar[idx];
				
				System.out.print(ar[i]+" ");
			}
			System.out.println();
			idx--;
		}
		
		for(int i=0;i<len;i++){
			if(i==idx+1)
				ar[i]=insertInt;
			System.out.print(ar[i]+" ");
		}		
		
	}
	
}