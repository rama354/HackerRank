package qualys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RouteTrafficOptimizer 
{
	private static List<Road> roaddetails=new LinkedList<Road>();
	private static Map<Integer,Route> validRoutes=new TreeMap<Integer,Route>();
	private static int junctions;
	private static List<Road> tollroads=new LinkedList<Road>();
	
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
								 
				validRoute=new Route(new HashSet<Road>());
				routekey=road.roadidx;
				validRoute.routekey=routekey;
				validRoutes.put(routekey, validRoute);
					
			}
			else
			{
				validRoute=validRoutes.get(routekey);
				if (validRoute.isComplete)
					return;
			}
			
			if (!validRoute.roads.contains(road))
			{
				validRoute.roads.add(road);
				validRoute.totalcost+=road.cost;
				road.routes.add(validRoute);
			}
			
			if (road.destjunction==junctions)
				validRoute.isComplete=true;
					
			identifyRoutes(routekey,road.destjunction);
			
			if (junction!=1)
				backTraceRouteAndComplete(routekey,junction);
			
		}
		
	}

	private static void backTraceRouteAndComplete(int routekey, int junction) {
		
		for(Road road:roaddetails)
		{

			if (junction==1)
				return;
			
			Route validRoute=null;
			if (road.destjunction==junction)
			{
				validRoute=validRoutes.get(routekey);
				validRoute.roads.add(road);
				validRoute.totalcost+=road.cost;
				road.routes.add(validRoute);
			}
			
			backTraceRouteAndComplete(routekey,road.startjunction);
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
			  
			  int tolljunction=junctions;
			  while(tolljunction>0)
			  {
				  for (Road road:route.roads)
				  {			 
					  if (route.tollroadidx==0 && !road.isTollRoad)
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
		String[] output = new String[tollroads.size()+1];
		int outidx=0;
		output[outidx]=tollroads.size()+"#"+finalCost;
		System.out.println(output[outidx++]);
		for (Road tollroad:tollroads)
		{
			output[outidx]=tollroad.roadidx+"#"+tollroad.tollCost;
			System.out.println(output[outidx++]);
		}
		
		return output;
		 
	}
	
	
	private static class Road{
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
