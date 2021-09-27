package pathserver;

import java.util.ArrayList;
import java.util.List;

import algo.Cell;
import algo.Obstacle;
import algoClient.AlgoClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pathserver.PathServerGrpc.PathServerBlockingStub;
import pathserver.Pathserver.PlanReply;
import pathserver.Pathserver.PlanRequest;
import pathserver.Pathserver.State;
import pathserver.Pathserver.PlanReply.Move;


public class PathserverClient {
	
	public static void getOMPLPaths(List<Cell> orderedDestinationCells, List<Obstacle> obstacleList, AlgoClient algoClient)
	{
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 10003).usePlaintext().build();
		PathServerBlockingStub userStub = PathServerGrpc.newBlockingStub(channel);
		
        orderedDestinationCells.remove(0);
		
		List<pathserver.Pathserver.PlanRequest.Obstacle> messageObsList =  new ArrayList<pathserver.Pathserver.PlanRequest.Obstacle>();
		
		for(Obstacle obstacle : obstacleList)
		{
			messageObsList.add(pathserver.Pathserver.PlanRequest.Obstacle.newBuilder().setX(obstacle.getX()).setY(obstacle.getY()).build());
		}
		
		for(int i = 0; i < obstacleList.size(); i++)
		{
			double endTheta = getDestinationOrientation(obstacleList.get(i));
			Cell endCell = orderedDestinationCells.get(i);
			Cell startCell = null;
			double startTheta = 0;		
			
			if(i == 0)
			{
				startCell = new Cell(1, 1);
				startTheta = Math.PI/2;				
			}
			else
			{
				startCell = orderedDestinationCells.get(i - 1);
				startTheta = getDestinationOrientation(obstacleList.get(i - 1));	
			}
			
			double startX = startCell.getX();
			startX = (startX/10) + 0.05;
			double startY = startCell.getY();
			startY = (startY/10) + 0.05;
			double endX = endCell.getX();
			endX = (endX/10) + 0.05;
			double endY = endCell.getY();
			endY = (endY/10) + 0.05;
			
			State startState = Pathserver.State.newBuilder().setX(startX).setY(startY).setTheta(startTheta).build();
			State endState = Pathserver.State.newBuilder().setX(endX).setY(endY).setTheta(endTheta).build();
			
			System.out.println("\n" + (i+1) + " Plan");
			System.out.println("Start State: ");
			System.out.println(startState);
			System.out.println("End State: ");
			System.out.println(endState);
			System.out.println("Obstacle: " + obstacleList.get(i));
			System.out.println("Destination: " + orderedDestinationCells.get(i));
			
			PlanRequest planRequest = PlanRequest.newBuilder().addAllObstacles(messageObsList).setCurrent(startState).setTarget(endState).build();
			PlanReply planReply = userStub.plan(planRequest);
			
			for(Move move : planReply.getMovesList())
			{
				System.out.println("Direction: " + move.getDirection() + " Distance: " + move.getDistance());
			}

			System.out.println("Received moves list from OMPL.");
			System.out.println("Sending to algo client...");
			algoClient.formatMoves(planReply.getMovesList(), startState);
		}		
	}
	
	private static double getDestinationOrientation(Obstacle destObstacle) {
    	
    	double destDirection;
    	
    	switch(destObstacle.getDirection())
    	{
    	case 'N':
    		destDirection = -Math.PI/2;
    		break;
    	case 'S':
    		destDirection = Math.PI/2;
    		break;
    	case 'E':
    		destDirection = Math.PI - 0.00001;
    		break;
    	default:
    		destDirection = 0;
    		break;
    	}
    	
    	return destDirection;
    }
	
}
