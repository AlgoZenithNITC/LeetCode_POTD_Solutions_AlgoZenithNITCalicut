class Solution {
public:
    int countHomogenous(string s){
        int mod = 1e9 + 7;
        int prev = 1;
        long long ans = prev;
        for(int i = 1; i < s.length(); i++){
            int curr = 1;
            if(s[i] == s[i - 1]){
                curr += prev;
            }
            prev = curr;
            ans += curr;
        }
        return ans%mod;
    }
};
