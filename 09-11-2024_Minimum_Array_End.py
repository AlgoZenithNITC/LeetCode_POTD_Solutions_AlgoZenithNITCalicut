class Solution:
    def minEnd(self, n: int, x: int) -> int:
        final_value = x
        remaining = n - 1
        bit_pos = 1

        while remaining:
            if not (x & bit_pos):
                final_value |= (remaining & 1) * bit_pos
                remaining >>= 1
            bit_pos <<= 1

        return final_value
