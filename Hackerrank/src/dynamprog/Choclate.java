package dynamprog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Choclate {

	/**
	 * @param args
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] choclate=new int[3][];
	static final int PLAYER1=0;
	static final int PLAYER2=1;
	static int row1,row2,row3;
	static boolean player1wins;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int numTc = Integer.parseInt(br.readLine());
		if (numTc==0 || numTc>100)
			return;
		//int row1,row2,row3;
		for(int i=1;i<=numTc;i++)
		{
			String[] rows=br.readLine().split(" ");
			row1=Integer.parseInt(rows[0]);
			row2=Integer.parseInt(rows[1]);
			row3=Integer.parseInt(rows[2]);
			if(row1<1||row1>25)
				return;
			
			if(row2>row1||row3>row2)
				return;
			
			resetTheGame();
			player1wins=false;
			//int currrow=0,currrowlen=row1;			
			predictWinForPlayer(Choclate.PLAYER1,0,row1);
			
			if (!player1wins)
			{
				//currrow=1;currrowlen=row2;
				predictWinForPlayer(Choclate.PLAYER1,1,row2);
			}
				
			if (!player1wins)
			{
				//currrow=2;currrowlen=row3;
				predictWinForPlayer(Choclate.PLAYER1,2,row3);
			}
			
			if(!player1wins)
				System.out.println("LOSE");
			else
				System.out.println("WIN");
		}

	}

	private static void predictWinForPlayer(int player,int row,int rowlen)
	{
		for(int x=row;x<3;x++)
		{
			int y=0;
			if(rowlen==row1)
				y=1;
			
			for(;y<rowlen;y++)
			{
					playTheGame(player,x,y);
					if(!player1wins)
						resetTheGame();
					else
						return;
			}
		}
			
	}
	
	//restore double array to 1s
	private static void resetTheGame() 
	{
		choclate[0]=new int[row1];
		for(int p=0;p<row1;p++)
			choclate[0][p]=1;	
		
		choclate[1]=new int[row2];
		for(int q=0;q<row2;q++)
			choclate[1][q]=1;
		
		choclate[2]=new int[row3];
		for(int r=0;r<row3;r++)
			choclate[2][r]=1;
		
	}

	private static void playTheGame(int player,int refx,int refy) 
	{
		int x=0,y=0;	
		for(;x<refx;x++)
		{
				for(;y<refy;y++)
				{
					if(refx==0 && refy==0)
					{
						if(player!=Choclate.PLAYER1)
							//System.out.println("LOSE")
							player1wins=true;
						
						return;
					}
						
					if(choclate[x][y] !=0)
						choclate[x][y]=0;
					else
					{
						
						break;	
					}
				}
	
		 }
		refx=x;refy=y;   
		player=(player==Choclate.PLAYER1)?Choclate.PLAYER2:Choclate.PLAYER1;
		//playTheGame(player,refx,refy);
		//predictWinForPlayer(player);

	}

}
