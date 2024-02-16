class Solution {
public:
    int findLeastNumOfUniqueInts(vector<int>& arr, int k) {
        unordered_map<int,int> mpp;
        multimap<int,int>npp;
        for(int i : arr)
        {
            mpp[i]++;
        }
        for(auto it : mpp)
        {
            npp.insert({it.second,it.first});
        }
        for(auto it:npp)
        {
            if(k<=0)
            break;
            else
            {
                k-=it.first;
                mpp.erase(mpp.find(it.second));
            }
        }
        if(k<0)
        return mpp.size()+1;
        return mpp.size();
    }
};
