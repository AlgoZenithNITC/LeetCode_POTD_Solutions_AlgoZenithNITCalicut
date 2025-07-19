class Solution {
public:
    vector<string> removeSubfolders(vector<string>& folder) {

        sort(folder.begin(),folder.end());
         
        vector<string>res;

        for(string &path : folder)
        {
            if(res.size()==0 || path.find(res.back()+"/") !=0)
            {
                res.push_back(path);
            }
        }
        

        return res;
    }
};
