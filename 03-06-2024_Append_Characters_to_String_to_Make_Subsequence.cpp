class Solution {
public:
    int appendCharacters(string s, string t) {
         int sLength = s.size();
        int tLength = t.size();
        int sIndex = 0, tIndex = 0;
        
        while(tIndex < tLength && sIndex < sLength){
            if(s[sIndex] == t[tIndex]){
                tIndex++;
            }
            sIndex++;
        }
        
        return tLength - tIndex;
    }
};
