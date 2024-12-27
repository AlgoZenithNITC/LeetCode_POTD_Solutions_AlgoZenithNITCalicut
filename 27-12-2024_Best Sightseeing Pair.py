def maxScoreSightseeingPair(arr):
    max_score = 0
    max_i = arr[0]
    
    for j in range(1, len(arr)):
        max_score = max(max_score, max_i + arr[j] - j)
        max_i = max(max_i, arr[j] + j)
    
    return max_score
