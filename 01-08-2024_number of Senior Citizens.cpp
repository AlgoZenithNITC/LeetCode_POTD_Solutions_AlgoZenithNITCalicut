class Solution {
public:
    int countSeniors(vector<string>& details) {
        int count = 0;

        for (string& info : details) {
            int tens = info[11] - '0';
            int ones = info[12] - '0';
            int age = tens * 10 + ones;

            if (age > 60) {
                count++;
            }
        }

        return count;
    }
};
