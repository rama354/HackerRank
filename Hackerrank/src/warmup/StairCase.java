package warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StairCase {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int hieght = Integer.parseInt(br.readLine());
		
		if (hieght < 1 || hieght > 100)
			return;
		
		int N=hieght-1;
		
		while(N>=0){
			for(int i=0;i<hieght;i++){
				if(i>=N)
					System.out.print("#");
				else
					System.out.print(" ");
			}
			N--;
		}
		
	}

}
