class Solution {
public:
    vector<int> findArray(vector<int>& p){
        int n = p.size();
        vector<int> result(n);
        result[0] = p[0];
        for(int i = 1; i < n; i++){
            result[i] = p[i - 1]^p[i];
        }
        return result;
    }
};
