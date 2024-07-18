/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:

    int ans = 0;
    vector<int> dfs(TreeNode* root, int d){
        if(!root) return {};

        if(root->left == nullptr && root->right == nullptr) return {1};

        vector<int> left = dfs(root->left, d);
        vector<int>right = dfs(root->right, d);

        for(auto& a: left){
            for(auto& b: right){
                if(a + b <= d){
                    ans ++;
                }
            }
        }

        vector<int> v;
        for(auto lv: left){
            if(lv + 1 <= d){
                v.push_back(lv+1);
            }
        }
        for(auto rv: right){
            if(rv + 1 <= d){
                v.push_back(rv+1);
            }
        }
        return v;
    }

    int countPairs(TreeNode* root, int distance) {
        dfs(root,distance);
        return ans;
    }
};
