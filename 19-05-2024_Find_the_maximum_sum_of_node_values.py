class Solution(object):
    def maximumValueSum(self, nums, k, edges):
    
        sum = 0
        cnt = 0
        temp = float('inf')

        for it in nums:
            a = it ^ k
            b = a - it
            if a > it:
                sum += a
                temp = min(temp, b)
                cnt += 1
            else:
                sum += it
                temp = min(temp, -b)

        if cnt % 2 == 0:
            return sum

        return sum - temp
