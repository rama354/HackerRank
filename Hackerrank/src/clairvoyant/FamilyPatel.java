package clairvoyant;

import java.util.Arrays;
import java.util.TreeSet;

public class FamilyPatel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int[] boxweights={20,10,5,40,20,41,41,2,6,7,3,4,5,6,23,34,7,8,2,2};
		 
		 Arrays.sort(boxweights);
		 int maxweight=boxweights[boxweights.length-1];
		 System.out.println(maxweight);
		 
		 int insurancecost=0;
		 
		 for(int i=0;i<boxweights.length;i++){
			 if (boxweights[i]==maxweight)
				 insurancecost+=(boxweights[i]*3.5);
			 else
				 insurancecost+=(boxweights[i]*2);
		 }
		 
		 System.out.println("Total insurance cost "+insurancecost);
	}

}
