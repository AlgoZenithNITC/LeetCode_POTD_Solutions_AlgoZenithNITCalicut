#include <vector>
using namespace std;

bool divideArray(vector<int>& nums) {
    vector<int> hash(501, 0);
    
    for (int num : nums) {
        hash[num]++;
    }
    
    for (int i = 0; i < 501; i++) {
        if (hash[i] % 2 != 0) {
            return false;
        }
    }
    
    return true;
}
