class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        left = 0
        max_len = 0
        increase = deque()
        decrease = deque()
        for right in range(len(nums)):
            while increase and nums[right] < increase[-1]:
                increase.pop()
            increase.append(nums[right])

            while decrease and nums[right] > decrease[-1]:
                decrease.pop()
            decrease.append(nums[right])

            while decrease[0] - increase[0] > limit:
                if nums[left]  == increase[0]:
                    increase.popleft()
                if nums[left] == decrease[0]:
                    decrease.popleft()

                left += 1
            max_len = max(max_len, right - left + 1)
        
        return max_len
