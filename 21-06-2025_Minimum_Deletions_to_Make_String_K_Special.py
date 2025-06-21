class Solution(object):
    def minimumDeletions(self, word, k):
        freq_counter = Counter(word)
        freq_list = sorted(freq_counter.values())
        n = len(freq_list)
        prefix_sum = [0] * (n + 1)
        
        for i in range(n):
            prefix_sum[i + 1] = prefix_sum[i] + freq_list[i]
        
        min_deletions = float('inf')

        for i in range(n):
            min_freq = freq_list[i]
            max_freq_allowed = min_freq + k

            l, r = i, n
            while l < r:
                m = (l + r) // 2
                if freq_list[m] <= max_freq_allowed:
                    l = m + 1
                else:
                    r = m

            deletions_left = prefix_sum[i] 
            deletions_right = prefix_sum[n] - prefix_sum[r]  
            deletions_right -= (max_freq_allowed * (n - r))

            total_deletions = deletions_left + deletions_right
            min_deletions = min(min_deletions, total_deletions)

        return min_deletions
            
