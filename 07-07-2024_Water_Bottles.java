class Solution {
    public int numWaterBottles(int numBottles, int exc) {
        int empty = numBottles, ans = numBottles;
        while(empty >= exc){
            int filled  = empty / exc;
            int rem = empty % exc;
            ans += filled;
            empty = filled + rem;
        }
        return ans;
    }
}
