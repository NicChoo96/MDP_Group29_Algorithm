package pathserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import algo.Cell;
import algo.Obstacle;
import algoClient.AlgoClient;
import algoClient.RobotStatus;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pathserver.PathServerGrpc.PathServerBlockingStub;
import pathserver.Pathserver.PlanReply;
import pathserver.Pathserver.PlanRequest;
import pathserver.Pathserver.State;
import pathserver.Pathserver.PlanReply.Move;


public class PathserverClient {
	
	public static void getOMPLPaths(List<Cell> orderedDestinationCells, List<Obstacle> obstacleList, AlgoClient algoClient, long end) throws TimeoutException
	{
		ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.29.29", 10003).usePlaintext().build();
		PathServerBlockingStub userStub = PathServerGrpc.newBlockingStub(channel);
		
        orderedDestinationCells.remove(0);
		
		List<pathserver.Pathserver.PlanRequest.Obstacle> messageObsList =  new ArrayList<pathserver.Pathserver.PlanRequest.Obstacle>();
		
		for(Obstacle obstacle : obstacleList)
		{
			messageObsList.add(pathserver.Pathserver.PlanRequest.Obstacle.newBuilder().setX(obstacle.getX()).setY(obstacle.getY()).build());
		}

		double startX = 0;
		double startY = 0;
		double startTheta = 0;
		double endX = 0;
		double endY = 0;
		double endTheta = 0;

		for(int i = 0; i < obstacleList.size(); i++)
		{
			endTheta = getDestinationOrientation(obstacleList.get(i));
			Cell endCell = orderedDestinationCells.get(i);
			Cell startCell = null;

			if(i == 0)
			{
				startCell = new Cell(1, 1);
				startTheta = Math.PI/2;
				startX = startCell.getX();
				startX = (startX/10) + 0.05;
				startY = startCell.getY();
				startY = (startY/10) + 0.05;
			}
			/*else
			{
				startCell = orderedDestinationCells.get(i - 1);
				startTheta = getDestinationOrientation(obstacleList.get(i - 1));
			}*/

			//startX = startCell.getX();
			//startX = (startX/10) + 0.05;
			//startY = startCell.getY();
			//startY = (startY/10) + 0.05;
			//endX = endCell.getX();
			//endX = (endX/10) + 0.05;
			//endY = endCell.getY();
			//endY = (endY/10) + 0.05;

			endX = endCell.getX();
			endX = (endX/10) + 0.05;
			endY = endCell.getY();
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

			algoClient.updateStatus(RobotStatus.PLAN);

			PlanRequest planRequest = PlanRequest.newBuilder().addAllObstacles(messageObsList).setCurrent(startState).setTarget(endState).build();
			PlanReply planReply = userStub.plan(planRequest);

			for(Move move : planReply.getMovesList())
			{
				System.out.println("Direction: " + move.getDirection() + " Distance: " + move.getDistance());
			}

			// Set the end state of this plan as the start state of the next plan.
			startX = planReply.getWaypoints(planReply.getWaypointsList().size() - 1).getX();
			startY = planReply.getWaypoints(planReply.getWaypointsList().size() - 1).getY();
			startTheta = planReply.getWaypoints(planReply.getWaypointsList().size() - 1).getTheta();

			System.out.println("Received moves list from OMPL.");
			System.out.println("Sending to algo client...");

			algoClient.formatMoves(planReply.getMovesList(), startState, obstacleList.get(i), end);
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

//	private static obstacleOffset(List<Obstacle> obstacleList, double offset)
//	{
//
//	}
}
