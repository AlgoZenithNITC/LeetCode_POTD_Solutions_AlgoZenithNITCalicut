class Solution {
public:
    int maxDifference(string s) {
        unordered_map<char, int> m;
        for(int i=0; i<s.length(); i++){
            m[s[i]]++;
        }
        int maxf=0;
        int minf=s.length();
        for(auto &d:m){
            if((d.second & 1) ==1) maxf=max(maxf, d.second);
            else{
                minf= min(minf, d.second);
            }
        }
        if(minf==s.length()) return maxf;
        return maxf-minf;
        
    }
};
