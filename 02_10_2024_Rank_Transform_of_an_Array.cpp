class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        vector<int> ans;
        map<int,int> mpp;
        for(int i:arr)
        {
            mpp[i]++;
        }
        int m = 1;
        for(auto it:mpp)
        {
            mpp[it.first] = m++;
        }
        for(int i :arr)
        {
            ans.push_back(mpp[i]);
        }
        return ans;
    }
};
