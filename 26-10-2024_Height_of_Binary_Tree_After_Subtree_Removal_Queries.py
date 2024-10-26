# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional

class Solution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        out = []
        a = [0] * 100005
        ans = [0] * 100005
        self.height(root, a)
        
        t, h, depth = 1, 0, 0
        nmax, nsmax, cmax, csmax, l, j = 0, 0, 0, 0, 0, 0
        q = [None] * 50000
        q[0] = root
        
        while h != t:
            l = t - h if t > h else 50000 - h + t
            j = l
            
            while l > 0:
                ht = q[h]
                h = 0 if h + 1 == 50000 else h + 1
                if a[ht.val] == cmax:
                    ans[ht.val] = depth + csmax if j > 1 else depth - 1
                else:
                    ans[ht.val] = depth + cmax
                
                if ht.left:
                    q[t] = ht.left
                    if a[ht.left.val] > nmax:
                        nsmax, nmax = nmax, a[ht.left.val]
                    elif a[ht.left.val] > nsmax:
                        nsmax = a[ht.left.val]
                    t = 0 if t + 1 == 50000 else t + 1
                
                if ht.right:
                    q[t] = ht.right
                    if a[ht.right.val] > nmax:
                        nsmax, nmax = nmax, a[ht.right.val]
                    elif a[ht.right.val] > nsmax:
                        nsmax = a[ht.right.val]
                    t = 0 if t + 1 == 50000 else t + 1
                
                l -= 1
            
            cmax, csmax = nmax, nsmax
            nmax = nsmax = 0
            depth += 1
        
        for i in queries:
            out.append(ans[i])
        
        return out

    def height(self, root: Optional[TreeNode], a: List[int]) -> int:
        if root is not None:
            h = 1
            if root.right or root.left:
                h += max(self.height(root.left, a), self.height(root.right, a))
            a[root.val] = h - 1
            return h
        return 0
