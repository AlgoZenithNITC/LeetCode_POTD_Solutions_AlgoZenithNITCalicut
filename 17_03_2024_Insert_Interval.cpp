class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>>ans;
        int x=newInterval[0];
        int y=newInterval[1];
        int i=0;
        int n=intervals.size();
        while(i<n)
        {
            if(intervals[i][1]<x)
            {
                ans.push_back(intervals[i]);
            }
            else if(intervals[i][0]>y)
            {
                break;
            }
            else
            {
                //merge section
                x=min(intervals[i][0],x);
                y=max(intervals[i][1],y);
            }
            i++;
        }
        ans.push_back({x,y});
        while(i<n)
        {
            ans.push_back(intervals[i]);
            i++;
        }
        return ans;
    }
};
