class Solution(object):
    def numOfSubarrays(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        oddcount = 0
        prefixsum = 0
        arrSize = len(arr)
        
        for num in arr:
            prefixsum += num
            oddcount += prefixsum % 2
        
        oddcount = oddcount + (arrSize - oddcount) * oddcount
        return oddcount % 1000000007
