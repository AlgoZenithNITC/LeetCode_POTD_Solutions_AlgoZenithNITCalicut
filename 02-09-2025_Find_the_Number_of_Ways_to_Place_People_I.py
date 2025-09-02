class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        points.sort(key= lambda x: (x[0],-x[1]))
        count=0
        for i in range(0,len(points)):
            t=points[i][1]
            b=-1
            for j in range(i+1,len(points)):
                if (b<points[j][1] and points[j][1]<=t):
                    count+=1
                    b=points[j][1]
                    if t==b:
                        break
        return count
