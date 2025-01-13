class Solution:
    def minimumLength(self, s: str) -> int:
        freq_map = Counter(s)
        min_len = 0
        for count in freq_map.values():
            min_len += 2 if count % 2 == 0 else 1
        
        return min_len
