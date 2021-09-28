package algoClient;

import com.mdp.grpc.*;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import pathserver.Pathserver;

import java.awt.geom.AffineTransform;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class AlgoClient {
    private static final Logger logger = Logger.getLogger(AlgoClient.class.getName());
    private final algoGrpc.algoBlockingStub blockingStub;

    public AlgoClient(Channel channel) {
        blockingStub = algoGrpc.newBlockingStub(channel);
    }

    /**
     * Receives and returns obstacle string from server.
     * @return string of obstacles as received from server.
     */
    public String receiveCoordinates() {
        Empty empty = Empty.newBuilder().build();
        try {
            ObstacleString obstaclesString = blockingStub.receiveCoordinates(empty);
            logger.info("Obstacle string received: \n" + obstaclesString.getObstacles() + "\n");
            return obstaclesString.getObstacles();
        } catch (StatusRuntimeException e) {
            logger.warning("rpc receiveCoordinates failed: " + e.getStatus());
            return "null";
        }
    }

    /**
     * Convert the list of moves from PathserverClient for sending to rPi.
     * @param movesList list of moves.
     */
    public void formatMoves(List<Pathserver.PlanReply.Move> movesList, Pathserver.State startState) {
        int radiusIndex = 0;
        double x = startState.getX();
        double y = startState.getY();
        double[] srcPts = new double[] {x, y};
        double[] destPts = new double[2];
        double theta = startState.getTheta();
        AffineTransform affine;
        double[] anchorPoints;
        List<double[]> movePoints = new ArrayList<>();
        movePoints.add(new double[] {x, y, theta});
        for (Pathserver.PlanReply.Move command : movesList) {
            if (Math.abs(command.getDistance()) > 0.000001) {
                switch (command.getDirection()) {
                case LEFT:
                    radiusIndex = 1;
                    anchorPoints = getAnchorPoint(x, y, theta, 1);
                    System.out.println("Anchor point: x = " + anchorPoints[0] + " , y = " + anchorPoints[1]);
                    System.out.println("Arc length: " + command.getDistance());
                    affine = AffineTransform.getRotateInstance(command.getDistance()/0.337, anchorPoints[0], anchorPoints[1]);
                    affine.transform(srcPts, 0, destPts, 0, 1);
                    x = round(destPts[0]);
                    y = round(destPts[1]);
                    theta = round(theta + command.getDistance()/0.337);
                    break;
                case RIGHT:
                    radiusIndex = -1;
                    anchorPoints = getAnchorPoint(x, y, theta, -1);
                    System.out.println("Anchor point: x = " + anchorPoints[0] + " , y = " + anchorPoints[1]);
                    System.out.println("Arc length: " + command.getDistance());
                    affine = AffineTransform.getRotateInstance(-command.getDistance()/0.337, anchorPoints[0], anchorPoints[1]);
                    affine.transform(srcPts, 0, destPts, 0, 1);
                    x = round(destPts[0]);
                    y = round(destPts[1]);
                    theta = round(theta - command.getDistance()/0.337);
                    break;
                case STRAIGHT:
                    radiusIndex = 0;
                    x = round(x + (command.getDistance() * Math.cos(theta)));
                    y = round(y + (command.getDistance() * Math.sin(theta)));
                    theta = round(theta);
                    break;
                default:
                    break;
                }
                srcPts[0] = x;
                srcPts[1] = y;
                try {
                    logger.info("Move command sent.");
                    TimeUnit.SECONDS.sleep((long) move(radiusIndex, command.getDistance()));
                    logger.info("Robot moved.");
                    movePoints.add(new double[]{x, y, theta});
                    moveVirtual(x, y, theta);
                } catch (Exception ignored) {
                }
            }
        }
        logger.info("Move Points: ");
        for (double[] points : movePoints) {
            System.out.println("x: " + points[0] + ", y: " + points[1] + ", theta: " + points[2]);
        }
        // TODO: move forward for camera to scan image, then move backward.
    }

    private double[] getAnchorPoint(double x, double y, double theta, double direction) {
        theta += direction * Math.PI/2;
        x += 0.337 * Math.cos(theta);
        y += 0.337 * Math.sin(theta);

        return new double[] {round(x), round(y)};
    }

    /**
     * Returns a double, rounded to 5 decimal places. This value can be modified.
     * @param value the double to be rounded.
     * @return the double rounded to 5 decimal places.
     */
    private double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(5, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Sends move command to the server.
     * @return the time required to complete the movement.
     */
    public double move(int radiusIndex, double distance) {
        MoveRequest moveRequest = MoveRequest.newBuilder().setRadiusIndexed(radiusIndex).setDistance(distance).build();
        MoveResponse moveResponse = blockingStub.move(moveRequest);
        logger.info("Move response received: " + moveResponse + "seconds\n");
        return moveResponse.getTimeRequired();
    }

    /**
     * Receive and return the list of available turn radii from the server.
     * @return the list of available turn radii.
     */
    public List<Double> getRadii() {
        Empty empty = Empty.newBuilder().build();
        RadiiResponse radiiResponse = blockingStub.getRadii(empty);
        return radiiResponse.getRadiiList();
    }

    /**
     * Send the robot's position to the server.
     * @param robotX robot's x-coordinate.
     * @param robotY robot's y-coordinate.
     * @param robotDirection angle robot is facing.
     */
    public void moveVirtual(double robotX, double robotY, double robotDirection) {
        RobotPosition.Builder robotPositionBuilder = RobotPosition.newBuilder();
        String positionString = "RP:" + robotX + ":" +
                robotY + ":" +
                robotDirection;
        RobotPosition robotPosition = robotPositionBuilder.setRobotCoordinates(positionString).build();
        logger.info("Sending coordinates to server...");
        Empty empty = blockingStub.moveVirtual(robotPosition);
    }

/*
    public static void main(String[] args) {
        // TODO: connect to rPi.
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8980).usePlaintext().build();

        AlgoClient client = new AlgoClient(channel);

        // Run the Hamilton and A* algorithms to find the path.
        MapTester.run(client.receiveCoordinates());
        // TODO: receive radii list from server.
        // MapTester.receiveRadii(client.getRadii())
        // TODO: send coordinates of robot to server as it moves.
        //
        // client.moveVirtual(MapTester.
        channel.shutdown();
    }

 */


}
