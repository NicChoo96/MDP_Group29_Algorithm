package ui;

import java.util.ArrayList;
import java.util.List;

import algo.Robot;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class UIRobot {
	
	private Rectangle robot = new Rectangle();
	private double x, y, panelHeight, scaling, _x, _y;
	private char direction = 'N';
	private double duration = 4000;
	private double arc = 160;
	
	public UIRobot (Pane pane, double panelHeight, double scaling, double startX, double startY) {
		
		this.panelHeight = panelHeight;
		this.scaling = scaling;
		    	
    	robot.setX(5 * scaling);
    	robot.setY((panelHeight - 20) * scaling);
    	robot.setWidth(20 * scaling);
    	robot.setHeight(20 * scaling);
    	
    	Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.RED)};
        LinearGradient lg1 = new LinearGradient(1, 0, 0, 0, true, CycleMethod.NO_CYCLE, stops);
    	
        robot.setFill(lg1);
        
    	x = startX;
    	y = startY;
    	
		pane.getChildren().add(robot);
	}
	
	public Rectangle getRobot() {
		return robot;
	}
	
	public void executeCommand2(List<Command> commandList)
	{
		List<PathTransition> pathTransitionList = new ArrayList<PathTransition>();
		Path path = new Path();
		path.getElements().add(new MoveTo(60, 740));	
		
		for(int i = 0; i < commandList.size(); i++)
		{
			Command command = commandList.get(i);
			
			x = command.getDestX() * scaling;
			y = (panelHeight - command.getDestY()) * scaling;
			
//			System.out.println(x + " , " + y);
			
			if(command.getForwardBack() == 1)
			{							
				if(command.getLeftRight() == 0)
				{			
					path.getElements().add(new LineTo(x, y));
					
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(5000));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pathTransitionList.add(pt);
				}
				else if(command.getLeftRight() == -1)
				{	
					ArcTo arcTo = new ArcTo();
					arcTo.setRadiusX(arc);
					arcTo.setRadiusY(arc);
					
					switch(this.direction)
					{
					case('N'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'W';
						break;
					case('S'):
						arcTo.setX(x);
					arcTo.setY(y);
						direction = 'E';
						break;
					case('E'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'N';
						break;
					case('W'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'S';
						break;
					}
					
					path.getElements().add(arcTo);	
					
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(5000));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pathTransitionList.add(pt);
					
				}
				else
				{
					ArcTo arcTo = new ArcTo();
					arcTo.setRadiusX(arc);
					arcTo.setRadiusY(arc);
					arcTo.setSweepFlag(true);
					
					switch(this.direction)
					{
					case('N'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'E';
						break;
					case('S'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'W';
						break;
					case('E'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'S';
						break;
					case('W'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'N';
						break;
					}
					
					path.getElements().add(arcTo);	
					
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(5000));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pathTransitionList.add(pt);
				}
			}
			else //Backwards
			{
				if(command.getLeftRight() == 0)
				{			
					path.getElements().add(new LineTo(x, y));
					
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(5000));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pt.setInterpolator(ReverseInterpolator.reverse(pt.getInterpolator()));
					pathTransitionList.add(pt);
				}
				else if(command.getLeftRight() == -1)
				{	
					ArcTo arcTo = new ArcTo();
					arcTo.setRadiusX(arc);
					arcTo.setRadiusY(arc);
					
					switch(this.direction)
					{
					case('N'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'W';
						break;
					case('S'):
						arcTo.setX(x);
					arcTo.setY(y);
						direction = 'E';
						break;
					case('E'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'N';
						break;
					case('W'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'S';
						break;
					}
					
					path.getElements().add(arcTo);		
				}
				else
				{
					ArcTo arcTo = new ArcTo();
					arcTo.setRadiusX(arc);
					arcTo.setRadiusY(arc);
					arcTo.setSweepFlag(true);
					
					switch(this.direction)
					{
					case('N'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'E';
						break;
					case('S'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'W';
						break;
					case('E'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'S';
						break;
					case('W'):
						arcTo.setX(x);
						arcTo.setY(y);
						direction = 'N';
						break;
					}
					
					path.getElements().add(arcTo);	
				}
			}
		}
		
		SequentialTransition st = new SequentialTransition();
//		PathTransition pathTransition = new PathTransition();
//		pathTransition.setNode(robot);
//		pathTransition.setDuration(Duration.millis(5000));
//		pathTransition.setPath(path);
//		pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
//		pathTransition.setCycleCount(999);
//		pathTransition.setInterpolator(ReverseInterpolator.reverse(pathTransition.getInterpolator()));
//		st.getChildren().add(pathTransition);
		for(PathTransition pathT : pathTransitionList)
		{
			System.out.println("test");
			st.getChildren().add(pathT);
		}
		st.setCycleCount(1);
		st.play();
	}
	
	public void executeCommand3(List<Command> commandList)
	{
		List<PathTransition> pathTransitionList = new ArrayList<PathTransition>();	
		
		for(int i = 0; i < commandList.size(); i++)
		{
			Command command = commandList.get(i);
			Path path = new Path();

			if(i == 0)
			{
				_x = x * scaling;
				_y = (panelHeight - y) * scaling;
				
				x = command.getDestX() * scaling;
				y = (panelHeight - command.getDestY()) * scaling;
			}
			else
			{
				_x = x;
				_y = y;
				x = command.getDestX() * scaling;
				y = (panelHeight - command.getDestY()) * scaling;
			}
			
			
			
//			System.out.println(x + " , " + y);
			
			if(command.getForwardBack() == 1)
			{							
				if(command.getLeftRight() == 0)
				{						
					
					path.getElements().add(new MoveTo(_x, _y));
					path.getElements().add(new LineTo(x, y));
					
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(duration));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pathTransitionList.add(pt);
				}
				else if(command.getLeftRight() == -1)
				{	
					ArcTo arcTo = new ArcTo();
					arcTo.setRadiusX(arc);
					arcTo.setRadiusY(arc);
					
					switch(this.direction)
					{
					case('N'):
						direction = 'W';
						break;
					case('S'):
						direction = 'E';
						break;
					case('E'):
						direction = 'N';
						break;
					case('W'):
						direction = 'S';
						break;
					}					
					
					arcTo.setX(x);
					arcTo.setY(y);
					
					path.getElements().add(new MoveTo(_x, _y));
					path.getElements().add(arcTo);	
					
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(duration));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pathTransitionList.add(pt);
				}
				else
				{
					ArcTo arcTo = new ArcTo();
					arcTo.setRadiusX(arc);
					arcTo.setRadiusY(arc);
					arcTo.setSweepFlag(true);
					
					switch(this.direction)
					{
					case('N'):
						direction = 'E';
						break;
					case('S'):
						direction = 'W';
						break;
					case('E'):
						direction = 'S';
						break;
					case('W'):
						direction = 'N';
						break;
					}					
					
					arcTo.setX(x);
					arcTo.setY(y);
					
					path.getElements().add(new MoveTo(_x, _y));
					path.getElements().add(arcTo);	
					
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(duration));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pathTransitionList.add(pt);
				}
			}
			else //Backwards
			{
				if(command.getLeftRight() == 0)
				{								
					path.getElements().add(new MoveTo(x, y));		
					path.getElements().add(new LineTo(_x, _y));
										
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(duration));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pt.setInterpolator(ReverseInterpolator.reverse(pt.getInterpolator()));
					pathTransitionList.add(pt);
				}
				else if(command.getLeftRight() == -1)
				{	
					ArcTo arcTo = new ArcTo();
					arcTo.setRadiusX(arc);
					arcTo.setRadiusY(arc);
					
					switch(this.direction)
					{
					case('N'):
						direction = 'W';
						break;
					case('S'):
						direction = 'E';
						break;
					case('E'):
						direction = 'N';
						break;
					case('W'):
						direction = 'S';
						break;
					}				
					
					arcTo.setX(_x);
					arcTo.setY(_y);
					
					path.getElements().add(new MoveTo(x, y));
					path.getElements().add(arcTo);
					
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(duration));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pt.setInterpolator(ReverseInterpolator.reverse(pt.getInterpolator()));
					pathTransitionList.add(pt);
				}
				else
				{
					ArcTo arcTo = new ArcTo();
					arcTo.setRadiusX(arc);
					arcTo.setRadiusY(arc);
					arcTo.setSweepFlag(true);
					
					switch(this.direction)
					{
					case('N'):
						direction = 'E';
						break;
					case('S'):
						direction = 'W';
						break;
					case('E'):
						direction = 'S';
						break;
					case('W'):
						direction = 'N';
						break;
					}					
					
					arcTo.setX(_x);
					arcTo.setY(_y);
					
					path.getElements().add(new MoveTo(x, y));	
					path.getElements().add(arcTo);
					
					PathTransition pt = new PathTransition();
					pt.setNode(robot);
					pt.setDuration(Duration.millis(duration));
					pt.setPath(path);
					pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
					pt.setInterpolator(ReverseInterpolator.reverse(pt.getInterpolator()));
					pathTransitionList.add(pt);
				}
			}
		}
		
		SequentialTransition st = new SequentialTransition();

		for(PathTransition pathT : pathTransitionList)
		{
			st.getChildren().add(pathT);
		}
		st.setCycleCount(1);
		st.play();
	}
	
//	private static void movePivot(Node node, double x, double y){
//        node.getTransforms().add(new Translate(-x,-y));
//        node.setTranslateX(x); 
//        node.setTranslateY(y);
//    }
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
}
