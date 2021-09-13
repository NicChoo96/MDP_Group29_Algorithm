package algo;

import java.util.*;

public class MapTester {
    public static void main(String[] args) {
        Map testMap = new Map();
        // Set test obstacles.
        testMap.setObstacle(5, 7, 'S');
        testMap.setObstacle(9, 10, 'W');
        testMap.setObstacle(2, 6, 'N');
        testMap.setObstacle(14, 14, 'E');
        testMap.setObstacle(18, 2, 'N');
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
        Pathfinder p = new Pathfinder();
        System.out.println("All Hamiltonian paths and their total distance: ");
        p.printAllHamiltonianPaths(g, start, visited, path, noOfNodes, distances);
        // Finding the shortest Hamiltonian path.
        List<Integer> sequence = p.findShortestPath(distances);
        System.out.println("\nShortest path: " + sequence);

        // Getting the source node and destination node to pass into A* algorithm
        HashMap<Integer, Cell> nodeNumbers = testMap.getNodeNumbers();
        System.out.println("Sequence of nodes to stop at: ");
        for (Integer k : sequence) {
            System.out.println(nodeNumbers.get(k));
        }

        // Instantiate Robot
        Robot robot = new Robot(1, 1, 'N');

        // A* Algorithm
        AStar ass = new AStar(testMap.getGrid(), robot);
        for (int i = 0; i < sequence.size() - 1; i++) {
            ass.menu(nodeNumbers.get(sequence.get(i)).getX(), nodeNumbers.get(sequence.get(i)).getY(),
                    nodeNumbers.get(sequence.get(i + 1)).getX(), nodeNumbers.get(sequence.get(i + 1)).getY());
        }
        
        List<List<Cell>> simpliedPath = new ArrayList<List<Cell>>();
        List<Cell> testPath = new ArrayList<Cell>();
        
        
        testPath.add(new Cell(12, 6));
        testPath.add(new Cell(13, 6));
        testPath.add(new Cell(14, 6));
        testPath.add(new Cell(15, 6));
//        testPath.add(new Cell(15, 5));
//        testPath.add(new Cell(15, 4));
//        testPath.add(new Cell(15, 3));
        testPath.add(new Cell(15, 7));
//        testPath.add(new Cell(15, 8));
//        testPath.add(new Cell(15, 9));	
        
        robot.setDirection('W');
        
        simpliedPath = Pathing.Simplify_Path(testPath);
        for(List<Cell> subPath : simpliedPath)
        {
        	System.out.println("Subpath");
        	for(Cell cell : subPath)
        	{
        		System.out.println(cell.getX() + "," + cell.getY());
        	}
        }        
        
        Pathing.createPath2(simpliedPath, robot, testMap);
        List<int[]> pointList = Pathing.getPoints(simpliedPath);
        
        System.out.println();
        
        for(int[] point : pointList)
        {
        	System.out.println("Points to go to: " + point[0] + " , " + point[1]);
        }
        
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
}
