int maximumUniqueSubarray(vector<int>& arr) {
    int n = arr.size();

    int l = 0, r = 0;
    int cum = 0, ans = 0;
    map<int,int> mp;

    while(r < n){
        mp[arr[r]]++;
        cum += arr[r];
        r++;

        while(mp.size() < r-l){
            mp[arr[l]]--;
            cum -= arr[l];
            if(mp[arr[l]] == 0) mp.erase(arr[l]);
            l++;
        }

        if(mp.size() == r-l)
            ans = max(ans, cum);
    }

    return ans;
}
