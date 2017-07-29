package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerGreater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while (t>0){
			String w=sc.next();
			char[] wchar=w.toCharArray();
			int len=wchar.length-1;
			boolean isbigger=false;
			for (int i=len;i>0;i--)
			{
				if (wchar[i]>wchar[i-1]){
					char temp=wchar[i-1];
					Arrays.sort(wchar, i-1,len+1);
					smallestBigLex(wchar,temp,i-1);
					isbigger=true;
					break;
				}
			}
			if (isbigger)
				System.out.println(new String(wchar));
			else
				System.out.println("no answer");
			t--;
		}
	}

	private static void smallestBigLex(char[] wchar, char c,int startidx) {
		int idx=wchar.length-1;
		char temp;
		while(idx>=startidx){	
			if (wchar[idx]==c){
				temp=wchar[idx+1];
				for (int i=idx+1;i>startidx;i--)
					wchar[i]=wchar[i-1];
				
				wchar[startidx]=temp;
				break;
			}
			idx--;
		}
	}

}
