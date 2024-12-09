from typing import List, Tuple
from collections import defaultdict

class VectorHash:
    def __call__(self, v: List[int]) -> int:
        hash_value = 0
        for i in v:
            hash_value ^= hash(i) + 0x9e3779b9 + (hash_value << 6) + (hash_value >> 2)
        return hash_value

class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        n = len(nums)
        check = []
        for i in range(1, n):
            if nums[i - 1] % 2 == nums[i] % 2:
                check.append((i - 1, i))
            if i + 1 != n and nums[i + 1] % 2 == nums[i] % 2:
                check.append((i, i + 1))
        
        mpp = {}
        c = sorted(queries)
        m = len(check)
        k = len(queries)
        ans = [False] * k
        
        j = 0
        for i in range(k):
            while j < m and check[j][0] < c[i][0]:
                j += 1
            if j < m and check[j][0] >= c[i][0] and check[j][1] <= c[i][1]:
                mpp[tuple(c[i])] = False
            else:
                mpp[tuple(c[i])] = True
        
        for i in range(k):
            ans[i] = mpp[tuple(queries[i])]
        
        return ans

