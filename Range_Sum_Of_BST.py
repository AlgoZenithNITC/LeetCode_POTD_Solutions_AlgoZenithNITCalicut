class Solution(object):
    def rangeSumBST(self, root, low, high):
        if not root:
            return 0
        if root.val >= low and root.val <= high:
            return root.val + self.rangeSumBST(root.left, low, high) + self.rangeSumBST(root.right, low, high)
        if root.val < low:
            return self.rangeSumBST(root.right, low, high)
        return self.rangeSumBST(root.left, low, high)
        
