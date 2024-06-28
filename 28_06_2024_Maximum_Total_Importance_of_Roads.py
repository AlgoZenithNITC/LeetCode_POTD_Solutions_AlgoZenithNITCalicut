class Solution:
    def maximumImportance(self, n: int, roads: List[List[int]]) -> int:
        degree = [0] * n
        for u, v in roads:
            degree[u] += 1
            degree[v] += 1
        
        cities = list(range(n))
        cities.sort(key=lambda x: -degree[x])
        
        total_importance = 0
        for i, city in enumerate(cities):
            total_importance += (n - i) * degree[city]
        
        return total_importance

