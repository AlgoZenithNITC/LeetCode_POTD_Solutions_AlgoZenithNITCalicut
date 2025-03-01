class Solution(object):
    def applyOperations(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        count = 0
        for i in range(len(nums) - 1):
            if nums[i] == nums[i + 1]:
                nums[i] *= 2
                nums[i + 1] = 0
            if nums[i] == 0:
                count += 1
        
        if nums[-1] == 0:
            count += 1

        ans = [num for num in nums if num != 0]
        ans.extend([0] * count)  # Append zeros at the end
        
        return ans