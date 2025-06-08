void solve(vector<int> &ans, int n, int num){
    if(num > n)
        return;
    
    for(int i = 0; i < 10; i++){
        if(num + i > n)
            break;
        if(num == 1 && i == 9)
            break;
        ans.emplace_back(num + i);
        solve(ans, n, (num+i)*10);
    }
}

vector<int> lexicalOrder(int n) {
    vector<int> ans;
    solve(ans, n, 1);
    return ans;
}
