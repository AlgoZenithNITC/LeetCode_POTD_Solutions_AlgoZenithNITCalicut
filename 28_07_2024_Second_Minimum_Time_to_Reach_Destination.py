from collections import defaultdict
import heapq

class Solution:
    def secondMinimum(self, n: int, edges: list[list[int]], time: int, change: int) -> int:
        g = defaultdict(list)
        for e in edges:
            u, v = e[0], e[1]
            g[u].append(v)
            g[v].append(u)

        q = []
        heapq.heappush(q, (0, 1))

        uniqueVisit = [0] * (n + 1)
        dis = [-1] * (n + 1)

        while q:
            t, node = heapq.heappop(q)

            if dis[node] == t or uniqueVisit[node] >= 2:
                continue

            uniqueVisit[node] += 1
            dis[node] = t

            if node == n and uniqueVisit[node] == 2:
                return dis[node]

            if (t // change) % 2 != 0:
                t = (t // change + 1) * change

            for nei in g[node]:
                heapq.heappush(q, (t + time, nei))

        return -1

