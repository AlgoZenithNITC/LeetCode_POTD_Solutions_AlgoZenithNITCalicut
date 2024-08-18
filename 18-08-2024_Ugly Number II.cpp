#include <iostream>
#include <vector>
#include <algorithm>

class Solution {
public:
    int nthUglyNumber(int n) {
        if (n <= 0) return 0; 
        std::vector<int> uglyNumbers(n);
        uglyNumbers[0] = 1; 

        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        
        for (int i = 1; i < n; i++) {
            int next_ugly = std::min({next_multiple_of_2, next_multiple_of_3, next_multiple_of_5});
            uglyNumbers[i] = next_ugly;

            if (next_ugly == next_multiple_of_2) {
                i2++;
                next_multiple_of_2 = uglyNumbers[i2] * 2;
            }
            if (next_ugly == next_multiple_of_3) {
                i3++;
                next_multiple_of_3 = uglyNumbers[i3] * 3;
            }
            if (next_ugly == next_multiple_of_5) {
                i5++;
                next_multiple_of_5 = uglyNumbers[i5] * 5;
            }
        }

        return uglyNumbers[n-1];
    } 
    };