struct VectorHash {
    size_t operator()(const vector<int>& v) const {
        size_t hash = 0;
        hash<int> hasher;
        for (int i : v) {
            hash ^= hasher(i) + 0x9e3779b9 + (hash << 6) + (hash >> 2);
        }
        return hash;
    }
};

namespace std {
    template<>
    struct hash<vector<int>> {
        size_t operator()(const std::vector<int>& v) const {
            return VectorHash{}(v);
        }
    };
}



class Solution {
public:
    vector<bool> isArraySpecial(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        vector<pair<int,int>> check;
        for(int i =  1 ; i<n ; i++)
        {
            if(nums[i-1]%2 == nums[i]%2)
            {
                check.push_back({i-1,i});
            }
            if(i+1!=n && nums[i+1]%2 == nums[i]%2)
            {
                check.push_back({i,i+1});
            }
        }
        unordered_map<vector<int>,bool> mpp;
        vector<vector<int>> c = queries;
        sort(c.begin(),c.end());
        int m = check.size() , k = queries.size();        
        vector<bool> ans(k);
        for(int i = 0 , j=0 ; i < k ; i++)
        {
            while(j<m && check[j].first<c[i][0])
                j++;
            if(j<m && check[j].first>=c[i][0] && check[j].second<=c[i][1])
                mpp[c[i]] = false;
            else
                mpp[c[i]] = true;
        }
        for(int i = 0 ; i<k ; i++)
        {
            ans[i] = mpp[queries[i]];
        }
        return ans;
    }
};
