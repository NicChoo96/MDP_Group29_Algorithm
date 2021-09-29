package algo;

public class Obstacle extends Cell {
    // To indicate North, South, East, or West.
    private final char direction;

    public double middleX, middleY;

    private final int id;

    public Obstacle(int id, int x, int y, char direction) {
        super(x, y);
        this.id = id;
        middleX = x * 0.1f + 0.05f;
        middleY = y * 0.1f + 0.05f;
        isObstacle = true;
        isTraversable = false;
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d), %c", x0, y0, direction);
    }
}