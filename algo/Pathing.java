package algo;

import java.util.ArrayList;
import java.util.List;
import ui.Command;

public class Pathing {
	
	public static List<List<Cell>> Simplify_Path(List<Cell> path)
	{
		List<List<Cell>> simplifiedPath = new ArrayList<List<Cell>>();
		List<Cell> tempPath = new ArrayList<Cell>();
		
		int directionX = 0;
		int directionY = 0;
		
		for(Cell cell : path)
		{
			if(directionX == 0 && directionY == 0)
			{
				tempPath.add(cell);
				
				if(tempPath.size() == 2)
				{
					directionX = tempPath.get(tempPath.size() - 1).getX() - tempPath.get(tempPath.size() - 2).getX();
					directionY = tempPath.get(tempPath.size() - 1).getY() - tempPath.get(tempPath.size() - 2).getY();
				}

			}
			else if(cell.getX() - tempPath.get(tempPath.size() - 1).getX() != directionX && cell.getY() - tempPath.get(tempPath.size() - 1).getY() != directionY)
			{
				directionX = cell.getX() - tempPath.get(tempPath.size() - 1).getX();
				directionY = cell.getY() - tempPath.get(tempPath.size() - 1).getY();
				
				List<Cell> subPath = new ArrayList<Cell>();
				subPath.addAll(tempPath);
				simplifiedPath.add(subPath);
				tempPath.clear();
				
				tempPath.add(cell);
			}
			else
			{
				tempPath.add(cell);
			}
		}
		
		List<Cell> subPath = new ArrayList<Cell>();
		subPath.addAll(tempPath);
		simplifiedPath.add(subPath);
		
		return simplifiedPath;
	}
	
//	public static void createPath(List<List<Cell>> simplifiedPath, Robot robot, Map map)
//	{
//		int directionX = 0;
//		int directionY = 0;
//		int offset = 1; //Offset to be used when turning
//		
//		Cell[][] grid = map.getGrid();
//		
//		List<int[]> directionList = new ArrayList<int[]>();
//		
//		for(int i = 0; i < simplifiedPath.size(); i++)
//		{
//			List<Cell> subPath = simplifiedPath.get(i);
//			
//			if(subPath.size() > 1)
//			{
//				directionX = subPath.get(subPath.size() - 1).getX() - subPath.get(0).getX();
//				directionY = subPath.get(subPath.size() - 1).getY() - subPath.get(0).getY();
//			}
//			
//			else
//			{
//				directionX = subPath.get(0).getX() - simplifiedPath.get(i - 1).get(simplifiedPath.get(i - 1).size() - 1).getX();
//				directionY = subPath.get(0).getY() - simplifiedPath.get(i - 1).get(simplifiedPath.get(i - 1).size() - 1).getY();
//			}
//			
//			if(directionX > 0 && directionY == 0)
//			{
//				directionList.add(new int[] {1, 0});
//			}
//			
//			if(directionX < 0 && directionY == 0)
//			{
//				directionList.add(new int[] {-1, 0});
//			}
//			
//			if(directionX == 0 && directionY > 0)
//			{
//				directionList.add(new int[] {0, 1});
//			}
//			
//			if(directionX == 0 && directionY < 0)
//			{
//				directionList.add(new int[] {0, -1});
//			}
//			
//			System.out.println("Directions: " + directionList.get(i)[0] + " , " + directionList.get(i)[1]);
//		}
//		
//		for(int i = 0; i < simplifiedPath.size() - 1; i++)
//		{
//			List<Cell> subPath = simplifiedPath.get(i);
//			Cell turningPoint = subPath.get(subPath.size() - 1); //Last cell in the subpath
//			
//			System.out.println("------------------------");
//			System.out.println("Robot direction: " + robot.getDirectionX() + ", " + robot.getDirectionY());//Debugging
//			System.out.println("Path direction: " + directionList.get(i)[0] + ", " + directionList.get(i)[1]);
//			System.out.println("Turning point: " + turningPoint.getX() + "," + turningPoint.getY()); 
//			
//			if(oppositeDirection(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i)[0], directionList.get(i)[1])) //Robot direction opposite as path direction
//			{
//				System.out.println("Robot facing wrong way");
//				
//				if(checkEmptySpace(grid, turningPoint, directionList.get(i)[0], directionList.get(i)[1], offset) == true) //Check along current path, if there is space
//				{	
//					System.out.println("There is space along the current path to perform a move back and turn");
//					if(crossProduct(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i)[0], directionList.get(i)[1]) > 0) //Move beyond the path backwards and then turn left
//					{
//						moveBackTurnLeft(robot);
//					}
//					else //Move beyond the path backwards and then turn left
//					{
//						moveBackTurnRight(robot);
//					}
//				}
//				else if(checkEmptySpace(grid, turningPoint, directionList.get(i + 1)[0], directionList.get(i + 1)[1], -offset) == true) //Check in the opposite direction of the next path, if there is space
//				{	
//					System.out.println("There is space along the next path to perform a backwards turn");
//					if(crossProduct(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i + 1)[0], directionList.get(i + 1)[1]) > 0) //Turn Right Backwards
//					{
//						turnRightBackwards(robot);
//					}
//					else //Turn Left Backwards
//					{
//						turnLeftBackwards(robot);
//					}	
//				}
//				else //No space at all, keep moving backwards and try again when there is another turn
//				{
//					System.out.println("No space at all, check next turn");
//					if(crossProduct(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i + 1)[0], directionList.get(i + 1)[1]) < 0)
//					{
//						turnRightBackwards(robot);
//					}
//					else //Turn Left Backwards
//					{
//						turnLeftBackwards(robot);
//					}	
//				}
//			}
//			else	//Correct orientation
//			{				
//				if(i != simplifiedPath.size() - 1)
//				{
//					if(crossProduct(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i + 1)[0], directionList.get(i + 1)[1]) > 0) //Turn Left
//					{
//						turnLeft(robot);
//					}
//					else //Turn Right
//					{
//						turnRight(robot);
//					}
//				}				
//			}
//		}
//		
//		if(robot.getDirectionX() != directionList.get(directionList.size() - 1)[0] && robot.getDirectionY() != directionList.get(directionList.size() - 1)[1])  //No more turns left but robot is still not in the correct direction
//		{
//			//Do emergency turning
//		}
//	}
	
