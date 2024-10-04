class Solution {
public:
    long long dividePlayers(vector<int>& skill) 
    {
        unordered_map<int,int> mp;
        int mini=INT_MAX,maxi=INT_MIN;
        for(auto& i:skill)
        {
           mp[i]++;
           mini=min(mini,i);
           maxi=max(maxi,i);
        }
        long long ans=0,sum=mini+maxi,n=skill.size();
        for(auto& i:mp)
        {
            if(i.second==0) continue;
            int rem=sum-i.first;
            if(i.second!=mp[rem]) return -1;
            else
            {
                if(rem==i.first) i.second/=2;
                ans+=(long long) i.second*rem*i.first;
                mp[rem]=0;
            }

        }
    return ans;  
    }
}; 
