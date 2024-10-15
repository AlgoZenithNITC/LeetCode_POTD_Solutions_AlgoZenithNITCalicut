class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        long bbc = 0, ans = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '0'){
                ans += bbc;
            }
            else{
                bbc++;
            }
        }
        return ans;
    }
}
