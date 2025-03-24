int countDays(int days, vector<vector<int>>& meetings) {
    sort(meetings.begin(), meetings.end());
    int r = 0;
    
    int ans = days;
    
    for(vector <int>pair: meetings){
        if(pair[1] <= r)
            continue;
        else{
            ans -= (pair[1] - max(pair[0], r));
            if(r < pair[0])
                ans--;
            r = pair[1];
        }
    }
    
    return ans;
}
