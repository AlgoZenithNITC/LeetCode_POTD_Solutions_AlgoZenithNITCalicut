class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dist_x = Math.abs(fx - sx), dist_y = Math.abs(fy - sy);
        int minimum_dist = Math.min(dist_x, dist_y);
        int rem_x = dist_x - minimum_dist, rem_y = dist_y - minimum_dist;
        if(Math.max(rem_x, rem_y) + minimum_dist == 0){
            if(t != 1){
                return true;
            }else{
                return false;
            }
        }
        return Math.max(rem_x, rem_y) + minimum_dist <= t;
    }
}
