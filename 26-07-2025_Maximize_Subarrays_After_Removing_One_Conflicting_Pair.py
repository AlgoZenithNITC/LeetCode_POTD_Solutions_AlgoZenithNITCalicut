class Solution:
    def maxSubarrays(self, n: int, conflictingPairs: list[list[int]]) -> int:
        for pair in conflictingPairs:
            if pair[1] < pair[0]:
                pair[0], pair[1] = pair[1], pair[0]

        conflictingPairs.sort(key=lambda x: x[1])

        m = len(conflictingPairs)
        max1 = 0
        max2 = 0
        gain = 0
        maxGain = 0
        totalOccupied = 0

        for i in range(m):
            start = conflictingPairs[i][0]
            base = n + 1 - conflictingPairs[i][1]
            if i < m - 1:
                base = conflictingPairs[i + 1][1] - conflictingPairs[i][1]

            if start > max1:
                max2 = max1
                max1 = start
                gain = 0
            elif start > max2:
                max2 = start

            gain += (max1 - max2) * base
            totalOccupied += max1 * base
            maxGain = max(maxGain, gain)

        total = n * (n + 1) // 2
        return total - totalOccupied + maxGain
