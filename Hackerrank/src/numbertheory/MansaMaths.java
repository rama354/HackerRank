package numbertheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MansaMaths {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		while(T>0){
			int[] digits=formDigitArr(sc.next());
			if (divBy8(digits))
				System.out.println("YES");
			else
				System.out.println("NO");
			T--;
		}
		
	}

	private static boolean divBy8(int[] digits) {
		if (digits.length==1 && digits[0]%8==0)
			return true;
		
		if (digits.length==2){
			if ((digits[0]*10+digits[1])%8==0 || (digits[1]*10+digits[0])%8==0)
				return true;
		}
		if (digits.length>=3)
		{
			int[] divNum=new int[3];
			for (int p=0;p<=digits.length-3;p++)
			{
				divNum[0]=digits[p];
				for (int q=p+1;q<=digits.length-2;q++)
				{
					divNum[1]=digits[q];
					for (int r=q+1;r<=digits.length-1;r++)
					{
						divNum[2]=digits[r];
						if (divide(divNum))
							return true;
					}
				}
			}	
		}
		return false; 
	}

	private static boolean divide(int[] num) {
		for (int x = 0; x < 3; x++) 
            for (int y = 0; y < 3; y++) 
                for (int z = 0; z < 3; z++) 
                    if (x != y && y != z && z != x) 
                       if ((num[x]*100+num[y]*10+num[z])%8==0)
                    	   return true;
                    
		return false;
	}

	private static int[] formDigitArr(String n) {
		int len=n.length();
		int[] digits=new int[len];
		
		for (int i=0;i<len;i++)
			digits[i]=Integer.valueOf(n.charAt(i)-'0');
		
		return digits;
	}
}
