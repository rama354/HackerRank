package search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
 
public class CircleCity
{
 
       /**
       * @param args
       */
       private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
       public static void main(String[] args) throws IOException
       {
              int numoftcs=Integer.parseInt(br.readLine());
      
              //System.out.println("numoftcs "+numoftcs);    
                    
              if (numoftcs<1 || numoftcs>1000)
                     return;
             
              while(numoftcs>0){
                    
                     String[] params=br.readLine().split(" ");             
                     int cityradius=Integer.parseInt(params[0]);
                    
                     if(cityradius<1 || cityradius>2000000000)
                           return;
                    
                     int maxstations=Integer.parseInt(params[1]);
                     if(maxstations<0 || maxstations>2000000000)
                           return;
                    
                     int pythXYCount=getPythogoreanXY(cityradius);
                    
                     if (pythXYCount>maxstations)
                           System.out.println("impossible");
                     else
                           System.out.println("possible");
                          
                     numoftcs--;
              }
             
             
       }
 
       private static int getPythogoreanXY(int cityradius)
       {
              int count=0;
              double y;
              for (int x=1;x<=Math.sqrt(cityradius);x++)
              {
                     y=Math.sqrt(cityradius-Math.pow(x, 2));
                    
                     if ((y == Math.floor(y)) && !Double.isInfinite(y))
                     {
                           if (y>0.0)
                                  count+=2;
                           else
                                  count++;
                     }
                          
              }
             
              /*for (int x=-cityradius;x<0;x++)
              {
                     y=Math.sqrt(Math.pow(cityradius, 2)- Math.pow(x, 2));
                    
                     if ((y == Math.floor(y)) && !Double.isInfinite(y))
                           count++;
              }*/
             
              count++;   //for x=0
              return 2*count;
       }
}