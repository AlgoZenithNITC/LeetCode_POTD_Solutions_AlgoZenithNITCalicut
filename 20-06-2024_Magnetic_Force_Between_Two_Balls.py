class Solution:
    def canPlaceBalls(self, position: List[int], m: int, force: int) -> bool:
        count = 1
        last_position = position[0]

        for i in range(1, len(position)):
            if position[i] - last_position >= force:
                count += 1
                last_position = position[i]
                if count == m:
                    return True
        return False

    def maxDistance(self, position: List[int], m: int) -> int:
        position.sort()
        left = 1
        right = position[-1] - position[0]
        result = 0

        while left <= right:
            mid = left + (right - left) // 2
            if self.canPlaceBalls(position, m, mid):
                result = mid
                left = mid + 1
            else:
                right = mid - 1

        return result
