package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class PlusMinus {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arrsize = Integer.parseInt(br.readLine());
		
		if (arrsize < 1 || arrsize > 100)
			return;
		
		int[] sortedarr=new int[arrsize];
		
		String[] inparr=br.readLine().split(" ");
		
		for(int i=0;i<arrsize;i++)
			sortedarr[i]=Integer.parseInt(inparr[i]);
		
		outPutFractions(sortedarr);

		
	}

	private static void outPutFractions(int[] arr) {
		Double plus = 0d,minus = 0d,zeroes=0d;
		int len=arr.length;
		for(int i=0;i<len;i++){
			if (arr[i]<0)
				minus++;
			if(arr[i]>0)
				plus++;
			if(arr[i]==0)
				zeroes++;
		}
		
		if(plus>0)
			System.out.println(new BigDecimal(plus/len).setScale(6, BigDecimal.ROUND_HALF_UP));
		if(minus>0)
			System.out.println(new BigDecimal(minus/len).setScale(6, BigDecimal.ROUND_HALF_UP));
		if(zeroes>0)
			System.out.println(new BigDecimal(zeroes/len).setScale(6, BigDecimal.ROUND_HALF_UP));
		
	}

}
