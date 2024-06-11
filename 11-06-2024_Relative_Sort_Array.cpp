class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        int maxElement = *max_element(arr1.begin(), arr1.end());
        vector<int> count(maxElement + 1, 0);

        for(auto num : arr1) {
            count[num]++;
        }

        vector<int> sortedArray;
        for(auto num : arr2) {
            while(count[num] > 0) {
                sortedArray.push_back(num);
                count[num]--;
            }
        }

        for(int i = 0; i <= maxElement; i++) {
            while(count[i] > 0) {
                sortedArray.push_back(i);
                count[i]--;
            }
        }

        return sortedArray;
    }
};
