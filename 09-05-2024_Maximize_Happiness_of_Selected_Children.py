class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        max_sum = 0
        for i in range(k):
            happiness[i] -= i
            if happiness[i] > 0:
                max_sum += happiness[i]
            else:
                break
        return max_sum
