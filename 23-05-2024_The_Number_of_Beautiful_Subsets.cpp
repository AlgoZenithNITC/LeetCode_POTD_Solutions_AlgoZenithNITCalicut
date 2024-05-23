class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        unordered_map<int, vector<int>> remainderMap;
        for (auto num : nums)
            remainderMap[num % k].push_back(num);

        int totalSubsets = 1;
        for (auto& [remainder, numList] : remainderMap) {
            sort(numList.begin(), numList.end());
            map<int, int> frequencyMap;
            for (auto num : numList)
                frequencyMap[num]++;

            int prevNum = INT_MIN, prevNotTaken = 1, prevTaken = 0, nowNotTaken = 0, nowTaken = 0;
            for (auto& [num, frequency] : frequencyMap) {
                int possibleSubsets = pow(2, frequency) - 1;
                if (prevNum + k == num) {
                    nowNotTaken = prevNotTaken + prevTaken;
                    nowTaken = prevNotTaken * possibleSubsets;
                } else {
                    nowNotTaken = prevNotTaken + prevTaken;
                    nowTaken = (prevNotTaken + prevTaken) * possibleSubsets;
                }

                prevNotTaken = nowNotTaken;
                prevTaken = nowTaken;
                prevNum = num;
            } 
            totalSubsets *= (nowNotTaken + nowTaken);
        }
        return totalSubsets - 1;
    }
};
