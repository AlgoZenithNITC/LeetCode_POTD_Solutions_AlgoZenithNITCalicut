#include <vector>
#include <algorithm>
#include <limits.h>

class Solution {
public:
    std::vector<int> luckyNumbers (std::vector<std::vector<int>>& matrix) {
        int rows = matrix.size();
        std::vector<int> result;
        
        for (int r_idx = 0; r_idx < rows; ++r_idx) {
            auto row = matrix[r_idx];
            int min_ele = *std::min_element(row.begin(), row.end());
            int col_idx = std::distance(row.begin(), std::find(row.begin(), row.end(), min_ele));
            int r = 0;
            while (r < rows) {
                if (matrix[r_idx][col_idx] < matrix[r][col_idx]) {
                    break;
                }
                ++r;
            }
            if (r == rows) {
                result.push_back(min_ele);
            }
        }
        return result;
    }
};
