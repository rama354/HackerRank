import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * @author asus
 *
 */
public class UtopianTree {

	/**
	 * @param args
	 */
	//private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	
	public static void main(String[] args) throws NumberFormatException,IOException {
		
		 int numTc = Integer.parseInt(br.readLine());
		 //int numTc=Integer.parseInt(args[0]);
		 int treeHeight=1,growthCycle=0;
			 
		 if (numTc >=1 && numTc <=10 )
		 {
			 for(int i=1;i<=numTc;i++)
			 {
				 //growthCycle=Integer.parseInt(args[i]);
				 growthCycle=Integer.parseInt(br.readLine());
				 if (growthCycle>=0 && growthCycle<=60)
				 	calcTreeGrowth(treeHeight,growthCycle);
				 else
					 System.out.println("Invalid growth cycles");
					 //bw.write("Invalid growth cycles");
			 }
			 
		 }
		 else
			 //bw.write("Incorrect TCs");
			 System.out.println("Incorrect TCs");

	}

	private static void calcTreeGrowth(int treeHeight, int cycle)
	{		 
		for (int i=1;i<=cycle;i++)
		{
			if (i%2==1)
				treeHeight*=2;
			if(i%2==0)
				treeHeight+=1;
		}
			
		
		System.out.println(treeHeight);
	}

}
