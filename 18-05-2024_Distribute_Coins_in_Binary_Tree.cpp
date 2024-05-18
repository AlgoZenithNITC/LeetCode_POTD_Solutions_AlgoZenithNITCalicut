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
    int give_coins(TreeNode* root , int &ans)
    {
        if(root==nullptr)
            return 0;
        int left = give_coins(root->left , ans);
        int right = give_coins(root->right , ans);
        ans += abs(left) + abs(right);
        return root->val + right + left - 1;
    }
public:
    int distributeCoins(TreeNode* root) {
        int ans = 0 ;
        give_coins(root , ans);
        return ans;
    }
};
