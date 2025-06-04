class Solution {
public:
    string answerString(string word, int k) {
        int n = word.size();
        int maxLen = n-k+1;

        if(k == 1) return word;

        char maxi = 'a';
        for(int i=0; i<n; i++){
            if(word[i]>maxi){
                maxi = word[i];
            }
        }
        vector<int> ind;
        for(int i=0; i<n; i++){
            if(maxi == word[i]){
                ind.push_back(i);
            }
        }
        string ans = "";
        ans+=maxi;
        for(int i=0; i<ind.size(); i++){
            string s = word.substr(ind[i], maxLen);
            if(ans < s) ans = s;
        }
        return ans;
    }
};