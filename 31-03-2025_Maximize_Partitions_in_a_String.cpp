class Solution {
  public:
    int maxPartitions(string &s) {
        int n = s.size();
        vector<int> lastIndex(26,0);
        vector<int> ans;

        for(int i=0;i<n;++i){
            lastIndex[s[i] - 'a'] = i ;
        }

        int farthest = 0, left = 0;
        for(int i=0;i<n;++i){
            farthest = max(farthest, lastIndex[s[i] - 'a']);
            if(i == farthest){
                ans.push_back(farthest - left + 1);
                left = i + 1;
            }
        }
        return ans.size();
        
    }
};
