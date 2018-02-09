package constructive;

import java.util.Scanner;

public class GamingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int max=Integer.MIN_VALUE;
            boolean winner=false;
            for (int i=0;i<n;i++){
            	int k=in.nextInt();
            	if (k>max){
            		winner=!winner;
            		max=k;
            	}
            }
            System.out.println(winner?"BOB":"ANDY");
         }        

	}

}
