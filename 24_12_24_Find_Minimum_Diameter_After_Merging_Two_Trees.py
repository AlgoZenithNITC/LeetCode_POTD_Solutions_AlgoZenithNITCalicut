class Solution:
    def dfs(self, adj, node, parent, diameter):
        maxD1 = 0
        maxD2 = 0

        for nei in adj[node]:
            if nei != parent:
                depth = self.dfs(adj, nei, node, diameter)
                if depth > maxD1:
                    maxD2 = maxD1
                    maxD1 = depth
                elif depth > maxD2:
                    maxD2 = depth

        diameter[0] = max(diameter[0], maxD1 + maxD2)
        return maxD1 + 1

    def treeDiameter(self, edges):
        if not edges:
            return 0
        n = len(edges) + 1
        adj = [[] for _ in range(n)]
        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
        dia = [0]
        self.dfs(adj, 0, -1, dia)
        return dia[0]

    def minimumDiameterAfterMerge(self, edges1, edges2):
        dia1 = self.treeDiameter(edges1)
        dia2 = self.treeDiameter(edges2)

        half1 = (dia1 + 1) // 2
        half2 = (dia2 + 1) // 2

        return max(dia1, dia2, half1 + half2 + 1)

