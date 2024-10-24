# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def flipEquiv(self, root1, root2):
        if root1 is None and root2 is None:
            return True  # both roots are empty
        if root1 is None or root2 is None:
            return False  # either one of them is empty
        if root1.val != root2.val:
            return False  # nodes are not equal
        
        flip = self.flipEquiv(root1.left, root2.right) and self.flipEquiv(root1.right, root2.left)  # flip is happening
        no_flip = self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right)  # flip is not happening
        return flip or no_flip
