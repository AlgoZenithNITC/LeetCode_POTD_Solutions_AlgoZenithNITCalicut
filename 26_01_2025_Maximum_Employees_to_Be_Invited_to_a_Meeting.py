

class Solution:
    def maximumInvitations(self, favorite):
        n = len(favorite)
        in_degree = [0] * n
        longest_chain = [0] * n
        visited = [False] * n

        for f in favorite:
            in_degree[f] += 1

        queue = deque()
        for i in range(n):
            if in_degree[i] == 0:
                queue.append(i)

        while queue:
            front = queue.popleft()
            visited[front] = True
            nxt = favorite[front]
            longest_chain[nxt] = longest_chain[front] + 1

            in_degree[nxt] -= 1
            if in_degree[nxt] == 0:
                queue.append(nxt)

        max_cycle = 0
        total = 0

        for i in range(n):
            if not visited[i]:
                c = i
                length = 0
                while not visited[c]:
                    visited[c] = True
                    c = favorite[c]
                    length += 1

                if length == 2:
                    total += (2 + longest_chain[i] + longest_chain[favorite[i]])
                else:
                    max_cycle = max(max_cycle, length)

        return max(total, max_cycle)
