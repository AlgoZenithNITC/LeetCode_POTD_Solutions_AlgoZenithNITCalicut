vector<int> getFinalState(vector<int>& nums, int k, int multiplier) {
    if(multiplier == 1)
        return nums;

    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    int n = nums.size();

    for(int i = 0; i < n; i++)
        pq.push({nums[i], i});

    while(k--){
        pair<int, int> t = pq.top();
        pq.pop();
        t.first *= multiplier;
        pq.push(t);
    }

    vector<int> ans(n);

    while(!pq.empty()){
        pair<int, int> t = pq.top();
        pq.pop();
        ans[t.second] = t.first;
    }

    return ans;
}
