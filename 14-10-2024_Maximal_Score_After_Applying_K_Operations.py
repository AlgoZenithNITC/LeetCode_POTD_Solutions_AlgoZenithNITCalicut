class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        # Convert nums to a max heap
        pq = [-num for num in nums]
        heapq.heapify(pq)

        score = 0

        for _ in range(k):
            ele = -heapq.heappop(pq)
            score += ele
            heapq.heappush(pq, -math.ceil(ele / 3))

        return score

