
class Solution:
    def xorQueries(self, arr, queries):
        temp = [0] * len(arr)
        temp[0] = arr[0]

        for i in range(1, len(arr)):
            temp[i] = temp[i - 1] ^ arr[i]

        ans = []
        for a, b in queries:
            if a > 0:
                ans.append(temp[b] ^ temp[a - 1])
            else:
                ans.append(temp[b])

        return ans
        
