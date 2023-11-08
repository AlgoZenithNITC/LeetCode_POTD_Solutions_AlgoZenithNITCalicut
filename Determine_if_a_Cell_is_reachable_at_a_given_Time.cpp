class Solution {
public:
    bool isReachableAtTime(int sx, int sy, int fx, int fy, int t){
        int dist_x = abs(fx - sx), dist_y = abs(fy - sy);
        int minimum_dist = min(dist_x, dist_y);
        int rem_x = dist_x - minimum_dist, rem_y = dist_y - minimum_dist;
        if(max(rem_x, rem_y) + minimum_dist == 0){
            if(t != 1){
                return true;
            }else{
                return false;
            }
        }
        return max(rem_x, rem_y) + minimum_dist <= t;
    }
};
