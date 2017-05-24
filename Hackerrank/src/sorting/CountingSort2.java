package sorting;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CountingSort2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        int[] count=new int[100];
        int n=sc.nextInt();
        for (int i=0;i<n;i++)
            count[sc.nextInt()]++;
        
        int idx=0;
        
        while(idx<100){
        	int p=idx;
            IntStream.range(0, count[idx++]).forEach(i -> System.out.print(p+" "));
        }

	}

}
