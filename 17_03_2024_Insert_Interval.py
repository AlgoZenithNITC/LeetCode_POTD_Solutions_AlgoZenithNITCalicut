class Solution:
    def insert(self, intervals, newInterval):
        ans = []
        x = newInterval[0]
        y = newInterval[1]
        i = 0
        n = len(intervals)
        while i < n:
            if intervals[i][1] < x:
                ans.append(intervals[i])
            elif intervals[i][0] > y:
                break
            else:
                x = min(intervals[i][0], x)
                y = max(intervals[i][1], y)
            i += 1
        ans.append([x, y])
        while i < n:
            ans.append(intervals[i])
            i += 1
        return ans

