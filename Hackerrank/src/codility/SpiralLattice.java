package codility;

public class SpiralLattice {

	
	public static void main(String[] args) {
		int x=3;
		int y=4;
		
		System.out.println(solution(x,y));
	}
	
	static double solution(int X,int Y) 
	{
		int spiral_width=X;
		int spiral_length=Y;
		double spiral_lattice=0;
		for (int i=0;i<spiral_width;i++)
		{
			for (int j=0;j<spiral_length;j++)
				spiral_lattice=spiral_lattice+(Math.pow(2,3*i)-1);
			
		}
	  
		return spiral_lattice;
	    
    }
}
