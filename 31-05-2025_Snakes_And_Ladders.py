class Solution:
    def BoustrophedonPosition(self, k: int, n: int) -> Tuple[int, int]:
        row = n - 1 - (k - 1) // n
        col = (k - 1) % n
        if ((k - 1) // n) % 2 == 1:
            col = n - 1 - col
        return row, col

    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        visited = [False] * (n * n)
        dq = deque()
        dq.append((1, 0))
        visited[0] = True
        
        while dq:
            cur, rolls = dq.popleft()
            if cur == n * n:
                return rolls
                
            for i in range(6, 0, -1):
                next_square = cur + i
                if next_square > n * n:
                    continue
                    
                x, y = self.BoustrophedonPosition(next_square, n)
                if board[x][y] == -1:
                    if next_square == n * n:
                        return rolls + 1
                    if visited[next_square - 1]:
                        continue
                    visited[next_square - 1] = True
                    dq.append((next_square, rolls + 1))
                else:
                    dest = board[x][y]
                    if dest == n * n:
                        return rolls + 1
                    if visited[dest - 1]:
                        continue
                    visited[dest - 1] = True
                    dq.append((dest, rolls + 1))
                    
        return -1
