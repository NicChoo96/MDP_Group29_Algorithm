package algoClient;

import algo.Obstacle;
import com.mdp.grpc.*;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import pathserver.Pathserver;

import java.awt.geom.AffineTransform;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AlgoClient {
    private static final Logger logger = Logger.getLogger(AlgoClient.class.getName());
    private final algoGrpc.algoBlockingStub blockingStub;

    public AlgoClient(Channel channel) {
        blockingStub = algoGrpc.newBlockingStub(channel);
    }

    /**
     * Convert the list of moves from PathserverClient for sending to rPi.
     * @param movesList list of moves.
     */
    public void formatMoves(List<Pathserver.PlanReply.Move> movesList, Pathserver.State startState, Obstacle currentGoal) {
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
        updateStatus(RobotStatus.MOV);
        for (Pathserver.PlanReply.Move command : movesList) {
            if (Math.abs(command.getDistance()) > 0.000001) {
                switch (command.getDirection()) {
                case LEFT:
                    radiusIndex = 1;
                    anchorPoints = getAnchorPoint(x, y, theta, 1);
                    affine = AffineTransform.getRotateInstance(command.getDistance()/0.337, anchorPoints[0], anchorPoints[1]);
                    affine.transform(srcPts, 0, destPts, 0, 1);
                    x = round(destPts[0]);
                    y = round(destPts[1]);
                    theta = round(theta + command.getDistance()/0.337);
                    break;
                case RIGHT:
                    radiusIndex = -1;
                    anchorPoints = getAnchorPoint(x, y, theta, -1);
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
                    long timeToSleep = (long) (move(radiusIndex, command.getDistance()) * 1.1e3);
                    Thread.sleep(timeToSleep);
                    movePoints.add(new double[]{x, y, theta});
                    moveVirtual(x, y, theta);
                } catch (Exception ignored) {
                }
            }
        }
        /*logger.info("Move Points: ");
        for (double[] points : movePoints) {
            System.out.println("x: " + points[0] + ", y: " + points[1] + ", theta: " + points[2]);
        }*/
        updateStatus(RobotStatus.STCI);
        takePicture(currentGoal);
        updateStatus(RobotStatus.IC);
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
     * Receives and returns obstacle string from server.
     * @return string of obstacles as received from server.
     */
    public String receiveCoordinates() {
        Empty empty = Empty.newBuilder().build();
        try {
            logger.info("Requesting obstacle string...");
            ObstacleString obstaclesString = blockingStub.receiveCoordinates(empty);
            logger.info("Obstacle string received: \n" + obstaclesString.getObstacles() + "\n");
            return obstaclesString.getObstacles();
        } catch (StatusRuntimeException e) {
            logger.warning("rpc receiveCoordinates failed: " + e.getStatus());
            return "null";
        }
    }

    /**
     * Sends move command to the server.
     * @return the time required to complete the movement.
     */
    private double move(int radiusIndex, double distance) {
        MoveRequest moveRequest = MoveRequest.newBuilder().setRadiusIndexed(radiusIndex).setDistance(distance).build();
        try {
            logger.info("Sending move command...");
            MoveResponse moveResponse = blockingStub.move(moveRequest);
            logger.info("Move response received: " + moveResponse.getTimeRequired() + " seconds\n");
            return moveResponse.getTimeRequired();
        } catch (StatusRuntimeException e) {
            logger.warning("rpc move failed: " + e.getStatus());
            return 0;
        }
    }

    /**
     * Receive and return the list of available turn radii from the server.
     * @return the list of available turn radii.
     */
    public List<Double> getRadii() {
        Empty empty = Empty.newBuilder().build();
        try {
            RadiiResponse radiiResponse = blockingStub.getRadii(empty);
            logger.info("Received turning radii from server.");
            return radiiResponse.getRadiiList();
        } catch (StatusRuntimeException e) {
            logger.warning("rpc getRadii failed: " + e.getStatus());
            return null;
        }
    }

    /**
     * Send the robot's position to the server. Converts the robot's coordinates into grid positions before sending.
     * Format of message is "RP:X:Y:Dir", where X and Y indicate the grid cell, and Dir is N, S, E, or W.
     * @param robotX robot's x-coordinate in metres.
     * @param robotY robot's y-coordinate in metres.
     * @param robotTheta angle robot is facing.
     */
    private void moveVirtual(double robotX, double robotY, double robotTheta) {
        int gridX = (int) (robotX * 10);
        int gridY = (int) (robotY * 10);
        char direction;
        if (robotTheta >= 0.25f * Math.PI && robotTheta < 0.75f * Math.PI) {
            direction = 'N';
        } else if (robotTheta >= -0.25f * Math.PI && robotTheta < 0.25f * Math.PI) {
            direction = 'E';
        } else if (robotTheta >= -0.75f * Math.PI && robotTheta < -0.25f * Math.PI) {
            direction = 'S';
        } else {
            direction = 'W';
        }

        String positionString = "RP:" + gridX + ":" + gridY + ":" + direction;
        RobotPosition robotPosition = RobotPosition.newBuilder().setRobotCoordinates(positionString).build();
        try {
            logger.info("Sending robot coordinates...");
            Empty empty = blockingStub.moveVirtual(robotPosition);
            logger.info("Successfully sent robot coordinates.");
        } catch (StatusRuntimeException e) {
            logger.warning("rpc moveVirtual failed: " + e.getStatus());
        }
    }

    /**
     * Sends a command to the server to take a picture of the image.
     * @param goal the obstacle whose picture is to be taken.
     */
    private void takePicture(Obstacle goal) {
        ImageID imageID = ImageID.newBuilder().setId(String.valueOf(goal.getId())).build();
        try {
            logger.info("Sending command to take picture...");
            Empty emptyResponse = blockingStub.takePicture(imageID);
            logger.info("Took picture of obstacle " + goal.getId());
        } catch (StatusRuntimeException e) {
            logger.warning("rpc takePicture failed: " + e.getStatus());
        }
    }

    /**
     * Sends the status of the robot to the server.
     * @param status the status of the robot (e.g., moving, stopped, taking picture).
     */
    public void updateStatus(RobotStatus status) {
        StatusString statusString = StatusString.newBuilder().setStatus(status.toString()).build();
        try {
            logger.info("Sending " + status +  " status...");
            Empty emptyResponse = blockingStub.updateStatus(statusString);
            logger.info("Robot status sent successfully.");
        } catch (StatusRuntimeException e) {
            logger.warning("rpc updateStatus failed: " + e.getStatus());
        }
    }

    /**
     * Checks if the Android has sent the start command.
     * @return a boolean indicating if the run has started.
     */
    public boolean checkStart() {
        Empty emptyRequest = Empty.newBuilder().build();
        try {
            StartResponse hasStarted = blockingStub.checkStart(emptyRequest);
            return hasStarted.getStart();
        } catch (StatusRuntimeException e) {
            logger.warning("rpc checkStart failed: " + e.getStatus());
            return false;
        }
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
