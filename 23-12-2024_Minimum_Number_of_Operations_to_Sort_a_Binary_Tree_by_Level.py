from collections import deque

class Solution:

    # Helper function to calculate the minimum number of swaps to sort the array
    def minSwaps(self, arr):
        n = len(arr)
        
        # Create a list of pairs where each pair is (value, original index)
        v = [(val, idx) for idx, val in enumerate(arr)]
        
        # Sort the list based on values
        v.sort(key=lambda x: x[0])
        
        visited = [False] * n
        swaps = 0
        
        # Iterate over the sorted list to calculate minimum swaps
        for i in range(n):
            # If already visited or already in the correct place, continue
            if visited[i] or v[i][1] == i:
                continue
            
            # Start the cycle of swapping elements
            cycle_size = 0
            j = i
            while not visited[j]:
                visited[j] = True
                j = v[j][1]  # Move to the next element in the cycle
                cycle_size += 1
            
            # If there is a cycle of size n, we need (n-1) swaps to sort it
            if cycle_size > 1:
                swaps += (cycle_size - 1)
        
        return swaps

    # Function to compute the minimum operations on the binary tree
    def minimumOperations(self, root):
        if not root:
            return 0
        
        # Queue for level-order traversal
        q = deque([root])
        ans = 0
        
        # Perform level-order traversal
        while q:
            sz = len(q)
            temp = []
            
            # Process each level
            for _ in range(sz):
                curr_node = q.popleft()
                temp.append(curr_node.val)
                
                # Add child nodes to the queue
                if curr_node.left:
                    q.append(curr_node.left)
                if curr_node.right:
                    q.append(curr_node.right)
            
            # For this level, calculate the minimum swaps required
            ans += self.minSwaps(temp)
        
        return ans


# Definition for a binary tree node
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
