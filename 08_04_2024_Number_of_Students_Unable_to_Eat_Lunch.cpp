class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        int n = students.size(), ans = 0;
        unordered_map<int,int> stu , sand;
        for(int i = 0 ; i  <n ; i++)
        {
            stu[students[i]]++;
        }
        for(int i = 0 ; i < n ; i++)
        {
            sand[sandwiches[i]]++;
            if(sand[sandwiches[i]]>stu[sandwiches[i]])
            {
                return n-i;
            }
        }
        return ans;
    }
};
