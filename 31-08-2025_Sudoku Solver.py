class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # 9x9 arrays to track digits usage
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]
        empty = []

        # initialize tracking structures
        for r in range(9):
            for c in range(9):
                if board[r][c] == ".":
                    empty.append((r, c))
                else:
                    d = board[r][c]
                    rows[r].add(d)
                    cols[c].add(d)
                    boxes[(r // 3) * 3 + (c // 3)].add(d)

        def backtrack(idx=0):
            if idx == len(empty):
                return True  # all filled

            r, c = empty[idx]
            b = (r // 3) * 3 + (c // 3)

            for d in "123456789":
                if d not in rows[r] and d not in cols[c] and d not in boxes[b]:
                    # place number
                    board[r][c] = d
                    rows[r].add(d)
                    cols[c].add(d)
                    boxes[b].add(d)

                    if backtrack(idx + 1):
                        return True

                    # undo placement
                    board[r][c] = "."
                    rows[r].remove(d)
                    cols[c].remove(d)
                    boxes[b].remove(d)

            return False

        backtrack()
