class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        left, now, nr = 0, 0, float('inf')
        
        for right in range(len(blocks)):
            if blocks[right] == 'W':
                now += 1
            if right - left + 1 == k:
                nr = min(nr, now)
                if blocks[left] == 'W':
                    now -= 1
                left += 1
        
        return nr
