class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        size = n * n + 1
        count = [0] * size

      
        for row in grid:
            for value in row:
                count[value] += 1

        num1, num2 = -1, -1

        for i in range(1, size):
            if count[i] == 2:
                num1 = i
            elif count[i] == 0:
                num2 = i

        return [num1, num2]
        
