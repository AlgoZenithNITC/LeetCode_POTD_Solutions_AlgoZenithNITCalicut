if multiplier == 1:
    return nums

# Priority queue to store (value, index) with a min-heap
pq = [(nums[i], i) for i in range(len(nums))]
heapq.heapify(pq)

while k > 0:
    value, index = heapq.heappop(pq)
    value *= multiplier
    heapq.heappush(pq, (value, index))
    k -= 1

# Reconstruct the final state
ans = [0] * len(nums)
while pq:
    value, index = heapq.heappop(pq)
    ans[index] = value

return ans
