package algo;

import algoClient.AlgoClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pathserver.PathserverClient;

import java.util.*;

public class MapTester {

    public static void run(String obstacleString) {
        Map testMap = new Map();
        String[] results = splitString(obstacleString);
        int x, y;
        char direction;
        // Set obstacles using obstacle string.
        for (int n = 0; n < results.length; n += 3) {
            x = Integer.parseInt(results[n]);
            y = Integer.parseInt(results[n + 1]);
            direction = results[n + 2].charAt(0);
            testMap.setObstacle(x, y, direction);
        }
        testMap.assignNodeNumbers();
        testMap.printMap();
        double[][] distances = testMap.computeDistances();
        // For debugging purposes, print the 2D distance array.
        /*System.out.println("Distance matrix (node to node distance): ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%.2f, ", distances[i][j]);
            }
            System.out.println();
        }
        System.out.println(); */

        // Adding edges to the nodes.
        List<Edge> edges = generateEdges(testMap.getNodeNumbers(), distances);

        // Initialize total number of nodes in the graph.
        int noOfNodes = testMap.getNodeNumbers().size();

        // Build a graph from the given edges.
        Graph g = new Graph(edges, noOfNodes);

        // Starting node
        int start = 0;

        // Add starting node to the path.
        List<Integer> path = new ArrayList<>();
        path.add(start);

        // Mark the start node as visited.
        boolean[] visited = new boolean[noOfNodes];
        visited[start] = true;

        // Hamiltonian Algorithm
        Pathfinder pathfinder = new Pathfinder();
        System.out.println("All Hamiltonian paths and their total distance: ");
        pathfinder.printAllHamiltonianPaths(g, start, visited, path, noOfNodes, distances);
        // Finding the shortest Hamiltonian path.
        List<Integer> sequence = pathfinder.findShortestPath(distances, testMap.getObstacles());
        System.out.println("\nShortest path: " + sequence);
        System.out.println("Obstacle visit order: " + pathfinder.getObstacleSequence());

        // Getting the source node and destination node to pass into A* algorithm
        HashMap<Integer, Cell> nodeNumbers = testMap.getNodeNumbers();
        List<Cell> destinationList = new ArrayList<>();
        System.out.println("Sequence of nodes to stop at: ");
        for (Integer k : sequence) {
            System.out.println(nodeNumbers.get(k));
            destinationList.add(nodeNumbers.get(k));
        }

        // Instantiate Robot
        Robot robot = new Robot(1, 1, 'N');

        // A* Algorithm
        /*
        System.out.println("Robot start direction: " + robot.getDirection());
        Cell source, dest;
        Obstacle obstacleToVisit;
        AStar ass = new AStar(testMap.getGrid(), robot);
        for (int i = 0; i < sequence.size() - 1; i++) {
            source = nodeNumbers.get(sequence.get(i));
            dest = nodeNumbers.get(sequence.get(i + 1));
            obstacleToVisit = pathfinder.getObstacleSequence().get(i);
            ass.menu(source.getX(), source.getY(), dest.getX(), dest.getY());
            robot.updateDirectionAfterObstacle(obstacleToVisit);
            System.out.println("Robot new direction: " + robot.getDirection());
        }
        System.out.println("\nAll paths: ");
        for (List<Cell> p : ass.getListOfPaths()) {
            System.out.println(p);
        }
        */

        // Send info to OMPL.
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8980).usePlaintext().build();
        AlgoClient algoClient = new AlgoClient(channel);
        PathserverClient.getOMPLPaths(destinationList, pathfinder.getObstacleSequence(), algoClient);
    }

    private static String[] splitString(String obstacleString) {
        // Remove "OBS:" from the obstacle string.
        // Current string format is "OBS:X:Y:Dir:X:Y:Dir..."
        String preSplitString = obstacleString.substring(4);

        return preSplitString.split(":");
    }

    private static List<Edge> generateEdges(HashMap<Integer, Cell> nodeNumbers, double[][] distances) {
        int n = nodeNumbers.size();
        Edge[] edges = new Edge[n * (n-1)/2];
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges[count++] = new Edge(i, j, distances[i][j]);
            }
        }
        return Arrays.asList(edges);
    }

    // For testing purposes only!
    // Test the algo with an arbitrary obstacle string.
    public static void main(String[] args) {
        run("OBS:9:4:N:13:15:E");
    }

}
