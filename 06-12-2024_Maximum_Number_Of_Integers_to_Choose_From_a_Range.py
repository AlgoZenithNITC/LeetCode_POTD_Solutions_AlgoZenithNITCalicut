class Solution:
    def maxCount(self, banned: list[int], n: int, maxSum: int) -> int:
        myNums = [1] * n  # Initialize myNums array with 1s

        for num in banned:
            if num > n:
                continue
            myNums[num - 1] = 0  # Mark banned numbers

        sum_ = 0
        t = 0

        for i in range(n):
            if sum_ + (i + 1) > maxSum:  # Adjust for 1-based indexing
                break
            if myNums[i] == 0:
                continue
            sum_ += (i + 1)  # Add 1-based index to sum
            t += 1

        return t
