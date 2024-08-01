import java.util.List;

public class Solution {
    public int countSeniors(List<String> details) {
        int count = 0;

        for (String info : details) {
            int tens = info.charAt(11) - '0';
            int ones = info.charAt(12) - '0';
            int age = tens * 10 + ones;

            if (age > 60) {
                count++;
            }
        }

        return count;
    }
}
