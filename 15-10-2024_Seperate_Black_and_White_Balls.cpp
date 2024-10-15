class Solution {
public:
    long long minimumSteps(string s) {
        ios_base::sync_with_stdio(0);
        cin.tie(0); cout.tie(0);
        
        int n = s.length();
        long long bbc = 0, ans = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == '0'){
                ans += bbc;
            }
            else{
                bbc++;
            }
        }
        return ans;
    }
};
