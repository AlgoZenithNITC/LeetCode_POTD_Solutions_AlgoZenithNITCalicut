class Solution {
public:
    bool isIsomorphic(string s, string t) {        
        vector<int>S(200, 0);
        vector<int>T(200, 0);

        int len = s.length();
        if(len != t.length()){
            return false;
        }
        for(int i = 0; i < len; i++){
            if(S[s[i]] != T[t[i]]){
                return false;
            }
            S[s[i]] = i + 1;
            T[t[i]] = i + 1;
        }
        return true;
    }
};
