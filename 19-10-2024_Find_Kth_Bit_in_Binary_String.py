class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        invert_count = 0
        len = (1 << n) - 1  

        while k > 1:
            if k == len // 2 + 1:
                return "1" if invert_count % 2 == 0 else "0"

            if k > len // 2:
                k = len + 1 - k  
                invert_count += 1  

            len //= 2  

        return "0" if invert_count % 2 == 0 else "1"
