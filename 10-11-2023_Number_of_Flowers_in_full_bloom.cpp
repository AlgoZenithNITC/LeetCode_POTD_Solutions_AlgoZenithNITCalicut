class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people){
        vector<int> start_time, end_time;
        int n = people.size();
        for(int i = 0; i < flowers.size(); i++){
            start_time.push_back(flowers[i][0]);
            end_time.push_back(flowers[i][1]);
        }
        sort(start_time.begin(), start_time.end());
        sort(end_time.begin(), end_time.end());
        vector<int> ans(n);
        for(int i = 0; i < n; i++){
            int started_blooming = upper_bound(start_time.begin(), start_time.end(), people[i]) - start_time.begin();
            int stopped_blooming = lower_bound(end_time.begin(), end_time.end(), people[i]) - end_time.begin();
            ans[i] = started_blooming - stopped_blooming;
        }
        return ans;
    }
};
