package gametheory;

import java.util.Scanner;

public class NimbleGame {

	static String nimbleGame(int[] s) {
        // Variant of Standard Nim Game https://www.math.ucla.edu/~tom/Game_Theory/comb.pdf
		int nimsum=0;
		for (int i=1;i<s.length;i++){
			if (s[i]%2==1){
				nimsum^=i;
			}
		}
		return nimsum>0?"First":"Second";
    }
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] s = new int[n];
            for(int s_i = 0; s_i < n; s_i++){
                s[s_i] = in.nextInt();
            }
            String result = nimbleGame(s);
            System.out.println(result);
        }
        in.close();
    }
}
