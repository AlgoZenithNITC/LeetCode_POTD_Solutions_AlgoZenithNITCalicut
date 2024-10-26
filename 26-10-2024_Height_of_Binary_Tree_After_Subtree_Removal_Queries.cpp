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
    vector<int> treeQueries(TreeNode* root, vector<int>& queries) {
        vector<int> out;
        int a[100005], ans[100005];
        height(root,a);
        int t=1, h=0, depth=0, nmax=0, nsmax=0, cmax=0,csmax=0,l=0,j=0;
        TreeNode * q[50000];
        q[0] = root;
        while(h != t){
            l = (t>h)?t-h : 50000-h+t;
            j = l;
            while(l--){
                TreeNode * ht = q[h];
                if(h+1 == 50000) {h=0;}
                else {h++;}
                if (a[ht->val] == cmax){
                    (j>1)? ans[ht->val] = depth+csmax : ans[ht->val] = depth-1;
                }else{
                    ans[ht->val] = depth+cmax;
                }
                if (ht->left != NULL){
                    q[t] = ht->left;
                    if (a[ht->left->val] > nmax){
                        nsmax = nmax; nmax = a[ht->left->val];
                    }else if(a[ht->left->val] > nsmax){
                        nsmax = a[ht->left->val];
                    }
                    if(t+1 == 50000) {t=0;}
                    else {t++;}
                }
                if (ht->right != NULL){
                    q[t] = ht->right;
                    if (a[ht->right->val] > nmax){
                        nsmax = nmax; nmax = a[ht->right->val];
                    }else if(a[ht->right->val] > nsmax){
                        nsmax = a[ht->right->val];
                    }
                    if(t+1 == 50000) {t=0;}
                    else {t++;}
                }
            }
            cmax = nmax; 
            csmax = nsmax;
            nmax = nsmax =0;
            depth++;
        }
        for(auto i : queries){
            out.push_back(ans[i]);
        }
        return out;
    }

    int height(TreeNode * root, int * a){
        if (root!=NULL){
            int h=1;
            if (root->right!=NULL || root->left!=NULL){
                h += max(height(root->left,a), height(root->right,a));
            }
            a[root->val] = h-1;
            return h;
        }
        return 0;
    }
    
};