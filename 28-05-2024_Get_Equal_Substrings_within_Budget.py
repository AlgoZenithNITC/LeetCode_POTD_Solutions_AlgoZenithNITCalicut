class Solution(object):
    def equalSubstring(self, s, t, maxCost):
        
        n = len(s)
        temp = [0] * n

        for i in range(n):
            temp[i] = abs(ord(s[i]) - ord(t[i]))

        l = 0
        j = 0
        l_cost = 0
        ans = 0

        for i in range(n):
            l += 1
            l_cost += temp[i]

            if l_cost > maxCost:
                ans = max(ans, l - 1)
                while l_cost > maxCost and j <= i:
                    l -= 1
                    l_cost -= temp[j]
                    j += 1

        ans = max(ans, l)

        return ans
