class Solution(object):
    def minKBitFlips(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        flipped=[0]*len(nums)
        times=ans=0
        for i in range(len(nums)):
            if i>=k:
                times-=flipped[i-k]
            if ((nums[i]==1 and times%2==1) or (nums[i]==0 and times%2==0)):
                if i+k>len(nums):
                    return -1
                ans+=1
                times+=1
                flipped[i]=1
        return ans
