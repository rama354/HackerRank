package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SherLockAnagrams {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T>0){
			String s=sc.next();	
			int len=s.length();
			int t=0;
			for(int i=1;i<len;i++){
				List<String> substrings=new ArrayList<String>();
				int k=i;
				IntStream.range(0,len-k+1).forEach(j->substrings.add(s.substring(j,j+k)));
				
				t+=getAnagrams(substrings,i);
			}
				
			System.out.println(t);
			T--;
		}

	}

	private static int getAnagrams(List<String> substrings,int len) {
		int pairs=0;
		if (substrings.size()>1)
		{
			int ssize=substrings.size();
			for (int i=0;i<ssize-1;i++){
				char[] a=substrings.get(i).toCharArray();
				int[] sub1=new int[26];
				int p=0;
				while (p<len) 
				      sub1[a[p++]-'a']++;
				
				for (int j=i+1;j<ssize;j++)
				{
					pairs++;
					int[] sub2=new int[26];
					char[] b=substrings.get(j).toCharArray();  
					int q = 0;
					while (q<len)
					      sub2[b[q++]-'a']++;
					   
				    for (int k=0;k<26;k++)
				    	if (sub1[k]!=sub2[k]){
				    		pairs--;
				    		break;
						}
				}
			}
		}
		return pairs;
	}

}
