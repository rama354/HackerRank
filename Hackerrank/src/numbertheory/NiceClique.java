package numbertheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NiceClique {

	/**
	 * @param args
	 */
	static Map<Long, String> niceAttrib = new HashMap<Long, String>();
	static List<Long> maxNPairSet;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numofElems = Integer.parseInt(br.readLine());

		if (numofElems < 1 || numofElems > 200)
			return;

		long[] DSet = new long[numofElems];

		for (int i = 0; i < numofElems; i++) {
			long elem = Long.parseLong(br.readLine());
			if (elem < 0 || elem > Math.pow(10, 15))
				return;
			DSet[i] = elem;
			setNiceAttrib(elem);
		}

		findMaxNicePairs();

	}

	private static void findMaxNicePairs() {
		 for (Long elemA:niceAttrib.keySet())
		 {
			String[] niceAttrA=niceAttrib.get(elemA).split(" ");
			long sumOfDivA=Long.parseLong(niceAttrA[0]);
			long primeDivcountA=Long.parseLong(niceAttrA[1]);
			
			for (Long elemB:niceAttrib.keySet()){
				 if (elemB!=elemA){
					 String[] niceAttrB=niceAttrib.get(elemB).split(" ");
					 long sumOfDivB=Long.parseLong(niceAttrA[0]);
					 long primeDivcountB=Long.parseLong(niceAttrA[1]);
					 
					 if(sumOfDivA%2==sumOfDivB%2||sumOfDivA%3==sumOfDivB%3
						||primeDivcountA%2==primeDivcountB%2||primeDivcountA%3==primeDivcountB%3)
						 
						 
					 
				 }
				
			}
		 }

	} 

	private static void setNiceAttrib(long elem) {
		long primeDivcount = 0;
		long sumOfDiv = 0;

		for (int j = 1; j <= elem; j++) {
			boolean isPrime = true;
			if (elem % j == 0) 
			{
				sumOfDiv += j;

				if (j==1)
					continue;
				
				if (j==2||j==3||j==5||j==7){
					primeDivcount++;
					continue;
				}
				
				for (int k = 2; k < j / 2; k++) {
					if (j % k == 0) {
						isPrime = false;
						break;
					}

				}
				if(isPrime)
					primeDivcount++;
			}
		}

		String attrib = Long.toString(sumOfDiv) +" "+Long.toString(primeDivcount);
		niceAttrib.put(elem, attrib);
	}

}
