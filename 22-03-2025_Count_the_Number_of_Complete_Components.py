class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        adjList = [[] for _ in range(n)]

        for v1, v2 in edges:
            adjList[v1].append(v2)
            adjList[v2].append(v1)

        visited = [False] * n

        def dfs(node: int, component: Set[int]):
            if not visited[node]:
                visited[node] = True
                component.add(node)
                for neighbor in adjList[node]:
                    if not visited[neighbor]:
                        dfs(neighbor, component)

        ans = 0

        for i in range(n):
            if not visited[i]:
                component = set()
                dfs(i, component)

                node_count = len(component)
                complete = all(len(adjList[v]) == node_count - 1 for v in component)

                if complete:
                    ans += 1

        return ans
