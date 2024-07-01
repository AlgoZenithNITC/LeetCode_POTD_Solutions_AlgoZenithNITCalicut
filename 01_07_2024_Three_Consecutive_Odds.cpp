class Solution {
public:
    bool threeConsecutiveOdds(vector<int>& arr) {
        int a=0;
        if (arr.size()==1 || arr.size()==2) return false;
        for(int i=0; i<arr.size()-2; i++){
            a=arr[i]*arr[i+1]*arr[i+2];
            if (a%2==1) return true;
        }return false;
    }
};
