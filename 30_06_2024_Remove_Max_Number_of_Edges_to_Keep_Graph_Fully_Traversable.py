from typing import List

class UnionFind:
    def __init__(self, n: int):
        self.components = n
        self.parent = list(range(n + 1))
        self.size = [1] * (n + 1)

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def unite(self, x: int, y: int) -> bool:
        root_x, root_y = self.find(x), self.find(y)
        if root_x == root_y:
            return False
        if self.size[root_x] < self.size[root_y]:
            root_x, root_y = root_y, root_x
        self.parent[root_y] = root_x
        self.size[root_x] += self.size[root_y]
        self.components -= 1
        return True

    def is_connected(self) -> bool:
        return self.components == 1

class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: List[List[int]]) -> int:
        alice, bob = UnionFind(n), UnionFind(n)
        edges_required = 0

        # Process type 3 edges first
        for edge in edges:
            if edge[0] == 3:
                if alice.unite(edge[1], edge[2]) or bob.unite(edge[1], edge[2]):
                    edges_required += 1

        # Process type 1 and type 2 edges
        for edge in edges:
            if edge[0] == 1:
                if alice.unite(edge[1], edge[2]):
                    edges_required += 1
            elif edge[0] == 2:
                if bob.unite(edge[1], edge[2]):
                    edges_required += 1

        # Check if both are fully connected
        if alice.is_connected() and bob.is_connected():
            return len(edges) - edges_required
        return -1

