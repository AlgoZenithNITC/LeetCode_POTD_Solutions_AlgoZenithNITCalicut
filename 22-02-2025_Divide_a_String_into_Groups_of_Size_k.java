

public class DivideString {
    public static List<String> divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        for (int i = 0; i < n; i += k) {
            String part = s.substring(i, Math.min(i + k, n));
            if (part.length() < k) {
                StringBuilder sb = new StringBuilder(part);
                for (int j = part.length(); j < k; j++) {
                    sb.append(fill);
                }
                part = sb.toString();
            }
            result.add(part);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 3;
        char fill = 'x';
        List<String> divided = divideString(s, k, fill);
        System.out.println(divided);  // Output: [abc, def, gx]
    }
}
