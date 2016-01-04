package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SherLockValidStr {

    /*public static int freqmaxval=0;
	public static int freqminval=0;*/
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
		String s = sc.next();

		System.out.println(findIfValidString(s));

    }
    
    private static String findIfValidString(String s) 
    {
		HashMap<Character,Integer> charcountMap=countCharOccurences(s);
    	
		int maxvalcount=0;
       
		List<Integer> countValues = new ArrayList<Integer>(charcountMap.values());
		Collections.sort(countValues);
        int freqminval=countValues.get(0);
        int freqmaxval=countValues.get(countValues.size()-1);
            
		for (char c:charcountMap.keySet())
			if (charcountMap.get(c)==freqmaxval)
				maxvalcount++;
	
        if (countValues.size()==1)
            return "YES";
            
		if (maxvalcount>1 && maxvalcount<charcountMap.size()-1)
			return "NO";
		
		if (freqminval>1 && countValues.get(1)!=freqminval)
			return "NO";
            
        if (freqminval==1 && countValues.get(1)==freqmaxval)
			return "YES";
		
		if (freqmaxval-freqminval==0 || freqmaxval-freqminval==1)
			return "YES";
            
         return "NO";
		 		 
	}
	
	
    private static HashMap<Character, Integer> countCharOccurences(String temp)
	{
		HashMap<Character,Integer> occurenceMap=new HashMap<Character,Integer>();
		int letteridx = 0;
		 
		
		while (letteridx < temp.length()) {
			char key=temp.charAt(letteridx);
			if (!occurenceMap.containsKey(key))
				occurenceMap.put(key, 1);
			else
			{
				int count=occurenceMap.get(key);
				occurenceMap.put(key, count+1);
			}
			
			letteridx++;
		}

		return occurenceMap;
    }
  }