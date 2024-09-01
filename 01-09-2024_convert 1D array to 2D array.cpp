#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> create2DArray(vector<int>& arr, int rows, int cols) {
        if (rows * cols != arr.size()) {
            return vector<vector<int>>(0, vector<int>(0));
        }
        vector<vector<int>> matrix(rows, vector<int>(cols));
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = arr[idx];
                idx++;
            }
        }
        return matrix;
    }
};
