class Solution(object):

    def dfs(self, graph, parent, curr, res, visited):
        visited[curr] = True
        for dest in graph[curr]:
            if not visited[dest]:
                res[dest].append(parent)
                self.dfs(graph, parent, dest, res, visited)

    def getAncestors(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[List[int]]
        """

        res = [[] for _ in range(n)]
        graph = [[] for _ in range(n)]

        for edge in edges:
            graph[edge[0]].append(edge[1])
        
        for i in range(n):
            self.dfs(graph, i, i, res, [False]*n)
        
        return res
