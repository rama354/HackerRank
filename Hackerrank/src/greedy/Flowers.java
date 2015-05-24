package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Flowers {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			String[] params = br.readLine().split(" ");
			int flowercount = Integer.parseInt(params[0]);
			
			int buyercount=Integer.parseInt(params[1]);
			
			if (flowercount<1||flowercount>100)
				return;
			
			if (buyercount<1||buyercount>100)
				return;
			
			String[] str = br.readLine().split(" ");
			Long[] flowerprices=new Long[str.length];
			for(int i=0;i<str.length;i++)
				flowerprices[i]=Long.parseLong(str[i]);
			
			if (flowerprices.length!=flowercount)
				return;
			
			System.out.println(computeTotalCost(flowercount,buyercount-1,flowerprices));
		
		
}

	
	private static int computeTotalCost(int flowercount, int buyercount,
			Long[] flowerprices) 
	{
		 HashMap<Integer, String> perbuyer=new HashMap<Integer, String>();
		 Arrays.sort(flowerprices, new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				 if (o1.intValue()<o2.intValue())
					 return 1;
				 if(o1.intValue()>o2.intValue())
					 return -1;
				 
				 return 0;
			}
			 
		});
		 
		 List<Long> pricelist=new ArrayList<Long>(Arrays.asList(flowerprices));
		 
		 int iteration=1;
		 
		 while (pricelist.size()!=0)
		 {
			 for (int i=0;i<pricelist.size();i++)
			 {
				 long flowercost=iteration*pricelist.remove(0);
				 perbuyer.put(i, iteration+" "+flowercost);
				 if (i<=buyercount-1)
					 continue;
			 }
			 
			 iteration++;
		 }
		 
		 int totalCost=0;
		 for (String str:perbuyer.values()){
			 String[] tokens=str.split(" ");
			 totalCost+=Long.parseLong(tokens[1]);
		 }
		 
		 return totalCost;
	}

}