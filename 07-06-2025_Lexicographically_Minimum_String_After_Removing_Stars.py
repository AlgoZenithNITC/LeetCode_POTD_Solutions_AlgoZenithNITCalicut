import heapq
from collections import defaultdict

class Solution:
    def clearStars(self, s: str) -> str:
        n = len(s)
        min_heap = []
        index_map = defaultdict(list)
        keep = [True] * n

        for i in range(n):
            if s[i] != '*':
                heapq.heappush(min_heap, s[i])
                index_map[s[i]].append(i)
            else:
                smallest = heapq.heappop(min_heap)
                last_pos = index_map[smallest].pop()
                keep[i] = False        
                keep[last_pos] = False  
        result = []
        for i in range(n):
            if keep[i]:
                result.append(s[i])
        return ''.join(result)
