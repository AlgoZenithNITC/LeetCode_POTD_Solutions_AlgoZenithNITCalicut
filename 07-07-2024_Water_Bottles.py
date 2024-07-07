class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        empty = numBottles
        ans = numBottles
        while empty >= numExchange:
            filled = empty // numExchange
            rem = empty % numExchange
            ans += filled
            empty = filled + rem
        
        return ans
