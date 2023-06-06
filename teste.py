from collections import deque

class Graph:
    def __init__(self):
        self.graph = {}
    
    def add_edge(self, u, v):
        if u in self.graph:
            self.graph[u].append(v)
        else:
            self.graph[u] = [v]


def build_graph(grid):
    rows = len(grid)
    cols = len(grid[0])
    g = Graph()

    for i in range(rows):
        for j in range(cols):
            if grid[i][j] != '.':
                node = grid[i][j]
                neighbors = []

                if i - 1 >= 0 and grid[i - 1][j] != '.':
                    neighbors.append(grid[i - 1][j])
                if i + 1 < rows and grid[i + 1][j] != '.':
                    neighbors.append(grid[i + 1][j])
                if j - 1 >= 0 and grid[i][j - 1] != '.':
                    neighbors.append(grid[i][j - 1])
                if j + 1 < cols and grid[i][j + 1] != '.':
                    neighbors.append(grid[i][j + 1])

                for neighbor in neighbors:
                    g.add_edge(node, neighbor)

    return g


def bfs(graph, start):
    visited = set()
    queue = deque()

    visited.add(start)
    queue.append(start)

    objectives = []
    while queue:
        node = queue.popleft()

        if node.isdigit():
            objectives.append(int(node))

        if node in graph:
            for neighbor in graph[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)

    objectives.sort()
    return objectives


# Read the text grid
file_path = 'mapa30.txt'
with open(file_path, 'r') as file:
    rows, cols = map(int, file.readline().split())
    text_grid = [file.readline().strip() for _ in range(rows)]

# Build the graph
g = build_graph(text_grid)

# Run BFS and get objectives in order
objectives = bfs(g.graph, '9')

# Print objectives in order
print("Objectives in order:")
for objective in objectives:
    print(objective)
