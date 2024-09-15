class Solution {
public:
    int findTheLongestSubstring(string s) {
        int prefixor = 0;
        int charmap[26] = {0};
        charmap['a'-'a'] = 1;
        charmap['e'-'a'] = 2;
        charmap['i'-'a'] = 4;
        charmap['o'-'a'] = 8;
        charmap['u'-'a'] = 16;

        vector<int>mp(32, -1);
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            prefixor ^= charmap[s[i]-'a'];
            if(mp[prefixor] == -1 and prefixor != 0){
                mp[prefixor] = i;
            }
            ans = max(ans, i-mp[prefixor]);
        }
        return ans;
    }
};
