class Solution:
    def candy(self, ratings):
        n = len(ratings)
        if n == 1:
            return 1

        candy = n
        i = 1

        while i < n:
            while i < n and ratings[i] == ratings[i - 1]:
                i += 1
                continue

            peak = 0
            while i < n and ratings[i - 1] < ratings[i]:
                peak += 1
                candy += peak
                i += 1

            depth = 0
            while i < n and ratings[i - 1] > ratings[i]:
                depth += 1
                candy += depth
                i += 1

            candy -= min(peak, depth)

        return candy
