class Solution:
    def maximumLength(self, s: str) -> int:
        freq_map = {}
        n = len(s)

        # Generate all special substrings and count their frequencies
        for i in range(n):
            cur_string = ""
            for j in range(i, n):
                # Check if the substring can continue to be "special"
                if not cur_string or s[j] == cur_string[-1]:
                    cur_string += s[j]
                    freq_map[cur_string] = freq_map.get(cur_string, 0) + 1
                else:
                    break

        # Find the maximum length of a substring occurring at least 3 times
        max_len = -1
        for substring, freq in freq_map.items():
            if freq > 2:
                max_len = max(max_len, len(substring))

        return max_len
