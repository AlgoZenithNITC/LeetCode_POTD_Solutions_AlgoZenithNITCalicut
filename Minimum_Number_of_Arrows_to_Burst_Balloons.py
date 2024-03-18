class Solution:
    def findMinArrowShots(self, points):        
        
        points.sort(key=lambda x: x[1])
        
        arrows = 1
        prevEnd = points[0][1]
        
        for i in range(1, len(points)):
            if points[i][0] > prevEnd:
                arrows += 1
                prevEnd = points[i][1]
        
        return arrows
