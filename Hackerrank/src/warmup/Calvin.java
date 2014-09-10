import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Calvin {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException 
	{
		String[] elems = new String(br.readLine()).split(" ");
		int freeway=Integer.parseInt(elems[0]);
		System.out.println("freeway "+freeway);
		
		int numoftcs=Integer.parseInt(elems[1]);
		System.out.println("numoftcs "+numoftcs);
		
		if (freeway<2 || freeway>100000)
			return;
		
		if (numoftcs<1 || numoftcs>1000)
			return;
		
		String[] segmentwidth=new String(br.readLine()).split(" ");
		int segsize=segmentwidth.length;
		if (segsize != freeway)
			return;
		
		for (int i=0;i<segsize;i++)
		{
			int width=Integer.parseInt(segmentwidth[i]);
			System.out.print(width+"["+i+"]");
			if (width<1 || width>3)
				return;
		}
		System.out.println();
		
		for (int tc=0;tc<numoftcs;tc++){
			String[] indexes=new String(br.readLine()).split(" ");
			int i=Integer.parseInt(indexes[0]);
			int j=Integer.parseInt(indexes[1]);
			
			if (i<0 || i>j || i>freeway)
				return;
			if (j<0 || j>freeway)
				return;
				
			if ((j-i+1)<2 || (j-i+1)>Math.min(freeway,1000))
				return;
				
			getLargestVehicle(i,j,segmentwidth);
		}
			

	}

	private static void getLargestVehicle(int entryseg, int exitseg, String[] segmentwidth) 
	{   
		 int largestVehicle=3;
		
		 for (int i=entryseg;i<=exitseg;i++){
			 int width=Integer.parseInt(segmentwidth[i]);
			 largestVehicle=Math.min(largestVehicle,width);
		 }
		 
		 System.out.println(largestVehicle);
		
	}

}
