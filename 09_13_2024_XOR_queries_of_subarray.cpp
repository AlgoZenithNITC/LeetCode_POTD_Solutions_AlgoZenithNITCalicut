class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
      vector<int> temp(arr.size());
      temp[0]=arr[0];

      for(int i=1;i<arr.size();i++){
        temp[i]=temp[i-1]^arr[i];
      } 

      vector<int> ans;
      for(int i=0;i<queries.size();i++){
        int a = queries[i][0] , b= queries[i][1];
        if(a>0){
            ans.push_back(temp[b]^temp[a-1]);
        }else ans.push_back(temp[b]);
      }

      return ans; 
    }
};
