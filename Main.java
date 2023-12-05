import java.util.*;

public class Map {

private static  classNode
 
implements
 Comparable<Node> {
        int vertex;
        int distance;

        public
 
Node(int vertex, int distance)
 
{
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override

        
public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    private final int[][] graph;
    private final int vertices;

    public Dijkstra(int[][] graph) {
        this.graph = graph;
        this.vertices = graph.length;
    }

public List<Integer> shortestPath(int source, int destination) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] distances = new int[vertices];
        int[] parents = new int[vertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        parents[source] = -1;

        queue.add(new Node(source, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

        for (int neighbor = 0; neighbor < vertices; neighbor++) {
                if (graph[current.vertex][neighbor] != 0) {
                    int newDistance = distances[current.vertex] + graph[current.vertex][neighbor];
                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        parents[neighbor] = current.vertex;
                        queue.add(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        if (distances[destination] == Integer.MAX_VALUE) {
            return null; // No path found
        }

        List<Integer> path = new ArrayList<>();
        int vertex = destination;
        path.add(vertex);

        while (parents[vertex] != -1) {
            vertex = parents[vertex];
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }
}

public class MapNavigator {
public static void main(String[] args) {
        // Example map:
        int[][] map = {
            {0, 4, 0, 0, 0},
            {4, 0, 8, 0, 0},
            {0, 8, 0, 7, 9},
            {0, 0, 7, 0, 3},
            {0, 0, 9, 3, 0}
        };

        // Find shortest path from A to E:
        Dijkstra Map = new Dijkstra(map);
        List<Integer> path = dijkstra.shortestPath(0, 4);

        if (path != null) {
            System.out.println("Shortest path: " + path);
        } else {
            System.out.println("No path found");
        }
    }
}
