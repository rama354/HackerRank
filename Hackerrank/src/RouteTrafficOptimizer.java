package qualys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Identifying traffic routes between two junctions through a series of intermediate junctions connected by roads.
Every road has a driving cost and every route cost will be sum of individual roads making up the route. 
Make the driving cost of every route equal by adding a single toll on each route if required. The final driving cost 
should be an optimized cost. If one road belongs to multiple routes then put toll on that road only if each route 
tollcost is same (to arrive at final cost) else identify closest road to destination for each route.
*/
public class RouteTrafficOptimizer 
{
	private static List<Road> roaddetails=new LinkedList<Road>();
	private static Map<Integer,Route> validRoutes=new TreeMap<Integer,Route>();
	private static int junctions;
	private static Set<Road> tollroads=new TreeSet<Road>();
	
	public static void main(String[] args) {
		 String[] input1=args[0].split("#");
		 junctions=Integer.parseInt(input1[0]);
		 if (junctions<2 || junctions>10000)
		 {
			 System.out.println("Invalid no of junctions");
			 return;
		 }

		 int roads=Integer.parseInt(input1[1]);
		 if (roads<1 || roads>10000)
		 {
			 System.out.println("Invalid no of roads");
			 return;
		 }
		 
		 for(int i=1;i<=roads;i++){
			 String[] roaddetail=args[i].split("#");
			 Road road=new Road(i,Integer.parseInt(roaddetail[0]),Integer.parseInt(roaddetail[1]),
					 												Integer.parseInt(roaddetail[2]));
			 
			 roaddetails.add(road);
		 }
		 
		 identifyRoutes(0,1);
		 //computeTollAndMaxCost();
		 //identifyTollRoad();
		 System.out.println(outputStringArr(computeTollAndMaxCost()));
	}


	private static void identifyRoutes(int routekey,int junction) 
	{	
		for(Road road:roaddetails)
		{
			if (junction==junctions)
				return;
			
			Route validRoute=null;
			if (road.startjunction==junction)
			{
	
				validRoute=validRoutes.get(routekey);
				if (validRoute==null || validRoute.isComplete)
				{
					validRoute=new Route(new HashSet<Road>());
					routekey=road.roadidx;
					validRoute.routekey=routekey;
					validRoutes.put(routekey, validRoute);
					if (junction!=1)
						backTraceRouteAndComplete(routekey,road);
				}
				if (validRoute.isComplete)
					return;		
				
				if (!validRoute.roads.contains(road))
				{
					validRoute.roads.add(road);
					validRoute.totalcost+=road.cost;
					road.routes.add(validRoute);
				}
				else
					continue;
				
				if (road.destjunction==junctions)
					validRoute.isComplete=true;
				
				identifyRoutes(routekey,road.destjunction);
				
				//if (junction!=1)
					//backTraceRouteAndComplete(routekey,junction);
			}				
			
		}
		
	}

	private static void backTraceRouteAndComplete(int routekey, Road road) {
		
		for(Road prevroad:roaddetails)
		{
			if (road.startjunction==1)
				return;
			
			Route validRoute=null;
			if (prevroad.destjunction==road.startjunction)
			{
				validRoute=validRoutes.get(routekey);
				if (!validRoute.roads.contains(prevroad))
				{
					validRoute.roads.add(prevroad);
					validRoute.totalcost+=prevroad.cost;
					prevroad.routes.add(validRoute);			
				}
				 
			}
			else
				continue;
			
			backTraceRouteAndComplete(routekey,prevroad);
		}
		
	}


	private static int computeTollAndMaxCost() 
	{
		 Route maxCostRoute=null;
		 for(Route route:validRoutes.values()){
			 if (maxCostRoute==null)
				 maxCostRoute=route;
			 if (route.totalcost>maxCostRoute.totalcost)
				 maxCostRoute=route;
		 }
		 
		 for(Route route:validRoutes.values())
		 {
			  route.tollcost=maxCostRoute.totalcost-route.totalcost;
			  route.totalcost+=route.tollcost;
			  
			  if (route.tollcost==0)
				  continue;
			  
			  int tolljunction=junctions;
			  while(tolljunction>0)
			  {
				  for (Road road:route.roads)
				  {			 
					  if (route.tollroadidx==0 && !road.isTollRoad )
					  {
						  if (road.destjunction==tolljunction)
						  {
							  if(road.routes.size()>1)
							  {
								  Route currroute=null;
								  for(Route mappedroute:road.routes)
								  {
									  if (currroute==null)
										  currroute=mappedroute;
									  
									  if(mappedroute.tollcost!=currroute.tollcost)
										  break;
									  
									  currroute=mappedroute;
								  }
								   
							  }
							  else
							  {
								  road.isTollRoad=true;
								  road.tollCost=route.tollcost;
								  tollroads.add(road);
								  route.tollroadidx=road.roadidx;
							  }
						  }	       	 
					  }
				  }	 
				
				  tolljunction--;  
			  }  
		 }
		 
		 return maxCostRoute.totalcost;
	}
	

	private static String[] outputStringArr(int finalCost) {
		if(tollroads.size()!=0)
		{
			String[] output = new String[tollroads.size()+1];
			int outidx=0;
			output[outidx++]=tollroads.size()+"#"+finalCost;
			//System.out.println(output[outidx++]);
			for (Road tollroad:tollroads)
			{
				output[outidx++]=tollroad.roadidx+"#"+tollroad.tollCost;
				//System.out.println(output[outidx++]);
			}
						
			return output;
		}
		else
		 	return new String[]{"No Solution"};
	}
	
	
	private static class Road implements Comparable<Road>{
		int roadidx;
		int startjunction;
		int destjunction;
		int cost;
		int tollCost;
		List<Route> routes=new LinkedList<Route>();
		
		boolean isTollRoad=false;
		
		public Road(int roadidx, int startjunction,int destjunction,int cost){
			this.roadidx=roadidx;
			this.startjunction=startjunction;
			this.destjunction=destjunction;
			this.cost=cost;
		}

		@Override
		public int compareTo(Road arg0) {
			 if (roadidx > arg0.roadidx)
				 return 1;
			 
			 if (roadidx < arg0.roadidx)
				 return -1;
			 
			 return 0;
				
		}
	}
	
	
	private static class Route{
		int routekey;
		Set<Road> roads;
		int tollcost;
		int tollroadidx;
		int totalcost;
		boolean isComplete=false;
		public Route(Set<Road> roads){
			this.roads=roads;
		}
		
	}
}
