import java.util.*;

class GraphBFS {  // Improved class name
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Method to add an edge to the graph
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);
    }

    // Breadth-First Search (BFS) Traversal
    public void bfs(int startNode) {
        Set<Integer> visited = new HashSet<>();  // Set to track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal

        queue.add(startNode); // Start with the given node
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll(); // Dequeue a node
            System.out.print(node + " "); // Process the node

            // Add unvisited adjacent nodes to the queue
            for (int neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("Breadth-First Traversal starting from node 0:");
        graph.bfs(0);
    }

    /**
     * Theory of BFS (Breadth-First Search):
     * 
     * 1. **Definition**: BFS is a graph traversal algorithm that explores all neighbors of a node 
     *    before moving to the next level of nodes.
     *
     * 2. **Algorithm**:
     *    - Start with a node and mark it as visited.
     *    - Enqueue the starting node.
     *    - While the queue is not empty:
     *      - Dequeue a node.
     *      - Print (process) the node.
     *      - Enqueue all unvisited neighbors.
     *
     * 3. **Data Structures Used**:
     *    - **Queue** (FIFO - First In, First Out)
     *    - **Set (HashSet)** to track visited nodes
     *
     * 4. **Time Complexity**: O(V + E) 
     *    - V = Number of vertices (nodes)
     *    - E = Number of edges (connections)
     *
     * 5. **Applications**:
     *    - Shortest path in unweighted graphs (Google Maps, GPS Navigation)
     *    - Social networks (Finding mutual friends, LinkedIn connections)
     *    - Web Crawlers (Indexing web pages)
     *    - AI and Games (Pathfinding, solving mazes)
     */
}
