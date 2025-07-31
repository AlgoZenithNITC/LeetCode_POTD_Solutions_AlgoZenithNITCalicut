class Solution {
public:

int subarrayBitwiseORs(vector<int>& arr) {
    unordered_set<int> res;
    unordered_set<int> cur;

    for (int num : arr) {
        unordered_set<int> new_cur = {num};
        for (int x : cur) {
            new_cur.insert(x | num);
        }
        cur = new_cur;
        for (int x : cur) {
            res.insert(x);
        }
    }

    return res.size();
}

};
