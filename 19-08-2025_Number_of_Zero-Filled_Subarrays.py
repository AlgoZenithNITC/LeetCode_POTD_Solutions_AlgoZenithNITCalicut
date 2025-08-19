class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        count = 0
        zero_length = 0
    
        for num in nums:
            if num == 0:
                zero_length += 1
                count += zero_length
            else:
                zero_length = 0
    
        return count
    
