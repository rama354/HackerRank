/**
 * 
 */
package constructive;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author r79
 *
 */
public class NewYearChaos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T>0)
		{
			int[] fstate=new int[sc.nextInt()];
			for (int i=0;i<fstate.length;i++)
				fstate[i]=sc.nextInt();
			
			System.out.println(countBribes(fstate));
			T--;
		}

	}

	private static String countBribes(int[] fstate) {
		int o_idx=fstate.length-1;
		int minbribes=0;
		while(o_idx>0)
        { 
			int idx=o_idx-1;
            int cnt=0;
			while(idx>=0)
			{
				if (cnt<2)
				{
					if (fstate[idx]<fstate[o_idx])
						cnt++;
					if (fstate[idx]>fstate[o_idx])
						minbribes++;
				}                
				else if (cnt==2)
					  if (fstate[idx]>fstate[o_idx])
						  return "Too chaotic";
				else
					break;
                	
                idx--;
			}
			o_idx--;	
		}
		
		return String.valueOf(minbribes);	
		
     }
	
 }
