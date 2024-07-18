# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    ans = 0
    def dfs(self, root, d):
        if not root:
            return []

        if not root.left and not root.right:
            return [1]

        left = self.dfs(root.left, d)
        right = self.dfs(root.right, d)

        for a in left:
            for b in right:
                if a + b <= d:
                    self.ans += 1

        v = []
        for lv in left:
            if lv + 1 <= d:
                v.append(lv + 1)
        for rv in right:
            if rv + 1 <= d:
                v.append(rv + 1)

        return v

    def countPairs(self, root, distance):
        self.dfs(root, distance)
        return self.ans
