class Solution(object):
    def isReachableAtTime(self, sx, sy, fx, fy, t):
        dist_x = abs(fx - sx)
        dist_y = abs(fy - sy)
        minimum_dist = min(dist_x, dist_y)
        rem_x = dist_x - minimum_dist
        rem_y = dist_y - minimum_dist
        if max(rem_x, rem_y) + minimum_dist == 0:
            if t != 1:
                return True
            else:
                return False
        return max(rem_x, rem_y) + minimum_dist <= t
