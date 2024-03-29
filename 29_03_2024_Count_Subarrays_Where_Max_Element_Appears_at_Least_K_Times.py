class Solution(object):
    def countSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        max_element=max(nums)
        ans=start=max_elememts_in_window=0
        for end in range(len(nums)):
            if nums[end]==max_element:
                max_elememts_in_window+=1
            while max_elememts_in_window==k:
                if nums[start]==max_element:
                    max_elememts_in_window-=1
                start+=1
            ans+=start
        return ans

