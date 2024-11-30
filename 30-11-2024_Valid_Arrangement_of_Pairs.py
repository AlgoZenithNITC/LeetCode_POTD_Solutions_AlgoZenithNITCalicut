class Solution:
    def validArrangement(self, pairs):
        adj = defaultdict(deque)  # Using deque for efficient pop operations from both ends
        indegree = defaultdict(int)
        outdegree = defaultdict(int)

        # Build adjacency list and track in/out degrees
        for u, v in pairs:
            adj[u].append(v)
            outdegree[u] += 1
            indegree[v] += 1

        # Find the starting node
        startnode = pairs[0][0]
        for node in adj:
            if outdegree[node] - indegree[node] == 1:
                startnode = node
                break

        # Hierholzer's Algorithm to find Eulerian path
        EulerPath = []
        stack = [startnode]

        while stack:
            curr = stack[-1]
            if adj[curr]:
                ngbr = adj[curr].pop()
                stack.append(ngbr)
            else:
                EulerPath.append(stack.pop())

        # Reverse the path
        EulerPath.reverse()

        # Build result from Eulerian path
        result = []
        for i in range(len(EulerPath) - 1):
            result.append([EulerPath[i], EulerPath[i + 1]])

        return result
