package ui;

public class Command {
	
	private int forwardBack, leftRight;
	private double destX, destY;
	
	public Command(int forwardBack, int leftRight, double destX, double destY) {
		this.forwardBack = forwardBack;
		this.leftRight = leftRight;
		this.destX = destX;
		this.destY = destY;
	}
	
	public int getForwardBack() {
		return forwardBack;
	}
	
	public int getLeftRight() {
		return leftRight;
	}
	
	public double getDestX() {
		return destX;
	}
	
	public double getDestY() {
		return destY;
	}
}
