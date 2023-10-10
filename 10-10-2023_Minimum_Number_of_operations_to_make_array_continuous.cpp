class Solution {
public:
    int minOperations(vector<int>& nums){
        int n = nums.size(), ans = n;
        set<int> s;
        for(int i : nums){
            s.insert(i);
        }
        vector<int> unique_elements(s.begin(), s.end());
        int size = unique_elements.size();
        for(int start = 0; start < size; start++){
            int end_index = upper_bound(unique_elements.begin() + start, unique_elements.end(), unique_elements[start] + n - 1) - unique_elements.begin();
            ans = min(ans, n - (end_index - start));
        }
        return ans;
    }
};
