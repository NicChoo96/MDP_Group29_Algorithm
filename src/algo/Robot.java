package algo;

public class Robot {
    protected Map map;
    //protected int x, y; // coordinates of lower left corner of robot
    public static int BLOCKWIDTH = 20, BLOCKHEIGHT = 20;
    public double x0, y0; // centre of robot
	private char direction;

    public Robot(double startPosX, double startPosY, char direction) {
    	x0 = startPosX;
		y0 = startPosY;
        this.direction = direction;
    }

    public void setDirection(char direction) {
    	this.direction = direction;
	}

	public char getDirection() {
    	return direction;
	}

    public void updateDirectionAfterObstacle(Obstacle obstacle) {
        switch (obstacle.getDirection()) {
        case 'N':
            setDirection('S');
            break;
        case 'S':
            setDirection('N');
            break;
        case 'E':
            setDirection('W');
            break;
        case 'W':
            setDirection('E');
            break;
        default:
            break;
        }
    }

    // TODO: add more stuff!
}
