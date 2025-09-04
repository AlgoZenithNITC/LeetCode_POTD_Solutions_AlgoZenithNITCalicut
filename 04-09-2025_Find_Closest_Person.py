class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        d1 = abs(x - z)  # Distance from Person 1 to Person 3
        d2 = abs(y - z)  # Distance from Person 2 to Person 3

        if d1 < d2:
            return 1
        elif d2 < d1:
            return 2
        else:
            return 0    
