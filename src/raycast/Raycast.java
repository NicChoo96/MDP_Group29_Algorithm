package raycast;

import java.util.ArrayList;
import java.util.List;

import algo.Obstacle;
import java.lang.Math;

public class Raycast {

	public static void main(String[] args) {
		
		List<Obstacle> obstacleList = new ArrayList<>();
		obstacleList.add(new Obstacle(5, 7, 'W'));
		obstacleList.add(new Obstacle(18, 16, 'E'));
		obstacleList.add(new Obstacle(8, 2, 'N'));
		
		System.out.println(raycast(0.5, 0.5, Math.toRadians(-90), obstacleList, Math.toRadians(120), Math.toRadians(1)));
		System.out.println(closestObstacle(0.5, 0.5, Math.toRadians(-90), obstacleList, Math.toRadians(120)));
	}
	
	public static boolean checkPointInObstacle(double x, double y, Obstacle obstacle)
	{
		double obsX, obsY;
		
		obsX = (double)obstacle.getX() / 10;	
		obsY = (double)obstacle.getY() / 10;
		
		return (obsX <= x && x <= (obsX + 0.1) && obsY <= y && y <= (obsY + 0.1));
	}
	
	public static Obstacle raycast(double x, double y, double theta, List<Obstacle> obstacleList, double arc, double rayInterval)
	{
		double arcStart, arcEnd;
		arcStart = theta + arc/2;
		arcEnd = theta - arc/2;
		
		double rate = 0.01;		
		double stepX, stepY;
		
		for(int i = 0; i < 200/rate; i++)
		{	
			
			for(double j = arcStart; j >= arcEnd; j -= rayInterval)
			{
				stepX = rate * Math.cos(j);
				stepY = rate * Math.sin(j);
				
				for(int k = 0; k < obstacleList.size(); k++)
				{						
					if(checkPointInObstacle(x + (stepX * i), y + (stepY * i), obstacleList.get(k)) == true)
					{
						return obstacleList.get(k);
					}
				}
			}
		}
		
		System.out.println("No obstacle found");
		return null;
	}
	
	public static Obstacle closestObstacle(double x, double y, double theta, List<Obstacle> obstacleList, double range)
	{
		double closestDistance = Integer.MAX_VALUE;
		Obstacle closestObstacle = null;
		double obsX, obsY, obsTheta;
		
		for(Obstacle obstacle : obstacleList)
		{
			obsX = (double)obstacle.getX()/10;
			obsY = (double)obstacle.getY()/10;
			
			double distance = Math.sqrt((Math.pow(obsX - x, 2)) + (Math.pow(obsY - y, 2)));
			
			obsTheta = Math.atan2(obsY - y, obsX - x);
			
			if(distance < closestDistance && (theta + range/2) >= obsTheta && (theta - range/2) <= obsTheta)
			{
				closestDistance = distance;
				closestObstacle = obstacle;
			}
		}
		return closestObstacle;
	}
}
