class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        int c=0;
        for(int i=0;i<arr.size();i++){
            int t=0;
            for(int j=0;j<arr.size();j++){
                if(arr[i]==arr[j]){
                    t++;
                }
            }
            if(t==1){
                c++;
            }
            if(c==k){
                return arr[i];
            }
        }
        return "";
    }
};