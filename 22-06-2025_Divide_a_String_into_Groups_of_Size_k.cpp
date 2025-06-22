class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
       vector<string> result;
        int n = s.length();
        for(int i=0; i<n; i=i+k){
            string temp = s.substr(i, k);
            if(temp.length()<k){
                temp+=string(k-temp.length(), fill);
            }
            result.push_back(temp);
        }
        return result;
        
        
    }
};
