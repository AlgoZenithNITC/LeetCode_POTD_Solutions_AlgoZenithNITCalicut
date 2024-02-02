import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder st = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                st.append(s.charAt(j));
                int num = Integer.parseInt(st.toString());
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
