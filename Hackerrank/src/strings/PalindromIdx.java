package strings;

import java.util.Scanner;

public class PalindromIdx {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
	 
		 if (T<1||T>20)
			 return;
		 
		while(T>0){
			String A=sc.next();
			 
			System.out.println(findPalidromMakr(A));
			T--;
		}
    }
    
    private static int findPalidromMakr(String a) 
    {
        int len=a.length();
        for(int j=0;j<len;j++)
        {
            if(j<=(len-1)-j && a.charAt(j)!=a.charAt((len-1)-j))
            {
            	for(int i=j;i<=(len-1)-i;i++)
            		if(a.charAt(i)!=a.charAt((len-2)-i))
            			return j;
            		 
            	return (len-1)-j;
            }
        }
       
        return -1;
	}

}
