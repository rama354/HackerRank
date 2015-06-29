package algebra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SteppingStones {
	

	
	  public static void main(String[] args) throws Exception{
		  
		  final BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	      long numtc= Long.parseLong(br.readLine());  
		  
	      if (numtc<1||numtc>100000)
	    	  return;
	      
	      //ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	      
		  while(numtc!=0){
			  
			  
			  /*executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					 					  
					long blocknum=0;
					try {
						blocknum = Long.parseLong(br.readLine());
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					  if (blocknum<1||blocknum>Math.pow(10, 18))
				    	  return;
					  System.out.println(calcBobChance(blocknum));
				}
			});			 	 
			  */
			  long blocknum = Long.parseLong(br.readLine());
			  System.out.println(calcBobChance(blocknum));
			  numtc--;
			   
		  }
		  
		 // executorService.shutdownNow();
	    }

	private static String calcBobChance(long blocknum) {
		//long currblock=1;
		//long incremental=1;
		//long counter=1;
		
		/*while (currblock<=blocknum){
			
			if(currblock==blocknum)
				return blocknum+" Go On Bob "+ incremental;
			incremental++;
			//counter++;
			currblock=currblock+incremental;
		}*/		
		//b2-4ac
		long discrimnant=1+(4*blocknum*2);
		
		double numroot1=(-1)+(Math.sqrt(discrimnant));
		Double root1=numroot1/2;
		
		double numroot2=(-1)-(Math.sqrt(discrimnant));
		Double root2=numroot2/2;
		
		
		if (root1>=1 && Math.ceil(root1)==root1)
			return blocknum+" Go On Bob "+ root1.longValue();
		
		if (root2>=1 && Math.ceil(root2)==root2)
			return blocknum+" Go On Bob "+ root2.longValue();
		
		return blocknum+" Better Luck Next Time";
			
	}

}
