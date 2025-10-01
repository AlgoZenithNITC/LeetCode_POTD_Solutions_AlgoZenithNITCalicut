class Solution:
    def numWaterBottles(self, n: int, x: int) -> int:
        total = 0
        empty_bottles = 0
        while n > 0:
            total += n
            empty_bottles += n
            n = empty_bottles // x
            empty_bottles = empty_bottles % x
        return total