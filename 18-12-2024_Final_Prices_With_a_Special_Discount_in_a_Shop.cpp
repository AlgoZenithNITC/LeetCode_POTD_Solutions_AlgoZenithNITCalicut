class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
        int n = prices.size();
        vector<int> ans = prices;
        stack<int> stack;
        for(int i=0; i<n; i++){
            while(!stack.empty() && prices[stack.top()] >= prices[i]){
                ans[stack.top()] -= prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
};
