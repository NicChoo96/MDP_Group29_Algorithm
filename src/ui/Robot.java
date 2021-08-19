package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Robot {
	public static int BLOCKWIDTH = 20, BLOCKHEIGHT = 20;
	public double x0, y0;
	public double x1, x2, x3, y1, y2, y3;
	public Direction direction;
	public double velocityX = 0, velocityY = 0;
	private double oldVelocityX, oldVelocityY;
	public List<Double> directionVec;
	
	public Robot(double startPosX, double startPosY, Direction direction) {
		this.x0 = startPosX;
		this.y0 = startPosY;
		this.x1 = x0 + BLOCKWIDTH;
		this.y1 = y0;
		this.x2 = x0;
		this.y2 = y0 + BLOCKHEIGHT;
		this.x3 = x1;
		this.y3 = y2;
		this.direction = direction;
	}
	
	public void draw(Graphics2D g2d) {
		Rectangle2D box = new Rectangle2D.Double(x2 * Panel.SCALE, (Panel.WIN_HEIGHT - y2) * Panel.SCALE , BLOCKWIDTH * Panel.SCALE, BLOCKHEIGHT * Panel.SCALE);
		g2d.setColor(Color.orange);
		g2d.fill(box);
	}
	
	public List<Double> calculateDirectionVec(double destX, double destY) {
		List<Double> directionVec = new ArrayList<Double>();
		directionVec.add((destX - x0) / Math.sqrt(Math.pow((destX - x0), 2) + Math.pow((destY - y0), 2)));
		directionVec.add((destY - y0) / Math.sqrt(Math.pow((destX - x0), 2) + Math.pow((destY - y0), 2)));
		return directionVec;
	}
	
	public double calculateDistance(double destX, double destY) {
		return Math.sqrt(Math.pow((destX - x0), 2) + Math.pow((destY - y0), 2));
	}
	
	public void update() {
		x0 = x0 + velocityX;
		y0 = y0 + velocityY;
		x1 = x0 + BLOCKWIDTH;
		y1 = y0;
		x2 = x0;
		y2 = y0 + BLOCKHEIGHT;
		x3 = x1;
		y3 = y2;
//		this.moveStraight(160, 160);
	}
	
	public boolean moveStraight(double destX, double destY) {
		
		System.out.println(x0);
		System.out.println(y0);
		
		if(velocityX == 0 && velocityY == 0)
		{
			velocityX = (destX - x0) / calculateDistance(destX, destY);
			velocityY = (destY - y0) / calculateDistance(destX, destY);
			
			System.out.println(velocityX);
			System.out.println(velocityY);
			
			
		}
		
		if(calculateDistance(destX, destY) <= 1) {
			
			System.out.println((destX - x0) / calculateDistance(destX, destY));
			System.out.println((destY - y0) / calculateDistance(destX, destY));
			
			x0 = destX;
			y0 = destY;
			
			velocityX = 0;
			velocityY = 0;
			
			x1 = x0 + BLOCKWIDTH;
			y1 = y0;
			x2 = x0;
			y2 = y0 + BLOCKHEIGHT;
			x3 = x1;
			y3 = y2;
			
			System.out.println(x0);
			System.out.println(y0);
			
			return true;
		}
		
		else {
			
			x0 = x0 + velocityX;
			y0 = y0 + velocityY;
			x1 = x0 + BLOCKWIDTH;
			y1 = y0;
			x2 = x0;
			y2 = y0 + BLOCKHEIGHT;
			x3 = x1;
			y3 = y2;
			return false;
		}		
	}
	
	public void move() {
		boolean done = false;
		this.moveStraight(0, 80);
		this.moveStraight(150, 150);
	}
}
