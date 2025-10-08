class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        n = len(spells)
        res = [0] * n

        for i in range(n):
            left, right = 0, len(potions) - 1
            ans = len(potions)  

            while left <= right:
                mid = left + (right - left) // 2
                product = spells[i] * potions[mid]

                if product >= success:
                    ans = mid
                    right = mid - 1
                else:
                    left = mid + 1

            res[i] = len(potions) - ans  

        return res

        
