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
    bool flipEquiv(TreeNode* root1, TreeNode* root2) {
        if(root1==NULL&&root2==NULL){
            return true;
        }// both roots are empty
        if((root1==NULL&&root2!=NULL)||(root1!=NULL&&root2==NULL)){
            return false;
        }// either one of them is empty
        if(root1->val!=root2->val){
            return false;
        }//nodes are not equal;
        bool x=flipEquiv(root1->left,root2->right);// flip is happen
        bool y=flipEquiv(root1->right,root2->left);//  flip is happen
        bool b=flipEquiv(root1->left,root2->left);// flip is not happen
        bool c=flipEquiv(root1->right,root2->right);// flip is not happen
        return x&&y||(b&&c);
    }
};