class Solution:
    def buildMatrix(self, k: int, rowConditions: list[list[int]], colConditions: list[list[int]]) -> list[list[int]]:
        graph = defaultdict(list)
        for edge in rowConditions:
            graph[edge[0]].append(edge[1])

        row_sorting = self.topo_sort(graph, k)
        graph.clear()
        for edge in colConditions:
            graph[edge[0]].append(edge[1])
        col_sorting = self.topo_sort(graph, k)

        if not row_sorting or not col_sorting:
            return []

        value_position = {}
        for i in range(k):
            value_position[row_sorting[i]] = [i, 0]
            value_position[col_sorting[i]][1] = i

        res = [[0] * k for _ in range(k)]
        for value in range(1, k + 1):
            row = value_position[value][0]
            column = value_position[value][1]
            res[row][column] = value

        return res

    def dfs(self, src: int, graph: defaultdict(list), visited: set, cur_path: set, res: list) -> bool:
        if src in cur_path:
            return False  
        if src in visited:
            return True  

        visited.add(src)
        cur_path.add(src)

        for neighbor in graph[src]:
            if not self.dfs(neighbor, graph, visited, cur_path, res):
                return False

        cur_path.remove(src)
        res.append(src)
        return True

    def topo_sort(self, graph: defaultdict(list), k: int) -> list[int]:
        visited = set()
        cur_path = set()
        res = []

        for src in range(1, k + 1):
            if not self.dfs(src, graph, visited, cur_path, res):
                return []

        res.reverse()
        return res