	public static boolean oppositeDirection(int directionX, int directionY, int _directionX, int _directionY)
	{
		if(directionX == 0 && _directionX == 0)
		{
			if(Math.abs(directionY - _directionY) == 2)
			{
				return true;
			}
		}
		
		if(directionY == 0 && _directionY == 0)
		{
			if(Math.abs(directionX - _directionX) == 2)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static double crossProduct(int directionX, int directionY, int _directionX, int _directionY)
	{	
		return directionX * _directionY - directionY * _directionX;
	}
	
	public static int whereToTurn(int directionX, int directionY, int _directionX, int _directionY)
	{
		if(Pathing.crossProduct(directionX, directionY, _directionX, _directionY) > 0) //Turn left
		{
			return 1;
		}
		else if(Pathing.crossProduct(directionX, directionY, _directionX, _directionY) < 0) //Turn right
		{
			return -1;
		}
		
		return 0;
	}
	
	public static boolean checkEmptySpace(Cell[][] grid, Cell turningPoint, int directionX, int directionY, int offset)
	{
		int x = turningPoint.getX();
		int y = turningPoint.getY();
		
		if(offset == 0)
		{
			return grid[MapConstants.MAP_ROWS - y - 1 - directionY][x + directionX].isTraversable;
		}
		
		if(offset < 0)
		{
			for(int i = 1; i <= Math.abs(offset); i++)
			{	
				if(grid[MapConstants.MAP_ROWS - y - 1 - (directionY * -i)][x + (directionX * -i)].isTraversable == false)
				{
					return false;
				}
			}
		}
		
		for(int i = 1; i <= offset; i++)
		{	
			if(grid[MapConstants.MAP_ROWS - y - 1 - (directionY * i)][x + (directionX * i)].isTraversable == false)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkEmptySpace2(Cell[][] grid, int[] turningPoint, int directionX, int directionY, int offset)
	{
		int x = turningPoint[0];
		int y = turningPoint[1];
		
		//Convert from point to cell
		x = x/10;
		y = y/10;	
		
		if(offset == 0)
		{
			return grid[MapConstants.MAP_ROWS - y - 1 - directionY][x + directionX].isTraversable;
		}
		
		if(offset < 0)
		{
			for(int i = 1; i <= Math.abs(offset); i++)
			{	
				if(grid[MapConstants.MAP_ROWS - y - 1 - (directionY * -i)][x + (directionX * -i)].isTraversable == false)
				{
					return false;
				}
			}
		}
		
		for(int i = 1; i <= offset; i++)
		{	
			if(grid[MapConstants.MAP_ROWS - y - 1 - (directionY * i)][x + (directionX * i)].isTraversable == false)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkPointInCell(Cell cell, int[] point)
	{
		int x = point[0];
		int y = point[1];
		
		int cellX = cell.getX() * 10;
		int cellY = cell.getY() * 10;
		
		if(x >= cellX && x <= (cellX + 10) && y >= cellY && y <= (cellY + 10))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void moveForwards(Robot robot, int distance)	//Dummy function
	{
		robot.centerX += robot.getDirectionX() * distance;
		robot.centerY += robot.getDirectionY() * distance;
		
		System.out.println("Moving forward " + distance);
		System.out.println("Robot Position: " + robot.centerX + " , " + robot.centerY); 
	}
	
	public static void moveBackwards(Robot robot, int distance)	//Dummy function
	{
		robot.centerX -= robot.getDirectionX() * distance;
		robot.centerY -= robot.getDirectionY() * distance;
		
		System.out.println("Moving backwards " + distance);
		System.out.println("Robot Position: " + robot.centerX + " , " + robot.centerY); 
	}
	
	public static void moveBackTurnLeft(Robot robot, int distance, int turningRadius)
	{
		moveBackwards(robot, distance);
		turnLeft(robot, turningRadius);
	}
	
	public static void moveBackTurnRight(Robot robot, int distance, int turningRadius)
	{
		moveBackwards(robot, distance);
		turnRight(robot, turningRadius);
	}
	
	public static void turnLeft(Robot robot, int turningRadius)	//Dummy function
	{
		int directionX = robot.getDirectionX();
		int directionY = robot.getDirectionY();
		int newDirectionX = robot.getDirectionX();
		int newDirectionY = robot.getDirectionY();
		
		if(directionX == 0 && directionY == 1)
		{
			newDirectionX = -1;
			newDirectionY = 0;
		}
		else if(directionX == 0 && directionY == -1)
		{
			newDirectionX = 1;
			newDirectionY = 0;
		}
		else if(directionX == 1 && directionY == 0)
		{
			newDirectionX = 0;
			newDirectionY = 1;
		}
		else if(directionX == -1 && directionY == 0)
		{
			newDirectionX = 0;
			newDirectionY = -1;
		}
		
		robot.setDirectionX(newDirectionX);
		robot.setDirectionY(newDirectionY);
		
		robot.centerX = robot.centerX + (directionX * turningRadius);
		robot.centerY = robot.centerY + (directionY * turningRadius);
		robot.centerX = robot.centerX + (newDirectionX * turningRadius);
		robot.centerY = robot.centerY + (newDirectionY * turningRadius);
		
		System.out.println("Turning left");
		System.out.println("Robot Position: " + robot.centerX + " , " + robot.centerY); 
	}
	
	public static void turnRight(Robot robot, int turningRadius)	//Dummy function
	{
		int directionX = robot.getDirectionX();
		int directionY = robot.getDirectionY();
		int newDirectionX = robot.getDirectionX();
		int newDirectionY = robot.getDirectionY();
		
		if(directionX == 0 && directionY == 1)
		{
			newDirectionX = 1;
			newDirectionY = 0;
		}
		else if(directionX == 0 && directionY == -1)
		{
			newDirectionX = -1;
			newDirectionY = 0;
		}
		else if(directionX == 1 && directionY == 0)
		{
			newDirectionX = 0;
			newDirectionY = -1;
		}
		else if(directionX == -1 && directionY == 0)
		{
			newDirectionX = 0;
			newDirectionY = 1;
		}
		
		robot.setDirectionX(newDirectionX);
		robot.setDirectionY(newDirectionY);
		
		robot.centerX = robot.centerX + (directionX * turningRadius);
		robot.centerY = robot.centerY + (directionY * turningRadius);
		robot.centerX = robot.centerX + (newDirectionX * turningRadius);
		robot.centerY = robot.centerY + (newDirectionY * turningRadius);
		
		System.out.println("Turning right");
		System.out.println("Robot Position: " + robot.centerX + " , " + robot.centerY); 
	}
	
	public static void turnLeftBackwards(Robot robot, int turningRadius)	//Dummy function
	{
		int directionX = robot.getDirectionX();
		int directionY = robot.getDirectionY();
		int newDirectionX = robot.getDirectionX();
		int newDirectionY = robot.getDirectionY();
		
		if(directionX == 0 && directionY == 1)
		{
			newDirectionX = 1;
			newDirectionY = 0;
		}
		else if(directionX == 0 && directionY == -1)
		{
			newDirectionX = -1;
			newDirectionY = 0;
		}
		else if(directionX == 1 && directionY == 0)
		{
			newDirectionX = 0;
			newDirectionY = -1;
		}
		else if(directionX == -1 && directionY == 0)
		{
			newDirectionX = 0;
			newDirectionY = 1;
		}
		
		robot.setDirectionX(newDirectionX);
		robot.setDirectionY(newDirectionY);
		
		robot.centerX = robot.centerX + (-directionX * turningRadius);
		robot.centerY = robot.centerY + (-directionY * turningRadius);
		robot.centerX = robot.centerX + (newDirectionX * turningRadius);
		robot.centerY = robot.centerY + (newDirectionY * turningRadius);
		
		System.out.println("Turning left backwards");
		System.out.println("Robot Position: " + robot.centerX + " , " + robot.centerY); 
	}
	
	public static void turnRightBackwards(Robot robot, int turningRadius)	//Dummy function
	{
		int directionX = robot.getDirectionX();
		int directionY = robot.getDirectionY();
		int newDirectionX = robot.getDirectionX();
		int newDirectionY = robot.getDirectionY();
		
		if(directionX == 0 && directionY == 1)
		{
			newDirectionX = -1;
			newDirectionY = 0;
		}
		else if(directionX == 0 && directionY == -1)
		{
			newDirectionX = 1;
			newDirectionY = 0;
		}
		else if(directionX == 1 && directionY == 0)
		{
			newDirectionX = 0;
			newDirectionY = 1;
		}
		else if(directionX == -1 && directionY == 0)
		{
			newDirectionX = 0;
			newDirectionY = -1;
		}
		
		robot.setDirectionX(newDirectionX);
		robot.setDirectionY(newDirectionY);
		
		robot.centerX = robot.centerX + (-directionX * turningRadius);
		robot.centerY = robot.centerY + (-directionY * turningRadius);
		robot.centerX = robot.centerX + (newDirectionX * turningRadius);
		robot.centerY = robot.centerY + (newDirectionY * turningRadius);
		
		System.out.println("Turning right backwards");
		System.out.println("Robot Position: " + robot.centerX + " , " + robot.centerY); 
	}	
	
	public static List<int[]> getPoints(List<List<Cell>> simplifiedPath)
	{
		List<int[]> pointList = new ArrayList<int[]>();
		
		
		for(int i = 0; i < simplifiedPath.size(); i++)
		{
			List<Cell> path = simplifiedPath.get(i);
			
			int[] point = new int[2];
			
			if(i == 0)
			{
				int[] startPoint = new int[2];
				startPoint[0] = path.get(0).getX() * 10 + 5;
				startPoint[1] = path.get(0).getY() * 10 + 5;
				pointList.add(startPoint);
			}
			
			point[0] = path.get(path.size() - 1).getX() * 10 + 5;
			point[1] = path.get(path.size() - 1).getY() * 10 + 5;
			pointList.add(point);		
		}
		
		return pointList;
	}
	
	public static void createPath2(List<List<Cell>> simplifiedPath, Robot robot, Map map)
	{
		int directionX = 0;
		int directionY = 0;
		int offset = 3; //Offset to be used when turning
		int turningRadius = 25;
		
		Cell[][] grid = map.getGrid();
		
		List<int[]> directionList = new ArrayList<int[]>();
		List<int[]> pointList = getPoints(simplifiedPath);
		List<Command> commandList = new ArrayList<Command>();
		int[] robotPos = new int[2];
		robot.centerX = pointList.get(0)[0];
		robot.centerY = pointList.get(0)[1];
		System.out.println("Robot Position: " + robot.centerX + " , " + robot.centerY);
		
		for(int i = 0; i < simplifiedPath.size(); i++)
		{
			List<Cell> subPath = simplifiedPath.get(i);
			
			if(subPath.size() > 1)
			{
				directionX = subPath.get(subPath.size() - 1).getX() - subPath.get(0).getX();
				directionY = subPath.get(subPath.size() - 1).getY() - subPath.get(0).getY();
			}
			
			else
			{
				directionX = subPath.get(0).getX() - simplifiedPath.get(i - 1).get(simplifiedPath.get(i - 1).size() - 1).getX();
				directionY = subPath.get(0).getY() - simplifiedPath.get(i - 1).get(simplifiedPath.get(i - 1).size() - 1).getY();
			}
			
			if(directionX > 0 && directionY == 0)
			{
				directionList.add(new int[] {1, 0});
			}
			
			if(directionX < 0 && directionY == 0)
			{
				directionList.add(new int[] {-1, 0});
			}
			
			if(directionX == 0 && directionY > 0)
			{
				directionList.add(new int[] {0, 1});
			}
			
			if(directionX == 0 && directionY < 0)
			{
				directionList.add(new int[] {0, -1});
			}
			
			System.out.println("Directions: " + directionList.get(i)[0] + " , " + directionList.get(i)[1]);
		}
		
		for(int i = 0; i < simplifiedPath.size() - 1; i++)
		{
			List<Cell> subPath = simplifiedPath.get(i);
			Cell turningPoint = subPath.get(subPath.size() - 1); //Last cell in the subpath
			
			robotPos[0] = (int)robot.centerX;
			robotPos[1] = (int)robot.centerY;
			
			System.out.println("------------------------");
			System.out.println("Robot direction: " + robot.getDirectionX() + " , " + robot.getDirectionY());//Debugging
			System.out.println("Path direction: " + directionList.get(i)[0] + " , " + directionList.get(i)[1]);
			System.out.println("Turning point: " + turningPoint.getX() + " , " + turningPoint.getY()); 
			
			if(oppositeDirection(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i)[0], directionList.get(i)[1])) //Robot direction opposite as path direction
			{
				System.out.println("Robot facing wrong way");
				
				if(checkEmptySpace(grid, turningPoint, directionList.get(i)[0], directionList.get(i)[1], offset) == true) //Check along current path, if there is space
				{	
					System.out.println("There is space along the current path to perform a move back");
					
					if(checkLength(pointList.get(i + 1), pointList.get(i + 2), true) >= turningRadius) //Next path has space
					{
						System.out.println("There is space along the next path to turn");
						
						if(crossProduct(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i + 1)[0], directionList.get(i + 1)[1]) > 0) //Move beyond the path backwards and then turn left
						{
							System.out.println("Move back turn left");
							int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
							moveBackwards(robot, distanceToMove + turningRadius);
							turnLeft(robot, turningRadius);						
						}
						else //Move beyond the path backwards and then turn right
						{
							System.out.println("Move back turn right");
							int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
							moveBackwards(robot, distanceToMove + turningRadius);
							turnRight(robot, turningRadius);
						}
					}
					else if(checkLength(pointList.get(i + 1), pointList.get(i + 2), true) < turningRadius) //Next path has no space
					{
						System.out.println("There is no space along the next path to turn");
						if(checkEmptySpace2(grid, pointList.get(i + 2), directionList.get(i + 1)[0], directionList.get(i + 1)[1], offset)) //No obstacle blocking end of 2nd subpath, can overshoot
						{
							System.out.println("There is space to overshoot");
							
							if(crossProduct(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i + 1)[0], directionList.get(i + 1)[1]) > 0) //Move beyond the path backwards and then turn left
							{
								System.out.println("Move back turn left");
								int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
								moveBackwards(robot, distanceToMove + turningRadius);
								turnLeft(robot, turningRadius);
								System.out.println("Reversing the overshoot");
								distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 2), true);
								moveBackwards(robot, distanceToMove);
							}
							else //Move beyond the path backwards and then turn right
							{
								System.out.println("Move back turn right");
								int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
								moveBackwards(robot, distanceToMove + turningRadius);
								turnRight(robot, turningRadius);
								System.out.println("Reversing the overshoot");
								distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 2), true);
								moveBackwards(robot, distanceToMove);
							}
						}
						else //Obstacle blocking, cant overshoot
						{
							//cry
						}
					}			
				}
				else if(checkEmptySpace(grid, turningPoint, directionList.get(i + 1)[0], directionList.get(i + 1)[1], -offset) == true) //Check in the opposite direction of the next path, if there is space
				{	
					System.out.println("There is space along the next path to perform a backwards turn");
					if(crossProduct(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i + 1)[0], directionList.get(i + 1)[1]) > 0) //Turn Right Backwards
					{
						turnRightBackwards(robot, turningRadius);
					}
					else //Turn Left Backwards
					{
						turnLeftBackwards(robot, turningRadius);
					}	
				}
				else //No space at all, keep moving backwards and try again when there is another turn
				{
					System.out.println("No space at all, check next turn");
					if(crossProduct(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i + 1)[0], directionList.get(i + 1)[1]) < 0)
					{
						turnRightBackwards(robot, turningRadius);
					}
					else //Turn Left Backwards
					{
						turnLeftBackwards(robot, turningRadius);
					}	
				}
			}
			else	//Correct orientation
			{				
				if(i != simplifiedPath.size() - 1)
				{
					if(crossProduct(robot.getDirectionX(), robot.getDirectionY(), directionList.get(i + 1)[0], directionList.get(i + 1)[1]) > 0) //Turn Left
					{
						if(checkLength(pointList.get(i), pointList.get(i + 1), true) >= turningRadius && checkLength(pointList.get(i + 1), pointList.get(i + 2), true) >= turningRadius) //Enough space in both subpaths
						{
							System.out.println("Enough space");
							int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
							if(distanceToMove >= turningRadius) //Needs to move to reach the turning radius
							{
								moveForwards(robot, distanceToMove - turningRadius);
								turnLeft(robot, turningRadius);
							}
							else //Overshot the turning radius, needs to reverse
							{
								moveBackwards(robot, turningRadius - distanceToMove);								
								turnLeft(robot, turningRadius);
							}			
						}
						else if(checkLength(pointList.get(i), pointList.get(i + 1), true) < turningRadius && checkLength(pointList.get(i + 1), pointList.get(i + 2), true) >= turningRadius) //No space in first subpath, try and reverse to get space
						{
							System.out.println("First subpath no space");
							if(checkEmptySpace2(grid, pointList.get(i), directionList.get(i)[0], directionList.get(i)[1], -offset)) //No obstacle blocking start of first subpath, can reverse to make space
							{
								int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
								moveBackwards(robot, turningRadius - distanceToMove);		
								turnLeft(robot, turningRadius);
							}
							else
							{
								//cry
							}
						}
						else if(checkLength(pointList.get(i), pointList.get(i + 1), true) >= turningRadius && checkLength(pointList.get(i + 1), pointList.get(i + 2), true) < turningRadius) //No space in second subpath, check if there is obstacle in 2nd subpath, if not can overshoot and reverse
						{
							System.out.println("2nd subpath no space");
							if(checkEmptySpace2(grid, pointList.get(i + 2), directionList.get(i + 1)[0], directionList.get(i + 1)[1], offset)) //No obstacle blocking end of 2nd subpath, can overshoot
							{
								int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
								if(distanceToMove >= turningRadius) //Needs to move to reach the turning radius
								{
									moveForwards(robot, distanceToMove - turningRadius);
									turnLeft(robot, turningRadius);
								}
								else //Overshot the turning radius, needs to reverse
								{
									moveBackwards(robot, turningRadius - distanceToMove);					
									turnLeft(robot, turningRadius);
								}								
								
								distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 2), true);
								moveBackwards(robot, distanceToMove);
							}
							else
							{
								//cry						
							}
						}
						else //No space in both subpaths
						{
							System.out.println("Both paths no space");
							if(checkEmptySpace2(grid, pointList.get(i), directionList.get(i)[0], directionList.get(i)[1], -offset)) //No obstacle blocking start of first subpath, can reverse to make space
							{								
								if(checkEmptySpace2(grid, pointList.get(i + 2), directionList.get(i + 1)[0], directionList.get(i + 1)[1], offset)) //No obstacle blocking end of 2nd subpath, can overshoot
								{						
									int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
									moveBackwards(robot, turningRadius - distanceToMove);		
									turnLeft(robot, turningRadius);
									distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 2), true);									
									moveBackwards(robot, distanceToMove);
								}
							}
						}
					}
					else //Turn Right
					{
						if(checkLength(pointList.get(i), pointList.get(i + 1), true) >= turningRadius && checkLength(pointList.get(i + 1), pointList.get(i + 2), true) >= turningRadius) //Enough space in both subpaths
						{
							System.out.println("Enough space");
							int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
							if(distanceToMove >= turningRadius) //Needs to move to reach the turning radius
							{
								moveForwards(robot, distanceToMove - turningRadius);
								turnRight(robot, turningRadius);
							}
							else //Overshot the turning radius, needs to reverse
							{
								moveBackwards(robot, turningRadius - distanceToMove);					
								turnRight(robot, turningRadius);
							}		
						}
						else if(checkLength(pointList.get(i), pointList.get(i + 1), true) < turningRadius && checkLength(pointList.get(i + 1), pointList.get(i + 2), true) >= turningRadius) //No space in first subpath, try and reverse to get space
						{
							System.out.println("1st subpath no space");
							if(checkEmptySpace2(grid, pointList.get(i), directionList.get(i)[0], directionList.get(i)[1], -offset)) //No obstacle blocking start of first subpath, can reverse to make space
							{
								int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
								moveBackwards(robot, turningRadius - distanceToMove);		
								turnRight(robot, turningRadius);
							}
							else
							{
								//cry
							}
						}
						else if(checkLength(pointList.get(i), pointList.get(i + 1), true) >= turningRadius && checkLength(pointList.get(i + 1), pointList.get(i + 2), true) < turningRadius) //No space in second subpath, check if there is obstacle in 2nd subpath, if not can overshoot and reverse
						{
							System.out.println("2nd subpath no space");
							if(checkEmptySpace2(grid, pointList.get(i + 2), directionList.get(i + 1)[0], directionList.get(i + 1)[1], offset)) //No obstacle blocking end of 2nd subpath, can overshoot
							{
								int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
								if(distanceToMove >= turningRadius) //Needs to move to reach the turning radius
								{
									moveForwards(robot, distanceToMove - turningRadius);
									turnRight(robot, turningRadius);
								}
								else //Overshot the turning radius, needs to reverse
								{
									moveBackwards(robot, turningRadius - distanceToMove);					
									turnRight(robot, turningRadius);
								}
								
								distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 2), true);
								moveBackwards(robot, distanceToMove);
							}
							else
							{
								//cry
							}
						}
						else //No space in both subpaths
						{
							System.out.println("Both paths no space");
							if(checkEmptySpace2(grid, pointList.get(i), directionList.get(i)[0], directionList.get(i)[1], -offset)) //No obstacle blocking start of first subpath, can reverse to make space
							{								
								if(checkEmptySpace2(grid, pointList.get(i + 2), directionList.get(i + 1)[0], directionList.get(i + 1)[1], offset)) //No obstacle blocking end of 2nd subpath, can overshoot
								{						
									int distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 1), true);
									moveBackwards(robot, turningRadius - distanceToMove);		
									turnRight(robot, turningRadius);
									distanceToMove = checkLength(new int[] {(int)robot.centerX, (int)robot.centerY}, pointList.get(i + 2), true);					
									moveBackwards(robot, distanceToMove);
								}
							}
						}
					}
				}				
			}
		}
		
		if(robot.getDirectionX() != directionList.get(directionList.size() - 1)[0] && robot.getDirectionY() != directionList.get(directionList.size() - 1)[1])  //No more turns left but robot is still not in the correct direction
		{
			//Do emergency turning
		}
	}
	
	public static int checkLength(int[] p1, int[] p2, boolean abs)
	{
		if(abs == true)
		{
			if(p1[0] - p2[0] == 0)
			{	
				return Math.abs(p1[1] - p2[1]);
			}
			else
			{				
				return Math.abs(p1[0] - p2[0]);
			}
		}
		else
		{
			if(p1[0] - p2[0] == 0)
			{
				return Math.abs(p1[1] - p2[1]);
			}
			else
			{
				return Math.abs(p1[0] - p2[0]);
			}
		}
	}
}
