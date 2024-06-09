class Solution(object):
    def subarraysDivByK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        prefixMod, result = 0, 0

        modGroups = [0] * k
        modGroups[0] = 1

        for num in nums:
            prefixMod = (prefixMod + num) % k
            result += modGroups[prefixMod]
            modGroups[prefixMod] += 1

        return result
