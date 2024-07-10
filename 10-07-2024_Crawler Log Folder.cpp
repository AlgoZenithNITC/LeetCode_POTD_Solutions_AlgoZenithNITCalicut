class Solution {
public:
    int minOperations(vector<string>& logs) {
        int t=0;
        for(int i=0;i<logs.size();i++){
            if(logs[i]=="./"){
            t=t;
            }
            else if(logs[i]=="../"){
                if(t>0){
                t--;
                }
            }
            else{
                t++;
            }
        }
        return t;
    }
};