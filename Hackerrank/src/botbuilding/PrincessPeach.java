package botbuilding;

import java.util.Arrays;
import java.util.Scanner;

public class PrincessPeach {

	static void displayPathtoPrincess(int n, String [] grid){
		int p_x=0;
		int p_y=0;
        for(int i = 0; i < n; i++) 
            if (grid[i].indexOf('p')!=-1){
            	p_x=grid[i].indexOf('p');
            	p_y=i;
            }
        
        int x_offset=Math.abs(p_x-n/2);
        int y_offset=Math.abs(p_y-n/2);
        while(y_offset>0){
    		if (p_y==0)
    			System.out.println("UP");
    		else
    			System.out.println("DOWN");
    		
    		x_offset--;
    	}
        
    	while(x_offset>0){
    		if (p_x==0)
    			System.out.println("LEFT");
    		else
    			System.out.println("RIGHT");
    		
    		x_offset--;
    	}
        	
    }
        	

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        displayPathtoPrincess(m,grid);
    }
}
