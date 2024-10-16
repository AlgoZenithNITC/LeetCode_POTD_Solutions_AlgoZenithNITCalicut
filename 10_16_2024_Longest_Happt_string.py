class Solution:
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        pq = []
        if a > 0:
            heapq.heappush(pq, (-a, "a"))
        if b > 0:
            heapq.heappush(pq, (-b, "b"))
        if c > 0:
            heapq.heappush(pq, (-c, "c"))

        s = []

        while pq:
            cnt, node = heapq.heappop(pq)
            cnt = -cnt
            n = len(s)
            if n >= 2 and s[-1] == node and s[-2] == node:
                if not pq:
                    break
                cnt1, node1 = heapq.heappop(pq)
                cnt1 = -cnt1
                s.append(node1)
                if cnt1 - 1 > 0:
                    heapq.heappush(pq, (-(cnt1 - 1), node1))
                heapq.heappush(pq, (-cnt, node))
            else:
                s.append(node)
                cnt -= 1
                if cnt > 0:
                    heapq.heappush(pq, (-cnt, node))

        return ''.join(s)
       
