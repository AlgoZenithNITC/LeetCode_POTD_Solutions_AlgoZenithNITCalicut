class Solution(object):
    def smallestSubarrays(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        last=[-1]*32
        ans=[]
        for i in range(len(nums)-1,-1,-1):
            for b in range(32):
                if (nums[i]&(1<<b)):
                    last[b]=i
            ans.append(max(1,max(last)-i+1))
        return ans[::-1]
