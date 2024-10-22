class Solution(object):
    def kthLargestLevelSum(self, root, k):
        if not root:
            return 0  # Handle empty tree case

        level_sums = []
        queue = deque([root])

        while queue:
            level_sum = 0
            level_size = len(queue)

            for _ in range(level_size):
                node = queue.popleft()
                level_sum += node.val
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            level_sums.append(level_sum)

        level_sums.sort(reverse=True)

        return level_sums[k - 1] if k <= len(level_sums) else -1
