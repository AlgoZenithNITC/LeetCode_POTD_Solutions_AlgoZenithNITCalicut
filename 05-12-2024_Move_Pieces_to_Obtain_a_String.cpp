class Solution {
public:
    bool canChange(string start, string target) {
        int i = 0, j = 0;
        const int n = start.length();
        while (i < n || j < n) {
            while (i < n && start[i] == '_') i++;
            while (j < n && target[j] == '_') j++;
            if (start[i] != target[j])
                return false;
            if (start[i] == 'L' && j > i)
                return false;
            if (start[i] == 'R' && j < i)
                return false;
            i++; j++;
        }
        return true;
    }
};
