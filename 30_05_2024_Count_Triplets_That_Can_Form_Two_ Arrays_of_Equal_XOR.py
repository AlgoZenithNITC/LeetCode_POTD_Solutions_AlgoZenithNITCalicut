class Solution(object):
    def countTriplets(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        ans=0
        for i in range(len(arr)):
            xorA=0
            for j in range(i+1,len(arr)):
                xorA=xorA^arr[j-1]
                xorB=0
                for k in range(j,len(arr)):
                    xorB=xorB^arr[k]
                    if xorA==xorB:
                        ans+=1
        return ans
