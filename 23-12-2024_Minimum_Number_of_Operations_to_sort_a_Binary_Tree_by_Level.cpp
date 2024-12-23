class Solution {
public:
    int minSwaps(vector<int>& arr){
        int n = arr.size();
        vector<pair<int,int>> v;
        for(int i=0; i<n; i++){
            v.push_back({arr[i], i});

        }
        sort(v.begin(), v.end());
        int swaps = 0;
        int i=0;
        while(i<n){
            if(v[i].second==i){
                i++;
                continue;
            }else{
                swaps++;
                swap(v[i], v[v[i].second]);
            }

        }
        return swaps;
            }
    int minimumOperations(TreeNode* root) {
       queue<TreeNode*> q;
       q.push(root);
       int ans=0;
       while(!q.empty()){
        int sz = q.size();
        vector<int> temp;
        for(int i=0; i<sz; i++){
            TreeNode* currNode = q.front();
            q.pop();
            temp.push_back(currNode->val);
            if(currNode->left){
                q.push(currNode->left);

            }
            if(currNode->right){
                q.push(currNode->right);
            }

        }
        ans+=minSwaps(temp);

       } 
       return ans;
    }
        
    
};
