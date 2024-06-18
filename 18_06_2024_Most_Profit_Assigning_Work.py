class Solution(object):
    def maxProfitAssignment(self, difficulty, profit, worker):
        ans = 0
        jobs = sorted(zip(difficulty, profit))
        worker.sort()
        j, maxProfit = 0, 0
        
        for i in range(len(worker)):
            while j < len(jobs) and jobs[j][0] <= worker[i]:
                maxProfit = max(maxProfit, jobs[j][1])
                j += 1
            ans += maxProfit
        
        return ans
