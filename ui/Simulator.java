package ui;

import java.util.ArrayList;
import java.util.List;

import algo.*;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class Simulator extends Application {
	
	double width = 200;
	double height = 200;
	double scaling = 4;
	
	public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
    	
    	Pane pane = new Pane();
    	
    	Scene scene = new Scene(pane, width * scaling, height * scaling);
    	  	
    	List<Obstacle> obstacleList = new ArrayList<Obstacle>();
		obstacleList.add(new Obstacle(20, 180, 'S'));
		obstacleList.add(new Obstacle(150, 150, 'E'));
		obstacleList.add(new Obstacle(80, 50, 'N'));
		obstacleList.add(new Obstacle(120, 120, 'W'));
		
		placeObstacles(obstacleList, pane);
		UIRobot robot = new UIRobot(pane, height, scaling, 15, 15);
		List<Command> commandList = new ArrayList<Command>();
		commandList.add(new Command(1, 0, 15, 40));
		commandList.add(new Command(1, 1, 35, 80));
		commandList.add(new Command(-1, -1, 15, 80));
//		commandList.add(new Command(1, 1, 45, 70));
//		commandList.add(new Command(1, 0, 150, 70));
//		commandList.add(new Command(1, -1, 180, 100));
//		commandList.add(new Command(1, 0, 180, 150));
//		commandList.add(new Command(-1, 0, 180, 50));
//		commandList.add(new Command(-1, -1, 150, 20));
//		commandList.add(new Command(-1, -1, 120, 50));
//		commandList.add(new Command(-1, 1, 90, 80));
		robot.executeCommand3(commandList);
		
        primaryStage.setTitle("Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
               
        scene.setFill(createGridPattern());
    }
    
    public ImagePattern createGridPattern() {

        double w = 40;
        double h = 40;

        Canvas canvas = new Canvas(w, h);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke(Color.BLACK);
        gc.setFill(Color.valueOf("#bee1ed"));
        gc.fillRect(0, 0, w, h);
        gc.strokeRect(0.5, 0.5, w, h);
        
        Image image = canvas.snapshot(new SnapshotParameters(), null);
        ImagePattern pattern = new ImagePattern(image, 0, 0, w, h, false);

        return pattern;

    }
    
    public void placeObstacles(List<Obstacle> obstacleList, Pane pane)
    {
    	for(Obstacle obstacle : obstacleList)
    	{
    		Rectangle obstacleRectangle = new Rectangle();
    		obstacleRectangle.setX(obstacle.getX() * scaling);
    		obstacleRectangle.setY((height - 10 - obstacle.getY()) * scaling);
    		obstacleRectangle.setWidth(10 * scaling);
    		obstacleRectangle.setHeight(10 * scaling);
    		pane.getChildren().add(obstacleRectangle);
    		
    		char direction = obstacle.getDirection();
    		
    		Line line = new Line();
    		
    		switch(direction)
    		{
	    		case 'N':
	    			line.setStartX((obstacle.getX() + 1) * scaling);
	    			line.setEndX((obstacle.getX() + 9) * scaling);
	    			line.setStartY((height - 10 - obstacle.getY()) * scaling);
	    			line.setEndY((height - 10 - obstacle.getY()) * scaling);
	    			line.setStroke(Color.RED);
	    			line.setStrokeWidth(scaling + 1);
	    			break;
	    		case 'S':
	    			line.setStartX((obstacle.getX() + 1) * scaling);
	    			line.setEndX((obstacle.getX() + 9) * scaling);
	    			line.setStartY((height - obstacle.getY()) * scaling);
	    			line.setEndY((height - obstacle.getY()) * scaling);
	    			line.setStroke(Color.RED);
	    			line.setStrokeWidth(scaling + 1);
	    			break;
	    		case 'E':
	    			line.setStartX((obstacle.getX() + 10) * scaling);
	    			line.setEndX((obstacle.getX() + 10) * scaling);
	    			line.setStartY((height - 1 - obstacle.getY()) * scaling);
	    			line.setEndY((height - 9 - obstacle.getY()) * scaling);
	    			line.setStroke(Color.RED);
	    			line.setStrokeWidth(scaling + 1);
	    			break;
	    		case 'W':
	    			line.setStartX((obstacle.getX()) * scaling);
	    			line.setEndX((obstacle.getX()) * scaling);
	    			line.setStartY((height - 1 - obstacle.getY()) * scaling);
	    			line.setEndY((height - 9 - obstacle.getY()) * scaling);
	    			line.setStroke(Color.RED);
	    			line.setStrokeWidth(scaling + 1);
	    			break;
    		}
    		
    		pane.getChildren().add(line);
    	}
    }   
}