class Solution:
    def pivotInteger(self, n):
        leftBound = 1
        rightBound = n
        fullSum = (n * (n + 1)) // 2
        while leftBound <= rightBound:
            midNum = leftBound + (rightBound - leftBound) // 2
            firstHlfSum = (midNum * (midNum + 1)) // 2
            secondHlfSum = fullSum - firstHlfSum + midNum
            if firstHlfSum == secondHlfSum:
                return midNum
            elif firstHlfSum < secondHlfSum:
                leftBound = midNum + 1
            else:
                rightBound = midNum - 1
        return -1

