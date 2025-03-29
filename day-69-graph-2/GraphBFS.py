from collections import deque  # Import deque for efficient queue operations

class GraphBFS:  # Improved class name
    def __init__(self):
        """Initialize an empty adjacency list to store the graph."""
        self.graph = {}

    def add_edge(self, u, v):
        """Add an edge from node u to node v."""
        if u not in self.graph:
            self.graph[u] = []  # If the node doesn't exist, create an empty list
        self.graph[u].append(v)  # Append v to u’s adjacency list

    def bfs(self, start_node):
        """Perform Breadth-First Search (BFS) starting from the given node."""
        
        visited = set()  # Set to keep track of visited nodes
        queue = deque([start_node])  # Initialize the queue with the start node
        visited.add(start_node)

        while queue:
            node = queue.popleft()  # Dequeue a node from the front of the queue
            print(node, end=" ")  # Process the node (print the output)

            # Enqueue unvisited adjacent nodes
            for neighbor in self.graph.get(node, []):
                if neighbor not in visited:
                    queue.append(neighbor)
                    visited.add(neighbor)

# Example Usage
if __name__ == "__main__":
    graph = GraphBFS()
    graph.add_edge(0, 1)
    graph.add_edge(0, 2)
    graph.add_edge(1, 3)
    graph.add_edge(1, 4)
    graph.add_edge(2, 5)
    graph.add_edge(2, 6)

    print("Breadth-First Traversal starting from node 0:")
    graph.bfs(0)

    """
    Theory of BFS (Breadth-First Search):

    1. **Definition**: BFS is a graph traversal algorithm that explores all neighbors of a node 
       before moving to the next level of nodes.

    2. **Algorithm**:
       - Start with a node and mark it as visited.
       - Enqueue the starting node.
       - While the queue is not empty:
         - Dequeue a node.
         - Print (process) the node.
         - Enqueue all unvisited neighbors.

    3. **Data Structures Used**:
       - **Queue (deque)** (FIFO - First In, First Out)
       - **Set (visited)** to track visited nodes

    4. **Time Complexity**: O(V + E) 
       - V = Number of vertices (nodes)
       - E = Number of edges (connections)

    5. **Applications**:
       - Shortest path in unweighted graphs (Google Maps, GPS Navigation)
       - Social networks (Finding mutual friends, LinkedIn connections)
       - Web Crawlers (Indexing web pages)
       - AI and Games (Pathfinding, solving mazes)
    """
