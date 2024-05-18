class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def give_coins(self, root, ans):
        if root is None:
            return 0
        left = self.give_coins(root.left, ans)
        right = self.give_coins(root.right, ans)
        ans[0] += abs(left) + abs(right)
        return root.val + right + left - 1

    def distributeCoins(self, root: TreeNode) -> int:
        ans = [0]
        self.give_coins(root, ans)
        return ans[0]

