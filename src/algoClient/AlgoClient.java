package algoClient;

import com.mdp.grpc.*;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ManagedChannel;
import algo.MapTester;
import io.grpc.StatusRuntimeException;
import pathserver.Pathserver;

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
    public void formatMoves(List<Pathserver.PlanReply.Move> movesList) {
        int radiusIndex = 0;
        for (Pathserver.PlanReply.Move command : movesList) {
            if (Math.abs(command.getDistance()) > 0.000001) {
                switch (command.getDirection()) {
                case LEFT:
                    radiusIndex = 1;
                    break;
                case RIGHT:
                    radiusIndex = -1;
                    break;
                case STRAIGHT:
                    radiusIndex = 0;
                    break;
                default:
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep((long) move(radiusIndex, command.getDistance()));
                } catch (InterruptedException ignored) {
                }
            }
        }
        // TODO: move forward for camera to scan image, then move backward.
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
     * @param robotDirection direction robot is facing.
     */
    public void moveVirtual(int robotX, int robotY, char robotDirection) {
        RobotPosition.Builder robotPositionBuilder = RobotPosition.newBuilder();
        String positionString = "RP:" + robotX + ":" +
                robotY + ":" +
                robotDirection;
        RobotPosition robotPosition = robotPositionBuilder.setRobotCoordinates(positionString).build();
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
        // TODO: send move commands to server.
        // Send 1 move command 1 at a time and wait for the duration specified by moveResponse.
        // MapTester.wait(client.move(MapTester.moveCommand().getRadiusIndex, MapTester.moveCommand().getDistance()))
        // TODO: send coordinates of robot to server as it moves.
        //
        // client.moveVirtual(MapTester.
        channel.shutdown();
    }

 */


}
