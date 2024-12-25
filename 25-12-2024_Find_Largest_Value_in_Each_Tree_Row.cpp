class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        // Using BFS
        vector<int> ans;
        queue<TreeNode*> q;
        if(root!=NULL) {q.push(root);}
        while(!q.empty()){
            int len = q.size();
            int max = INT_MIN;
            while(len--){
                TreeNode* node = q.front();
                q.pop();
                if(node->val > max) {max = node->val;}
                if(node->left != NULL) {q.push(node->left);}
                if(node->right != NULL) {q.push(node->right);}
            }
            ans.push_back(max);
        }
        return ans;
    }
};
