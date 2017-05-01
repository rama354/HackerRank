package implementation;

import java.util.Scanner;

public class Kangaroo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int x1=sc.nextInt();
		int v1=sc.nextInt();
		int x2=sc.nextInt();
		int v2=sc.nextInt();
		
		if (v1>v2) 
        {
            double n=(double)(x2-x1)/(v1-v2);
            System.out.println(n);
			System.out.println(Math.floor(n)==n?"YES":"NO");
        }
		else
			System.out.println("NO");

	}

}
