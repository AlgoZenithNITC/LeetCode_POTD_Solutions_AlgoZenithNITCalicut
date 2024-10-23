from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def replaceWithCousinsSum(root):
    if not root:
        return None

    q = deque([(root, None, 0)])  # (node, parent, level)

    while q:
        size = len(q)
        level_sum = 0

        # Calculate level sum
        for _ in range(size):
            node, parent, level = q.popleft()
            level_sum += node.data
            q.append((node, parent, level))

        # Update node values with sum of cousins
        for _ in range(size):
            node, parent, level = q.popleft()
            sum_of_cousins = level_sum

            if parent and parent.left == node and parent.right:
                sum_of_cousins -= parent.right.data
            if parent and parent.right == node and parent.left:
                sum_of_cousins -= parent.left.data

            sum_of_cousins -= node.data

            node.data = sum_of_cousins

            if node.left:
                q.append((node.left, node, level + 1))
            if node.right:
                q.append((node.right, node, level + 1))

    return root
