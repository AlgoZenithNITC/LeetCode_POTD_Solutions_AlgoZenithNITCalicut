class Solution:
    def leastInterval(self, tasks, n):
        size = len(tasks)
        mp = {}
        for it in tasks:
            if it in mp:
                mp[it] += 1
            else:
                mp[it] = 1
        maxHeap = []
        for it in mp:
            maxHeap.append(mp[it])
        maxHeap.sort(reverse=True)
        
        q = []
        time = 0
        while len(maxHeap) > 0 or len(q) > 0:
            time += 1
            if len(maxHeap) > 0:
                curr = maxHeap[0]
                maxHeap.pop(0)
                count = curr - 1
                if count > 0:
                    q.append((count, time + n))
            if len(q) > 0 and q[0][1] == time:
                maxHeap.append(q[0][0])
                q.pop(0)
        return time

