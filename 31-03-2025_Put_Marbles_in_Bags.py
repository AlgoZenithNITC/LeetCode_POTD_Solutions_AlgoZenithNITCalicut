class Solution(object):
    def putMarbles(self, weights, k):
        if k == 1:
            return 0  
        n = len(weights)
    
    # Create pairwise adjacent sums
        adjacent_sums = [weights[i] + weights[i + 1] for i in range(n - 1)]
    
    # Sort the adjacent sums
        adjacent_sums.sort()
    
    # Calculate min and max scores
        min_score = sum(adjacent_sums[:k-1])
        max_score = sum(adjacent_sums[-(k-1):])
    
        return max_score - min_score
