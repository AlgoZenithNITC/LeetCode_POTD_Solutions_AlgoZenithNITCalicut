class Solution {
public:
    int getLucky(string s, int k) {
        if(s=="")
        return 0;

        string num = "";
        for(char c : s)
        {
            int n = c-'a'+1;
            num += to_string(n);
        }
        int ans = 0;
        while(k>0)
        {
            ans = 0;
            for (char digit : num) {
                ans += digit - '0';
            }
            num = to_string(ans);
            k--;
        }
        return ans;
    }
};
